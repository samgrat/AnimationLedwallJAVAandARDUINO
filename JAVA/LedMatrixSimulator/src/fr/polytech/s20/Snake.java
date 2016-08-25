package fr.polytech.s20;

import java.awt.Color;

public class Snake {
	
	private int width = 0;
	private int height = 0;
	
	private int temporisation=50; // tempo entre deux mouvements du snake
	private int snakeSize;
	
	private Color colors[][];

	// Grille de déplacement du snake
	private int[][] grid;
		// 0 = cellule vide, 
		// 1 = tete du snake
		// 2 = corps du snake
		// 3 = queue du snake
	
	// Positions du snake dans la grille
	private int[][] snake; // snake[0] est le tableau des 2 coordonnées de la tête du snake
	
	private Color snakeColor = new Color((int) (255 * Math.random()),(int) (255 * Math.random()),(int) (255 * Math.random()));
	private Color headColor = Color.PINK;
	private Color defaultColor = Color.GRAY;	

	public Snake()
	{
		this(null);
	}
	public Snake(Color[][] cols)
	{
		if(cols==null)
		{
			System.err.println("ARghh");
			System.exit(0);
		}
		
		colors = cols;
		width = colors.length;
		height = colors[0].length;
		defaultColor = colors[0][0]; 
		
		// Initialisation de la grille vierge
		grid = new int[width][height];
		for (int w = 0; w < width; w++)
			for (int h = 0; h < height; h++)
				grid[w][h] = 0;

		// Init du snake en position initiale
		snake = new int[width*height][2];
		snakeSize = width/2;
		for(int i=0;i<snakeSize;i++)
			setSnake(i, width/2-i, height/2);
		go();
	}

	/**
	 * Met à jour les structures de données pour 1'élément du snake.
	 * Les attributs "snake", "colors" et "grid" sont modifiés.
	 * <b> Toujours passer par cette méthode pour les modifs.</b> Cela garantit la cohérence.
	 * @param pos = la position dans le snake de l'élément considéré (0=tête, snakeSize-1=bout de la queue)
	 * @param x = l'abscisse de l'élément dans la grille
	 * @param y = l'ordonnée de l'élément dans la grille
	 */
	private void setSnake(int pos, int x, int y)
	{
		snake[pos][0]=x;
		snake[pos][1]=y;
		if(pos==0)
			colors[x][y]=headColor;
		else
			colors[x][y]=snakeColor;
		
		int val=-1;
		if(pos==0)// tête
			val=1; 
		else if(pos==snakeSize-1)// extrémité de la queue
			val=3; 
		else val=2; // tranche de serpent standard
		grid[x][y]=val;
	}
	
	public void infiniteRandomMoves() throws InterruptedException
	{
		while(true)
		{
			if(lockedInATrap())
			{
				System.err.println("AAAaaaarrrggghhh, coincé !! :-(      Restarting snake in a few secs...");
				break;
			}
			moveSnakeRandomly();
			
			Thread.sleep(temporisation);
		}
	}


	// Le snake se met à bouger
	public void go()
	{
		try 
		{
			infiniteRandomMoves();

			
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	/**
	 * Prérequis : lockedInATrap() renvoie faux !
	 * >> <b>Toujours</b> tester lockedInATrap() avant d'appeler cette fonction !
	 */
	public void moveSnakeRandomly()
	{
		boolean[] dirs = availableDirectionSet();
		int rand = (int)(4*Math.random());
		while(!dirs[rand])
		{
			rand = (int)(4*Math.random());
		}
		moveSnake(rand);
	}
	
	/**
	 * Déplace le snake d'une case dans la direction indiquée... si possible. Ne bouge pas sinon.<br>
	 * La direction est par rapport à la grille (la droite est toujours la même, indépendemment de la direction de déplacement du serpent
	 * @param direction = (0=à droite, 1=bas, 2=gauche, 3=haut)
	 */
	public void moveSnake(int direction)
	{
		int x0=snake[0][0],y0=snake[0][1];
		int xq=snake[snakeSize-1][0], yq=snake[snakeSize-1][1];
		
		// Il Faut d'abord vérifier que le mouvement est possible, sinon on ne fait rien.
		boolean c1, c2, c3, c4;
		c1=direction==0 && x0!=width-1 && grid[x0+1][y0]==0;
		c2=direction==1 && y0!=height-1 && grid[x0][y0+1]==0;
		c3=direction==2 && x0!=0 && grid[x0-1][y0]==0;
		c4=direction==3 && y0!=0 && grid[x0][y0-1]==0;

		if(!c1&&!c2&&!c3&&!c4)
		{
			System.err.println("Impossible move ("+direction+").");
			return;
		}
		// Il faut mettre à jour "grid" et "color" pour le bout de queue...
		grid[xq][yq]=0;
		colors[xq][yq]=defaultColor;
		
		// Ensuite on décalle tous les éléments de "snake" vers la fin
		for(int i=snakeSize-1;i>0;i--)
		{
			setSnake(i, snake[i-1][0], snake[i-1][1]);
		}
		// Enfin on met à jour la tête
		if(direction==0 && x0!=width && grid[x0+1][y0]==0)
		{ //DROITE
			setSnake(0,x0+1,y0);
		}else if(direction==1 && y0!=height && grid[x0][y0+1]==0)
		{//BAS
			setSnake(0, x0, y0+1);
		}else if(direction==2 && x0!=0 && grid[x0-1][y0]==0)
		{//GAUCHE
			setSnake(0, x0-1, y0);
		}else if(direction==3 && y0!=0 && grid[x0][y0-1]==0)
		{//HAUT
			setSnake(0, x0, y0-1);
		}else{
			System.err.println("Impossible move ("+direction+").");
		}
	}
	/**
	 * Retourne sous la forme d'un tableau de 4 booléens l'ensemble des directions possibles 
	 * pour le prochain mouvement du snake, i.e. des directions qui ne vont ni dans le mur ni sur le snake lui même
	 * 
	 */
	public boolean[] availableDirectionSet()
	{
		boolean[] dirOk = new boolean[4];
		for(int l=0;l<4;l++)
			dirOk[l]=false;
		int x0=snake[0][0],y0=snake[0][1];
		boolean c1, c2, c3, c4;
		c1=x0!=width-1 && grid[x0+1][y0]==0;
		c2= y0!=height-1 && grid[x0][y0+1]==0;
		c3=x0!=0 && grid[x0-1][y0]==0;
		c4=y0!=0 && grid[x0][y0-1]==0;
		if(c1) dirOk[0]=true;
		if(c2) dirOk[1]=true;
		if(c3) dirOk[2]=true;
		if(c4) dirOk[3]=true;
		return dirOk;
	}
	
	/**
	 * Teste si la snake est bloqué (= aucune direction possible)
	 * @return true or false.
	 */
	public boolean lockedInATrap()
	{
		boolean[] dirs = availableDirectionSet();
		for(int i=0;i<dirs.length;i++)
			if(dirs[i]==true)
				return false;
		return true;
	}	
	/**
	 * Méthode pour aider au débug...
	 */
	public void printGrid()
	{
	 
		System.out.println(" Grille :");
		for (int h = 0; h < height; h++)
			for (int w = 0; w < width; w++)
			{
				if(w==width-1)
					System.out.println(grid[w][h]);
				else
					System.out.print(grid[w][h]);
			}
	}
	/**
	 * Méthode pour aider au débug...
	 */
	public void printSnake()
	{
		System.out.println(" Snake :");
		System.out.print("x: ");
		for(int h = 0; h < snakeSize; h++)
		{
			if(h==snakeSize-1)
				System.out.println(snake[h][0]);
			else
				System.out.print(snake[h][0]);
		}
		System.out.print("y: ");
		for(int h = 0; h < snakeSize; h++)
		{
			if(h==snakeSize-1)
				System.out.println(snake[h][1]);
			else
				System.out.print(snake[h][1]);
		}
	}

	
}
