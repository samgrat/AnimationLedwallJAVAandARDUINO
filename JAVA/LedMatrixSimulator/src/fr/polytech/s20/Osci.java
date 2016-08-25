package fr.polytech.s20;

import java.awt.Color;

public class Osci {


	private int width = 0;
	private int height = 0;	
	
	private int temporisation=350;

	private Color colors[][]; 
	private Color citrouille = new Color(223,109,20);
	private Color fond = Color.gray;
	public Osci()
	{
		this(null);
	}

	public Osci(Color[][] cols) {
		
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
				colors[w][h]=fond;
		
		//initialisation ligne vide
		
		for(int w = 0; w<=(width/3)*2; w++)
			colors[w][height/2]=citrouille;
			
		temp();
			
		int y = height/2;					//oscilation
		int compteur=0;
		int deplacement=0;
		int nb0=0;
		while(compteur<=50){
			for (int c = 1; c<=(width/3)*2;c++)
				copieColonne(c,c-1);
			colors[(width/3)*2][y]=fond;
			
			if(nb0==1){					//pour pas avoir plus de 2 continu de suite
				if (y==0)			
					deplacement = 1;
				if (y==height-1)
					deplacement = -1;			
				if (y!=height-1 && y !=0)	{		//soit 1 ou -1
					int a = -1;
					int b = 1;
					int c = (int) (Math.random()*2); 
						if(c == 0 )
							deplacement = a;
						else 
								deplacement = b ;
				}
				nb0 = 0;
			}
			else {
				if (y==0)			
					deplacement = (int) (Math.random()*2);
				if (y==height-1)
					deplacement = (int) (Math.random()*2)-1;			
				if (y!=height-1 && y !=0)
					deplacement = (int) (Math.random()*3)-1;
			}
			if (deplacement == -1){
				colors[(width/3)*2][y-1]=citrouille;
				y = y-1;
			}
			if (deplacement == 0){
				colors[(width/3)*2][y]=citrouille;
				nb0 ++;
			}
			if (deplacement == 1){
				colors[(width/3)*2][y+1]=citrouille;
				y = y+1;
			}
			temp();
			compteur ++ ;
		}
		
		// fin
		
		if(y<height/2)
			for (int a=y; a<=height/2;a++){
				colors[(width/3)*2][a]=citrouille;
				temp();
				for (int c = 1; c<=(width/3)*2;c++)
					copieColonne(c,c-1);
				colors[(width/3)*2][a]=fond;	
			}
		if(y>height/2)
			for(int b=y; b>=height/2; b--){
				colors[(width/3)*2][b]=citrouille;
				temp();
				for (int c = 1; c<=(width/3)*2;c++)
					copieColonne(c,c-1);
				colors[(width/3)*2][b]=fond;
				
			}
		for(int w=(width/3)*2;w<width;w++){
			colors[w][height/2]=citrouille;
			temp();
	}
		
//		int l = width-((width/3)*2);
		int i = 0;
		while(i<width-2){
			for (int c = 1; c<=(width-1);c++)
				copieColonne(c,c-1);			
		colors[width-1][height/2]=citrouille;
		temp();
			i++;
		}
	  }
		
	private void copieColonne (int widthDepart, int widthArrive){
		for (int h = 0;h<height;h++){
			colors[widthArrive][h]=colors[widthDepart][h]; // ex : la colonne 1 est la copie de la colonne 0
		}
	}
	
	private void temp (){
			try 
			{
				Thread.sleep(temporisation); // la temporisation en milisecondes
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}		
}

