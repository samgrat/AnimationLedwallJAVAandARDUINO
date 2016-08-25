void setup() {
  // put your setup code here, to run once:

}

void loop() {
  // put your main code here, to run repeatedly:
int[] rgb = {0,0,255};
int temps = 1000;
BlinkM_setRGB( matrix[1][4], rgb[0], rgb[1], rgb[2]); // Ces lignes correspondent aux "cases" qui restent constamment allumées  
BlinkM_setRGB( matrix[2][3], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[3][4], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[4][2], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[5][2], rgb[0], rgb[1], rgb[2]);
BlinkM_setRGB( matrix[6][2], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[7][3], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[8][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[4][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[4][5], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[5][4], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[5][5], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[2][7], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[3][7], rgb[0], rgb[1], rgb[2]);  
BlinkM_setRGB( matrix[6][7], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[7][7], rgb[0], rgb[1], rgb[2]);

for ( int i=0; i<60; i++) {                          // Le smiley effectuera 60 clins d'oeils, valeur que l'on peut changer 
BlinkM_setRGB( matrix[2][8], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[3][8], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[6][8], rgb[0], rgb[1], rgb[2]); 
BlinkM_setRGB( matrix[7][8], rgb[0], rgb[1], rgb[2]); 
delay(temps);
BlinkM_setRGB( matrix[2][8], 0, 0, 0); 
BlinkM_setRGB( matrix[3][8], 0, 0, 0); 
BlinkM_setRGB( matrix[6][8], 0, 0, 0); 
BlinkM_setRGB( matrix[7][8], 0, 0, 0); 
delay(300);
temps = long random(1000,5000); // On défini un temps d'attente aléatoire (entre 1 et 5 sec) entre deux clignements
}
}
