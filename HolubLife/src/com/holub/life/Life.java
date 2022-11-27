package com.holub.life;

import java.awt.*;
import javax.swing.*;
import com.holub.ui.MenuSite;
import com.holub.ui.LogPanel;

/*******************************************************************
 * An implemenation of Conway's Game of Life.
 *
 * @include /etc/license.txt
 */

public final class Life extends JFrame
{	
	private static JComponent universe;
	private static JFrame life;
	
	public static void main( String[] arguments )
	{	
		life();
	}

	private Life()
	{	
		
		super( "The Game of Life. "
					+"(c)2003 Allen I. Holub <http://www.holub.com>");
		
		// Must establish the MenuSite very early in case
		// a subcomponent puts menus on it.
		MenuSite.establish( this );		//{=life.java.establish}
		
		
		setDefaultCloseOperation	( EXIT_ON_CLOSE 		);
		getContentPane().setLayout	( new BorderLayout()	);
		
		LogPanel initial = new LogPanel();
		getContentPane().add(initial,BorderLayout.NORTH );
		getContentPane().add( Universe.instance(), BorderLayout.CENTER); //{=life.java.install}

		pack();
		setVisible( true );
	}
	
	public synchronized static JFrame life()
	{	if( life == null )
			life = new Life();
		return life;
	}

	public static JFrame getLife() {
		return life;
	}

}
