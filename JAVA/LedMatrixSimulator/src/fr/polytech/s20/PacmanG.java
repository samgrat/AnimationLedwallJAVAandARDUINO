package fr.polytech.s20;

import java.awt.Color;

public class PacmanG{

	private int width = 0;
	private  int height = 0;	
	
	private int temporisation=500;
	
	private  Color col1 = Color.YELLOW;
	private  Color col2 = Color.GRAY;
	private  Color gris = Color.GRAY;
	
	private  Color colors[][]; 
	
	public PacmanG()
	{
		this(null);
	}

	public PacmanG(Color[][] cols) {
		
		if(cols==null)
		{
			System.err.println("ARghh");
			System.exit(0);
		}
		
		colors = cols;
		width = colors.length; // nombre colonnes
		height = colors[0].length; // nombre lignes
			
			pacDebut();
			int h=1;
			while(h<(width-11)){
				pac2(h);
				for(int i=0; i<height;i++)
					colors[h-1][i]=col2;
				temp();
				pac3(h+1);
				for(int i=0; i<height;i++)
					colors[h][i]=col2;
				temp();
				pac2(h+2);
				for(int i=0; i<height;i++)
					colors[h+1][i]=col2;
				colors[h+8][5]=colors[h+9][5]=gris;
				temp();
				pac1(h+3);
				for(int i=0; i<height;i++)
					colors[h+2][i]=col2;
				temp();
				h = h+4;
			}
			
			if((width-10)%4==1){
				pac2(width-10);
				for(int i=0; i<height;i++)
					colors[width-11][i]=col2;
			temp();
			}
			
			if((width-10)%4==2){
				pac2(width-11);
				for(int i=0; i<height;i++)
					colors[width-12][i]=col2;
				temp();
				pac3(width-10);
				for(int i=0; i<height;i++)
					colors[width-11][i]=col2;
				temp();
			}
			
			if (width>8)
				FinG1();
			else 
				FinG2();

	}
	
	private void pacDebut(){
		
		int h=1;
		
		if (h<=width){
		colors[0][3]=colors[0][7]=col1;  //1		
		temp();	
		}
		h++;
		
		if (h<=width){ 
		colors[1][4]=colors[1][6]=col1; 		//2
		for (int i =3; i<8;i++)
			if(i!=5)
				colors[0][i]=col1;
		temp();
		}
		h++;
		
		if (h<=width){
		colors[2][5]=col1;			//3
		for (int i=3; i<8;i++)
			colors[1][i]=col1;
		for (int i=2; i<9;i++)
			colors[0][i]=col1;
		temp();
		}
		h++;
		
		if (h<=width){
		colors[3][4]=colors[3][6]=col1;			//4
		for (int i=3; i<8;i++)
			if (i!=5)
				colors[2][i]=col1;
		for (int i=2; i<9;i++)
			if (i!=5)
				colors[1][i]=col1;
		for (int i=1; i<height;i++)
			if (i!=3)
				colors[0][i]=col1;
		colors[0][3]= Color.blue; //l'oeil 
		colors[0][0]=col2;
		colors[1][5]=colors[2][5]=gris;
		temp();	
		}
		h++;
		
		if (h<=width){
		colors[4][3]=colors[4][7]=col1;					//5
		for (int i=2; i<9;i++)
			if (i!=5 && i!=4 && i!=6)
				colors[3][i]=col1;
		for (int i=2; i<9;i++)
			if (i!=5)
				colors[2][i]=col1;
		for (int i=1; i<height;i++)
			if (i!=3)
				colors[1][i]=col1;
		colors[1][3]=Color.blue;
		for (int i=1; i<height;i++)
				colors[0][i]=col1;
		colors[1][0]=col2;
		colors[2][5]=colors[3][4]=colors[3][6]=gris;
		temp();
		}
		h++;
		
		if (h<=width){
		colors[5][4]=colors[5][6]=col1;			//6
		for (int i=3; i<8;i++)
			if (i!=5)
				colors[4][i]=col1;
		for (int i=2; i<9;i++)
			if (i!=5)
				colors[3][i]=col1;
		for (int i=1; i<height;i++)
			if (i!=3)
				colors[2][i]=col1;
		colors[2][3]= Color.blue; //l'oeil 
		for (int i=1; i<height;i++)
				colors[1][i]=col1;
		for (int i=2; i<9;i++)
				colors[0][i]=col1;
		colors[2][0]=colors[0][1]=colors[0][9]=col2;
		temp();
		}
		h++;
		
		if (h<=width){
		colors[6][5]=col1;			//7
		for (int i=3; i<8;i++)
				colors[5][i]=col1;
		for (int i=2; i<9;i++)
				colors[4][i]=col1;
		for (int i=1; i<height;i++)
			if (i!=3)
				colors[3][i]=col1;
		colors[3][3]=Color.blue;
		for (int i=1; i<height;i++)
				colors[2][i]=col1;
		for (int i=2; i<9;i++)
				colors[1][i]=col1;
		for (int i=2; i<9;i++)
				colors[0][i]=col1;
		colors[1][1]=colors[1][9]=colors[3][0]=col2;
		temp();
		}
		h++;
		
		if (h<=width){
		colors[7][4]=colors[7][6]=col1;			//8
		for (int i=3; i<8;i++)
			if (i!=5)
				colors[6][i]=col1;
		for (int i=2; i<9;i++)
			if (i!=5)
				colors[5][i]=col1;
		for (int i=1; i<height;i++)
			if (i!=3)
				colors[4][i]=col1;
		colors[4][3]= Color.blue; //l'oeil 
		for (int i=1; i<height;i++)
				colors[3][i]=col1;
		for (int i=2; i<8;i++)
				colors[2][i]=col1;
		for (int i=2; i<9;i++)
				colors[1][i]=col1;
		for (int i=3; i<7;i++)
				colors[0][i]=col1;
		colors[4][0]=colors[2][1]=colors[2][9]=colors[0][2]=colors[0][8]=col2;
		for (int i=5; i<7;i++)
				colors[i][5]=gris;
		temp();
		}
		h++;
		
		if (h<=width){
		pac1(0);
		temp();
		}
		
	}
	
	private void pac1 (int w){
		
		//pacman normal
		
		colors[w][5]= col1; //colonne 0
		for(int i=0; i<height; i++)
			if(i!=5)
				colors[w][i]=col2;
				
		for(int i=0; i<height; i++)								//colonne 1
			if(i==3 || i ==4 || i==5 || i==6 || i==7)
				colors[w+1][i]=col1;
			else
				colors[w+1][i]=col2;
				
		for(int i=0; i<height; i++)								//colonne 2
			if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
				colors[w+2][i]=col1;
			else
				colors[w+2][i]=col2;
		
		for(int i=0; i<height; i++)								//colonne 3
			if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
				colors[w+3][i]=col1;
			else
				colors[w+3][i]=col2;
		
		for(int i=0; i<height; i++)								//colonne 4
			if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
				colors[w+4][i]=col1;
			else
				colors[w+4][i]=col2;
	
		for(int i=0; i<height; i++)								//colonne 5
			if(i==1 || i==2 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
				colors[w+5][i]=col1;
		colors[w+5][0]=col2;
		colors[w+5][3]= Color.BLUE; //l'oeil 

		for(int i=0; i<height; i++)								//colonne 6
			if(i==2 || i==3 || i ==4 || i==6 || i==7 || i==8)
				colors[w+6][i]=col1;
			else 
				colors[w+6][i]=gris;
		
		for(int i=0; i<height; i++)								//colonne 7
			if(i==2 || i==3 || i==7 || i==8)
				colors[w+7][i]=col1;
			else 
				colors[w+7][i]=gris;
		
		colors[w+8][3]=colors[w+8][7]=col1; //colonne 8
		
	}
		
	private void pac2(int w){

		//pacman demi-ouvert
		
			for(int i=0; i<height; i++)								//colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[w][i]=col2;
				else
					colors[w][i]=col1;
			
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[w+1][i]=col1;
				else
					colors[w+1][i]=col2;
			
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[w+2][i]=col1;
				else
					colors[w+2][i]=col2;
						
			for(int i=0; i<height; i++)								//colonne 3
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[w+3][i]=col1;
				else
					colors[w+3][i]=col2;
			
			for(int i=0; i<height; i++)								//colonne 4
				if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[w+4][i]=col1;
				else
					colors[w+4][i]=col2;
			
			for(int i=0; i<height; i++)								//colonne 5
				if(i==1 || i==2 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[w+5][i]=col1;
			colors[w+5][0]=col2;
			colors[w+5][3]= Color.BLUE; //l'oeil 

			for(int i=0; i<height; i++)								//colonne 6
				if(i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 )
					colors[w+6][i]=col1;
			
			for(int i=0; i<height; i++)								//colonne 7
				if(i==3 || i ==4 || i==6 || i==7)
					colors[w+7][i]=col1;
				
			colors[w+8][4]=colors[w+8][6]=col1; //colonne 8
				
	}
	
	private void pac3(int w){

		//pacman ferme
		
			for(int i=0; i<height; i++)								//colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[w][i]=col2;
				else
					colors[w][i]=col1;
			
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[w+1][i]=col1;
				else
					colors[w+1][i]=col2;
			
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[w+2][i]=col1;
				else
					colors[w+2][i]=col2;
			
			for(int i=0; i<height; i++)								//colonne 3
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[w+3][i]=col1;
				else
					colors[w+3][i]=col2;
			
			for(int i=0; i<height; i++)								//colonne 4
				if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[w+4][i]=col1;
			colors[w+4][0]=col2;
			
			for(int i=0; i<height; i++)								//colonne 5
				if(i==1 || i==2 || i==3 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[w+5][i]=col1;
			colors[w+5][0]=col2;
			colors[w+5][4]= Color.BLUE; //l'oeil 

			for(int i=0; i<height; i++)								//colonne 6
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[w+6][i]=col1;
			
			for(int i=0; i<height; i++)								//colonne 7
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[w+7][i]=col1;
			
			colors[w+8][5]=col1; //colonne 8				
	}
	
	private void FinG1(){
		
		pac2(width-9);
		for(int i = width-1; i>width-9; i--)
			copieColonne(i-1,i);
		if(width>=9)
			for(int i=0; i<height; i++)
				colors[width-9][i]=col2;
		if(width>=height)
			for(int i=0; i<height; i++)
				colors[width-10][i]=col2;
		if(width>=11)
			for(int i=3; i<8; i++)
				colors[width-11][i]=col2;
		if(width>=12)
			colors[width-12][5]=col2;
		temp();
		
		for(int i = width-1; i>width-8; i--)
			copieColonne(i-1,i);
		for(int i=0; i<height; i++)
			colors[width-8][i]=col2;
		temp();
		
		for(int i = width-1; i>width-7; i--)
			copieColonne(i-1,i);
		for(int i=0; i<height; i++)
			colors[width-7][i]=col2;
		temp();

		for(int i = width-1; i>width-6; i--)
			copieColonne(i-1,i);
		for(int i=0; i<height; i++)
			colors[width-6][i]=col2;
		temp();

		for(int i = width-1; i>width-5; i--)
			copieColonne(i-1,i);
		for(int i=0; i<height; i++)
			colors[width-5][i]=col2;
		temp();
		
		for(int i = width-1; i>width-4; i--)
			copieColonne(i-1,i);
		for(int i=0; i<height; i++)
			colors[width-4][i]=col2;
		temp();
		
		for(int i = width-1; i>width-3; i--)
			copieColonne(i-1,i);
		for(int i=0; i<height; i++)
			colors[width-3][i]=col2;
		temp();
		
		copieColonne(width-2,width-1);
		for(int i=0; i<height; i++)
			colors[width-2][i]=col2;
		temp();
		
		for(int i=0; i<height; i++)
			colors[width-1][i]=col2;
		temp();
	}
	
	private void FinG2(){
		
		if (width==8){
			for(int i = width-1; i>width-8; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col2;
				else
					colors[0][i]=col1;	
			temp();			
		}
		
		if (width==7){
			for(int i = width-1; i>width-7; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-7; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col2;
				else
					colors[0][i]=col1;	
			temp();	
		}
		
		if(width==6){
			for(int i = width-1; i>width-6; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-6; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-6; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col2;
				else
					colors[0][i]=col1;	
			temp();
		}
		
		if(width==5){
			for(int i = width-1; i>width-5; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 3
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-5; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-5; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-5; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col2;
				else
					colors[0][i]=col1;	
			temp();
		}
		if(width==4){

			for(int i = width-1; i>width-4; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 4
				if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col1;
			colors[0][0]=col2;
			temp();
			
			for(int i = width-1; i>width-4; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 3
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-4; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-4; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-4; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col2;
				else
					colors[0][i]=col1;	
			temp();
		}
		
		if(width==3){
			
			for(int i = width-1; i>width-3; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 5
				if(i==1 || i==2 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col1;
			colors[0][0]=col2;
			colors[0][3]= Color.BLUE; //l'oeil 
			temp();
			
			for(int i = width-1; i>width-3; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 4
				if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col1;
			colors[0][0]=col2;
			temp();
			
			for(int i = width-1; i>width-3; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 3
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-3; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-3; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-3; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col2;
				else
					colors[0][i]=col1;	
			temp();
		}
		
		if(width==2){
			for(int i = width-1; i>width-2; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 6
				if(i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 )
					colors[0][i]=col1;
			temp();
			
			for(int i = width-1; i>width-2; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 5
				if(i==1 || i==2 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col1;
			colors[0][0]=col2;
			colors[0][3]= Color.BLUE; //l'oeil 
			temp();
		
			for(int i = width-1; i>width-2; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 4
				if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col1;
			colors[0][0]=col2;
			temp();
			
			for(int i = width-1; i>width-2; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 3
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-2; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-2; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i = width-1; i>width-2; i--)
				copieColonne(i-1,i);
			for(int i=0; i<height; i++)								// colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col2;
				else
					colors[0][i]=col1;	
			temp();
		}
		
		if(width==1){
		
			for(int i=0; i<height; i++)								//colonne 7
				if(i==3 || i ==4 || i==6 || i==7)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i=0; i<height; i++)								//colonne 6
				if(i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 )
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i=0; i<height; i++)								//colonne 5
				if(i==1 || i==2 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col1;
			colors[0][0]=col2;
			colors[0][3]= Color.BLUE; //l'oeil 
			temp();
			
			for(int i=0; i<height; i++)								//colonne 4
				if(i==1 || i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i=0; i<height; i++)								//colonne 3
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i=0; i<height; i++)								//colonne 2
				if(i==2 || i==3 || i ==4 || i==5 || i==6 || i==7 || i==8)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i=0; i<height; i++)								//colonne 1
				if(i==3 || i ==4 || i==5 || i==6 || i==7)
					colors[0][i]=col1;
				else
					colors[0][i]=col2;
			temp();
			
			for(int i=0; i<height; i++)								//colonne 0
				if(i==0 || i==1 || i==2 || i==3 || i ==4 || i==6 || i==7 || i==8 || i==9)
					colors[0][i]=col2;
				else
					colors[0][i]=col1;
			temp();
		}
		
		int h = width;
		for(int i = width-1; i>0; i--)
			copieColonne(i-1,i);
		for(int i=0;i<height;i++)
			colors[0][i]=col2;
		h--;
		while(h>0){
			for(int i = width-1; i>0; i--)
				copieColonne(i-1,i);
			temp();
			h--;
		}
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
