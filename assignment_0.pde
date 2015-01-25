// define the mover
Mover mover;

// to setup the frame and the new mover.
void setup(){
  size(640,360);
  mover = new Mover();
  
}

// to draw the background and the "ball"
void draw(){
  background(255);// white background
  stroke(0);// black stroke
  strokeWeight(5);
  line(40,0,40,360);
  line(600,0,600,360);// two lines stands for the border.
  stroke(0,0,255);
  
  mover.update();//to change the posistion of "ball"
  mover.checkEdges();// to check if it meets the border
  mover.display();// to show the "ball"
  mover.pointmotion();// to show the experts of ping-pong.
}


