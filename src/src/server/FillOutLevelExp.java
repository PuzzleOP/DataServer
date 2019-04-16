package server;

import java.util.ArrayList;


public class FillOutLevelExp {
	
	int[] levelsfe()
	{
		int level[] = new int[100];
		for(int i = 1; i <= 100; i++)
			level[i] = i;
		return level;
	}
	
	int[] experiencefe()
	{
		int x = 100;
		int exp[] = new int[100];
		for(int i = 1; i <= 100; i++)
		{
			x = x + ((x/100) * 10);
			exp[i] = x;
		}
		return exp;
	}
	//for pushing

}
