import java.awt.*;
import java.awt.geom.*;
import java.util.*;

public class UFOShape implements MoveableShape
{
   private int x;
   private int y;
   private int z;
   /**
   @param x the starting x coordinate for the shape
   @param y the starting y coordinate for the shape
   @param z null
   */
   public UFOShape(int x, int y, int z)
   {
      this.x = x;
      this.y = y;
      this.z = z;
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
   /**
   @param g2 creates the image of the moveableshape
   @return   returns an image of a ufo.
   */
   public void draw(Graphics2D g2)
   {
      QuadCurve2D.Double curve = new QuadCurve2D.Double(x + 4, y, x + 10, y - 6, x + 16, y); 
      Point2D.Double p1 = new Point2D.Double(x , y);
      Point2D.Double p2 = new Point2D.Double(x + 4, y + 6);
      Point2D.Double p3 = new Point2D.Double(x + 20, y);
      Point2D.Double p4 = new Point2D.Double(x + 16, y + 6);
      Line2D.Double l1 = new Line2D.Double(p1, p2);
      Line2D.Double l2 = new Line2D.Double(p2, p4);
      Line2D.Double l3 = new Line2D.Double(p4, p3);
      Line2D.Double l4 = new Line2D.Double(p3, p1);
      Line2D.Double center = new Line2D.Double(x + 2, y + 3, x + 18, y + 3);
      g2.setColor(Color.blue);
      g2.draw(curve);
      g2.setColor(Color.magenta);
      g2.draw(l1);
      g2.draw(l2);
      g2.draw(l3);
      g2.draw(l4);
      g2.draw(center);
   }
   
}