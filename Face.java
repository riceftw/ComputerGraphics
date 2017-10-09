import java.awt.Color;
import java.util.Arrays;

public class Face
{
  public int[] index;
  public Color color;

  public Face(int[] i, Color c)
  {
    //index = new int [i.length];
    
    //for (int j = 0; j < i.length; j++) {
      //index[j] = i[j];
    //}
    index = i;
    this.color = c;
  }

  public String toString()
  {/* Make it look nice to save your debugging time! */
    return ("\nVertices are: " + Arrays.toString(this.index) + " Color: " + 
            this.color.toString());
  }
}
