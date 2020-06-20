 //<>//
class Ball {
  float dx; 
  float dy;
  int radius;
  int userScore = 0;
  int opponentScore = 0;
  color ballColor = color(200, 100, 50);
  Ball() {
    x = random(SCREENX/4, SCREENX/2);
    y = random(SCREENY/4, SCREENY/2);
    dx = random(1, 2); 
    dy = random(1, 2); 
    radius=5;
  }

  void move() {
    x = x+dx; 
    y = y+dy;
  }
  void draw() {
    fill(ballColor);
    ellipse(int(x), int(y), radius, 
      radius);
  }




  void collide(Player tp) {
    if (x-radius <=0) dx=-dx;
    else if (x+radius>=SCREENX) dx=-dx;
    if (y+radius >= tp.ypos &&
      y-radius<tp.ypos+PADDLEHEIGHT &&
      x >=tp.xpos && x <= tp.xpos+PADDLEWIDTH) {
      println("collided!");
      dy=-dy;
    }
  }

  void collideOpponent(Player tp) { 
    if (y+radius >= tp.ypos &&
      y-radius<tp.ypos+PADDLEHEIGHT && x >=tp.xpos &&
      x <= tp.xpos+PADDLEWIDTH) {
      println("collided!");
      dy=-dy;
    }
  }
  
  void reset()
  {
   if(mousePressed && y < 0)
   {
     y = random(SCREENY/4, SCREENY/2);
     opponentScore++;
     dy = random(1, 2); 

   }
   else if(mousePressed && y > 240)
   {
     y = random(SCREENY/4, SCREENY/2);
     userScore--;
     dy = random(1, 2); 

   }
  }
  

}
