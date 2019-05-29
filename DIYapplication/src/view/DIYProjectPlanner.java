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
import model.ProjectsPanel;
import model.Project;

public class DIYProjectPlanner extends JFrame {

    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
	private static final long serialVersionUID = -131614090848525596L;
	
	private static final String VERSION = "0.0.1";
	
    /** The file chooser for opening and saving an image. */
    private JFileChooser myJFileChooser;
    
    /**
     * The add button to add projects and its panel
     */
    JButton myAddJButton;
    
    /**
     * The left panel where the projects are
     */
    JPanel myJPanelLeft;
    
    /** The model for reference. */
	private DIYFileManager model;

	public DIYProjectPlanner(final DIYFileManager model) {
		super("DIY Project Planner");
		super.setIconImage((new ImageIcon("./Images/iconDIY.png")).getImage());
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500, 400));
		this.model = model;
		myJFileChooser = new JFileChooser(".");
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
		final JScrollPane jScrollPaneLeft = new ProjectsPanel();
        add(jScrollPaneLeft, BorderLayout.WEST);
        
        //TODO: Description
        final JPanel jPanelRight = new JPanel();//setUpLeftPanel();
        add(jPanelRight, BorderLayout.EAST);
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
        	if (myJFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
        		try {                  
        			model.loadProjects(myJFileChooser.getSelectedFile()); 
                        
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
        	if (myJFileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
        		try {                  
        			model.saveProjects(myJFileChooser.getSelectedFile()); 
                        
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
