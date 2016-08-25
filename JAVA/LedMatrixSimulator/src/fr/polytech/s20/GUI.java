package fr.polytech.s20;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("serial")
public class GUI extends JFrame 
{
	private LEDMatrix matrix;
	
	public GUI()
	{
		matrix = new LEDMatrix();

		add(matrix); // ajoute 'matrix' à la JFrame
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		setMinimumSize(new Dimension((int)matrix.getSize().getWidth()+20,(int)matrix.getSize().getHeight()+35));
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new GUI();
	}
}
