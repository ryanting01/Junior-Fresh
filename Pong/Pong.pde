Player thePlayer; 
Ball theBall; 
Player theOpponent;
void settings() {
  size(SCREENX, SCREENY);
}
void setup() {
  

  thePlayer = new Player(215);
  theOpponent = new Player(35);
  theBall = new Ball();
  ellipseMode(RADIUS);
}





void draw() {
  background(255);
  thePlayer.move(mouseX); 
  theOpponent.moveOpponent();
  theBall.move(); 
  theBall.collide(thePlayer); 
  theBall.collideOpponent(theOpponent);
  thePlayer.draw(); 
  theOpponent.draw();
  theBall.draw();
  theBall.reset();
  thePlayer.scoreCard();
  thePlayer.score();

}
