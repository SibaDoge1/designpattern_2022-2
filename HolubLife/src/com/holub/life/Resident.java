package com.holub.life;

import java.awt.*;
import javax.swing.*;
import com.holub.ui.Colors;	// Contains constants specifying various
import com.holub.ui.LogPanel;
import com.holub.ui.PopulationLogCaller;
// colors not defined in java.awt.Color.
import com.holub.life.Cell;
import com.holub.life.Storable;
import com.holub.life.Direction;
import com.holub.life.Neighborhood;
import com.holub.life.Universe;

/*** ****************************************************************
 * The Resident class implements a single cell---a "resident" of a
 * block.
 *
 * @include /etc/license.txt
 */

public final class Resident implements Cell
{
	private static final Color BORDER_COLOR = Colors.DARK_YELLOW;

	private int nextState = 0;
	private int state = 0;

	private boolean isStable(){return state == nextState; }

	/** figure the next state.
	 *  @return true if the cell is not stable (will change state on the
	 *  next transition().
	 */
	public boolean figureNextState(
							Cell north, 	Cell south,
							Cell east, 		Cell west,
							Cell northeast, Cell northwest,
							Cell southeast, Cell southwest )
	{
		verify( north, 		"north"		);
		verify( south, 		"south"		);
		verify( east, 		"east"		);
		verify( west, 		"west"		);
		verify( northeast,	"northeast"	);
		verify( northwest,	"northwest" );
		verify( southeast,	"southeast" );
		verify( southwest,	"southwest" );

		int neighbors = 0;

		if( north.	  isAlive()) ++neighbors;
		if( south.	  isAlive()) ++neighbors;
		if( east. 	  isAlive()) ++neighbors;
		if( west. 	  isAlive()) ++neighbors;
		if( northeast.isAlive()) ++neighbors;
		if( northwest.isAlive()) ++neighbors;
		if( southeast.isAlive()) ++neighbors;
		if( southwest.isAlive()) ++neighbors;

		//willBeAlive = (neighbors==3 || (amAlive && neighbors==2));
		nextState = RuleManager.instance().getRule().checkState(this, neighbors);
		return !isStable();
	}

	private void verify( Cell c, String direction )
	{	assert (c instanceof Resident) || (c == Cell.DUMMY)
				: "incorrect type for " + direction +  ": " +
				   c.getClass().getName();
	}

	/** This cell is monetary, so it's at every edge of itself. It's
	 *  an internal error for any position except for (0,0) to be
	 *  requsted since the width is 1.
	 */
	public Cell	edge(int row, int column)
	{	assert row==0 && column==0;
		return this;
	}

	public boolean transition()
	{
		boolean changed = isStable();
		state = nextState;
		
		if(state == 1)
			PopulationLogCaller.setCurrentVal_s(1);
		
		if(state >= RuleManager.instance().getRule().getStates())
			clear();
		return changed;
	}

	public void redraw(Graphics g, Rectangle here, boolean drawAll)
    {   g = g.create();
		g.setColor(RuleManager.instance().getRule().getStateColors().get(state));
		g.fillRect(here.x+1, here.y+1, here.width-1, here.height-1);

		// Doesn't draw a line on the far right and bottom of the
		// grid, but that's life, so to speak. It's not worth the
		// code for the special case.

		g.setColor( BORDER_COLOR );
		g.drawLine( here.x, here.y, here.x, here.y + here.height );
		g.drawLine( here.x, here.y, here.x + here.width, here.y  );
		g.dispose();
	}

	public void userClicked(Point here, Rectangle surface)
	{
		state = isAlive() ? 0 : 1;
		if (isAlive())
			PopulationLogCaller.setCurrentVal_s(1);
		else
			PopulationLogCaller.setCurrentVal_s(-1);
		LogPanel.PostRefreshLog();

	}

	public void	clear(){
		state = 0;
		nextState = 0;
	}

	public boolean isAlive()		{return state == 1;			    }
	public Cell    create()			{return new Resident();			}
	public int 	   widthInCells()	{return 1;}

	public int getState()
	{
		return state;
	}

	public Direction isDisruptiveTo()
	{	return isStable() ? Direction.NONE : Direction.ALL ;
	}

	public boolean transfer(Storable blob,Point upperLeft,boolean doLoad)
	{
		Memento memento = (Memento)blob;
		if( doLoad )
		{
			state = memento.isAlive(upperLeft) ? 1 : 0;
			nextState = state;
			if(isAlive())
				return true;
		}
		else if( isAlive() )  					// store only live cells
			memento.markAsAlive( upperLeft );

		return false;
	}

	/** Mementos must be created by Neighborhood objects. Throw an
	 *  exception if anybody tries to do it here.
	 */
	public Storable createMemento()
	{	throw new UnsupportedOperationException(
					"May not create memento of a unitary cell");
	}
}
