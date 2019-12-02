import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Panel that contains the Sierpinski triangles.
 * Responsible for animating the triangles, and managing state.
 * 
 * @author Nicholas, modified by Cameron
 * @version 2016-11-10
 */
@SuppressWarnings("serial")
public class SierpinskiPanel extends JPanel
{
    /**
     * The list of triangles currently being tracked and
     * managed by this panel.
     */
    private ArrayList<SierpinskiTriangle> triangles;
    
    /**
     * Map that stores whether or not any particular triangle
     * should recirculate back to the top of the screen after
     * falling off the bottom of the screen.
     */
    private HashMap<SierpinskiTriangle, Boolean> recirculationMap;
    
    /**
     * The maximum number of allowed triangles.
     */
    public static int maxTriangleCount = 15;

    /**
     * Constructs a new SierpinskiPanel, initializing the
     * necessary variables.
     */
    public SierpinskiPanel()
    {
        setBackground(Color.DARK_GRAY);
        setDoubleBuffered(true);
        triangles = new ArrayList<SierpinskiTriangle>();
        recirculationMap = new HashMap<SierpinskiTriangle, Boolean>();
    }
    
    /**
     * Adds a triangle to this panel.
     * 
     * @param triangle The triangle to add to this panel.
     * @param recirculate Whether or not this triangle is to loop back
     * to the top of the screen after falling off the bottom on the screen.
     */
    public void addTriangle(SierpinskiTriangle triangle, boolean recirculate)
    {
        if (triangles.size() == maxTriangleCount)
        {
            removeTriangle(triangles.get(0));
        }
        
        triangles.add(triangle);
        recirculationMap.put(triangle, recirculate);
    }
    
    /**
     * Removes the specified triangle from the panel.
     * 
     * @param triangle The triangle to remove.
     */
    private void removeTriangle(SierpinskiTriangle triangle)
    {
        triangles.remove(triangle);
        recirculationMap.remove(triangle);
    }

    /**
     * Applies the specified radius to all of the triangles
     * stored in this panel.
     * 
     * @param radius The radius to apply to all triangles.
     */
    public void setRadius(int radius)
    {
        for (SierpinskiTriangle triangle: triangles)
        {
            triangle.setRadius(radius);
        }
    }

    /**
     * Applies the specified displacement rate to
     * all of the triangles stored in this panel.
     * 
     * @param rate The displacement rate to apply to all triangles.
     */
    public void setDisplacementRate(int rate)
    {
        for (SierpinskiTriangle triangle: triangles)
        {
            triangle.setDisplacementRate(rate);
        }
    }
    
    /**
     * Applies the specified rotational velocity
     * to all of the triangles stored in this panel.
     * 
     * @param velocity The rotational velocity to apply to all triangles.
     */
    public void setRotationalVelocity(double velocity)
    {
        for (SierpinskiTriangle triangle: triangles)
        {
            triangle.setRotationalVelocity(velocity);
        }
    }
    
    /**
     * Applies the specified recursion depth
     * to all of the triangles stored in this panel.
     * 
     * @param depth The recursion depth to apply to all triangles.
     */
    public void setDepth(int depth)
    {       
        for (SierpinskiTriangle triangle: triangles)
        {
            triangle.setDepth(depth);
        }
    }
    
    /**
     * Sets all triangles to either be drawn filled or as wireframes.
     * 
     * @param filled Whether or not all triangles should be drawn filled.
     */
    public void setFilled(boolean filled)
    {
        for (SierpinskiTriangle triangle: triangles)
        {
            triangle.setFilled(filled);
        }
    }
    
    /**
     * Sets whether or not inscribed circles should
     * be drawn on the triangles.
     * 
     * @param draw Whether or not inscribed circles should
     * be drawn on the triangles.
     */
    public void setDrawCircles(boolean draw)
    {
        for (SierpinskiTriangle triangle: triangles)
        {
            triangle.setDrawCircle(draw);
        }
    }
    
    /**
     * Applies the specified primary color
     * to all of the triangles stored in this panel.
     * 
     * @param color The primary color to apply to all triangles.
     */
    public void setPrimaryColor(Color color)
    {
        for (SierpinskiTriangle triangle: triangles)
        {
            triangle.setPrimaryColor(color);
        }
    }
    
    /**
     * Applies the specified secondary color
     * to all of the triangles stored in this panel.
     * 
     * @param color The secondary color to apply to all triangles.
     */
    public void setSecondaryColor(Color color)
    {
        for (SierpinskiTriangle triangle: triangles)
        {
            triangle.setSecondaryColor(color);
        }
    }
    
    /**
     * Determines whether or not a triangle is off-screen
     * and should be deleted.
     * 
     * @param triangle The triangle to examine.
     * @return true if the triangle should be deleted.
     */
    private boolean triangleNeedsCulling(SierpinskiTriangle triangle)
    {
        return triangle.getCenterPoint().y >= 
                getHeight() + triangle.getRadius();
    }
    
    /**
     * Specifies whether or not triangles should loop back to the top
     * of the screen after falling past the bottom of the visible area.
     * 
     * @param recirculate Whether or not triangles should be re-drawn at the
     * top of the screen after falling off of the bottom of the screen.
     */
    public void setRecirculateTriangles(boolean recirculate)
    {
        for (SierpinskiTriangle triangle : triangles)
        {
            recirculationMap.put(triangle, recirculate);
        }        
    }
    
    /**
     * Performs the animation step of the program, computing the
     * new location and orientation for all triangles.
     */
    private void updateTriangles()
    {
        ArrayList<SierpinskiTriangle> trianglesMarkedForDeletion =
                new ArrayList<SierpinskiTriangle>();

        for (SierpinskiTriangle triangle: triangles)
        {
            Point center = triangle.getCenterPoint();

            //Sets the new location and offset for triangles
            triangle.setCenterPoint(new Point(center.x, center.y 
                    + triangle.getDisplacementRate()));
            
            triangle.setRotationOffset(triangle.getRotationOffset() 
                    + triangle.getRotationalVelocity());

            
            // Does the triangle need to be deleted or moved back to top?
            if (triangleNeedsCulling(triangle))
            {
                if (recirculationMap.get(triangle))
                {
                    triangle.setCenterPoint(new Point(
                            ThreadLocalRandom.current().nextInt(0, getWidth()),
                            0 - triangle.getRadius()));
                }
                else
                {
                    trianglesMarkedForDeletion.add(triangle);
                }
            }
        }

        for (SierpinskiTriangle culledTriangle : trianglesMarkedForDeletion)
        {
            removeTriangle(culledTriangle);
        }
    }

    /**
     * Removes all triangles from this panel.
     */
    public void clearTriangles()
    {
        triangles.clear();
    }
    
    
    /**
     * Saves the current instance out to file.
     */
    public void saveTriangles()
    {
        JFileChooser fileChooser = new JFileChooser();
        
        // Prompt for a file
        int returnVal = fileChooser.showSaveDialog(null);

        // A file was selected?
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            // Yes
            File file = fileChooser.getSelectedFile();

            // Does the file already exist?
            if (file.exists())
            {
                // Yes: ask if we should really overwrite
                int ret = JOptionPane.showConfirmDialog(fileChooser,
                                "File exists.  Overwrite?", "",
                                JOptionPane.YES_NO_OPTION);
                // If 1, then the answer was 'NO': exit this method
                if (ret == 1)
                {
                    return;
                }
            }

            // Open file
            FileOutputStream fos;
            try
            {
                fos = new FileOutputStream(file);
            }
            catch (FileNotFoundException e2)
            {
                // Tell user that there was an error opening
                JOptionPane.showMessageDialog(fileChooser,
                                "Could not open file for writing",
                                "File Error",
                                JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Write the file
            ObjectOutputStream oos;
            try
            {
                // Open the ObjectOutputStream
                oos = new ObjectOutputStream(fos);
                // Write the shape list
                oos.writeObject(triangles);
                oos.writeObject(recirculationMap);

            }
            catch (IOException e2)
            {
                // Tell the user that there was an error
                JOptionPane.showMessageDialog(fileChooser,
                                "Error writing file", "File Error",
                                JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
                // Under all cases: try to close the file
                try
                {
                    // Close the file
                    fos.close();
                }
                catch (IOException e3)
                {
                    System.out.println("Unable to close "
                                    + "FileOutputStream.");
                }
            }
        }
    }
    
    /**
     * Restores a panel instance from file.
     */
    @SuppressWarnings("unchecked")
    public void loadTriangles()
    {
        JFileChooser fileChooser = new JFileChooser();

        // Prompt for a file
        int returnVal = fileChooser.showOpenDialog(null);

        // A file was selected?
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            // Yes
            File file = fileChooser.getSelectedFile();

            // Open file
            FileInputStream fis;

            try
            {
                fis = new FileInputStream(file);
            }
            catch (FileNotFoundException e2)
            {
                // Tell user that there was an error opening
                JOptionPane.showMessageDialog(fileChooser,
                                "File not found", "File Error",
                                JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Read from the file
            ObjectInputStream ois;

            try
            {
                // Open the ObjectInputStream
                ois = new ObjectInputStream(fis);

                triangles = (ArrayList<SierpinskiTriangle>)ois.readObject();

                recirculationMap =
                        (HashMap<SierpinskiTriangle, Boolean>)ois.readObject();

            }
            catch (IOException e2)
            {
                // Tell the user that there was an error
                JOptionPane.showMessageDialog(fileChooser,
                                "Error reading file", "File Error",
                                JOptionPane.ERROR_MESSAGE);
            }
            catch (ClassNotFoundException e2)
            {
                // Tell the user that there was an error
                JOptionPane.showMessageDialog(fileChooser,
                                "Error reading file", "File Error",
                                JOptionPane.ERROR_MESSAGE);
            }
            finally
            {
                try
                {
                    // Close the file under all conditions
                    fis.close();
                }
                catch (IOException e3)
                {
                    System.out.println("Unable to close "
                                    + "FileInputSteam.");
                }
            }
        }        
    }
    
    /**
     * Runs the animation step and repaints the triangles.
     */
    public void redraw()
    {
        updateTriangles();
        repaint();
    }
    
    /** (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     * 
     * @param g Graphics object used for drawing.
     */
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        for (SierpinskiTriangle triangle: triangles)
        {
            triangle.draw(g);
        }
        
        g.setColor(Color.LIGHT_GRAY);

        g.drawPolygon(new int[]{0 + 5, getWidth() - 5, getWidth() - 5, 0 + 5},
                new int[]{0 + 5, 0 + 5, getHeight() - 5, getHeight() - 5}, 4);
    }
}
