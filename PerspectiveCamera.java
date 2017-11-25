public class PerspectiveCamera extends Camera
{
  public Vector3D getVPN(){/*return the view plane normal vector*/
  	Vector3D result = this.vpn;

    Matrix T = new Matrix();
    T.m[0][3] = -vrp.x;
    T.m[1][3] = -vrp.y;
    T.m[2][3] = -vrp.z;

    return(result.transform(T));
  }

  protected Point3D projectionTransform(final Point3D p){
  	Matrix persM = new Matrix();
  	persM.m[2][2] = 0;
  	double distance = cop.distance(new Point3D(0,0,0));
  	persM.m[3][2] = -1/distance;
  	return (p.transform(persM));

  }

  public PerspectiveCamera(double xmin_, double xmax_, double ymin_, double ymax_){

  	super(xmin_, xmax_, ymin_, ymax_);
  	
  }

  public void setupCOP(Point3D cop_){
  	this.cop = cop_;
  }
  protected Point3D cameraTransform(final Point3D p){

    return(p.transform(this.m));
  }

  public void setupUVN(Point3D vrp_, Vector3D vpn_, Vector3D vuv_){
    this.vrp = vrp_;
    this.vpn = vpn_;
    this.vuv = vuv_;

    Matrix T = new Matrix();
    T.m[0][3] = -vrp_.x;
    T.m[1][3] = -vrp_.y;
    T.m[2][3] = -vrp_.z;


    Vector3D n = vpn;
    n.normalize();

    Vector3D u = vuv.crossProduct(vpn);
    u.normalize();

    Vector3D v = n.crossProduct(u);

    Matrix R = new Matrix();
    R.m[0][0] = u.x;
    R.m[0][1] = u.y;
    R.m[0][2] = u.z;
    R.m[1][0] = v.x;
    R.m[1][1] = v.y;
    R.m[1][2] = v.z;
    R.m[2][0] = n.x;
    R.m[2][1] = n.y;
    R.m[2][2] = n.z;

    m = R.multiply(T);

  }


  private Matrix m = new Matrix(); 
  //camera transformation matrix
  { m.setIdentity(); }
 
  private Point3D vrp=new Point3D(0,0,0); 
  //view reference point: the origin of camera coordinating system
 
  private Vector3D vpn=new Vector3D(0,0,1), vuv=new Vector3D(0,1,0);  
  //view plane normal (axis n) and the view up vector (axis v)     

  private Point3D cop=new Point3D(0,0,-4); 
  //centre of projection
}
