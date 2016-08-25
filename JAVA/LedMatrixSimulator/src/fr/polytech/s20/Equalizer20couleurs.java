package fr.polytech.s20;


	import java.awt.*;
		
	public class Equalizer20couleurs {
		
      
		private int width = 10;
		private int height = 20;
		private int r=0,g=0,b=0;
		private Color CouleurAlea = new Color(r,g,b);

		private int temporisation = 0; // temps entre deux animations
		private int temps = 15000; //temps d'animation en ms
		private int hmax = 0; //hauteur aléatoire d'une colonne
		private int hmax1 =height; //hauteur maximale pour l'effet vague
		private int k =0; 
		private Color colors[][]; 
		
		// L'equalizateur possède 2 modes + le mode couleurs aléatoire:
		
		private Color[][] MatrixCouleurs = {{},{},{},{},{},{},{},{},
	    // MatrixCouleur[8][] contient les 8 couleurs du mode Arc-en-ciel
				{Color.RED,Color.ORANGE,Color.YELLOW,new Color(173,255,0),Color.GREEN,new Color(0,255,0),Color.BLUE},{},{},{},{},{},{},{},{},{},{},{},
		// MatrixCouleur[20][] contient les 20 couleurs du mode 20 couleurs
				{new Color(0,0,255),new Color(51,0,204),new Color(51,0,153),new Color(51,102,153),new Color(51,153,153),new Color(51,204,153),new Color(51,255,153),new Color(102,255,153),new Color(102,255,153),new Color(102,204,153),new Color(102,153,153),new Color(102,102,153),new Color(102,51,153),new Color(102,0,153),new Color(255,0,153),new Color(255,51,153),new Color(255,102,153),new Color(255,153,153),new Color(255,204,153),new Color(255,255,153),new Color(255,255,102)}};

		private Color Default = Color.BLACK;
		
		public Equalizer20couleurs(Color[][] cols)
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
			//On verifie si le mode Arc-en-ciel ou le mode 20 couleurs peut-être activé
			if(width == 8 || width == 20){
				// effet "vague" au démarrage
				/*for(int i1 =0; i1<20; i1++){
					for(int k=0; k<width; k++){
					for(int w1 =k; w1< width ; w1++){
						for(int h1 =0; h1<hmax1; h1++){
							for(int l =0; l<width; l++){
							try{
								colors[w1][h1] = MatrixCouleurs[width][w1];
								colors[w1-l][h1] = MatrixCouleurs[width][w1];
							} catch (ArrayIndexOutOfBoundsException e){}
							hmax1--; }}}	
					}	try 
					{
						Thread.sleep(10000);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					}*/
				
				
						
				for(int i =0; i <100; i++){
				for(int w=0; w<width; w++){
					hmax = (int) (Math.random()*(height))+1;
					for(int h=0; h<hmax; h++)
						colors[w][height-1-h] = MatrixCouleurs[width][w];
				}
				try 
				{
					Thread.sleep(175);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
					
					for (int w = 0; w < width; w++)
						for (int h = 0; h < height; h++)
							colors[w][h] = Default ;	
				
				}}
			
			/*else // Sinon on passe l'equalizer en mode aléatoire
				for(int w=0; w<width; w++){
					System.err.println("pass1");
					hmax = (int) (Math.random()*(height))+1;
					
					// On defini une couleur aléatoire qui n'est pas trop "pâle"
				while(r < 50){
					    r = (int) Math.random()*255;
						g = (int) Math.random()*255;
						b = (int) Math.random()*255;
						System.err.println("pass2");}
			
					CouleurAlea = new Color(r,g,b);
					
					for(int h=0; h<hmax; h++)
						colors[w][height-1-h] = CouleurAlea; 
					System.err.println("pass3");

				}*/ //  à réparer
				
			
			try 
			{
				Thread.sleep(temporisation);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}
		
	} // FIN Equalizer20couleurs


