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

	public static void main( String[] arguments )
	{	new Life();
	}

	private Life()
	{	super( "The Game of Life. "
					+"(c)2003 Allen I. Holub <http://www.holub.com>");

		// Must establish the MenuSite very early in case
		// a subcomponent puts menus on it.
		MenuSite.establish( this );		//{=life.java.establish}
		
		
		setDefaultCloseOperation	( EXIT_ON_CLOSE 		);
		getContentPane().setLayout	( new BorderLayout()	);
		LogPanel.SetLogPanelText("<html>First line<br><br><br><br>lol</html>");
		getContentPane().add(LogPanel.instance(),BorderLayout.NORTH );
		getContentPane().add( Universe.instance(), BorderLayout.CENTER); //{=life.java.install}

		pack();
		setVisible( true );
	}
}
