package fr.polytech.s20;

import java.awt.Color;

public class Disque {
	
	int centre;
	int y;
	int largeur;
	Color col;

	public Disque(int centre, int y, int largeur, Color col, Color colors[][]){
		
		this.largeur = largeur;
		this.col=col;
		this.y = y;
		
		for (int i = 0; i<=largeur/2; i++ )
			colors[centre+i][y]=col;
		for (int i=1 ; i<=largeur/2; i++)
			colors[centre-i][y]=col;
		
	}
}
