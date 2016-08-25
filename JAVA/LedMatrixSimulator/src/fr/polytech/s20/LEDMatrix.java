package fr.polytech.s20;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@SuppressWarnings("serial")
public class LEDMatrix extends Canvas 
{
	// Constantes = paramètres
	private static final int width = 20;//8 10
	private static final int height = 10;
	private static final int LEDSize =40;
	private static int delay = 1; // Délai de rafraichissement de l'affichage en ms
	private static int tempo = 5; // temporisation pour les animations
	private static final Color defaultColor = Color.GRAY;

	/**
	 *  Tableau des couleurs affichées dans le canvas
	 */
	private Color colors[][];

	// Gestion de l'affichage de l'animation
	private Timer refreshingTimer;
	private RefreshingTask refreshingTask;

	//Gestion de l'animation du tableau de couleurs
	private Timer animationTimer;
	private AnimationTask animationTask;

	public LEDMatrix()
	{
		setSize(width * LEDSize, height * LEDSize);
		colors = new Color[width][height];
//		initColorsRandom();
		initColorsDefault();
		
		// Création et lancement du timer chargé de mettre à jour l'affichage à l'écran
		refreshingTimer = new Timer(true);
		refreshingTask = new RefreshingTask();
		startRefreshingTask();
		// Création et lancement du timer chargé de mettre à jour l'animation à l'écran
		animationTimer = new Timer(true);
		animationTask = new AnimationTask();
		startAnimationTask();
	}

	private void initColorsRandom()
	{
		for (int w = 0; w < width; w++)
			for (int h = 0; h < height; h++)
			{
				colors[w][h] = getRandomColor();
			}
	}
	
	private void initColorsDefault() 
	{
		for (int w = 0; w < width; w++)
			for (int h = 0; h < height; h++) 
			{
				colors[w][h] = defaultColor;
			}
	}
	
	private Color getColor(int r, int g, int b) 
	{
		return new Color(r, g, b);
	}

	Color getRandomColor()
	{
		int r = 0, g = 0, b = 0;
		r = (int) (256 * Math.random());
		g = (int) (256 * Math.random());
		b = (int) (256 * Math.random());
		return new Color(r, g, b);
	}

	public void paint(Graphics g)
	{
		drawGrid(g);
		drawContent(g);
	}

	/**
	 *  Méthode gérant le double buffering pour des animations non saccadées
	 */
	public void update(Graphics g) 
	{
		Graphics offgc;
		Image offscreen = null;
		Rectangle box = g.getClipBounds();
		offscreen = createImage(box.width, box.height);
		offgc = offscreen.getGraphics();
		offgc.setColor(getBackground());
		offgc.fillRect(0, 0, box.width, box.height);
		offgc.setColor(getForeground());
		paint(offgc);
		g.drawImage(offscreen, 0, 0, this);
	}

	private void drawGrid(Graphics g)
	{
		g.setColor(Color.BLACK);
		for (int w = 0; w < width; w++)
			for (int h = 0; h < height; h++) 
			{
				g.drawRect(w * LEDSize, h * LEDSize, LEDSize, LEDSize);
			}
	}

	private void drawContent(Graphics g)
	{
		for (int w = 0; w < width; w++)
			for (int h = 0; h < height; h++) 
			{
				g.setColor(colors[w][h]);
				g.fillRect(w * LEDSize + 1, h * LEDSize + 1, LEDSize - 1,
						LEDSize - 1);
			}
	}

	public void stopRefreshingTask() 
	{
		refreshingTask.cancel();
	}

	public void startRefreshingTask()
	{
		refreshingTimer.scheduleAtFixedRate(refreshingTask, 0, delay);
	}

	public void startAnimationTask()
	{
		animationTimer.schedule(animationTask, 1000);
	}

	class RefreshingTask extends TimerTask 
	{
		public void run() 
		{
			repaint();
		}
	}

	class AnimationTask extends TimerTask
	{
		// TODO "Exporter cette classe et créer un constructeur prenant "colors" en param
		// (les constantes width et height peuvent être déduites...
		// (>Comme pour la classe Snake)
		public void randomAllWithTempo() throws InterruptedException
		{
			for (int w = 0; w < width; w++)
				for (int h = 0; h < height; h++) 
				{
					colors[w][h] = getRandomColor();
					Thread.sleep(tempo);
				}
		}

		public void unParUnVertical() throws InterruptedException
		{
			Color col = getRandomColor();
			for (int w = 0; w < width; w++)
				for (int h = 0; h < height; h++)
				{
					colors[w][h] = col;
					Thread.sleep(tempo);
				}

		}

		public void unParUnHorizontal() throws InterruptedException 
		{
			Color col = getRandomColor();
			for (int h = 0; h < height; h++)
				for (int w = 0; w < width; w++)
				{
					colors[w][h] = col;
					Thread.sleep(tempo);
				}
		}

		public void unRandomWithTempo() throws InterruptedException
		{
			int w = 0, h = 0;
			w = (int) ((width) * Math.random());
			h = (int) ((height) * Math.random());
			Color col = getRandomColor();
			colors[w][h] = col;
			Thread.sleep(tempo);
		}
		
		public void run() 
		{
			// Gérer la mise à jour dynamique de "colors" ici
			try 
			{
				while (true) {
					
					Thread.sleep(2000);
//					randomAllWithTempo();
//					unRandomWithTempo();
//					unParUnVertical();
////				new Snake(colors);
////				new Carre(colors); // l'animation fonctionne avec une matrice carrée
					//new SquareAll(colors);
				    new Smiley(colors);
				    new LigneHorizon(colors);
					new Equalizer20couleurs(colors);
					new LigneHorizon(colors);
					new Bienvenue(colors);
					//new tests(colors);
//					new Osci(colors);
//					new PacmanD(colors);
//					new PacmanG(colors);
//					new Archimede(colors);
//					new Hanoi(colors);	
//					new Diamond(colors);				
					Thread.sleep(tempo);
					
				}
			} catch (InterruptedException e) 
			{
				System.err.println("Oups... something went wrong with animation timer tempo...");
				e.printStackTrace();
			}
		}

		
	}
}
