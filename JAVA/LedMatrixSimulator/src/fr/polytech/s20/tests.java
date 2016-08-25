package fr.polytech.s20;


	import java.awt.Color;
    import java.awt.*;
		
	public class tests {
		
      
		private int width = 0;
		private int height = 0;
		
		private int temporisation = 0; // temps entre deux animations
		
		private Color colors[][]; 
		
		private Color RightColor = Color.RED; // les ligne de droite sont de couleur rouge	
		private Color RightColor2 = new Color(255,55,55); // Rouge clair
		private Color RightColor3 = new Color(255,85,85); // Rouge clair clair

		private Color LeftColor = Color.BLUE; // les lignes de gauches sont de couleur bleu
		private Color LeftColor2 = new Color(55,55,255); // Bleu clair
		private Color LeftColor3 = new Color(85,85,255); // Bleu clair clair
		
		private Color Default = Color.LIGHT_GRAY;
		
		public tests(Color[][] cols)
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
					colors[w][h] = Default ;
			
			
			setAll(width, height);
		}

		

		private void setAll(int width, int height) 
		{
			colors[2][3] = RightColor;
			
			try 
			{
				Thread.sleep(temporisation);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
	}


