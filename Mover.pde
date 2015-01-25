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
  void update(){
    PVector mouse = new PVector(mouseX,mouseY);
    PVector acceleration = PVector.sub(mouse,location);
    
    acceleration.normalize();//normalize the acceleration.
    acceleration.mult(0.2);
    velocity.add(acceleration);
    velocity.limit(topspeed);//limit the speed.
    location.add(velocity);
    
  }
// to show the place of the polygon("ball")
  void display(){
    stroke(0);
    strokeWeight(2);
    fill(0,255,0);
    polygon(location.x,location.y,40,4);
  }
// to check the edges,and change the direction.
  void checkEdges(){
   if ((location.x<80)||(location.x>560)){
     velocity.x = velocity.x * -1;
   }
  
   else if((location.y<40)||(location.y>320)){
     velocity.y = velocity.y * -1;
   }
  }
//this method is to show the expert's place to catch the "ball"   
   void pointmotion(){
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
 
 

