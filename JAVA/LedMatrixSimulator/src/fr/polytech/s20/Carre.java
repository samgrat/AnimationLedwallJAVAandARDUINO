package fr.polytech.s20;

import java.awt.Color;

public class Carre
{
	private int width = 0;
	private int height = 0;
	
	private int temporisation = 500; // temps entre deux annimations (changement de carré)
	
	private Color colors[][]; 
	
	private Color defaultColor = Color.GREEN; // le fond est de couleur verte	

	private Color carreColor = Color.PINK; // le carré est de couleur rose
	
	public Carre()
	{
		this(null);
	}

	public Carre(Color[][] cols)
	{
		if(cols==null)
		{
			System.err.println("ARghh");
			System.exit(0);
		}
		
		colors = cols;
		width = colors.length; // nombre colonnes
		height = colors[0].length; // nombre lignes
				
		// Initialisation de la couleur de la grille
		for (int w = 0; w < width; w++) 
			for (int h = 0; h < height; h++)
				colors[w][h] = defaultColor;
		
		// Appel des fonctions de carré :
		setAll(width, height);
	}

	private void setAll(int width, int height) 
	{
		for(int i = 0; i < height/2; i++) // le "i" donne le cadre avec une distance qui part du centre
			setSquare(width, height, i);
	}

	private void setSquare(int width, int height, int i)
	{
		for(int w=0; w< width; w++)
			for(int h=0; h< height; h++)
			{
				if(((w==(width/2-i-1))&&(h>=(height/2-1-i))&&(h<=height/2+i)) || ((w==(width/2+i))&&(h>=(height/2-1-i))&&(h<=height/2+i))) 
					{
						colors[w][h] = colors[h][w] = carreColor;
					}					
			}
		try 
		{
			Thread.sleep(temporisation);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
}
