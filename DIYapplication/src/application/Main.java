package application;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import GUI.DIYcontroller;

public final class Main {

	private Main() {
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
				new DIYcontroller().createAndShowGUI();
			}
		});
	}

}
