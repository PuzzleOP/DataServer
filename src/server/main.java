package server;

public class main 
{
	static MainMenu menu = new MainMenu();
	static Database db = new Database();
	
	public static void main(String[] args) throws Exception
	{
		db.getConnection();
		db.InitDb();
		menu.main(args);
	}
}
