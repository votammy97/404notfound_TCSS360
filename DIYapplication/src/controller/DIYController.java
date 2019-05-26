package controller;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.DIYProjectPlanner;
import view.Login;

public final class DIYController {

    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private DIYController() {
        throw new IllegalStateException();
    }

	public static void main(final String[] theArgs) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (final UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		} catch (final IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (final InstantiationException ex) {
			ex.printStackTrace();
		} catch (final ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Login a = new Login();
				
			}
		});
	}

}
