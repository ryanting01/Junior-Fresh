class Player {
float xpos; int ypos;
color paddlecolor = color(50);
  Player(int screen_y)
  {
    xpos=SCREENX/2;
    ypos=screen_y;
  }
void move(int x){
if(x>SCREENX-PADDLEWIDTH) xpos = SCREENX-PADDLEWIDTH; else xpos=x;
}
void moveOpponent(){
  if(xpos > 450)
  {
   xpos = 450; 
  }
  
  if(xpos < x)
  {
   xpos = xpos + 2;


  }
  else if(xpos > x)
  {
    xpos = xpos - 2;

  }

}



void draw() {
    fill(paddlecolor);
rect(xpos, ypos, PADDLEWIDTH, PADDLEHEIGHT); }


void scoreCard()
{
   PFont font;
  font = createFont("Arial",16,true);
  textFont(font, 19);
  
  fill(0);
  
  text("Opponent Score: " + opponentScore, 10, 25);
  text("User Score: " + userScore, 350, 25);

   
  
  if(opponentScore == 3)
  {
   text("You Lose", 250, 120); 

  }
  if(userScore == 3)
  {
   text("You Win", 250, 120); 

  }
  
}

  void score()
  {
   if(y <= 0 && y >= -1.5)
   {
    userScore++;
   }
   else if(y >= 240 && y <= 241.5)
   {
    opponentScore++; 
   }

  }

}   
