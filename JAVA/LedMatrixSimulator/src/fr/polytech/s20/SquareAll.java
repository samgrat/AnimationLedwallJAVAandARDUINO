package fr.polytech.s20;


import java.awt.Color;

public class SquareAll 
{
	private int width = 0;
	private int height = 0;
	
	private int temporisation = 500; // temps entre deux annimations (changement de carré) utilisée dans Thread.sleep();
	
	private Color colors[][];
	
	// Ici on va devoir définir quelques couleurs (environ 10)
	public Color[] listColor = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	// Ces couleurs seront selectionnées aléatoirement à chaque fois pour un nouveau carré (parmis une couleur non affichée dans la fonction getRandomColor)
	private Color[] list2;
	
	public SquareAll()
	{
		this(null);
	}

	public SquareAll(Color[][] cols)
	{
		if(cols==null)
		{
			System.err.println("ARghh");
			System.exit(0);
		}
		
		// Initialise list2 avec des random couleur pour une longueur égale à celle de listColor
		Color list2[] = new Color[listColor.length];
		LEDMatrix  LEDM = new LEDMatrix();
		for (int i = 0; i < list2.length; i++)
		{
			list2[i] = LEDM.getRandomColor();
		}
		
		///////////////////// 
		listColor=list2;
		/////////////////////
		colors = cols;
		width = colors.length; // nombre colonnes
		height = colors[0].length; // nombre lignes

		Color colorSquare[] = new Color[(height+1)/2];
		// Initialisation colorSquare
		for (int i = 0; i < colorSquare.length; i++) 
		{
			colorSquare[i] = Color.GRAY;
		}
		
		// Appel des fonctions de carré :
		setSquare(width, height, listColor, colorSquare);
	}

	private void setSquare(int width, int height, Color[] listColor, Color[] colorSquare) 
	{
		int compteur = 0;
		while(compteur<=15)
		{
		for (int k = 0; k < (Math.min(width, height)+1)/2 ; k++) // +1 car si c'est impaire ça ne fonctionne pas
		{
			if((width-2*k <= 2) || (height-2*k <= 2))
			{	
				if(Math.min(width, height)%2==0)
				{
					colorSquare[k] = getRandomColor2(colorSquare);
					modifyColor(width, height, k, colorSquare);
					for(int w=k; w< width-k; w++)
						for(int h=k; h< height-1-k; h++)
						{
							colors[w][h+1] = colors[w][h]; // recopie la couleur de la ligne du dessus
						}
				}
				else
				{
					colorSquare[k] = getRandomColor2(colorSquare);
					modifyColor(width, height, k, colorSquare);
				}
			}
			else 
			{
				colorSquare[k] = colorSquare[k+1];
				//System.out.println(colorSquare[k]+" et "+colorSquare[k+1]);
				modifyColor(width, height, k, colorSquare);
			}
		}
		
		try 
		{
			Thread.sleep(temporisation); // la temporisation en milisecondes
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		compteur++;
		}
	}

	private Color getRandomColor2(Color[] colorSquare) 
	{
		int var = (int)(Math.random()*listColor.length); // voir si on peut faire : Color col = listColor[(int)(Math.random()*listColor.length)]; pour supprimer la variable "var"
		Color col = listColor[var];
		for(int i=0; i<colorSquare.length;i++)
			if(col==colorSquare[i]) return getRandomColor2(colorSquare); // si la couleur est déjà utilisée, on relance la fonction
		return col;
	}

	private void modifyColor(int width, int height, int k, Color[] colorSquare) 
	{
		// on va en fait appliquer le tableau de couleur colorSquare[] au tableau colors[][]

		for(int w=0; w< width; w++)
			for(int h=0; h< height; h++)
			{
				if(((w==k)&&(k<=h)&&(h<=height-1-k))/*colonne carré gauche*/ || ((h==k)&&(k<=w)&&(w<=width-1-k))/*ligne carré haut*/ || ((w==width-1-k)&&(k<=h)&&(h<=height-1-k))/*colonne carré droit*/ || ((h==height-k-1)&&(k<=w)&&(w<=width-1-k))/*ligne carré bas*/)
					/*alors ceci est un carré et on applique la couleur*/ colors[w][h] = colorSquare[k];
			}
	}
	
}
