package view;

import javax.swing.*;

import model.DIYFileManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.Controller;


public class Login extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField myFirstName;
	private JTextField myEmailAddress;
	private JLabel myErrorMessage;
	private JButton myOkButton;
	private JButton myCancelButton;
	private Controller myController;
	
	public Login() {
		myFirstName = new JTextField(12);
		myEmailAddress = new JTextField(12);
		myErrorMessage = new JLabel("Inputs can't contain any space");
		myErrorMessage.setForeground(Color.RED);
		myOkButton = new JButton("Ok");
		myCancelButton = new JButton("Cancel");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		this.setLayout(new GridLayout(4,1));
		
		panel1.add(new JLabel("First Name"));
		panel1.add(myFirstName);
		panel2.add(new JLabel("Email Address"));
		panel2.add(myEmailAddress);
		panel3.add(myOkButton);
		panel3.add(myCancelButton);
		panel4.add(myErrorMessage);
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		this.add(panel4);
		panel4.setVisible(false);
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Login");
		this.setLocationRelativeTo(null);
		
		
		myOkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(myFirstName.getText().contains(" ") 
						|| myEmailAddress.getText().contains(" ")) {
					panel4.setVisible(true);
					
				} else {
					panel4.setVisible(false);
					dispose();
					final DIYProjectPlanner view = new DIYProjectPlanner(myController);
					final DIYFileManager model = new DIYFileManager(
							   myFirstName.getText(), myEmailAddress.getText());
					myController.loginSuccess(view, model);
				}
			}
			
		});
		
		myCancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}
	
	public void assignController(final Controller theController) {
		myController = theController;
	}
}