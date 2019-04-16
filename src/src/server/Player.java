package server;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Player
{

	static Database db = new Database();
	
	JFrame dialog = new JFrame();
	
	String name;
	String gender;
	String clas;
	
	int money;
	int level;
	int exp;
	int health;
	int attack;
	int defense;
	
	
	Player(String iname, String igender, int imoney, int ilevel, int iexp, String iclas, int ihealth, int iattack, int idefense)
	{
		name = iname;
		gender = igender;
		clas = iclas;
		
		money = imoney;
		level = ilevel;
		exp = iexp;
		health = ihealth;
		attack = iattack;
		defense = idefense;
	}
	
	public String getName() { return name; }
	public String getGender() { return gender; }
	public String getClas() { return clas; }
	
	public int getMoney() { return money; }
	public int getLevel() { return level; }
	public int getExp() { return exp; }
	public int getHealth() { return health; }
	public int getAttack() { return attack; }
	public int getDefense() { return defense; }
	
	public void setMoney(int gold) { money = gold; }
	public void setLevel(int lvl) { level = lvl; }
	public void setExp(int e) { exp = e; }
	public void setHealth(int hp) { health = hp; }
	public void setAttack(int att) { attack = att; }
	public void setDefense(int def) { defense = def; }
	
	void CheckLevel() throws Exception
	{
		ArrayList<String> table = db.getExperience(level);
		int expreq = Integer.parseInt(table.get(1));
		if(getExp() >= expreq)
		{
			JOptionPane.showMessageDialog(dialog, "You are now level " + level);
			level++;
			exp = expreq - exp;
			//do levelup from database
		}
	}
	
}