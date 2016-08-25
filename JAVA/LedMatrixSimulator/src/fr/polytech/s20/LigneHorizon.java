package fr.polytech.s20;


	import java.awt.Color;
    import java.awt.*;
		
	public class LigneHorizon {
		
      
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
		
		private Color Default = Color.WHITE;
		
		public LigneHorizon(Color[][] cols)
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
			
			// Appel des fonctions de ligne :
			setAll(width, height);
		}

		

		private void setAll(int width, int height) 
		{
			for(int decal = 0; decal < width-5; decal++){
				for (int k = 0; k < height/2; k++){
					
					colors[19-decal][2*k] = RightColor3; //lignes rouges des lignes paires arrivant par la gauche 
					colors[18-decal][2*k] = RightColor2;
					colors[17-decal][2*k] = RightColor;
					colors[16-decal][2*k] = RightColor2;
					colors[15-decal][2*k] = RightColor3;
					
					colors[0+decal][2*k+1] = LeftColor3; //lignes rouges des lignes paires arrivant par la gauche 
					colors[1+decal][2*k+1] = LeftColor2;
					colors[2+decal][2*k+1] = LeftColor;
					colors[3+decal][2*k+1] = LeftColor2;
					colors[4+decal][2*k+1] = LeftColor3;
				}
					
					try 
					{
						Thread.sleep(75);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					
					for(int k = 0; k < height/2; k++){
						
					colors[19-decal][2*k] = Default; //lignes rouges des lignes paires arrivant par la gauche 
					colors[18-decal][2*k] = Default;
					colors[17-decal][2*k] = Default;
					colors[16-decal][2*k] = Default;
					colors[15-decal][2*k] = Default; 
					
					
					colors[0+decal][2*k+1] = Default; //lignes rouges des lignes paires arrivant par la gauche 
					colors[1+decal][2*k+1] = Default;
					colors[2+decal][2*k+1] = Default;
					colors[3+decal][2*k+1] = Default;
					colors[4+decal][2*k+1] = Default;
					}

// Toute les boucles l,m,n et o qui suivent gèrent l'affaichage des barres lorqu'elles atteignent les cotés
				}
			
			for(int l = 0; l <height/2; l++){
				
				colors[0][2*l] = RightColor2;
				colors[1][2*l] = RightColor;
				colors[2][2*l] = RightColor2;
				colors[3][2*l] = RightColor3;
				
				colors[19][2*l+1] = LeftColor2;
				colors[18][2*l+1] = LeftColor;
				colors[17][2*l+1] = LeftColor2;
				colors[16][2*l+1] = LeftColor3;
			}
			
			try 
			{
				Thread.sleep(75);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			for(int l = 0; l < height/2; l++){
				
			colors[0][2*l] = Default;
			colors[1][2*l] = Default;
			colors[2][2*l] = Default;
			colors[3][2*l] = Default;
			
			colors[19][2*l+1] = Default;
			colors[18][2*l+1] = Default;
			colors[17][2*l+1] = Default;
			colors[16][2*l+1] = Default;
			}
			
			for(int m = 0; m <height/2; m++){
				
				colors[0][2*m]= RightColor;
				colors[1][2*m] = RightColor2;
				colors[2][2*m] = RightColor3;
				
				colors[19][2*m+1] = LeftColor;
				colors[18][2*m+1] = LeftColor2;
				colors[17][2*m+1] = LeftColor3;
				
			}
			
			try 
			{
				Thread.sleep(75);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			for(int m = 0; m <height/2; m++){
				
				colors[0][2*m]= Default;
				colors[1][2*m] = Default;
				colors[2][2*m] = Default;
				
				colors[19][2*m+1] = Default;
				colors[18][2*m+1] = Default;
				colors[17][2*m+1] = Default;
				
			}			

			for(int n = 0; n <height/2; n++){
				
				colors[0][2*n]= RightColor2;
				colors[1][2*n] = RightColor3;
				
				colors[19][2*n+1] = LeftColor2;
				colors[18][2*n+1] = LeftColor3;
				
			}
			
			try 
			{
				Thread.sleep(75);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			for(int n = 0; n <height/2; n++){
				
				colors[0][2*n]= Default;
				colors[1][2*n] = Default;
				
				colors[19][2*n+1] = Default;
				colors[18][2*n+1] = Default;
				
			}	

			for(int o = 0; o <height/2; o++){
				
				colors[0][2*o] = RightColor3;
				
				colors[19][2*o+1] = LeftColor3;
				
			}
			
			try 
			{
				Thread.sleep(75);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			for(int o = 0; o <height/2; o++){
				
				colors[0][2*o]= Default;
				
				colors[19][2*o+1] = Default;
				
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


