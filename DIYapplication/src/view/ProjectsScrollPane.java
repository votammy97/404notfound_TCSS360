package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import model.Project;

/**
 * Class for the left component of the main application
 * @author Ken Gil Romero
 * @version Spring 19
 */
public class ProjectsScrollPane extends JScrollPane {
		
    /**
     * A generated serial version UID for object Serialization.
     */
	private static final long serialVersionUID = 2077101975990854195L;
	
	// /** The model for reference. */
	// private Controller myController;
	
	/**
     * Setting up the Projects panels.
     * 
     */
	public ProjectsScrollPane(/* final Controller theController */) {      
        super(new JPanel(), 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, //VERTICAL_SCROLLBAR_ALWAYS
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        myController = theController;
        ((JPanel)this.getViewport().getView()).setPreferredSize(new Dimension(250, 270));;
        //((JPanel)this.getViewport().getView()).add();
    }
}