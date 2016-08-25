package fr.polytech.s20;


	import java.awt.*;

import javax.imageio.IIOException;
		
	public class Bienvenue {
		
      
		private int width = 20;
		private int height = 10;
		private int lig = height/2;
		private String phrase = "BIENVENUE";
		
		private int temporisation = 0; // temps entre deux animations
		
		private Color colors[][]; 
		
		private Color ColorMessage = Color.LIGHT_GRAY; // Couleur du message
	
		private Color Default = new Color(128, 0, 128); // Violet
		
		public Bienvenue(Color[][] cols)
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
			for(int decal =0; decal<44; decal++){ //compteur de décalage de l'animation
				
			LettreB(1,decal);
			LettreI(6,decal);
			LettreE(10,decal);
			LettreN(14,decal);
			LettreV(20,decal);
			LettreE(26,decal);
			LettreN(30,decal);
			LettreU(36,decal);
			LettreE(42,decal);

			try 
			{
				Thread.sleep(1000);
			} catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
			
			for (int w = 0; w < width; w++) 
				for (int h = 0; h < height; h++)
					colors[w][h] = Default ;}
			
			try 
			{
				Thread.sleep(temporisation);
			} catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
			
			}
	
		


		/*public void DecriptePhrase(String phrase, int decal, int k, int i){
			
			
				switch (phrase.charAt(i)){
				case 'B': k--;
					LettreB(k,decal);
				break;
				case 'E': k-=2;
					LettreE(k,decal);
				break;
				case 'I': k-=2;
					LettreI(k,decal);
				break;
				case 'N': LettreN(k,decal);
				break;
				case 'U': LettreU(k,decal);
				break;
				case 'V': LettreV(k,decal);
				break;
				default: k+=6;
				
			}
			
		}*/

		public void LettreB(int PositionIni, int decal){
			
			try 
			{
				colors[PositionIni-decal][lig-2] = ColorMessage;
				colors[PositionIni-decal][lig-1] = ColorMessage;
				colors[PositionIni-decal][lig] = ColorMessage;
				colors[PositionIni-decal][lig+1] = ColorMessage;
				colors[PositionIni-decal][lig+2] = ColorMessage;
				colors[PositionIni+1-decal][lig-2] = ColorMessage;
				colors[PositionIni+1-decal][lig] = ColorMessage;
				colors[PositionIni+1-decal][lig+2] = ColorMessage;
				colors[PositionIni+2-decal][lig-2] = ColorMessage;
				colors[PositionIni+2-decal][lig] = ColorMessage;
				colors[PositionIni+2-decal][lig+2] = ColorMessage;
				colors[PositionIni+3-decal][lig-1] = ColorMessage;
				colors[PositionIni+3-decal][lig+1] = ColorMessage;
				
			} catch (ArrayIndexOutOfBoundsException e)
			{
			
				try{
					
					colors[PositionIni+1-decal][lig-2] = ColorMessage;
					colors[PositionIni+1-decal][lig] = ColorMessage;
					colors[PositionIni+1-decal][lig+2] = ColorMessage;
					colors[PositionIni+2-decal][lig-2] = ColorMessage;
					colors[PositionIni+2-decal][lig] = ColorMessage;
					colors[PositionIni+2-decal][lig+2] = ColorMessage;
					colors[PositionIni+3-decal][lig-1] = ColorMessage;
					colors[PositionIni+3-decal][lig+1] = ColorMessage;
				
				} catch (ArrayIndexOutOfBoundsException f){
					
					try{
						colors[PositionIni+2-decal][lig-2] = ColorMessage;
						colors[PositionIni+2-decal][lig] = ColorMessage;
						colors[PositionIni+2-decal][lig+2] = ColorMessage;
						colors[PositionIni+3-decal][lig-1] = ColorMessage;
						colors[PositionIni+3-decal][lig+1] = ColorMessage;

				} catch (ArrayIndexOutOfBoundsException g){
					
					try{
						colors[PositionIni+3-decal][lig-1] = ColorMessage;
						colors[PositionIni+3-decal][lig+1] = ColorMessage;
						
		} catch (ArrayIndexOutOfBoundsException h){ 
		
		}}}}
	
	
	} // FIN LettreB
		
		public void LettreI (int PositionIni, int decal){
			
			try{ 
				colors[PositionIni-decal][lig-2] = ColorMessage;
				colors[PositionIni-decal][lig+2] = ColorMessage;
				colors[PositionIni+1-decal][lig-2] = ColorMessage;
				colors[PositionIni+1-decal][lig-1] = ColorMessage;
				colors[PositionIni+1-decal][lig] = ColorMessage;
				colors[PositionIni+1-decal][lig+1] = ColorMessage;
				colors[PositionIni+1-decal][lig+2] = ColorMessage;
				colors[PositionIni+2-decal][lig-2] = ColorMessage;
				colors[PositionIni+2-decal][lig+2] = ColorMessage;
				
			} catch (ArrayIndexOutOfBoundsException i){
				try{
					colors[PositionIni+1-decal][lig-2] = ColorMessage;
					colors[PositionIni+1-decal][lig-1] = ColorMessage;
					colors[PositionIni+1-decal][lig] = ColorMessage;
					colors[PositionIni+1-decal][lig+1] = ColorMessage;
					colors[PositionIni+1-decal][lig+2] = ColorMessage;
					colors[PositionIni+2-decal][lig-2] = ColorMessage;
					colors[PositionIni+2-decal][lig+2] = ColorMessage;
					
				} catch (ArrayIndexOutOfBoundsException j){
					try{
					colors[PositionIni+2-decal][lig-2] = ColorMessage;
					colors[PositionIni+2-decal][lig+2] = ColorMessage;	
					
					} catch (ArrayIndexOutOfBoundsException k){
						
					}}}} //FIN LettreI
		
		private void LettreE (int PositionIni, int decal){
			
			try{ 
				colors[PositionIni-decal][lig-2] = ColorMessage;
				colors[PositionIni-decal][lig-1] = ColorMessage;
				colors[PositionIni-decal][lig] = ColorMessage;
				colors[PositionIni-decal][lig+1] = ColorMessage;
				colors[PositionIni-decal][lig+2] = ColorMessage;
				colors[PositionIni+1-decal][lig-2] = ColorMessage;
				colors[PositionIni+1-decal][lig] = ColorMessage;
				colors[PositionIni+1-decal][lig+2] = ColorMessage;
				colors[PositionIni+2-decal][lig-2] = ColorMessage;
				colors[PositionIni+2-decal][lig+2] = ColorMessage;
				
			} catch (ArrayIndexOutOfBoundsException l){
				try{
					colors[PositionIni+1-decal][lig-2] = ColorMessage;
					colors[PositionIni+1-decal][lig] = ColorMessage;
					colors[PositionIni+1-decal][lig+2] = ColorMessage;
					colors[PositionIni+2-decal][lig-2] = ColorMessage;
					colors[PositionIni+2-decal][lig+2] = ColorMessage;
					
				} catch (ArrayIndexOutOfBoundsException m){
					try{
						colors[PositionIni+2-decal][lig-2] = ColorMessage;
						colors[PositionIni+2-decal][lig+2] = ColorMessage;
						
					} catch (ArrayIndexOutOfBoundsException n){
						
					}
			
		}}} //FIN LettreE
		
		private void LettreN(int PositionIni, int decal){
			
			try{
				colors[PositionIni-decal][lig-2] = ColorMessage;
				colors[PositionIni-decal][lig-1] = ColorMessage;
				colors[PositionIni-decal][lig] = ColorMessage;
				colors[PositionIni-decal][lig+1] = ColorMessage;
				colors[PositionIni-decal][lig+2] = ColorMessage;
				colors[PositionIni+1-decal][lig-1] = ColorMessage;
				colors[PositionIni+2-decal][lig] = ColorMessage;
				colors[PositionIni+3-decal][lig+1] = ColorMessage;
				colors[PositionIni+4-decal][lig-2] = ColorMessage;
				colors[PositionIni+4-decal][lig-1] = ColorMessage;
				colors[PositionIni+4-decal][lig] = ColorMessage;
				colors[PositionIni+4-decal][lig+1] = ColorMessage;
				colors[PositionIni+4-decal][lig+2] = ColorMessage;
				
			} catch (ArrayIndexOutOfBoundsException o){
				try{
					colors[PositionIni+1-decal][lig-1] = ColorMessage;
					colors[PositionIni+2-decal][lig] = ColorMessage;
					colors[PositionIni+3-decal][lig+1] = ColorMessage;
					colors[PositionIni+4-decal][lig-2] = ColorMessage;
					colors[PositionIni+4-decal][lig-1] = ColorMessage;
					colors[PositionIni+4-decal][lig] = ColorMessage;
					colors[PositionIni+4-decal][lig+1] = ColorMessage;
					colors[PositionIni+4-decal][lig+2] = ColorMessage;
					
				} catch (ArrayIndexOutOfBoundsException p){
					try{
						colors[PositionIni+2-decal][lig] = ColorMessage;
						colors[PositionIni+3-decal][lig+1] = ColorMessage;
						colors[PositionIni+4-decal][lig-2] = ColorMessage;
						colors[PositionIni+4-decal][lig-1] = ColorMessage;
						colors[PositionIni+4-decal][lig] = ColorMessage;
						colors[PositionIni+4-decal][lig+1] = ColorMessage;
						colors[PositionIni+4-decal][lig+2] = ColorMessage;

					} catch (ArrayIndexOutOfBoundsException q){
						try{
							colors[PositionIni+3-decal][lig+1] = ColorMessage;
							colors[PositionIni+4-decal][lig-2] = ColorMessage;
							colors[PositionIni+4-decal][lig-1] = ColorMessage;
							colors[PositionIni+4-decal][lig] = ColorMessage;
							colors[PositionIni+4-decal][lig+1] = ColorMessage;
							colors[PositionIni+4-decal][lig+2] = ColorMessage;

						} catch (ArrayIndexOutOfBoundsException r){
							try{
								colors[PositionIni+4-decal][lig-2] = ColorMessage;
								colors[PositionIni+4-decal][lig-1] = ColorMessage;
								colors[PositionIni+4-decal][lig] = ColorMessage;
								colors[PositionIni+4-decal][lig+1] = ColorMessage;
								colors[PositionIni+4-decal][lig+2] = ColorMessage;
						
							} catch (ArrayIndexOutOfBoundsException s){
								
							}}}}}} // FIN LettreN
																						
			private void LettreV (int PositionIni, int decal){
				
				try{
					colors[PositionIni-decal][lig-2] = ColorMessage;
					colors[PositionIni-decal][lig-1] = ColorMessage;
					colors[PositionIni-decal][lig] = ColorMessage;
					colors[PositionIni+1-decal][lig+1] = ColorMessage;
					colors[PositionIni+2-decal][lig+2] = ColorMessage;
					colors[PositionIni+3-decal][lig+1] = ColorMessage;
					colors[PositionIni+4-decal][lig-2] = ColorMessage;
					colors[PositionIni+4-decal][lig-1] = ColorMessage;
					colors[PositionIni+4-decal][lig] = ColorMessage;
					
				} catch (ArrayIndexOutOfBoundsException t){
					try{
						colors[PositionIni+1-decal][lig+1] = ColorMessage;
						colors[PositionIni+2-decal][lig+2] = ColorMessage;
						colors[PositionIni+3-decal][lig+1] = ColorMessage;
						colors[PositionIni+4-decal][lig-2] = ColorMessage;
						colors[PositionIni+4-decal][lig-1] = ColorMessage;
						colors[PositionIni+4-decal][lig] = ColorMessage;
						
					} catch (ArrayIndexOutOfBoundsException u){
						try{
							colors[PositionIni+2-decal][lig+2] = ColorMessage;
							colors[PositionIni+3-decal][lig+1] = ColorMessage;
							colors[PositionIni+4-decal][lig-2] = ColorMessage;
							colors[PositionIni+4-decal][lig-1] = ColorMessage;
							colors[PositionIni+4-decal][lig] = ColorMessage;

						} catch (ArrayIndexOutOfBoundsException v){
							try{
								colors[PositionIni+3-decal][lig+1] = ColorMessage;
								colors[PositionIni+4-decal][lig-2] = ColorMessage;
								colors[PositionIni+4-decal][lig-1] = ColorMessage;
								colors[PositionIni+4-decal][lig] = ColorMessage;

							} catch (ArrayIndexOutOfBoundsException w){
								try{
									colors[PositionIni+4-decal][lig-2] = ColorMessage;
									colors[PositionIni+4-decal][lig-1] = ColorMessage;
									colors[PositionIni+4-decal][lig] = ColorMessage;
									
								} catch (ArrayIndexOutOfBoundsException x){
									
								}}}}}} // FIN LettreV


			private void LettreU(int PositionIni, int decal) {
				
				try{
					colors[PositionIni-decal][lig-2] = ColorMessage;
					colors[PositionIni-decal][lig-1] = ColorMessage;
					colors[PositionIni-decal][lig] = ColorMessage;
					colors[PositionIni-decal][lig+1] = ColorMessage;
					colors[PositionIni+1-decal][lig+2] = ColorMessage;
					colors[PositionIni+2-decal][lig+2] = ColorMessage;
					colors[PositionIni+3-decal][lig+2] = ColorMessage;
					colors[PositionIni+4-decal][lig-2] = ColorMessage;
					colors[PositionIni+4-decal][lig-1] = ColorMessage;
					colors[PositionIni+4-decal][lig] = ColorMessage;
					colors[PositionIni+4-decal][lig+1] = ColorMessage;
					
				} catch (ArrayIndexOutOfBoundsException e){
					try{
						colors[PositionIni+1-decal][lig+2] = ColorMessage;
						colors[PositionIni+2-decal][lig+2] = ColorMessage;
						colors[PositionIni+3-decal][lig+2] = ColorMessage;
						colors[PositionIni+4-decal][lig-2] = ColorMessage;
						colors[PositionIni+4-decal][lig-1] = ColorMessage;
						colors[PositionIni+4-decal][lig] = ColorMessage;
						colors[PositionIni+4-decal][lig+1] = ColorMessage;
						
					} catch (ArrayIndexOutOfBoundsException f){
						try{
							colors[PositionIni+2-decal][lig+2] = ColorMessage;
							colors[PositionIni+3-decal][lig+2] = ColorMessage;
							colors[PositionIni+4-decal][lig-2] = ColorMessage;
							colors[PositionIni+4-decal][lig-1] = ColorMessage;
							colors[PositionIni+4-decal][lig] = ColorMessage;
							colors[PositionIni+4-decal][lig+1] = ColorMessage;

						} catch (ArrayIndexOutOfBoundsException g){
							try{
								colors[PositionIni+3-decal][lig+2] = ColorMessage;
								colors[PositionIni+4-decal][lig-2] = ColorMessage;
								colors[PositionIni+4-decal][lig-1] = ColorMessage;
								colors[PositionIni+4-decal][lig] = ColorMessage;
								colors[PositionIni+4-decal][lig+1] = ColorMessage;

							} catch (ArrayIndexOutOfBoundsException h){
								try{
									colors[PositionIni+4-decal][lig-2] = ColorMessage;
									colors[PositionIni+4-decal][lig-1] = ColorMessage;
									colors[PositionIni+4-decal][lig] = ColorMessage;
									colors[PositionIni+4-decal][lig+1] = ColorMessage;
									
								} catch (ArrayIndexOutOfBoundsException i){
									
								}

							}
						}
					}
				}

		
	} // FIN LettreU															
		
				}




