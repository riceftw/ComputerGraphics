public class Camera

{

  public Vector3D getVPN(){/*return a vector that points towards the viewer. Used for face orientation*/
   
    return (origin.faceNormal(min, max, origin));
  }

  protected Point3D cameraTransform(final Point3D p){
    return p;
  }

  protected Point3D projectionTransform(final Point3D p){
    return p;
  } 
 
  private final Point3D viewportTransform(final Point3D p){
    double newX = ax + bx*p.x;
    double newY = ay + by*p.y;
    Point3D result = new Point3D(newX, newY, 0);
    return result;
  }

  public final Point3D project(final Point3D p){

    Point3D temp=cameraTransform(p);
    temp=projectionTransform(temp);
    return viewportTransform(temp);
  }

  public Camera(double xmin_, double xmax_, double ymin_, double ymax_){
    this.xmin = xmin_;
    this.xmax = xmax_;
    this.ymin = ymin_;
    this.ymax = ymax_;
    this.min = new Point3D(xmin, ymin ,0);
    this.max = new Point3D(xmax, ymax, 0);
    this.origin = new Point3D(0,0,0);
  }

  public void setViewport(int width, int height){
  /*calculate ax, bx, ay, by*/
    double dX = xmax - xmin;
    double dY = ymax - ymin;
    double dU = width;
    double dV = height;
    double umin = -(width/2);
    double vmin = -(height/2);
    double umax = width/2;
    double vmax = height/2;
    this.bx = dU/dX;
    this.by = dV/dY;
    this.ax = umin - this.bx * xmin;
    this.ay = vmin - this.by * ymin;
  }

  public String toString(){/* Make it look nice to save your debugging time! */
    String result = ("xmin = " + xmin + ", xmax = " + xmax + ", ymin = " + ymin + ", ymax= " + ymax + 
                     "\n ax = " + ax + ", bx = " + bx + ", ay = " + ay + ", by = + by");
    return result;
  }

  private double xmin, xmax, ymin, ymax;

  private double fcp, bcp;  //NOT USED: front & back clippling planes

  private double ax, bx, ay, by;

  public Point3D min, max, origin;

}