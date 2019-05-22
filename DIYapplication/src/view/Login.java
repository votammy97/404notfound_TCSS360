package view;

import javax.swing.*;
import java.awt.*;


public class Login extends JFrame{
	JTextField firstName;
	JTextField emailAddress;
	JLabel jlabel1;
	JLabel jlabel2;
	JButton button1;
	JButton button2;
	
	JPanel panel1;
	JPanel panel2;
	JPanel panel3;
	
	public Login() {
		firstName = new JTextField(12);
		emailAddress = new JTextField(12);
		jlabel1 = new JLabel("First Name");
		jlabel2 = new JLabel("Email Address");
		button1 = new JButton("ok");
		button2 = new JButton("cancel");
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		
		this.setLayout(new GridLayout(3,1));
		
		panel1.add(jlabel1);
		panel1.add(firstName);
		
		panel2.add(jlabel2);
		panel2.add(emailAddress);
		
		panel3.add(button1);
		panel3.add(button2);
		
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setTitle("Login");
	}
	
	public static void main(String[] args) {
		new Login();
	}
	
}
