package fr.polytech.s20;

import java.awt.Color;

public class Archimede {

	private int width = 0;
	private int height = 0;	
	
	private int temporisation=1000;
	
	private Color cuivre = new Color(179,103,0);
	private Color defaultColor = Color.GRAY;
	
	private Color colors[][];	
		
	public Archimede()
	{
		this(null);
	}
	
	public Archimede(Color[][] cols) {
		
			if(cols==null)
				{
				System.err.println("ARghh");
				System.exit(0);
				}
		
		colors = cols;
		width = colors.length; // nombre colonnes
		height = colors[0].length; // nombre lignes
		
		//creation fond uni
		
				for (int w =0; w<width; w++)
					for (int h=0;h<height; h++)
						colors[w][h]=defaultColor;
		
		//creation cuve
		
		for (int i =1 ;i<width-1;i++)
			colors[i][height-2]=cuivre;
		
		for (int j = height-3; j>=((height/3)+1);j--)
			colors[1][j]=colors[width-2][j]=cuivre;
		
		//robinet
		
		for(int i=width-1;i>=width-4;i--)
			colors[i][1]=Color.lightGray;
		colors[width-4][2]=Color.lightGray;
		
		//eau
		
		for (int i=3 ; i<height-2; i++)
			colors[width-4][i]=Color.CYAN;
		
		for (int i = height-3; i>=((height/3)+1);i--){
			int nb = (int) (6+Math.random()*(width-11)); //random entre a et b, a<b : a+Math.random()*(b-a)
				for (int e = nb; e<=width-3;e++)
					colors[e][i]=Color.CYAN;			
			Disque rouge = new Disque(nb,i,(width/6),Color.red,colors);			//on rajoute l eau 
			temp();
				for (int e=2;e<=width-3;e++)
					colors[e][i]=Color.cyan;				
			}
		
		int nb = (int) (6+Math.random()*(width-11));
		Disque rouge = new Disque(nb,(height/3),(width/6),Color.red,colors);
		temp();
		
		//eau depasse
		
		for (int i =0; i<width; i++)
			colors[i][height/3]=Color.cyan;
		
		colors[0][(height/3)+1]=colors[0][(height/3)+2]=colors[width-1][(height/3)+1]=colors[width-1][(height/3)+2]=Color.cyan;
		
		//le disque qui tombe
		
		int l =(width/6);
		if(nb<=width/2)
			for (int i = height-1; i>(height-1-l);i--)
				colors[0][i]=Color.red;
		else 
			for (int i = height-1; i>(height-1-l);i--)
				colors[width-1][i]=Color.red;
		temp();
		
		for (int h=height-1; h>=0; h--){
			for (int w=0; w<width; w++)
				colors[w][h]=Color.BLUE;
			temp2();
		}
		
		temp();
	
	}
	
	private void temp(){
		try 
		{
			Thread.sleep(temporisation); // la temporisation en milisecondes
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	private void temp2(){
		try 
		{
			Thread.sleep(200); // la temporisation en milisecondes
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}
