import java.awt.*;
import java.awt.geom.*;
import java.util.*;
public class BirdShape implements MoveableShape
{
   private int x;
   private int y;
   private int width;
   
   public BirdShape(int x, int y, int width)
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
      QuadCurve2D wing = new QuadCurve2D.Double(x, y, x + 5, y + 7, x + 10, y);
      g2.setColor(Color.red);
      QuadCurve2D wing2 = new QuadCurve2D.Double(x + 10, y, x + 10, y + 7, x + 20, y);
      g2.draw(wing);
      g2.draw(wing2);
      g2.setColor(Color.orange);
      QuadCurve2D wing3 = new QuadCurve2D.Double(x, y, x + 5, y + 15, x + 10, y);
      QuadCurve2D wing4 = new QuadCurve2D.Double(x + 10, y, x + 15, y + 15, x + 20, y);
      g2.draw(wing3);
      g2.draw(wing4);
   }
   
}