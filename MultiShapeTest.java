/**
@author Darian Thompson
Project2 Driver
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
public class MultiShapeTest
{
   public void inc ()
   {
      count++; 
   }
   public static void main (String []args)
   {
      Random location = new Random();
      final int DELAY = 10;
      //holds main window that displays buttons to modify the sub window
      JFrame mainFrame = new JFrame("Main Window");
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mainFrame.setSize(500, 200);
      
      JButton showButton = new JButton("Show");
      JButton exitButton = new JButton("Exit");
      JButton addButton = new JButton("Add");
      JButton removeButton = new JButton("Remove");
      JPanel mainPanel = new JPanel();
      JPanel subPanel = new JPanel();
      //checkbox group to add specific shapes
      JCheckBox birdCheck = new JCheckBox("Bird");
      JCheckBox ufoCheck = new JCheckBox("UFO");
      JCheckBox cloudCheck = new JCheckBox("Cloud");

      mainPanel.add(showButton);
      mainPanel.add(exitButton);
      mainPanel.add(addButton);
      mainPanel.add(removeButton);
      mainPanel.add(birdCheck);
      birdCheck.setSelected(true);
      mainPanel.add(ufoCheck);
      mainPanel.add(cloudCheck);
      mainFrame.add(mainPanel);
      mainFrame.pack();
      mainFrame.setVisible(true);
      //subwindow that holds moving icons
      JFrame subFrame = new JFrame("Shape Window");
      subFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      subFrame.setLayout(new FlowLayout());
      int x = location.nextInt(500) + 1;
      int y = location.nextInt(500) + 1;
      int z;
      final int xdir = location.nextInt(5);
      final int ydir = location.nextInt(5) + 1;
      MoveableShape shape
            = new UFOShape(x, y, 100);
      MoveableShape shape2 
            = new BirdShape(x + 100, y, 100);
      MoveableShape shape3 = 
              new CloudShape(x, y + 300, 100);
      ArrayList <MoveableShape> ufos = new ArrayList <MoveableShape> ();
      ArrayList <MoveableShape> birds = new ArrayList <MoveableShape> ();
      ArrayList <MoveableShape> clouds = new ArrayList <MoveableShape> ();
      
      for (int i = 0; i < 109; i++)
      {
         ufos.add(shape);
      }
            for (int i = 0; i < 109; i++)
      {
         clouds.add(shape3);
      }
            for (int i = 0; i < 100; i++)
      {
         birds.add(shape2);
      }
      ArrayList <MoveableShape> shapeList = new ArrayList <MoveableShape>();
     //shapeList.add(shape2);
      
      ShapeIcon icon = new ShapeIcon(shapeList, IconWidth, IconHeight);
      
      final JLabel labelBox = new JLabel(icon);
      labelBox.setIcon(icon);
      JButton hideButton = new JButton("Hide");
      JButton subExitButton = new JButton("Exit");
      labelBox.setBackground(Color.black);
      labelBox.setOpaque(true);
      subFrame.setSize(900, 900);
      subFrame.add(labelBox);
      subPanel.add(hideButton);
      subPanel.add(subExitButton);
      subFrame.add(subPanel);
      subFrame.pack();
      
      
      Timer t = new Timer(DELAY, new
      ActionListener()
      {
         int xdir = location.nextInt(5) + 1;
         int ydir = location.nextInt(5) + 1;
         
         public void actionPerformed(ActionEvent event)
         { 
            if (xdir == ydir)
               xdir = xdir + 2;
            for (int i = 0; i < shapeList.size();i++)
            {
               shapeList.get(i).translate(xdir, ydir);
               labelBox.repaint();
            }
         }
      });

      //action listeners that hold actions for buttons
      showButton.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent e)
         {
            subFrame.setVisible(true);
            if (!shapeList.isEmpty())
               t.start();
         }
      });
       exitButton.addActionListener(new ActionListener()
       {
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
       });
       removeButton.addActionListener(new ActionListener()
       {
         public void actionPerformed(ActionEvent e)
         {
            if (!shapeList.isEmpty())
            {
               if (birdCheck.isSelected())
               {
                  count--;
                  if (count < 0)
                     count = 0;
                  shapeList.remove(count);
               }
               if (ufoCheck.isSelected())
               {
                  count--;
                  if (count < 0)
                     count = 0;
                  shapeList.remove(count);
               }
               if (cloudCheck.isSelected())
               {
                  count--;
                  if (count < 0)
                     count = 0;
                  shapeList.remove(count);
               }
            }
            if (shapeList.isEmpty())
            {
               shapeList.clear();
               t.stop();
               t.start();
               subFrame.setVisible(false);
               subFrame.setVisible(true);
            }
         }
      });
       addButton.addActionListener(new ActionListener()
       {
         public void actionPerformed(ActionEvent e)
         {  
            int z = 0;
            if (birdCheck.isSelected())
            { 
               shapeList.add(new BirdShape(x + 150, y + 50, 100));
               count++;
            }
            if (ufoCheck.isSelected())
            {
               shapeList.add(new UFOShape(x, y, 100));
               count++;
            }
            if (cloudCheck.isSelected())
            {
               shapeList.add(new CloudShape(x, y + 100, 100));
               count++;
            }
            subFrame.setVisible(true);
            t.start();
         } 
       }); 
       hideButton.addActionListener(new ActionListener()
       {
         public void actionPerformed(ActionEvent e)
         {
            t.stop();
            subFrame.setVisible(false);
         } 
       });
       subExitButton.addActionListener(new ActionListener()
       {
         public void actionPerformed(ActionEvent e)
         {
            shapeList.clear();
            subFrame.dispose();
            count = 0;
         }
       });
   }
      private static final int IconHeight = 900;
      private static final int IconWidth = 900;
      private static int count = 0;
}