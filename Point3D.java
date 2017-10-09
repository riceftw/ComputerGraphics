public class Point3D
{
  public double x,y,z;

  public Point3D(double X,double Y,double Z){
    x = X;
    y = Y;
    z = Z;
  }

  public double distance(Point3D p){
    double xDist = this.x - p.x;
    double yDist = this.y - p.y;
    double zDist = this.z - p.z;
    return Math.sqrt(xDist * xDist + yDist * yDist + zDist * zDist); 
  }

  public String toString()
  {/* Make it look nice to save your debugging time! */
    return ("\nx = " + this.x + " y = " + this.y + " z = " + this.z);
  }
}


