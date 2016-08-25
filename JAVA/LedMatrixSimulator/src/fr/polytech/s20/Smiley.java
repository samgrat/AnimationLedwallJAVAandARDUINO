package fr.polytech.s20;


	import java.awt.Color;
    import java.awt.*;
		
	public class Smiley {
		
      
		private int width = 20;
		private int height = 10;
		private int col = width/2; // la moitié de la largueur de la grille
		private int lig = height/2; // la moitié de la longueur de la grille
		private int temps = (int) (Math.random()*2000)+1000;
		
		private int temporisation = 0; // temps entre deux animations
		
		private Color colors[][]; 
		
		private Color ColorFace = Color.RED; // Couleur du Smiley
		
		private Color Default = Color.BLUE;
		
		public Smiley(Color[][] cols)
		{
			if(cols==null || width < 8 || height < 7)
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
					colors[w][h] = Default ;
			
			// Appel des fonctions de ligne :
			setAll(width, height);
		}

		

		private void setAll(int width, int height) 
		{
			int k =1,l=0;
			
			for (int i= 0; i <2; i++){ // On fait deux boucles - pour le coté gauche et pour le coté droit de l'image -.
			
				colors[col-(k)*(4-l)][lig+1] = ColorFace;
				colors[col-(k)*(3-l)][lig+2] = ColorFace;
				colors[col-(k)*(3-l)][lig-2] = ColorFace;
				colors[col-(k)*(2-l)][lig+3] = ColorFace;
				colors[col-(k)*(2-l)][lig-2] = ColorFace;
				colors[col-(k)*(1-l)][lig+1] = ColorFace;
				colors[col-(k)*(1-l)][lig] = ColorFace;
				colors[col-(k)*(1-l)][lig+3] = ColorFace;
				
				// On s'occupe du coté droit:
				k = -1;
			    l=1;
			}
			
			for (int i = 0; i < 5; i++){ // le smiley effectue 5 clins d'oeils
				
				colors[col-3][lig-3] = ColorFace;
				colors[col-2][lig-3] = ColorFace;
				colors[col+2][lig-3] = ColorFace;
				colors[col+1][lig-3] = ColorFace;
				
				try 
				{
					Thread.sleep(temps);  //temps d'attente aléatoire entre deux clins d'oeil
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				
				colors[col-3][lig-3] = Default;
				colors[col-2][lig-3] = Default;
				colors[col+2][lig-3] = Default;
				colors[col+1][lig-3] = Default;
				
				try 
				{
					Thread.sleep(500);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				
				temps = (int) (Math.random()*2000)+1000;
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


