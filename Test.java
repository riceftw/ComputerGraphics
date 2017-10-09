import java.awt.Color;
import java.util.Arrays;

public class Test {
  
  public static void main (String[] args) {
    
    //Lab1 Testers
    
    
    Point3D point = new Point3D(1, 2, 3);
    Point3D point2 = new Point3D(2,5,3);
    //System.out.println(point.distance(point2));
    //System.out.println(point.toString());  
    Vector3D vector = new Vector3D(2,5,3);
    //System.out.println(vector.L2norm());
    Vector3D vector2 = new Vector3D(1,0,0);
    Vector3D vector3 = new Vector3D(10,10,5);
    //System.out.println(dotvector.dotProduct(dotvector2));
    //vector.normalize();
    //System.out.println(vector.toString());
    
    
    //Lab2 Testers
    int[] vertices = {1,2,3};
    Color c = Color.red;
    Face faceTest = new Face(vertices, c);
    //System.out.println(faceTest.toString()); 

    Point3D[] objectVertices = {point, point2};
    Face[] objectFaces = {faceTest};
    GObject objectTest = new GObject ("pyramid.dat");
    System.out.println(objectTest.toString());
  }

}
