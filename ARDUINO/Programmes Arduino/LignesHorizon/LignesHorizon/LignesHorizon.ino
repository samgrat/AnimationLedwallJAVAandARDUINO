#include <Arduino.h>
#include "Wire.h"
#include "BlinkM_funcs.h"

const int ledPin = 13;
const int buttonPin = 8;

//Variables de couleurs qui seront assign��es au hasard
  long red = 0;
  long green = 0;
  long blue = 0;

//Adresse pixel qui se d��place
 int adressePixel = 1;
 int adresseBefore = 1;
 int loopidx = 0;
 
 #define width 8
 #define height 10
 
// Création matrice 5x5
//int matrix[width][height]={
 //  {25,24,23,22,21}, {16,17,18,19,20},{15,14,13,12,11},{6,7,8,9,10},{5,4,3,2,1}
// };
 
  
 //Création matrice 8x10
 int matrix[width][height]={
  {11,12,13,14,15,16,17,18,19,20},{21,22,23,24,25,26,27,28,29,30},{31,32,33,34,35,36,37,38,39,40},{41,42,43,44,45,46,47,48,49,50},
  {55,51,52,53,54,56,57,58,59,60},{61,62,63,64,65,66,67,68,69,70},{71,72,73,74,75,76,77,78,79,80},{81,82,83,84,85,86,87,88,89,90} 
  };

int temp = 1000;

class Disque {

   public : 
        void faireDisque(int centre, int y, int largeur, int vert, int rouge, int bleu);

};

 void Disque :: faireDisque(int centre, int y, int largeur, int vert, int rouge, int bleu){
   for (int i = 0; i<=largeur/2; i++ )
                        BlinkM_setRGB( matrix[centre+i][y],vert,rouge,bleu);		
		for (int i=1; i<=largeur/2; i++)
                        BlinkM_setRGB( matrix[centre+i][y],vert,rouge,bleu);		
		
 }

void setup()
{
    Serial.begin(19200);

    //Utiliser pour flasher la led de la carte Arduino pour dire qu'il se passe qlq chose
    pinMode(ledPin, OUTPUT);
    digitalWrite(ledPin, HIGH);
    pinMode(buttonPin, INPUT);
    digitalWrite(buttonPin, HIGH); // turn on internal pullup

    BlinkM_begin();
    delay(1000);

    // Arr��ter les script en fonctionnement
    BlinkM_stopScript( 0 );
    // Eteindre toutes les leds: 1er parametres= adresse (si 0 = broadcast),
    BlinkM_fadeToRGB( 0, 0,0,0);
    
    Serial.print("BlinkMDemo ready\n");
    delay(1000);
    //test affiche la matrice
    int i,j;
    for(i=0;i<width;i++)
    {
      for(j=0; j<height;j++)
      {
          Serial.print(matrix[j][i]);
          Serial.print(" ");
          delay(50);
      }
       Serial.println( " ");
    }

}

void loop() {
  
  pinMode(7, OUTPUT);
  digitalWrite(7, HIGH); //Transistor passant, Bus alimenté
  loopidx++;
  
    /////////////////////////
  // Coder à partir d'ici
  /////////////////////////
  
barreshorizontales(30); // entrez une durée en secondes en paramètre
     }
     
  /////////////////////////    
  // Le code termine ici
  /////////////////////////  
  
  void barreshorizontales(int duree){
    
   // BlinkM_setRGB( matrix[ligne][colonne], rgb[0], rgb[1], rgb[2]);
   
   for (int i = 0; i < (int) duree; i++){ //temps d'animation
     for (int decal = 0; decal < width-5; decal++){ // compteur qui décalle l'animation
       for (int k = 0; k < height/2 ; k++){ 
         
       BlinkM_setRGB( matrix[2*k][width-1-decal], 150, 0, 0); // lignes rouges des lignes paires arrivant par la gauche
       BlinkM_setRGB( matrix[2*k][width-2-decal], 200, 0, 0);
       BlinkM_setRGB( matrix[2*k][width-3-decal], 255, 0, 0);
       BlinkM_setRGB( matrix[2*k][width-4-decal], 200, 0, 0);
       BlinkM_setRGB( matrix[2*k][width-5-decal], 150, 0, 0);
       
       BlinkM_setRGB( matrix[2*k+1][0+decal], 0, 0, 150); // lignes bleues des lignes impaires arrivant de la droite
       BlinkM_setRGB( matrix[2*k+1][1+decal], 0, 0, 200);
       BlinkM_setRGB( matrix[2*k+1][2+decal], 0, 0, 255);
       BlinkM_setRGB( matrix[2*k+1][3+decal], 0, 0, 200);
       BlinkM_setRGB( matrix[2*k+1][4+decal], 0, 0, 150);
       
       delay(200);
       //On eteint toutes les Leds précedement allumées après une courte pause
              
       BlinkM_setRGB( matrix[2*k][width-1-decal], 0, 0, 0); // lignes rouges des lignes paires arrivant par la gauche
       BlinkM_setRGB( matrix[2*k][width-2-decal], 0, 0, 0);
       BlinkM_setRGB( matrix[2*k][width-3-decal], 0, 0, 0);
       BlinkM_setRGB( matrix[2*k][width-4-decal], 0, 0, 0);
       BlinkM_setRGB( matrix[2*k][width-5-decal], 0, 0, 0);
       
       BlinkM_setRGB( matrix[2*k+1][0+decal], 0, 0, 0); // lignes bleues des lignes impaires arrivant de la droite
       BlinkM_setRGB( matrix[2*k+1][1+decal], 0, 0, 0);
       BlinkM_setRGB( matrix[2*k+1][2+decal], 0, 0, 0);
       BlinkM_setRGB( matrix[2*k+1][3+decal], 0, 0, 0);
       BlinkM_setRGB( matrix[2*k+1][4+decal], 0, 0, 0);  
     }}
     
// Toute les boucles qui suivent gèrent l'affaichage des barres lorqu'elles atteignent les cotés

       for (int k = 0; k < height/2 ; k++){ 

       BlinkM_setRGB( matrix[2*k][width-1], 200, 0, 0);  // lignes rouges des lignes paires arrivant par la gauche
       BlinkM_setRGB( matrix[2*k][width-2], 255, 0, 0);
       BlinkM_setRGB( matrix[2*k][width-3], 200, 0, 0);
       BlinkM_setRGB( matrix[2*k][width-4], 150, 0, 0);

       BlinkM_setRGB( matrix[2*k+1][0], 0, 0, 200); // lignes bleues des lignes impaires arrivant de la droite
       BlinkM_setRGB( matrix[2*k+1][1], 0, 0, 255);
       BlinkM_setRGB( matrix[2*k+1][2], 0, 0, 200);
       BlinkM_setRGB( matrix[2*k+1][3], 0, 0, 150);
       
       delay(200);
       //On eteint toutes les Leds précedement allumées après une courte pause
              
       BlinkM_setRGB( matrix[2*k][width-1], 0, 0, 0);  // lignes rouges des lignes paires arrivant par la gauche
       BlinkM_setRGB( matrix[2*k][width-2], 0, 0, 0);
       BlinkM_setRGB( matrix[2*k][width-3], 0, 0, 0);
       BlinkM_setRGB( matrix[2*k][width-4], 0, 0, 0);

       BlinkM_setRGB( matrix[2*k+1][0], 0, 0, 0); // lignes bleues des lignes impaires arrivant de la droite
       BlinkM_setRGB( matrix[2*k+1][1], 0, 0, 0);
       BlinkM_setRGB( matrix[2*k+1][2], 0, 0, 0);
       BlinkM_setRGB( matrix[2*k+1][3], 0, 0, 0); 
     }
 
        for (int k = 0; k < height/2 ; k++){ 

       BlinkM_setRGB( matrix[2*k][width-1], 255, 0, 0);// lignes rouges des lignes paires arrivant par la gauche
       BlinkM_setRGB( matrix[2*k][width-2], 200, 0, 0);
       BlinkM_setRGB( matrix[2*k][width-3], 150, 0, 0);

       BlinkM_setRGB( matrix[2*k+1][0], 0, 0, 255); // lignes bleues des lignes impaires arrivant de la droite
       BlinkM_setRGB( matrix[2*k+1][1], 0, 0, 200);
       BlinkM_setRGB( matrix[2*k+1][2], 0, 0, 150);
       
       delay(200);
       //On eteint toutes les Leds précedement allumées après une courte pause
              
       BlinkM_setRGB( matrix[2*k][width-1], 0, 0, 0);// lignes rouges des lignes paires arrivant par la gauche
       BlinkM_setRGB( matrix[2*k][width-2], 0, 0, 0);
       BlinkM_setRGB( matrix[2*k][width-3], 0, 0, 0);

       BlinkM_setRGB( matrix[2*k+1][0], 0, 0, 0); // lignes bleues des lignes impaires arrivant de la droite
       BlinkM_setRGB( matrix[2*k+1][1], 0, 0, 0);
       BlinkM_setRGB( matrix[2*k+1][2], 0, 0, 0);
     }
     
      for (int k = 0; k < height/2 ; k++){ 

       BlinkM_setRGB( matrix[2*k][width-1], 200, 0, 0);  // lignes rouges des lignes paires arrivant par la gauche
       BlinkM_setRGB( matrix[2*k][width-2], 150, 0, 0);

       BlinkM_setRGB( matrix[2*k+1][0], 0, 0, 200); // lignes bleues des lignes impaires arrivant de la droite
       BlinkM_setRGB( matrix[2*k+1][1], 0, 0, 150);
       
       delay(200);
       //On eteint toutes les Leds précedement allumées après une courte pause
              
       BlinkM_setRGB( matrix[2*k][width-1], 0, 0, 0);// lignes rouges des lignes paires arrivant par la gauche
       BlinkM_setRGB( matrix[2*k][width-2], 0, 0, 0);

       BlinkM_setRGB( matrix[2*k+1][0], 0, 0, 0); // lignes bleues des lignes impaires arrivant de la droite
       BlinkM_setRGB( matrix[2*k+1][1], 0, 0, 0);
     }
     
        for (int k = 0; k < height/2 ; k++){ 

       BlinkM_setRGB( matrix[2*k][width-1], 150, 0, 0);  // lignes rouges des lignes paires arrivant par la gauche

       BlinkM_setRGB( matrix[2*k+1][0], 0, 0, 150); // lignes bleues des lignes impaires arrivant de la droite
       
       delay(200);
       //On eteint toutes les Leds précedement allumées après une courte pause
              
       BlinkM_setRGB( matrix[2*k][width-1], 0, 0, 0);// lignes rouges des lignes paires arrivant par la gauche

       BlinkM_setRGB( matrix[2*k+1][0], 0, 0, 0); // lignes bleues des lignes impaires arrivant de la droite
     }
 
 
 }}
    
    
  

