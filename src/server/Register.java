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

public class Register 
{

	public JFrame frame;	
	private JFrame dialog;
	
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtSecurity;
	private JTextField txtAge;
	
	private String username;
	private String password;
	private String security;
	
	private int age;
	
	static Database db = new Database();
	static MainMenu menu = new MainMenu();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run() 
			{
				try 
				{
					Register window = new Register();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 299, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(39, 291, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(174, 291, 89, 23);
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
		txtSecurity.setBounds(157, 229, 106, 20);
		frame.getContentPane().add(txtSecurity);
		
		JLabel lblSecurity = new JLabel("Security Answer: ");
		lblSecurity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSecurity.setBounds(10, 221, 118, 33);
		frame.getContentPane().add(lblSecurity);
		
		JLabel lblAge = new JLabel("Age: ");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAge.setBounds(10, 163, 89, 33);
		frame.getContentPane().add(lblAge);
		
		txtAge = new JTextField();
		txtAge.setColumns(10);
		txtAge.setBounds(157, 171, 106, 20);
		frame.getContentPane().add(txtAge);
		
		//Action Events
		
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				frame.dispose();
				menu.frame.setVisible(true);
			}
		});
		
		btnRegister.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty() || txtAge.getText().isEmpty() || txtSecurity.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(dialog, "Please fill out every field!");
				}
				else
				{
					username = txtUsername.getText();
					password = txtPassword.getText();
					age = Integer.parseInt(txtAge.getText());
					security= txtSecurity.getText();
					try
					{
						if(checkAvailable(username) == true)
						{
							db.insertAccount(username, password, age, security, 0);
							menu.frame.setVisible(true);
							frame.dispose();
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
	
	boolean checkAvailable(String username) throws Exception
	{
		boolean taken = true;
		try
		{
			ArrayList<String> user = db.getAccount(username);
			if(user.get(0).equals(username))
			{
				taken = false;
			}
			return taken;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return taken;		
	}

}
