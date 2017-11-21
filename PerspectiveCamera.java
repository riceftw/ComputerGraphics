public class PerspectiveCamera extends Camera
{
  public Vector3D getVPN(){/*return the view plan normal vector*/
  	Vector3D origin = new Vector3D(0,0,1);
    return (origin);
  }

  protected Point3D projectionTransform(final Point3D p){
  	Matrix persM = new Matrix();
  	persM.m[2][2] = 0;
  	double distance = cop.distance(new Point3D(0,0,0));
  	persM.m[3][2] = 1/distance;
  	return (p.transform(persM));

  }

  public PerspectiveCamera(double xmin_, double xmax_, double ymin_, double ymax_){

  	super(xmin_, xmax_, ymin_, ymax_);
  	
  }

  public void setupCOP(Point3D cop_){
  	this.cop = cop_;
  }     

  private Point3D cop=new Point3D(0,0,-4); //centre of projection
}
