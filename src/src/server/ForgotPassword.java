package server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

public class ForgotPassword {

	private JFrame frame;
	private JFrame dialog;
	
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtSecurity;
	boolean valid = false;

	
	private String username;
	private String password;
	private String security;
	
	static Database db=new Database();
	static MainMenu menu=new MainMenu();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword window = new ForgotPassword();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ForgotPassword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 299, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(90, 260, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(90, 291, 89, 23);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(10, 35, 89, 33);
		frame.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(157, 43, 106, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(157, 101, 106, 20);
		frame.getContentPane().add(txtPassword);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(10, 93, 89, 33);
		frame.getContentPane().add(lblPassword);
		
		txtSecurity = new JTextField();
		txtSecurity.setColumns(10);
		txtSecurity.setBounds(157, 130, 106, 20);
		frame.getContentPane().add(txtSecurity);
		
		JLabel lblSecurity = new JLabel("Security Answer: ");
		lblSecurity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSecurity.setBounds(10, 130, 106, 20);
		frame.getContentPane().add(lblSecurity);
		
		
		
	    btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.dispose();
				menu.frame.setVisible(true);
			}
		});
	    
	    btnLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(dialog, "Please fill out every field!");
				}
				else
				{
					username = txtUsername.getText();
					password = txtPassword.getText();
					security= txtSecurity.getText();
					try
					{
						username=txtUsername.getText();
						static Database db=new Database();
						
						if(username.equals(dt.getAccount(username)))
						{
							
						}
						else
						{
							JOptionPane.showMessageDialog(dialog, "Username taken!");
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					
				}
			}
		});

	}
	
	}

