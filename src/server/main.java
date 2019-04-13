package server;

public class main 
{
	public static void main(String[] args) throws Exception
	{
		Database db = new Database();
		//db.getConnection();
		db.InitDb();
		//db.printArray(db.getAccount("test"));
	}
}
