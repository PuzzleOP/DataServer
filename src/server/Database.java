package server;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database 
{
	
	public static Connection getConnection() throws Exception
	{
		try
		{
			String driver = "com.mysql.cj.jdbc.Driver";
			String databaseName = "dataserver";
			String url = "jdbc:mysql://localhost:3306/dataserver?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username = "root";
			String password = "d9324340";
			Class.forName(driver);		
			Connection connection = DriverManager.getConnection(url,username,password);
			System.out.println("Connected to " + databaseName + " as " + username);
			return connection;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;	
	}
	
	public static void createTableAccounts() throws Exception
	{
		try
		{
			Connection connection = getConnection();
			PreparedStatement createAccounts = connection.prepareStatement("CREATE TABLE IF NOT EXISTS accounts(id int NOT NULL AUTO_INCREMENT, username varchar(255), password varchar(255), age int, security varchar(255) , PRIMARY KEY(id))");
			createAccounts.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Create Table Accounts function has been completed!");
		}
	}
	
	public static void insertAccount(String username, String password, int age, String security) throws Exception
	{
		try
		{
			Connection connection = getConnection();
			
			PreparedStatement insertAccountStatement = connection.prepareStatement("INSERT INTO accounts(username, password, age, security) VALUES ('" + username + "', '" + password + "', '" + age + "', '" + security + "')");
			insertAccountStatement.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Insert account into table has been completed!");
		}
	}
	
	public static ArrayList<String> getAccount(String username) throws Exception
	{
		try
		{
			Connection connection = getConnection();
			PreparedStatement getAccountStatement = connection.prepareStatement("SELECT * FROM accounts WHERE username = '" + username + "'");
			
			ResultSet result = getAccountStatement.executeQuery();
			ArrayList<String> array = new ArrayList<String>();
			while(result.next())
			{
				array.add(result.getString("username"));
				array.add(result.getString("password"));
				array.add(result.getString("age"));
				array.add(result.getString("security"));
			}
			return array;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	public static void printArray(ArrayList<String> array) throws Exception
    {
    	for(int i = 0; i < array.size(); i++)
    	{
    		System.out.println(array.get(i));
    	}
    }
	
	public void InitDb() throws Exception
	{
		createTableAccounts();
	}
}