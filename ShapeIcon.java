import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
   An icon that contains a moveable shape.
*/
public class ShapeIcon implements Icon
{
   public ShapeIcon(ArrayList <MoveableShape> shapes, int width, int height)
   {
      shapeList = shapes;
      this.width = width;
      this.height = height;
   }
   public ShapeIcon(MoveableShape shape,
      int width, int height)
   {
      this.shape = shape;
      this.width = width;
      this.height = height;
   }
   
   public int getIconWidth()
   {
      return width;
   }

   public int getIconHeight()
   {
      return height;
   }
   public ArrayList<MoveableShape> getShapelist()
   {
      return shapeList;
   } 
   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      for (int i = 0; i < shapeList.size(); i++)
      {
         shapeList.get(i).draw(g2);
      }
   }
 
   public void addShape()
   {
      shapeList.add(shape);
   }
   public void removeShape()
   {
      shapeList.remove(shapeList.size() - 1);
   }
   private int width;
   private int height;
   private MoveableShape shape;
   private ArrayList<MoveableShape> shapeList;
}


