package fr.polytech.s20;

import java.awt.Color;

public class Hanoi {

	private int width = 0;
	private int height = 0;	
	
	private int temporisation=1000;
	
	private Color colors[][];	
	
	private Color defaultColor = Color.GRAY;
	
	public Hanoi()
	{
		this(null);
	}
	
public Hanoi(Color[][] cols) {
		
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
		
		//creation socle
		
		for(int i = 0; i<width; i++)
			colors[i][height-1]=Color.black;
			
		//creation piliers
	 
		int Pilier1 = (width/3)/2+1;
		int Pilier2 = ((width/3)/2*3)+1;
		int Pilier3 = (width/3)/2*5+1;
		for (int i = 1; i <height-1; i++)
			colors[Pilier1][i]=Color.pink;
		for (int i = 1; i <height-1; i++)
			colors[Pilier2][i]=Color.pink;
		for (int i = 1; i <height-1; i++)
			colors[Pilier3][i]=Color.pink;
	
		//initialisation
		
		int l1 = ((Pilier2-Pilier1)/2)*2;
		Disque disque1 = new Disque(Pilier1,height-2,l1,Color.RED, colors);		
		int l2 = l1-2;
		Disque disque2 = new Disque(Pilier1,height-3,l2,Color.ORANGE, colors);
		int l3 = l2 -2;
		Disque disque3 = new Disque(Pilier1,height-4,l3,Color.YELLOW, colors);
		int l4 = l3-2;
		Disque disque4 = new Disque(Pilier1,height-5,l4,Color.MAGENTA, colors);
		temp();
		
		deplacer(disque4,Pilier1,Pilier2,height-2,height-5); //itÃƒÂ©ration 1
		temp();
		
		deplacer(disque3,Pilier1,Pilier3,height-2,height-4); //itÃƒÂ©ration 2
		temp();
		
		deplacer(disque4,Pilier2,Pilier3,height-3,height-2); //itÃƒÂ©ration 3
		temp();
		
		deplacer(disque2,Pilier1,Pilier2,height-2,height-3); //itÃƒÂ©ration 4
		temp();
		
		deplacer(disque4,Pilier3,Pilier1,height-3,height-3); //itÃƒÂ©ration 5
		temp();
		
		deplacer(disque3,Pilier3,Pilier2,height-3,height-2); //itÃƒÂ©ration 6
		temp();
		
		deplacer(disque4,Pilier1,Pilier2,height-4,height-3); //itÃƒÂ©ration 7
		temp();
		
		deplacer(disque1,Pilier1,Pilier3,height-2,height-2);	//itÃƒÂ©ration 8
		temp();
		
		deplacer(disque4,Pilier2,Pilier3,height-3,height-4); //itÃƒÂ©ration 9
		temp();
		
		deplacer(disque3,Pilier2,Pilier1,height-2,height-3); //itÃƒÂ©ration 10
		temp();
		
		deplacer(disque4,Pilier3,Pilier1,height-3,height-3); //itÃƒÂ©ration 11
		temp();
		
		deplacer(disque2,Pilier2,Pilier3,height-3,height-2); //itÃƒÂ©ration 12
		temp();
		
		deplacer(disque4,Pilier1,Pilier2,height-2,height-3); //itÃƒÂ©ration 13
		temp();
		
		deplacer(disque3,Pilier1,Pilier3,height-4,height-2); //itÃƒÂ©ration 14
		temp();
		
		deplacer(disque4,Pilier2,Pilier3,height-5,height-2); //itÃ©ration 15
		temp();
		
	}

private void deplacer(Disque disque, int pilierA, int pilierD, int hauteur, int hauteur2){
	
	//cree le nouveau disque
	int largeur = disque.largeur;
	Color col = disque.col;
	Disque tempo = new Disque(pilierD, hauteur, largeur, col, colors );
	
	//faire disparaitre l ancien 
	disque = tempo;
	tempo = new Disque(pilierA,hauteur2,largeur,defaultColor,colors) ;
	colors[pilierA][hauteur2]=Color.pink;
	
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
