package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import controller.Controller;
import model.ProjectList;

/**
 * Main Application view class
 * @author
 * @author Ken Gil Romero
 * @version Spring 19
 */
public class DIYProjectPlanner extends JFrame {

    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
	private static final long serialVersionUID = -131614090848525596L;
	
	/**
	 * 
	 */
	private static final String VERSION = "0.0.1";
    
    /**
     * The left panel where the projects are
     */
    private ProjectsPanel myProjectsJpanel;

    /**
     * The right panel where the projects are
     */
    private DescriptionPanel myDescriptionJpanel;
    
    /** The model for reference. */
	private final Controller myController;

	/**
	 * 
	 * @param theController
	 * @author 
	 */
	public DIYProjectPlanner(final Controller theController) {
		super("DIY Project Planner");
		super.setIconImage((new ImageIcon("./Images/iconDIY.png")).getImage());
		myController = theController;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(600, 500));
		
		createAndShowGUI();
	}

	/**
	 * 
	 */
	public void createAndShowGUI() {
		setUpComponents();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	/**
	 * Sets up the components of the GUI.
	 * @author 
	 * @author Ken Gil Romero
	 * @author 
	 */
	private void setUpComponents() {
		setJMenuBar(createMenuBar());
		myProjectsJpanel = new ProjectsPanel(myController);
        add(myProjectsJpanel, BorderLayout.WEST);
		//add(new ProjectsPanel(myController), BorderLayout.WEST);
        
        //TODO: Description
        myDescriptionJpanel = new DescriptionPanel();
        add(myDescriptionJpanel, BorderLayout.EAST);
	}
	
	/**
	 * Creates the project panels and sets their buttons actions
	 * @author Ken Gil Romero
	 */
	public void buildProjectPanels(final ProjectList theProjectsList) {
		myProjectsJpanel.buildProjectPanels(theProjectsList);
	}
	
	/**
	 * 
	 * @return
	 */
	public JMenuBar createMenuBar() {
		final JMenuBar bar = new JMenuBar();

		bar.add(createFileMenu());
		bar.add(createSortMenu());
		bar.add(createHelpMenu());

		return bar;
	}

	/**
	 * 
	 * @return
	 */
	private JMenu createFileMenu() {
		final JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);

		final JMenuItem make = new JMenuItem("New...");
		make.addActionListener(theEvent -> myController.createNewProject());
		final JMenuItem open = new JMenuItem("Open...");
		open.addActionListener(theEvent -> myController.openProjects());
		final JMenuItem save = new JMenuItem("Save...");
		save.addActionListener(theEvent -> myController.saveProjects());
		final JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(theEvent -> System.exit(0));

		menu.add(make);
		menu.add(open);
		menu.add(save);
		menu.add(exit);

		return menu;
	}
	
	/**
	 * 
	 * @return
	 */
	private JMenu createSortMenu() {
		final JMenu menu = new JMenu("Sort");
		menu.setMnemonic(KeyEvent.VK_S);
		
		final JMenu sortByName = new JMenu("By Name");
		final JMenuItem nameAsc = new JMenuItem("Normal");
		nameAsc.addActionListener(theEvent -> myController.sortByName());
		final JMenuItem nameDes = new JMenuItem("Reversed");
		nameDes.addActionListener(theEvent -> myController.sortByNameR());
		sortByName.add(nameAsc);
		sortByName.add(nameDes);
		
		final JMenu sortByDuration = new JMenu("By Duration");
		final JMenuItem durAsc = new JMenuItem("Ascending");
		durAsc.addActionListener(theEvent -> myController.sortByDuration());
		final JMenuItem durDes = new JMenuItem("Descending");
		durDes.addActionListener(theEvent -> myController.sortByDurationR());
		sortByDuration.add(durAsc);
		sortByDuration.add(durDes);
		
		final JMenu sortByCost = new JMenu("By Cost");
		final JMenuItem costAsc = new JMenuItem("Ascending");
		costAsc.addActionListener(theEvent -> myController.sortByCost());
		final JMenuItem costDes = new JMenuItem("Descending");
		costDes.addActionListener(theEvent -> myController.sortByCostR());
		sortByCost.add(costAsc);
		sortByCost.add(costDes);
		
		final JMenu sortByEnergy = new JMenu("By Energy Efficiency");
		final JMenuItem energyAsc = new JMenuItem("Normal");
		energyAsc.addActionListener(theEvent -> myController.sortByEnergy());
		final JMenuItem energyDes = new JMenuItem("Reversed");
		energyDes.addActionListener(theEvent -> myController.sortByEnergyR());
		sortByEnergy.add(energyAsc);
		sortByEnergy.add(energyDes);
		
		menu.add(sortByName);
		menu.add(sortByDuration);
		menu.add(sortByCost);
		menu.add(sortByEnergy);
		
		return menu;
	}
	
	/**
	 * 
	 * @return
	 */
	private JMenu createHelpMenu() {
		final JMenu menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);

		final JMenuItem about = new JMenuItem("About...");
		about.addActionListener(theEvent -> showAboutDialog());
		menu.add(about);

		return menu;
	}

	/**
	 * 
	 * @author 
	 * @author Ken Gil Romero
	 */
	private void showAboutDialog() {
		JOptionPane.showMessageDialog(null,
				String.format("First Name of User: \n" + myController.getFirstName() + "\n" +
						"Email Address of User: \n" + myController.getEmailAddress() + "\n\n" + 
						"Created by:\nMatthew Chan\nZhe Li\nGordon McCreary\nKen Gil Romero\nTammy Vo\n\nVersion: %s",
						VERSION),
				"About", JOptionPane.INFORMATION_MESSAGE);
	}
}
