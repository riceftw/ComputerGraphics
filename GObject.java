import java.util.Scanner;
import java.io.*;
import java.awt.Color;
import java.util.Arrays;

public class GObject
{
  public Point3D[] vertex;
  public Face[] face;
  
  public GObject(Point3D[] v, Face[] f){
  	vertex = v;
  	face = f;
  }

  public void transform(Matrix m) {

    for (int i = 0; i < vertex.length; i++){
      Matrix M = new Matrix();

      M.setTranslation(vertex[i].x, vertex[i].y, vertex[i].z);

      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
            M.m[j][k] = 0;
        }
      }

      Matrix result = m.multiply(M);

      vertex[i] = new Point3D(result.m[0][3], result.m[1][3], result.m[2][3]);
    }
  }

  public GObject(String fileName){

  	File file = new File(fileName);
  	
  	try {
  	  Scanner sc = new Scanner(file);

  	  int numVert = sc.nextInt();
  	  vertex = new Point3D[numVert];
  	  for (int i = 0; i < numVert; i++) {
  		vertex[i] = new Point3D(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
  	  }

  	  int numFace = sc.nextInt();
  	  face = new Face[numFace];

  	  for (int j = 0; j < numFace; j++) {

  	  	int faceVertLen = sc.nextInt();
  	  	int[] faceVert = new int[faceVertLen];

  	  	for (int k = 0; k < faceVertLen; k++) {
  	  		faceVert[k] = sc.nextInt();
  	  	}

  	  	Color faceColor = new Color (sc.nextFloat(), sc.nextFloat(), sc.nextFloat());
  	  	

  	  	face[j] = new Face(faceVert, faceColor);

        /** Test **/
        
  	  }
    }
    catch (FileNotFoundException e){}	
  	
  }

  public String toString(){
  /* Make it look nice to save your debugging time! */
    return ("\n----------------------------\nVertices are: " + Arrays.toString(this.vertex) + "\n \nFaces are: " + Arrays.toString(this.face) );
  }
}

