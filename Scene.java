import java.awt.*;
import java.util.*;

public class Scene
{
  private GObject[] obj;

  public Scene(String[] fileName){
  	obj = new GObject[fileName.length];

  	for (int i = 0; i < fileName.length; i++) {
  		obj[i] = new GObject(fileName[i]);
  	}

  }

  public void transform(Matrix m){

  	for (int i = 0; i < obj.length; i++) {
  		obj[i].transform(m);
  	}


  }

  //wait until next lab for Camera
  public void draw(Camera c, Graphics g){
    Vector3D vpn = c.getVPN();
    //System.out.println(vpn.toString());
    

    for (int k = 0; k < obj.length; k++) {
      GObject currObj = this.obj[k];

      int loop = currObj.face.length;

      for (int i = 0; i < loop; i++) {

        Face currFace = currObj.face[i];

        Point3D one = currObj.vertex[currFace.index[0]];
        Point3D two = currObj.vertex[currFace.index[1]];
        Point3D three = currObj.vertex[currFace.index[2]];

        if (one.isFrontFace(one,two,three, vpn)) {
          int[] xPoints = new int[currFace.index.length];
          int[] yPoints = new int[currFace.index.length];

          g.setColor(currFace.color);
          for (int j = 0; j < currFace.index.length; j++) {
            Point3D currVertex = c.project(currObj.vertex[currFace.index[j]]);
            xPoints[j] = (int)currVertex.x;
            yPoints[j] = (int)currVertex.y;
          }
          g.fillPolygon(xPoints, yPoints, currFace.index.length);
        }

      }
    }

  }

  public String toString() {/* Make it look nice to save your debugging time! */

  	String toPrint = "GObjects are: \n";

  	for (int i = 0; i < obj.length; i++) {
  		toPrint = toPrint + obj[i].toString();
  	}
  	return toPrint;
  }
}