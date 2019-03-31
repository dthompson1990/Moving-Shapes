import java.awt.*;
import java.awt.geom.*;
import java.util.*;
public class CloudShape implements MoveableShape
{
   private int x;
   private int y;
   private int width;
   public CloudShape(int x, int y, int width)
   {
      this.x = x;
      this.y = y;
      this.width = width;
   }
   /**
   Moves the shape based on parameters
   @param dx int shape moves by this amount in the horizontal direction for every timer tick
   @param dy int shape moves by this amount in the vertical direction for every timer tick
   */
   public void translate(int dx, int dy)
   {
      x += dx;
      y += dy;
      if (x > 900)
         x = 0;
      if (y > 900)
         y = 0;
   }
   /*
   @param g2 creates the image of the moveableshape
   */
   public void draw(Graphics2D g2)
   {
      QuadCurve2D l1 = new QuadCurve2D.Float(x, y, x + 12, y + 12, x + 24, y);
      g2.setPaint(Color.blue);
      QuadCurve2D l2 = new QuadCurve2D.Float(x, y, x + 4, y - 8, x + 8, y);    
      QuadCurve2D l3 = new QuadCurve2D.Float(x + 8, y, x + 12, y - 8, x + 15, y);
      QuadCurve2D l4 = new QuadCurve2D.Float(x + 15, y, x + 20, y - 8, x + 24, y);
      g2.draw(l1);
      g2.setPaint(Color.cyan);
      g2.draw(l2);
      g2.draw(l3);
      g2.draw(l4);
      
   }
   
}