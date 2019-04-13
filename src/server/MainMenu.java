package server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MainMenu 
{

	public JFrame frame;
	
	private JFrame dialog;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JButton btnForgotLogin;
	private JButton btnRegister;
	private JButton btnLogin;
	private JLabel lblBackground;
	private JLabel lblUsername;
	private JLabel lblPassword;
	
	static Database db = new Database();
	static Register reg = new Register();
	static ForgotPassword fp = new ForgotPassword();
	static CreateCharacter cc = new CreateCharacter();
	static Ingame ig = new Ingame();

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try
				{
					MainMenu window = new MainMenu();
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
	public MainMenu()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 353, 289);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(145, 49, 98, 20);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(145, 100, 98, 20);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(41, 49, 82, 17);
		frame.getContentPane().add(lblUsername);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(41, 100, 82, 17);
		frame.getContentPane().add(lblPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(34, 157, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		btnRegister = new JButton("Register");
		btnRegister.setBounds(154, 157, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		btnForgotLogin = new JButton("Forgot Password");
		btnForgotLogin.setBounds(190, 216, 137, 23);
		frame.getContentPane().add(btnForgotLogin);
		
		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 337, 250);
		frame.getContentPane().add(lblBackground);
		
		//Action Listeners
		btnRegister.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				reg.frame.setVisible(true);
				frame.setVisible(false);
				reg.frame.setBounds(frame.getX(), frame.getY(), reg.frame.getWidth(), reg.frame.getHeight());
			}
		});
		
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String usernameEntered;
				String passwordEntered;
				
				usernameEntered = txtUsername.getText();
				passwordEntered = txtPassword.getText();
				
				try
				{
					ArrayList<String> userinfo;
					userinfo = db.getAccount(usernameEntered);
					if(usernameEntered.equals(userinfo.get(0)) && passwordEntered.equals(userinfo.get(1)))
					{
						int hasChar = Integer.parseInt(userinfo.get(4));
						if(hasChar == 0)
						{
							JOptionPane.showMessageDialog(dialog,"You need to create a new character!");
						}
						else if(hasChar == 1)
						{
							JOptionPane.showMessageDialog(dialog,"You have logged in!");
						}
						else
						{
							System.out.println("hacking!");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(dialog,"You have entered an incorrect password!");
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(dialog,"Incorrect username!");
				}
				
				
			}
		});
		
		btnForgotLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
		});
	}
}
