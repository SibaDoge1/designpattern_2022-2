package com.holub.life;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.Timer;		// overrides java.awt.timer
import com.holub.ui.MenuSite;
import com.holub.tools.Publisher;

import java.util.Observable;

/***
 * The <code>Clock</code> class handles the timing of gameboard
 * updates. It creates its own menu (which sets the clock speed),
 * and sends notifications off to any observers every time the
 * clock "ticks."
 *
 * <h2>Revisions</h2>
 * <p>
 * 12-8-2004	AIH	Added a kludge to the clock-tick handler that
 * 				checks whether any menu item is active before it
 * 				allows the clock to tick. This mod fixes a bug
 * 				that caused the running game to overwrite any
 * 				displayed menus. See {@link #menuIsActive} for
 * 				details.
 *
 * @include /etc/license.txt
 */

public class Clock
{	private Timer			clock		= new Timer();
	private TimerTask		tick		= null;
	TickData TD = new TickData();
	
	// The clock can't be an everything-is-static singleton because
	// it creates a menu, and it can't do that until the menus
	// are established.
	//
	private Clock()
	{	createMenus();
	}

	private static Clock instance;

	/** The clock is a singleton. Get a reference to it by calling
	 *  <code>Clock.instance()</code>. It's illegal to call
	 *  <code>new Clock()</code>.
	 */
	public synchronized static Clock instance()
	{	if( instance == null )
			instance = new Clock();
		return instance;
	}

	/** Start up the clock.
	 *  @param millisecondsBetweenTicks The number of milliseconds between
	 *  					 ticks. A value of 0 indicates that
	 *  					 the clock should be stopped.
	 */

	public void startTicking( )
	{	if(tick != null)
		{	tick.cancel();
			tick=null;
		}

		if( TD.getTick() > 0 )
		{	tick =	new TimerTask()
					{	public void run(){ tick(); }
					};
			clock.scheduleAtFixedRate( tick, 0, TD.getTick());
		}
	}

	/** Stop the clock
	 */

	public void stop()
	{	
		TD.setTick(0);;
		startTicking();
	}

	/** Create the menu that controls the clock speed and
	 *  put it onto the menu site. 
	 */
	private void createMenus()
	{
		// First set up a single listener that will handle all the
		// menu-selection events except "Exit"
	
////////////////////////////////////////////////////////////////////////////////////////
		
		// (TODO) 여기여기여기여기 
		// 이 부분에서 시간을 동적으로 바꿀 수 있어야함.
		// 0. 메뉴바에 숫자를 입력받아 그것을 tick의 parameter로 사용한다.
		// 1. 0을 입력하면 halt
		
		// 2. 메뉴바는 아마도 다음처럼 될 것 같음. >> | GRID | GO | TICK TIME (텍스트 박스) |
		// 2-0. MenuSite 이해하기 
		// >> MenuSite.java 257 : addMenu
		// >> MenuSite.java 307 : addLine
		// 2-1. MenuSite.addTextBox 만들어야함
	
		// 3. 사실 GO에 있는 모든 내용이 TICK TIME과 겹치는데...
		
		//JMenuItem과 JTextField를 동시에 받을 수 있어야함.
		// Halt, Agonizing, Slow, Medium, Fast를 이넘으로 매핑..
		// 어댑터로 if else하지말고
		
		// 더 큰 객체로... encapsulation이 안되려나??
//		https://docs.oracle.com/javase/7/docs/api/javax/swing/JMenuItem.html
//		https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextField.html
//		둘다 JComponent임.
		
//		https://docs.oracle.com/javase/7/docs/api/java/awt/event/ActionEvent.html
//		ActionEvent는 구조가 조금 다름..
		
		
		
		ActionListener modifier =									//{=startSetup}
			new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{

					// System.out.println((JMenuItem)e.getSource());
//					char toDo = name.charAt(0);
//
//					if( toDo=='T' ) {
//						tick();				      // single tick
//						TD.setTick(0); 
//					}
//					else if (toDo == 'A') {
//						TD.setTick(500); // agonizing
//						startTicking( );
//					}
//					else if (toDo == 'S') {
//						TD.setTick(150); // slow
//						startTicking( );
//					}
//					else if (toDo == 'M') {
//						TD.setTick(70);  // medium
//						startTicking( );
//					}
//					else if (toDo == 'F') {
//						TD.setTick(50);  // fast
//						startTicking( );
//					}
//					else {
//						TD.setTick(0);   // halt
//						startTicking( );
//					}
				}
			};
		
			// {=midSetup}
		// Observer Pattern
		// when millisecondsBetweenTicks value changes,
		// update the window.
		TickMenu TM = new TickMenu(TD, this, modifier);
		
		MenuSite.addLine(this,"Go","Halt",  			modifier);
		MenuSite.addLine(this,"Go","Tick (Single Step)",modifier);
		MenuSite.addLine(this,"Go","Agonizing",	 	  	modifier);
		MenuSite.addLine(this,"Go","Slow",		 		modifier);
		MenuSite.addLine(this,"Go","Medium",	 	 	modifier);
		MenuSite.addLine(this,"Go","Fast",				modifier);
		MenuSite.addTextField(this,"Tick Rate",				modifier);
		
		//update when static var is changed >> observer
		MenuSite.addMenu(this, String.valueOf(TD.getTick()));
		// {=endSetup}
		
////////////////////////////////////////////////////////////////////////////////////////
		
	}	//{=endCreateMenus}

	private Publisher publisher = new Publisher();

	/** Add a listener that's notified every time the clock ticks:
	 *  <PRE>
	 *  Clock.instance().addClockListener
	 *  (	new Clock.Listener()
	 *  	{	public void tick()
	 *  		{	System.out.println("tick!");
	 *  		}
   	 *		}
	 *  );
	 *  </PRE>
	 */
	public void addClockListener( Listener observer )
	{	publisher.subscribe(observer);
	}

	/** Implement this interface to be notified about clock ticks.
	 *  @see Clock
	 */
	public interface Listener
	{	void tick();
	}

	/** Force the clock to "tick," even if it's not time for
	 *  a tick. Useful for forcing a tick when the clock is
	 *  stopped. (Life uses this for single stepping.)
	 */
	public void tick()
	{	publisher.publish
		(	new Publisher.Distributor()
			{	public void deliverTo( Object subscriber )
				{	if( !menuIsActive() )
						((Listener)subscriber).tick();
				}
			}
		);
	}

	/** Check if any item on the menu bar has been selected.
	 *  This is an incredible kluge. The problem is that Swing draws the
	 *  menus on the same "canvas" as the main frame. As a consequence,
	 *  displayed menus are overwritten by a running game. Moreover, Swing
	 *  provides no notification on the order of "some menu item has been
	 *  selected," so the only way to detect menu-bar activity is to poll
	 *  it. This method does just that, and returns true if some menu
	 *  is being displayed. The {@link #tick} method effectively suspends
	 *  clock ticks as long as a menu is displayed, (which slows down
	 *  the clock, unfortunately).
	 *  <p>
	 *  From a design-patterns perspective, this method demonstrates that
	 *  a facade (the MenuSite) does not provide strict isolation from
	 *  the underlying subsystem. I can't immagine another application
	 *  that would need to know whether or not the menu bar is active,
	 *  so adding this menu to the MenuSite would be "noise." Since
	 *  the method does something that's of no relevance to other
	 *  MenuSite users, it makes an "end run" around the facade.
	 */

	private boolean menuIsActive()
	{	MenuElement[] path =
					MenuSelectionManager.defaultManager().getSelectedPath();
		return ( path != null && path.length > 0 );
	}
}
