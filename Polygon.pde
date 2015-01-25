//to build a polygon. depend on different parameters.
// x,y represent the place of the polygon and the radius means 
// the distantce from central point to the corner. and the npoints 
// means the how many points the polygon has.
void polygon(float x, float y, float radius, int npoints) {
  float angle = TWO_PI / npoints;
  beginShape();
  for (float a = 0; a < TWO_PI; a += angle) {
    float sx = x + cos(a) * radius;
    float sy = y + sin(a) * radius;
    vertex(sx, sy);
  }
  endShape(CLOSE);
}

