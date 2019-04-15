package server;

public class main 
{
	static MainMenu menu = new MainMenu();
	static Database dt = new Database();
	
	public static void main(String[] args) throws Exception
	{
		dt.getConnection();
		dt.InitDb();
		menu.main(args);
	}
}
