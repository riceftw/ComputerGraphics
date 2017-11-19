import java.awt.Color;
import java.util.Arrays;

public class Test {
  
  public static void main (String[] args) {
    
    //Lab1 Testers
    
    
    Point3D point = new Point3D(1, 0, 0);
    Point3D point2 = new Point3D(0,1,0);
    Point3D point3 = new Point3D(0,0,1);
    //System.out.println(point.distance(point2));
    //System.out.println(point.toString());  
    Vector3D vector = new Vector3D(2,5,3);
    //System.out.println(vector.L2norm());
    Vector3D vector2 = new Vector3D(-1,0,0);
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



    Matrix testMatrix = new Matrix();
    testMatrix.setTranslation(0,10,20);


    String[] testFiles = {"cube.dat", "pyramid.dat"};
    Scene sceneTest = new Scene(testFiles);
    System.out.println(sceneTest.toString());

    sceneTest.transform(testMatrix);

    System.out.println("\nTransformed Matrix:");
    System.out.println(sceneTest.toString());

    //System.out.println(point.isFrontFace(point, point2, point3, vector2));

   
    /*for (int i = 0; i < 3; i++) {
        for (int k = 0; k < 3; k++) {
            testMatrix.m[i][k] = i + k;
        }
    }
    */
    /*
    testMatrix.m[0][0] = 1;
    testMatrix.m[0][1] = 0;
    testMatrix.m[0][2] = 0;
    testMatrix.m[0][3] = 3;

    testMatrix.m[1][0] = 0;
    testMatrix.m[1][1] = 1;
    testMatrix.m[1][2] = 0;
    testMatrix.m[1][3] = 5;

    testMatrix.m[2][0] = 0;
    testMatrix.m[2][1] = 0;
    testMatrix.m[2][2] = 1;
    testMatrix.m[2][3] = 7;

    testMatrix.m[3][0] = 0;
    testMatrix.m[3][1] = 0;
    testMatrix.m[3][2] = 0;
    testMatrix.m[3][3] = 1;
    */
    


   /* for (int i = 0; i < 4; i++) {
        for (int k = 0; k < 4; k++) {
            System.out.print(" " + testMatrix.m[i][k] + " ");
        }
        System.out.println("\n");
    }
    */
    /*System.out.println("Before Transform: \n" + objectTest.toString() + "\n \n");

    objectTest.transform(testMatrix);
    System.out.println("After Transform: \n" + objectTest.toString());
    */

    //System.out.println(point2.transform(testMatrix));

    //System.out.println(vector3.transform(testMatrix));

    /*for (int i = 0; i < 4; i++) {
        for (int k = 0; k < 4; k++) {
            System.out.print(" " + testMatrix.m[i][k] + " ");
        }
        System.out.println("\n");
    }
    */


  }

}
