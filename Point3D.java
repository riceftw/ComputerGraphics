public class Point3D
{
  public double x,y,z;

  public Point3D(double X,double Y,double Z){
    x = X;
    y = Y;
    z = Z;
  }

  public Point3D transform(Matrix m){
    Matrix M = new Matrix();
    M.setTranslation(x,y,z);
    
    for (int i = 0; i < 3; i++) {
        for (int k = 0; k < 3; k++) {
            M.m[i][k] = 0;
        }
    }


    Matrix result = m.multiply(M);

    /*for (int i = 0; i < 4; i++) {
        for (int k = 0; k < 4; k++) {
            System.out.print(" " + result.m[i][k] + " ");
        }
        System.out.println("\n");
    }*/
    double w = result.m[3][3];
    Point3D resultPoint = new Point3D(result.m[0][3]/w , result.m[1][3]/w, result.m[2][3]/w);
    return resultPoint;
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

  //Lab 3
  public Vector3D vector(Point3D p){
  /* return the vector that is between this point and p.*/
    return new Vector3D(p.x - this.x, p.y - this.y, p.z -this.z);
  }

  public static Vector3D faceNormal(Point3D p1, Point3D p2, Point3D p3){
    Vector3D vector1 = new Vector3D(p2.x - p1.x, p2.y - p1.y, p2.z - p1.z);
    Vector3D vector2 = new Vector3D(p3.x - p1.x, p3.y - p1.y, p3.z - p1.z);
    //System.out.println(vector1.crossProduct(vector2));
    return vector1.crossProduct(vector2);
  }
  public static boolean isFrontFace(Point3D p1, Point3D p2, Point3D p3, Vector3D vpn){

    //System.out.println(faceNormal(p1,p2,p3).dotProduct(vpn));
    if (faceNormal(p1,p2,p3).dotProduct(vpn) >= 0) {
      //System.out.println("Here");

      return true;
    }
    return false;
  }








}


