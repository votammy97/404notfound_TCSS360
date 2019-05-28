package view;

import javax.swing.*;

import model.DIYFileManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame{
	JTextField firstName;
	JTextField emailAddress;
	JLabel jlabel1;
	JLabel jlabel2;
	JLabel jlabel3;
	JButton button1;
	JButton button2;
	String name;
	String email;
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	JPanel panel4;
	private DIYFileManager mng = new DIYFileManager("firsName", "emailAddress");
	
	public Login() {
		firstName = new JTextField(12);
		emailAddress = new JTextField(12);
		jlabel1 = new JLabel("First Name");
		jlabel2 = new JLabel("Email Address");
		jlabel3 = new JLabel("Inputs can't contain any space");
		jlabel3.setForeground(Color.RED);
		
		button1 = new JButton("ok");
		button2 = new JButton("cancel");
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		this.setLayout(new GridLayout(4,1));
		
		panel1.add(jlabel1);
		panel1.add(firstName);
		
		panel2.add(jlabel2);
		panel2.add(emailAddress);
		
		panel3.add(button1);
		panel3.add(button2);
		
		panel4.add(jlabel3);
		
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
		
		
		
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(firstName.getText().contains(" ") 
						|| emailAddress.getText().contains(" ")) {
					panel4.setVisible(true);
					
				} else {
					panel4.setVisible(false);
					name = firstName.getText();
					email = emailAddress.getText();
					//System.out.println(name);
					//System.out.println(email);
					setName(firstName.getText());
					setEmail(emailAddress.getText());
					dispose();
					DIYProjectPlanner.start(name, email);
				}
			}
			
		});
		
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
			
		});
		
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public void setEmail(String newEmail) {
		email = newEmail;
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	
	public void setInfo(DIYFileManager mng) {
		mng.setEmail(this.getEmail());
		mng.setName(this.getName());
	}
	
	public void open() {
		new Login();
	}
	
}
