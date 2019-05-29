package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;

public class ProjectsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5924207307409471100L;
	
    /** The model for reference. */
    private Controller myController;
	
	ProjectsPanel(final Controller theController) {
		super();
		JPanel LeftPanel = new JPanel(new BorderLayout());
		myController = theController;
        JButton add = new JButton("+");
        add.setBackground(Color.WHITE);
        add.setPreferredSize(new Dimension(250, 50));    
        add.addActionListener(theEvent -> myController.setAddProjectButtonActionListener());
        LeftPanel.add(add, BorderLayout.NORTH);
        LeftPanel.add(new JPanel(), BorderLayout.CENTER);
		LeftPanel.add(new ProjectsScrollPane(/* theController */), BorderLayout.SOUTH);
        add(LeftPanel);
	}
	

}
