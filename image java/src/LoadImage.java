import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
 
public class LoadImage extends Applet
{
    
    private Image spiral = null;
     
    public void paint(Graphics g) 
  {
      this.setSize(640, 480);
      
      if (spiral == null)
      spiral = getImage("mirror11.jpg");
         
      Graphics2D g3 = (Graphics2D)g;
      MotionBlurFilter myblur=new MotionBlurFilter();
      bufferimage buffer=new bufferimage();
      BufferedImage bufferedimage= buffer.imageToBufferedImage(spiral);
      myblur.filter( bufferedimage,  bufferedimage );
     
      g3.drawImage(spiral, 0, 0, 200, 200, this);
      
 }
    
     
    public Image getImage(String path)
  {
       Image tempImage = null;
     try
     {
           URL imageURL = LoadImage.class.getResource(path);
            tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
     }
       catch (Exception e)
     {
           System.out.println("An error occured - " + e.getMessage());
     }
       return tempImage;
   }
    
}