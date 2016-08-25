package fr.polytech.s20;

import java.awt.Color;

public class Diamond
{
	private int width = 0;
	private int height = 0;
	private int maxSize = 0;
	
	private int temporisation = 100;
	
	// grille de déplacement losange
	private int[][] grid;
		// -1 = cellule vide
		// autre = couleur
		
	private Color defaultColor = Color.GRAY;	
	
	private Color colors[][];
	
	// direction à suivre pour le déplacement
	private int xf, yf;
	
	// position du centre du losagne
	private int x0, y0;

	// couleurs utilisées
	private int colorDiamond[];
	
	// couleurs utilisables
	private Color listColor[];
	
	private boolean unUsedColor[];
	
	private int finalSquare[][];
	
	public Diamond()
	{
		this(null);
	}

	public Diamond(Color[][] cols) 
	{
		if(cols==null)
		{
			System.err.println("ARghh");
			System.exit(0);
		}
		
		colors = cols;
		width = colors.length;
		height = colors[0].length;
		
		// tableau des couleurs disponible pour les losanges
		listColor = new Color[Math.max(width, height)];
				
		// la taille du losange est 4* plus petite que le minimum (hauteur, largeur) 
		maxSize = (int)(Math.min(width, height)+1)/4;
				
		// tableau des couleurs utilisées. Le numéro k de la case est le numéro du losange (losange k) et l'information de la case donne la couleur
		colorDiamond = new int[maxSize+1];

		// Initialisation aléatoire de la liste des couleurs utilisables
		for (int i = 0; i < listColor.length; i++) 
		{
			int r = (int)(Math.random()*255);
			int g = (int)(Math.random()*255);
			int b = (int)(Math.random()*255);
			//System.out.println("listColor[" + i + "] --> r : " + r + " | g : " + g + " | b : " + b);
			listColor[i] = new Color(r, g, b);
		}
		
		// Initialisation de la grille vierge
		grid = new int[width][height];
		for (int w = 0; w < width; w++)
			for (int h = 0; h < height; h++)
				grid[w][h] = -1; // -1 donne "pas de changement"
		
		// Initialisation des couleurs non utilisées. Aucune couleurs utilisées : true
		unUsedColor = new boolean[Math.max(width, height)];
		for (int i = 0; i < unUsedColor.length; i++) 
		{
			unUsedColor[i] = true;
		}
		
		// Initialisation du centre 
		x0 = (int)((Math.random()*(width-2*maxSize))+maxSize);
		y0 = (int)((Math.random()*(height-2*maxSize))+maxSize);
		grid[x0][y0] = 0;
			
		// Initialisation des couleurs des loasanges
		for (int i = 0; i < colorDiamond.length; i++) 
		{
			colorDiamond[i] = grid[x0-maxSize+i][y0];
		}
				
		// Initialisation du tableau d'adresses finals disponibles
		finalSquare = new int[2][(2*(width-2*maxSize) + 2*(height-2*maxSize-2))];
		int var = 0;
		for (int x = maxSize; x < width-maxSize; x++)
		{
			// ligne du haut du carré final
			finalSquare[0][var] = x;
			finalSquare[1][var] = maxSize;
			// ligne du bas du carré final
			var++;
			finalSquare[0][var] = x;
			finalSquare[1][var] = height-maxSize-1;
			var++;
		}
		for (int y = maxSize; y < height-maxSize-2; y++)//non rentre la ligne du bas du carré final dans le tableau
		{
			// colonne de gauche du carré final
			finalSquare[0][var] = maxSize;
			finalSquare[1][var] = y;
			// colonne de droit du carré final
			var++;
			finalSquare[0][var] = width-maxSize-1;
			finalSquare[1][var] = y;
			var++;
		}
		
		//printGrid();
		
		// Initialisation de la direction
		xf=x0;
		yf=y0;
		
		// Lancement de la fonction
		for (int i = 0; i < 1000; i++) {
			setDiamond();
		}
	}

	/* ======================================================================================== */
	
	private void printGrid() 
	{
		//System.out.println("x0 : " + x0 + ", y0 : " + y0);
		
		//test affiche grille
		for (int h = 0; h < height; h++)
		{
			for (int w = 0; w < width; w++)
			{
				if(grid[w][h]>=0 && grid[w][h]<10) System.out.print(" " + grid[w][h] + " ");
				else System.out.print(grid[w][h] + " ");
			}
			System.out.println();
		}		
	}
	
	private void printColorDiamond() 
	{
		System.out.print("colorDiamond : ");
		for(int i = 0; i< colorDiamond.length; i++)
		{
			System.out.print(colorDiamond[i] + " ");
		}
		System.out.println();	
	}

	private void printCopyDiamond(int[][] copyDiamond) 
	{
		for (int h = 0; h <=2*maxSize; h++)
		{
			for (int w = 0; w <=2*maxSize; w++)
			{
				if(copyDiamond[w][h]>=0 && copyDiamond[w][h]<10) System.out.print(" " + copyDiamond[w][h] + " ");
				else System.out.print(copyDiamond[w][h] + " ");
			}
			System.out.println();
		}		
	}

	private void printFinalSquare() 
	{
		System.out.print("(x, y)");
		for (int x = 0; x < finalSquare.length; x++)
		{
			 System.out.print("(" + finalSquare[0][x] + ", " + finalSquare[1][x] + ")");
		}
		System.out.println();
	}
	
	private void setDiamond() 
	{
		//printFinalSquare();
		
		//System.out.println("dans le setDiamond()");
		refreshWindows();
		temp();
		for (int k = 0; k <= maxSize ; k++)
		{
//			printColorDiamond();
//			System.out.println("colorDiamond.lenght : " + colorDiamond.length);
//			System.out.println("maxSize : " + maxSize);
//			System.out.println("k : " + k + " | k+1 : " + k+1);
			if (maxSize-k ==0)
				{
					//System.out.println("dans le if de setDiamand()");
					getRandomColor();
					modifyColor(k);
				}
			else 
			{
				//System.out.println("dans le else de setDiamond()");
				colorDiamond[k] = colorDiamond[k+1];
				modifyColor(k); 
			}
			//printGrid();
			//colors[x0][y0] = Color.orange;
		}
		move();
		temp();
	}

	private void getRandomColor() 
	{
		int rand = (int)(Math.random()*listColor.length);
		if(unUsedColor[rand]==true) 
			{
				colorDiamond[maxSize] = rand;// couleur du centre
				if(colorDiamond[0]>=0) unUsedColor[colorDiamond[0]] = true; // le losange 0 va disparaitre donc sa couleur devient utilisable (test <=0 car la il se peut qu'il n'y ait aucune couleur : -1)
				unUsedColor[rand]=false; // la couleur est utilisée donc elle n'est plus utilisable
			}
		else getRandomColor();
		//System.out.println("colorDiamond[maxSize] " + colorDiamond[maxSize]);
	}

	private void modifyColor(int k)
	{
		int r = maxSize - k;
		for (int x = x0; x <= x0+r; x++) 
			for (int y = y0-r; y <= y0 ; y++)
				if(Math.abs(x0-x)==Math.abs(y0-r-y))
				{
					int color = colorDiamond[k];
					grid[x][y] = color;
					grid[x0-Math.abs(x-Math.abs(x0))][y] = color;
					grid[x0-Math.abs(x-x0)][y0+Math.abs(y-y0)] = color; // symétrie bas-gauche
					grid[x][y0+Math.abs(y-y0)] = color; // symétrie bas-droit
				}
	}

	private void refreshWindows() // on affiche sur la fenêtre ouverte ce qui est vraiment dans notre tableau grid[][]
	{
		for (int h = 0; h < height; h++)
			for (int w = 0; w < width; w++) 
			{
				if(grid[w][h]>=0) colors[w][h] = listColor[grid[w][h]];
				else colors[w][h] = defaultColor;
			}
	}

	private void move() 
	{
		if(xf==x0 && yf==y0) finalDirection(); // si on est déjà au point d'arrivé on recherche un nouveau point
		int direction[] = new int[2];
		direction = getCloseDirection(direction);
		copyDiamond(direction);
	}

	/* ------ donne la direction de "proche en proche" pour aller vers xf, yf ------ */
	private int[] getCloseDirection(int[] direction)
	{
		// utiliser pythagore pour que la trajectoire soit plus jolie (et donc droite)
		double distance[] = new double [9];
		distance[0] = Math.sqrt(Math.pow((x0-xf),2)+Math.pow((y0-yf), 2)); // la distance entre (x0,y0) et (xf,yf)
		distance[1] = Math.sqrt(Math.pow((x0-1-xf),2)+Math.pow((y0-yf), 2)); // (x0-1,y0) et (xf,yf) = gauche
		distance[2] = Math.sqrt(Math.pow((x0+1-xf),2)+Math.pow((y0-yf), 2)); // (x0+1,y0) et (xf,yf) = droite
		distance[3] = Math.sqrt(Math.pow((x0-xf),2)+Math.pow((y0-1-yf), 2)); // (x0,y0-1) et (xf,yf) = haut
		distance[4] = Math.sqrt(Math.pow((x0-xf),2)+Math.pow((y0+1-yf), 2)); // (x0,y0+1) et (xf,yf) = bas
		distance[5] = Math.sqrt(Math.pow((x0-1-xf),2)+Math.pow((y0-1-yf), 2)); // (x0-1,y0-1) et (xf,yf) = haut gauche
		distance[6] = Math.sqrt(Math.pow((x0-1-xf),2)+Math.pow((y0+1-yf), 2)); // (x0-1,y0+1) et (xf,yf) = haut droite
		distance[7] = Math.sqrt(Math.pow((x0+1-xf),2)+Math.pow((y0-1-yf), 2)); // (x0+1,y0-1) et (xf,yf) = bas gauche
		distance[8] = Math.sqrt(Math.pow((x0+1-xf),2)+Math.pow((y0+1-yf), 2)); // (x0+1,y0+1) et (xf,yf) = bas droite
		double minDistance = Double.MAX_VALUE;
		for (int i = 0; i < distance.length; i++)
		{
			System.out.print(distance[i] + " ");
			minDistance = Math.min(distance[i], minDistance);
		}
		System.out.println("\n" + minDistance);
		if(minDistance==distance[1]){ direction[0] = x0-1; direction[1] = y0;}
		else if(minDistance==distance[2]){ direction[0] = x0+1; direction[1] = y0;}
		else if(minDistance==distance[3]){ direction[0] = x0; direction[1] = y0-1;}
		else if(minDistance==distance[4]){ direction[0] = x0; direction[1] = y0+1;}
		else if(minDistance==distance[5]){ direction[0] = x0-1; direction[1] = y0-1;}
		else if(minDistance==distance[6]){ direction[0] = x0-1; direction[1] = y0+1;}
		else if(minDistance==distance[7]){ direction[0] = x0+1; direction[1] = y0-1;}
		else if(minDistance==distance[8]){ direction[0] = x0+1; direction[1] = y0+1;}
		else {direction[0] = x0; direction[1] = y0; System.err.println("bug : on ne devrait pas arriver à ce cas");}
		System.out.println("direction[] = " + direction[0] + ", " + direction[1]);
		return direction;
	}

	/* ------ Donne la direction finale pour le déplacement du losange ------ */
	private void finalDirection() // TODO faire en sorte que la position ne soit pas aléatoire mais résulte de l'angle avec lequel le losange rebondit
	{
		int randomf = (int)(Math.random()*(2*(width-2*maxSize) + 2*(height-2*maxSize-2)));
		
		xf = finalSquare[0][randomf];
		yf = finalSquare[1][randomf];
	}
	
	/*------ recopie le losange vers sa position proche ------*/
	private void copyDiamond(int[] direction)
	{	// copie du losange
		int[][] copyDiamond = new int[2*maxSize+1][2*maxSize+1];
		
		/////////////////////////////////////////
//		System.out.println("x0 : " + x0 + ", y0 : " + y0 + " | xf : " + xf + ", yf : " + yf + " | direction[0] : " + direction[0] + ", direction[1] : " + direction[1]);
//		System.out.println("Grid avant modification : ");
//		printGrid();
		/////////////////////////////////////////

		for(int x = 0; x<=2*maxSize; x++)
			for(int y = 0; y<=2*maxSize; y++)
			{
				copyDiamond[x][y] = grid[x+x0-maxSize][y+y0-maxSize];
				grid[x+x0-maxSize][y+y0-maxSize] = -1; // la LED copiée peut s'éteindre
			}
		
		/////////////////////////////////////////
//		System.out.println("CopyDiamond : ");
//		printCopyDiamond(copyDiamond);
		/////////////////////////////////////////
		
		// nouvelles valeurs du centre du losange
		x0 = direction[0];
		y0 = direction[1];
		
		// recopie au bon endroit du losange
		for(int x = 0; x<=2*maxSize; x++)
			for(int y = 0; y<=2*maxSize; y++)
			{
				grid[x+x0-maxSize][y+y0-maxSize] = copyDiamond[x][y];
			}
		
		/////////////////////////////////////////
//		System.out.println("Grid après modification : ");
//		printGrid();
//		System.out.println();
		/////////////////////////////////////////
		
	}

	private void temp() 
	{
		try {
			Thread.sleep(temporisation);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}