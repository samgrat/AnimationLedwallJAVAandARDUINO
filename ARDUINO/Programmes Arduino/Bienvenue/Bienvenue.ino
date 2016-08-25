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
 
int rgb[] = {0,0,255};
int temps = tempsensecondes(10); // 10 secondes d'animation

for (int compteur = 0; compteur < temps; compteur++){ 
  for ( int i =0; i<42; i++) {

bienvenue(i, rgb); // Classe contenant les positions d'allumage led du mot "Bienvenue" 
 
delay(200);
for ( int w= 0; w< width; w++){ // On éteint toutes les leds
      for (int h =0; h< height ; h++)
        BlinkM_setRGB( matrix[w][h], 0,0,0);}
        
}}
}
  /////////////////////////    
  // Le code termine ici
  ///////////////////////// 
  
int tempsensecondes (int tps){
  tps *= 5;
 return tps; } 
  
void bienvenue(int i, int rgb[]){
  
  for(int i=0; i <42;i++){
    
    while (i==0 && width > 0){ // les while servent à éviter un affichage hors écran (à droite && à gauche)
BlinkM_setRGB( matrix[width+i][2], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width+i][3], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width+i][5], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=1 && i >= 1-width){
BlinkM_setRGB( matrix[width-1+i][2], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-1+i][4], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-1+i][6], rgb[0], rgb[1], rgb[2]);  }

    while (i<=2 && i >= 2-width){
BlinkM_setRGB( matrix[width-2+i][3], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-2+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-2+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=3 && i >= 3-width){
BlinkM_setRGB( matrix[width-3+i][4], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-3+i][5], rgb[0], rgb[1], rgb[2]); } // FIN Lettre B

    while (i<=5 && i >= 5-width){
BlinkM_setRGB( matrix[width-5+i][2], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-5+i][3], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-5+i][4], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-5+i][5], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-5+i][6], rgb[0], rgb[1], rgb[2]); } // FIN Lettre I

    while (i<=7 && i >= 7-width){
BlinkM_setRGB( matrix[width-7+i][2], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-7+i][3], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-7+i][4], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-7+i][5], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-7+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=8 && i >= 8-width){
BlinkM_setRGB( matrix[width-8+i][2], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-8+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-8+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=9 && i >= 9-width){
BlinkM_setRGB( matrix[width-9+i][2], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-9+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-9+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=10 && i >= 10-width){
BlinkM_setRGB( matrix[width-10+i][2], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-10+i][6], rgb[0], rgb[1], rgb[2]); } // FIN Lettre E

    while (i<=12 && i >= 12-width){
BlinkM_setRGB( matrix[width-12+i][2], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-12+i][3], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-12+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-12+i][5], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-12+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=13 && i >= 13-width){
BlinkM_setRGB( matrix[width-13+i][3], rgb[0], rgb[1], rgb[2]); }

    while (i<=14 && i >= 14-width){
BlinkM_setRGB( matrix[width-14+i][4], rgb[0], rgb[1], rgb[2]); }
    
    while (i<=15 && i >= 15-width){
BlinkM_setRGB( matrix[width-15+i][2], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-15+i][3], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-15+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-15+i][5], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-15+i][6], rgb[0], rgb[1], rgb[2]); } // FIN Lettre N

    while (i<=17 && i >= 17-width){
BlinkM_setRGB( matrix[width-17+i][2], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-17+i][3], rgb[0], rgb[1], rgb[2]); }

    while (i<=18 && i >= 18-width){
BlinkM_setRGB( matrix[width-18+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-18+i][5], rgb[0], rgb[1], rgb[2]); }

    while (i<=19 && i >= 19-width){
BlinkM_setRGB( matrix[width-19+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=20 && i >= 20-width){
BlinkM_setRGB( matrix[width-20+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-20+i][5], rgb[0], rgb[1], rgb[2]); }

    while (i<=21 && i >= 2-width){
BlinkM_setRGB( matrix[width-21+i][2], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-21+i][3], rgb[0], rgb[1], rgb[2]); } // FIN Lettre V

    while (i<=23 && i >= 23-width){
BlinkM_setRGB( matrix[width-23+i][2], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-23+i][3], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-23+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-23+i][5], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-23+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=24 && i >= 24-width){
BlinkM_setRGB( matrix[width-24+i][2], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-24+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-24+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=25 && i >= 25-width){
BlinkM_setRGB( matrix[width-25+i][2], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-25+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-25+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=26 && i >= 26-width){
BlinkM_setRGB( matrix[width-26+i][2], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-26+i][6], rgb[0], rgb[1], rgb[2]); } // FIN Lettre E

    while (i<=28 && i >= 28-width){
BlinkM_setRGB( matrix[width-28+i][2], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-28+i][3], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-28+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-28+i][5], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-28+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=29 && i >= 29-width){
BlinkM_setRGB( matrix[width-29+i][3], rgb[0], rgb[1], rgb[2]); } 

    while (i<=30 && i >= 30-width){
BlinkM_setRGB( matrix[width-30+i][4], rgb[0], rgb[1], rgb[2]); } 

    while (i<=31 && i >= 31-width){
BlinkM_setRGB( matrix[width-31+i][2], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-31+i][3], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-31+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-31+i][5], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-31+i][6], rgb[0], rgb[1], rgb[2]); } // FIN Lettre N

    while (i<=33 && i >= 33-width){
BlinkM_setRGB( matrix[width-33+i][2], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-33+i][3], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-33+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-33+i][5], rgb[0], rgb[1], rgb[2]); }

    while (i<=34 && i >= 34-width){
BlinkM_setRGB( matrix[width-34+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=35 && i >= 35-width){
BlinkM_setRGB( matrix[width-35+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=36 && i >= 36-width){
BlinkM_setRGB( matrix[width-36+i][2], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-36+i][3], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-36+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-36+i][5], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-36+i][6], rgb[0], rgb[1], rgb[2]); } // FIN Lettre U

    while (i<=38 && i >= 38-width){
BlinkM_setRGB( matrix[width-38+i][2], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[width-38+i][3], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-38+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-38+i][5], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-38+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=39 && i >= 39-width){
BlinkM_setRGB( matrix[width-39+i][2], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-39+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-39+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=40 && i >= 40-width){
BlinkM_setRGB( matrix[width-40+i][2], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-40+i][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-40+i][6], rgb[0], rgb[1], rgb[2]); }

    while (i<=41 && i >= 41-width){
BlinkM_setRGB( matrix[width-41+i][2], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[width-41+i][6], rgb[0], rgb[1], rgb[2]); } // FIN Lettre E

delay(500);

for (int w = 0; w< width; w++)// On efface l'écran après une courte pause entre deux decalages
   for(int h = 0; h< height; h++)
   BlinkM_setRGB( matrix[w][h], 0, 0, 0); 
}}




