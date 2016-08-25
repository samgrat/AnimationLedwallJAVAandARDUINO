package fr.polytech.s20;

import java.awt.Color;

public class PacmanD {

	private int width = 0;
	private int height = 0;	
	
	private int temporisation=500;
	
	private Color col1 = Color.YELLOW;
	private Color col2 = Color.GRAY;
	private Color gris = Color.GRAY;

	private Color colors[][]; 
	
	public PacmanD()
	{
		this(null);
	}

	public PacmanD(Color[][] cols) {
		
		if(cols==null)
		{
			System.err.println("ARghh");
			System.exit(0);
		}
		
		colors = cols;
		width = colors.length; // nombre colonnes
		height = colors[0].length; // nombre lignes

			pacDebut();
			int h=width-10;
			while(h>3){
				pac2(h);
				for(int i=0; i<height;i++)
					colors[h+9][i]=col2;
				temp();				
				pac3(h-1);
				for(int i=0; i<height;i++)
					colors[h+8][i]=col2;
				temp();
				pac2(h-2);
				for(int i=0; i<height;i++)
					colors[h+7][i]=col2;
				colors[h][5]=colors[h-1][5]=gris;
				temp();
				pac1(h-3);
				for(int i=0; i<height;i++)
					colors[h+6][i]=col2;
				temp();
				h = h-4;
			}
			
			//les cas non pris dans la boucles pour aller jusqu'a bout
			if((width-10)%4==1){
				pac2(1);
				for(int i=0; i<height;i++)
					colors[10][i]=col2;
			temp();
			}
			
			if((width-10)%4==2){
				pac2(2);
				for(int i=0; i<height;i++)
					colors[11][i]=col2;
				temp();
				pac3(1);
				for(int i=0; i<height;i++)
					colors[10][i]=col2;
				temp();
			}
			
			if((width-10)%4==3){
				pac2(3);
				for(int i=0; i<height;i++)
					colors[12][i]=col2;
				temp();
				pac3(2);
				for(int i=0; i<height;i++)
					colors[11][i]=col2;
				temp();
				pac2(1);
				for(int i=0; i<height;i++)
					colors[10][i]=col2;
				colors[3][5]=colors[2][5]=gris;
				temp();
			}

			
			if (width>8)
				FinD1();
			else 
				FinD2();
						
	}
	
	private void FinD2() {
		if (width==8){
			for(int i = 0; i<7; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col2;
				else
					colors[width-1][i]=col1;	
			temp();			
		}
		
		if (width==7){
			for(int i = 0; i<6; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i = 0; i<6; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col2;
				else
					colors[width-1][i]=col1;	
			temp();	
		}
		
		if(width==6){
			for(int i = 0; i<5; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i = 0; i<5; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i = 0; i<5; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col2;
				else
					colors[width-1][i]=col1;	
			temp();
		}
		
		if(width==5){
			for(int i = 0; i<4; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 3
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i = 0; i<4; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i = 0; i<4; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i = 0; i<4; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col2;
				else
					colors[width-1][i]=col1;	
			temp();
		}
		
		if(width==4){

			for(int i = 0; i<3; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 4
				if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col1;
			colors[width-1][0]=col2;
			temp();
			
			for(int i = 0; i<3; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 3
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i = 0; i<3; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i = 0; i<3; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i = 0; i<3; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col2;
				else
					colors[width-1][i]=col1;	
			temp();
		}
		
		if(width==3){
			
			for(int i = 0; i<2; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 5
				if(i==1 || i==2 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col1;
			colors[width-1][0]=col2;
			colors[width-1][3]= Color.BLUE; //l'oeil 
			temp();
			
			for(int i = 0; i<2; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 4
				if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col1;
			colors[width-1][0]=col2;
			temp();
			
			for(int i = 0; i<2; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 3
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i = 0; i<2; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i = 0; i<2; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i = 0; i<2; i++)
				copieColonne(i+1,i);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col2;
				else
					colors[width-1][i]=col1;	
			temp();
		}

		if(width==2){
				copieColonne(1,0);
			for(int i=0; i<height; i++)								//colonne 6
				if(i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 )
					colors[width-1][i]=col1;
			temp();
			
				copieColonne(1,0);
			for(int i=0; i<height; i++)								//colonne 5
				if(i==1 || i==2 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col1;
			colors[width-1][0]=col2;
			colors[width-1][3]= Color.BLUE; //l'oeil 
			temp();
		
				copieColonne(1,0);
			for(int i=0; i<height; i++)								//colonne 4
				if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col1;
			colors[width-1][0]=col2;
			temp();
			
				copieColonne(1,0);
			for(int i=0; i<height; i++)								//colonne 3
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
				copieColonne(1,0);
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
				copieColonne(1,0);
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
				copieColonne(1,0);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col2;
				else
					colors[width-1][i]=col1;	
			temp();
		}

		if(width==1){
			
			for(int i=0; i<height; i++)								//colonne 7
				if(i==3 || i ==4 || i==6 || i==7)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i=0; i<height; i++)								//colonne 6
				if(i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 )
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i=0; i<height; i++)								//colonne 5
				if(i==1 || i==2 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col1;
			colors[width-1][0]=col2;
			colors[width-1][3]= Color.BLUE; //l'oeil 
			temp();
			
			for(int i=0; i<height; i++)								//colonne 4
				if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i=0; i<height; i++)								//colonne 3
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[width-1][i]=col1;
				else
					colors[width-1][i]=col2;
			temp();
			
			for(int i=0; i<height; i++)								//colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[width-1][i]=col2;
				else
					colors[width-1][i]=col1;
			temp();
		}
		
		int h = width;
		for(int i = 0; i<width-1; i++)
			copieColonne(i+1,i);
		for(int i=0;i<height;i++)
			colors[width-1][i]=col2;
		h--;
		while(h>=0){
			for(int i = 0; i<width-1; i++)
				copieColonne(i+1,i);
			temp();
			h--;
		}

		
	}

	private void FinD1() {
		
		pac2(0);
		for(int i=0; i<8; i++)
			copieColonne(i+1,i);
		if(width>8)
			for(int i=0; i<height; i++)
				colors[8][i]=col2;
		if(width>9)
			for(int i=0; i<height; i++)
				colors[9][i]=col2;
		if(width>10)
			for(int i=3; i<8; i++)
				colors[10][i]=col2;
		if(width>11)
			colors[11][5]=col2;
		temp();
		
		for(int i = 0; i<7; i++)
			copieColonne(i+1,i);
		for(int i=0; i<height; i++)
			colors[7][i]=col2;
		temp();
		
		for(int i = 0; i<6; i++)
			copieColonne(i+1,i);
		for(int i=0; i<height; i++)
			colors[6][i]=col2;
		temp();
		
		for(int i = 0; i<5; i++)
			copieColonne(i+1,i);
		for(int i=0; i<height; i++)
			colors[5][i]=col2;
		temp();
		
		for(int i = 0; i<4; i++)
			copieColonne(i+1,i);
		for(int i=0; i<height; i++)
			colors[4][i]=col2;
		temp();
		
		for(int i = 0; i<3; i++)
			copieColonne(i+1,i);
		for(int i=0; i<height; i++)
			colors[3][i]=col2;
		temp();
		
		for(int i = 0; i<2; i++)
			copieColonne(i+1,i);
		for(int i=0; i<height; i++)
			colors[2][i]=col2;
		temp();
		
		copieColonne(1,0);
		for(int i=0; i<height; i++)
			colors[1][i]=col2;
		temp();
		
		for(int i=0; i<height; i++)
			colors[0][i]=col2;
		temp();
		
	}

	private void pacDebut(){
		
		int h=width;
		
		if (h>0){
			colors[width-1][3]=colors[width-1][7]=col1;  //1		
			temp();
		}
			h--;		
			
		if (h>0){
			colors[width-2][4]=colors[width-2][6]=col1;  //2
			for (int i =3; i<8;i++)
				if(i!=5)
					colors[width-1][i]=col1;
			temp();
		}
			h--;	
	
		if (h>0){
			colors[width-3][5]=col1;  //3
			for (int i=3; i<8;i++)
				colors[width-2][i]=col1;
			for (int i=2; i<9;i++)
					colors[width-1][i]=col1;
			temp();
			}
			h--;	
				
		if (h>0){
			colors[width-4][4]=colors[width-4][6]=col1;			//4
			for (int i=3; i<8;i++)
				if (i!=5)
					colors[width-3][i]=col1;
			for (int i=2; i<9;i++)
				if (i!=5)
					colors[width-2][i]=col1;
			for (int i=1; i<height;i++)
				if (i!=3)
					colors[width-1][i]=col1;
			colors[width-1][3]= Color.blue; //l'oeil 
			colors[width-1][0]=col2;
			colors[width-2][5]=colors[width-3][5]=gris;
			temp();	
			}
		h--;		

		if (h>0){
			colors[width-5][3]=colors[width-5][7]=col1;					//5
			for (int i=2; i<9;i++)
				if (i!=5 && i!=4 && i!=6)
					colors[width-4][i]=col1;
			for (int i=2; i<9;i++)
				if (i!=5)
					colors[width-3][i]=col1;
			for (int i=1; i<height;i++)
				if (i!=3)
					colors[width-2][i]=col1;
			colors[width-2][3]=Color.blue;
			for (int i=1; i<height;i++)
					colors[width-1][i]=col1;
			colors[width-2][0]=col2;
			colors[width-3][5]=colors[width-4][4]=colors[width-4][6]=gris;
			temp();
			}
			h--;
		
		if (h>0){
			colors[width-6][4]=colors[width-6][6]=col1;			//6
			for (int i=3; i<8;i++)
				if (i!=5)
					colors[width-5][i]=col1;
			for (int i=2; i<9;i++)
				if (i!=5)
					colors[width-4][i]=col1;
			for (int i=1; i<height;i++)
				if (i!=3)
					colors[width-3][i]=col1;
			colors[width-3][3]= Color.blue; //l'oeil 
			for (int i=1; i<height;i++)
				colors[width-2][i]=col1;
			for (int i=2; i<9;i++)
				colors[width-1][i]=col1;
			colors[width-3][0]=colors[width-1][1]=colors[width-1][9]=col2;
			temp();
			}
		h--;		

		if (h>0){
			colors[width-7][5]=col1;			//7
			for (int i=3; i<8;i++)
					colors[width-6][i]=col1;
			for (int i=2; i<9;i++)
					colors[width-5][i]=col1;
			for (int i=1; i<height;i++)
				if (i!=3)
					colors[width-4][i]=col1;
			colors[width-4][3]=Color.blue;
			for (int i=1; i<height;i++)
					colors[width-3][i]=col1;
			for (int i=2; i<9;i++)
					colors[width-2][i]=col1;
			for (int i=2; i<9;i++)
					colors[width-1][i]=col1;
			colors[width-2][1]=colors[width-2][9]=colors[width-4][0]=col2;
			temp();
			}
		h--;
		
		if (h>0){
			colors[width-8][4]=colors[width-8][6]=col1;			//8
			for (int i=3; i<8;i++)
				if (i!=5)
					colors[width-7][i]=col1;
			for (int i=2; i<9;i++)
				if (i!=5)
					colors[width-6][i]=col1;
			for (int i=1; i<height;i++)
				if (i!=3)
					colors[width-5][i]=col1;
			colors[width-5][3]= Color.blue; //l'oeil 
			for (int i=1; i<height;i++)
					colors[width-4][i]=col1;
			for (int i=2; i<8;i++)
					colors[width-3][i]=col1;
			for (int i=2; i<9;i++)
					colors[width-2][i]=col1;
			for (int i=3; i<7;i++)
					colors[width-1][i]=col1;
			colors[width-5][0]=colors[width-3][1]=colors[width-3][9]=colors[width-1][2]=colors[width-1][8]=col2;
			for (int i=width-6; i>width-8;i--)
					colors[i][5]=gris;
			temp();
			}
			h--;
	
	if (h>0){
		pac1(width-9);
		temp();
		}
	}
	
	private void pac1 (int w){
		
		//pacman normal
		
		colors[w+8][5]= col1; //colonne 0
		for(int i=0; i<height; i++)
			if(i!=5)
				colors[w+8][i]=col2;
		
		for(int i=0; i<height; i++)								//colonne 1
			if(i==3 || i ==4 || i==5 || i==6 || i==7)
				colors[w+7][i]=col1;
			else
				colors[w+7][i]=col2;
		
				
		for(int i=0; i<height; i++)								//colonne 2
			if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
				colors[w+6][i]=col1;
			else
				colors[w+6][i]=col2;
		
		for(int i=0; i<height; i++)								//colonne 3
			if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
				colors[w+5][i]=col1;
			else
				colors[w+5][i]=col2;
		
		for(int i=0; i<height; i++)								//colonne 4
			if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
				colors[w+4][i]=col1;
			else
				colors[w+4][i]=col2;
	
		for(int i=0; i<height; i++)								//colonne 5
			if(i==1 || i==2 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
				colors[w+3][i]=col1;
		colors[w+3][3]= Color.BLUE; //l'oeil 
		colors[w+3][0]=col2;

		for(int i=0; i<height; i++)								//colonne 6
			if(i==2 || i==3 || i ==4 || i==6 || i==7 || i==8)
				colors[w+2][i]=col1;
			else 
				colors[w+2][i]=gris;
		
		for(int i=0; i<height; i++)								//colonne 7
			if(i==2 || i==3 || i==7 || i==8)
				colors[w+1][i]=col1;
			else 
				colors[w+1][i]=gris;
		
		colors[w][3]=colors[w][7]=col1; //colonne 8
		
	}
		
	private void pac2(int w){

		//pacman demi-ouvert
		
				for(int i=0; i<height; i++)								//colonne 0
					if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
						colors[w+8][i]=col2;
					else
						colors[w+8][i]=col1;
				
				for(int i=0; i<height; i++)								//colonne 1
					if(i==3 || i ==4 || i==5 || i==6 || i==7)
						colors[w+7][i]=col1;
					else
						colors[w+7][i]=col2;
				
				for(int i=0; i<height; i++)								//colonne 2
					if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
						colors[w+6][i]=col1;
					else
						colors[w+6][i]=col2;
		
				for(int i=0; i<height; i++)								//colonne 3
					if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
						colors[w+5][i]=col1;
					else
						colors[w+5][i]=col2;
				
				for(int i=0; i<height; i++)								//colonne 4
					if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
						colors[w+4][i]=col1;
					else
						colors[w+4][i]=col2;
			
				for(int i=0; i<height; i++)								//colonne 5
					if(i==1 || i==2 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
						colors[w+3][i]=col1;
				colors[w+3][3]= Color.BLUE; //l'oeil 
				colors[w+3][0]=col2;

				for(int i=0; i<height; i++)								//colonne 6
					if(i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 )
						colors[w+2][i]=col1;
				
				for(int i=0; i<height; i++)								//colonne 7
					if(i==3 || i ==4 || i==6 || i==7)
						colors[w+1][i]=col1;
				
				colors[w][4]=colors[w][6]=col1; //colonne 8
				
	}
	
	private void pac3(int w){

		//pacman ferme
		
				for(int i=0; i<height; i++)								//colonne 0
					if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
						colors[w+8][i]=col2;
					else
						colors[w+8][i]=col1;	
				
				for(int i=0; i<height; i++)								//colonne 1
					if(i==3 || i ==4 || i==5 || i==6 || i==7)
						colors[w+7][i]=col1;
					else
						colors[w+7][i]=col2;
				
				for(int i=0; i<height; i++)								//colonne 2
					if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
						colors[w+6][i]=col1;
					else
						colors[w+6][i]=col2;
				
				for(int i=0; i<height; i++)								//colonne 3
					if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
						colors[w+5][i]=col1;
					else
						colors[w+5][i]=col2;
				
				for(int i=0; i<height; i++)								//colonne 4
					if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
						colors[w+4][i]=col1;
				colors[w+4][0]=col2;
			
				for(int i=0; i<height; i++)								//colonne 5
					if(i==1 || i==2 || i==3 || i==5 || i==6 || i==7 || i==8 || i==9)
						colors[w+3][i]=col1;
				colors[w+3][0]=col2;
				colors[w+3][4]= Color.BLUE; //l'oeil 
				
				for(int i=0; i<height; i++)								//colonne 6
					if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
						colors[w+2][i]=col1;
				
				for(int i=0; i<height; i++)								//colonne 7
					if(i==3 || i ==4 || i==5 || i==6 || i==7)
						colors[w+1][i]=col1;
				
				colors[w][5]=col1; //colonne 8
				
	}
	
	private void copieColonne (int widthDepart, int widthArrive){
		for (int h = 0;h<height;h++){
			colors[widthArrive][h]=colors[widthDepart][h]; // ex : la colonne 1 est la copie de la colonne 0
		}
	}
	
	private void temp (){
		try 
		{
			Thread.sleep(temporisation); // la temporisation en milisecondes
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}		
	
}
