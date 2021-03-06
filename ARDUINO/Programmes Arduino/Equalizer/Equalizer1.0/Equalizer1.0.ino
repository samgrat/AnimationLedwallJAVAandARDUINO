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

void loop()
{
  pinMode(7, OUTPUT);
  digitalWrite(7, HIGH); //Transistor passant, Bus alimenté
  loopidx++;
  /////////////////////////
  // Coder à partir d'ici
  /////////////////////////
  
  int hcolonne = 0;
  
  int[] rgb = {255,0,0}; // Couleur de la première colonne rouge
  
  for (int i= 0; i< 60; i++){ // nombre arbitraire d'affichage différent de l'equalizer (30 sec d'animation prévu)
    for (int w =0; w< width ; w++){
      hcolonne = long random (0, height);  // hauteur aléatoire de la colonne
      
      for (int h = 0; h < hcolonne; h++) //Affichage ligne par ligne
   BlinkM_setRGB( matrix[w][h], rgb[0], rgb[1], rgb[2]);
   
   switch (w) {
     case 0: rgb = {255,165,0} // couleur orange de la deuxième colonne
     break;
     case 1: rgb = {255,255,0} // jaune
     break;
     case 2: rgb = {173,255,47} // vert-jaune
     break;
     case 3: rgb = {0,128,0} // vert
     break;
     case 4: rgb = {0,255,255} // aqua
     break;
     case 5: rgb = {0,0,255} // bleu
     break;
     case 6: rgb = {138,43,226} // bleu-violet
     break;
     }
     }
     delay (500); // pause d'une demi-seconde avant l'affichage d'un nouveau equalizer
     }


   
    
    
