import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.BufferedImage;

public class Animator extends JFrame
{
  public Animator()
  {

    
    setSize(WIDTH + 300,HEIGHT + 300);
    setTitle("Computer Graphics Demo");
    getContentPane( ).setLayout(new BorderLayout());
    
    overall = new JPanel();

    JRadioButton wireButton = new JRadioButton("Wire Frame");
    wireButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        wire = true;      
      }
    });
    
    
    JRadioButton solidButton = new JRadioButton("Solid");
    solidButton.setSelected(true);
    solidButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        wire = false;      
      }
    });

    ButtonGroup group = new ButtonGroup();
    group.add(wireButton);
    group.add(solidButton);


    overall.add(solidButton);
    overall.add(wireButton);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(overall, BorderLayout.CENTER);
    setVisible(true);
   
  }

  private int R;
  protected void animate(Graphics g)
  {
    g.setColor(Color.RED);
    R=R>20?0:R+1;
    g.fillPolygon(new int[]{100,WIDTH/2,R*3},new int[]{100,HEIGHT/2,R*3},3);
  }

  

  protected final void loop()
  {
    while(true)
    {
      
      image=new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
      Graphics2D g2 = image.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(Color.BLACK);
      g2.fillRect(0,0,getWidth(),getHeight());

      animate(g2);
      
     

      ((Graphics2D)getGraphics()).drawImage(image,0,75,null);

      
  
      
      paint(getGraphics());


      try {Thread.sleep(INTERVAL);}
      catch(InterruptedException e){}
    }
  }
  
 

  public final void paint(Graphics g){}

  private static final int WIDTH=400;
  private static final int HEIGHT=300;
  private static final int INTERVAL=100;
  JFrame start;
  JPanel overall;
  public boolean wire;

  private BufferedImage image;
  public static void main(String[] args) 
  {
    new Animator().loop();
  }
}
