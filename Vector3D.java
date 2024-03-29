import static java.lang.Math.*;  
/* Now you can use math functions without the Math. prefix */

public class Vector3D implements Cloneable     
{
  public double x,y,z;
  
  public Vector3D(double X, double Y, double Z){
    this.x = X;
    this.y = Y;
    this.z = Z;
  }

  public Vector3D transform(Matrix m) {

    Matrix M = new Matrix();
    M.setTranslation(x,y,z);
    for (int i = 0; i < 3; i++) {
        for (int k = 0; k < 3; k++) {
            M.m[i][k] = 0;
        }
    }
    
    Matrix result = m.multiply(M);
    double w = result.m[3][3];

    Vector3D resultVector = new Vector3D(result.m[0][3]/w, result.m[1][3]/w, result.m[2][3]/w);
    return resultVector;
  }

  public String toString()
  {/* Make it look nice to save your debugging time! */
    return ("\n x = " + this.x + " y = " + this.y + " z = " + this.z);
  }

  public Vector3D clone() throws CloneNotSupportedException{
    Vector3D clone = new Vector3D(this.x, this.y, this.z);
    return clone;
  }

  public double L2norm()
  {
    return sqrt (x * x + y * y + z * z);
  }

  public double dotProduct(Vector3D v)
  {
    return this.x * v.x + this.y * v.y + this.z * v.z;
  }

  public Vector3D crossProduct(Vector3D v){
    double newX = this.y * v.z - this.z * v.y;
    double newY = this.x * v.z - this.z * v.x;
    double newZ = this.x * v.y - this.y * v.x;
    Vector3D result = new Vector3D(newX, -1 * newY, newZ);
    return result;
  }

  public void normalize(){
    double magnitude = (this.L2norm());
    this.x = x/magnitude;
    this.y = y/magnitude;
    this.z = z/magnitude;
  } 
}


