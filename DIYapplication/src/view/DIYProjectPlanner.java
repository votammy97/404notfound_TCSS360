package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import model.DIYFileManager;
import model.Project;

public class DIYProjectPlanner extends JFrame {

    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
	private static final long serialVersionUID = -131614090848525596L;
	
	private static final String VERSION = "0.0.1";
	
    /** The file chooser for opening and saving an image. */
    private JFileChooser jFileChooser;
    
    /**
     * The add button to add projects and its panel
     */
    JButton addJButton;
    
    /**
     * The left panel where the projects are
     */
    JPanel jPanelLeft;
    
    /** The model for reference. */
	private /*PropertyChangeEnabledRaceControls*/ DIYFileManager model;

	public DIYProjectPlanner(final DIYFileManager model) {
		super("DIY Project Planner");
		super.setIconImage((new ImageIcon("./Images/iconDIY.png")).getImage());
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500, 400));
		this.model = model;
		jFileChooser = new JFileChooser(".");
	}

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
	 */
	private void setUpComponents() {
		setJMenuBar(createMenuBar());
		final JScrollPane jScrollPaneLeft = setUpLeftPanel();
        add(jScrollPaneLeft, BorderLayout.WEST);
        
        //TODO: Description
        final JPanel jPanelRight = new JPanel();//setUpLeftPanel();
        add(jPanelRight, BorderLayout.EAST);
	}
	
    /**
     * Setting up the Left components.
     * 
     * @return the left scroll pane
     */
    private JScrollPane setUpLeftPanel() {
        JPanel jPanelLeft = new JPanel();
        //jPanelLeft.setLayout(new BorderLayout());
        
        addJButton = new JButton("+");
        addJButton.setBackground(Color.WHITE);
        addJButton.setPreferredSize(new Dimension(250, 50));
        addJButton.addActionListener(theEvent -> {
        	//TODO: 
//        	open add project window
//        	Project project = new Project();
//        	addProject(project)
        });
        
        jPanelLeft.add(addJButton);
        final JScrollPane jScrollPane = new JScrollPane(jPanelLeft, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, //VERTICAL_SCROLLBAR_ALWAYS
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        return jScrollPane;
    }
    
     /**
      * add a project to the left components.
      * @param project the project to be added
      */
    public void addProject(Project project) {
    	JPanel jPanel = new JPanel(new BorderLayout());
    	jPanel.setBorder(BorderFactory.createTitledBorder(project.getMyName()));
		JButton edit = new JButton("Edit");
		edit.addActionListener(theEvent -> {
			editProject(jPanel);
		});
		JButton delete = new JButton("Delete");
	    delete.addActionListener(theEvent -> {
			deleteProject(/* project, */ jPanel); //TODO
		});
		jPanel.add(edit);
		jPanel.add(delete);
    	jPanelLeft.add(jPanel);
    	jPanelLeft.revalidate();
    }
    
    /**
     * edit a project to the left components.
     * @param panel to be edited
     */
    public void editProject(JPanel jPanel) {
		jPanelLeft.remove(jPanel);
		//TODO open editGUI and get project
//		model.addProject(project);
//		addProject(project);
    	jPanelLeft.revalidate();
    }
    
    /**
     * remove a panel to the left components.
     * @param jPanel the panel to be deleted
     */
    public void deleteProject(JPanel jPanel) {
		jPanelLeft.remove(jPanel);
		//TODO remove in the project list
    	jPanelLeft.revalidate();
    }
    
	public JMenuBar createMenuBar() {
		final JMenuBar bar = new JMenuBar();

		bar.add(createFileMenu());
		bar.add(createHelpMenu());

		return bar;
	}

	private JMenu createFileMenu() {
		final JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);

		final JMenuItem make = new JMenuItem("New...");
		final JMenuItem open = addAndSetsMenuItemOpen();
		final JMenuItem save = addAndSetsMenuItemSave();
		final JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(theEvent -> System.exit(0));

		menu.add(make);
		menu.add(open);
		menu.add(save);
		menu.add(exit);

		return menu;
	}
	
	/**
     * @return adds and sets the JMenuItem open
     */
    private JMenuItem addAndSetsMenuItemOpen() {
        final JMenuItem jMenuItemLoadRace = new JMenuItem("Open...");
        jMenuItemLoadRace.addActionListener(theEvent -> {
        	if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        		try {                  
        			model.loadProjects(jFileChooser.getSelectedFile()); 
                        
                } catch (final IOException e) {
                    JOptionPane.showMessageDialog(this,
                                    "Error loading file.");
                }
            }
        });
        return jMenuItemLoadRace;
    }
    
    private JMenuItem addAndSetsMenuItemSave() {
    	final JMenuItem jMenuItemLoadRace = new JMenuItem("Save...");
        jMenuItemLoadRace.addActionListener(theEvent -> {
        	if (jFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        		try {                  
        			model.saveProjects(jFileChooser.getSelectedFile()); 
                        
                } catch (final IOException e) {
                    JOptionPane.showMessageDialog(this,
                                    "Error saving file.");
                }
            }
        });
    	return jMenuItemLoadRace;
    }
    
    /**
     * Start of the application.
     */
    public static void start(String name, String emailAddr) {  
        final DIYFileManager model = new DIYFileManager(name, emailAddr);
        final DIYProjectPlanner controller = new DIYProjectPlanner(model);
        
        controller.createAndShowGUI();
    }


	private JMenu createHelpMenu() {
		final JMenu menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);

		final JMenuItem about = new JMenuItem("About...");
		about.addActionListener(theEvent -> showAboutDialog());
		menu.add(about);

		return menu;
	}

	private void showAboutDialog() {
		JOptionPane.showMessageDialog(null,
				String.format(
						"Created by:\nMatthew Chan\nZhe Li\nGordon McCreary\nKen Gil Romero\nTammy Vo\n\nVersion: %s",
						VERSION),
				"About", JOptionPane.INFORMATION_MESSAGE);
	}
}
