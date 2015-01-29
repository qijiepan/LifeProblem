import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class assignment_0 extends PApplet {

// define the mover
Mover mover;

// to setup the frame and the new mover.
public void setup(){
  size(640,360);
  mover = new Mover();
  
}

// to draw the background and the "ball"
public void draw(){
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


// four variables in mover. location,velocity and acceleration.
// and the topspeed.
class Mover{
  PVector location;
  PVector velocity;
  PVector acceleration;
  
  float topspeed;
  

// build the mover  
  Mover(){
    location = new PVector(80,180);
    velocity = new PVector(random(-2,2),random(-2,2)); 
    topspeed = 5;
  }
// the method of update,which inluce the velocity and accleration.  
  public void update(){
    PVector mouse = new PVector(mouseX,mouseY);
    PVector acceleration = PVector.sub(mouse,location);
    
    acceleration.normalize();//normalize the acceleration.
    acceleration.mult(0.2f);
    velocity.add(acceleration);
    velocity.limit(topspeed);//limit the speed.
    location.add(velocity);
    
  }
// to show the place of the polygon("ball")
  public void display(){
    stroke(0);
    strokeWeight(2);
    fill(0,255,0);
    polygon(location.x,location.y,40,4);
  }
// to check the edges,and change the direction.
  public void checkEdges(){
   if ((location.x<80)||(location.x>560)){
     velocity.x = velocity.x * -1;
   }
  
   else if((location.y<40)||(location.y>320)){
     velocity.y = velocity.y * -1;
   }
  }
//this method is to show the expert's place to catch the "ball"   
   public void pointmotion(){
     if(location.x<=85){
       stroke(0,0,255);
       strokeWeight(10);
       point(30,location.y);
     }
     else if(location.x>=555){
       stroke(0,0,255);
       strokeWeight(10);
       point(610,location.y);
     }
   }
 }
 
 

//to build a polygon. depend on different parameters.
// x,y represent the place of the polygon and the radius means 
// the distantce from central point to the corner. and the npoints 
// means the how many points the polygon has.
public void polygon(float x, float y, float radius, int npoints) {
  float angle = TWO_PI / npoints;
  beginShape();
  for (float a = 0; a < TWO_PI; a += angle) {
    float sx = x + cos(a) * radius;
    float sy = y + sin(a) * radius;
    vertex(sx, sy);
  }
  endShape(CLOSE);
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "assignment_0" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
