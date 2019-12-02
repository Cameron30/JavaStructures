import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 * Represents a Sierpinski triangle,
 * able to draw itself using a provided Graphics object.
 * 
 * @author Nicholas, modified by Cameron
 * @version 2016-11-11
 */
public class SierpinskiTriangle implements Serializable
{
    /**
     * Class serialization version to validate compatible
     * serialization/de-serialization.
     */
    private static final long serialVersionUID = 42L;

    /**
     * The recursion depth at which triangles are drawn.
     */
    private int drawingDepth;

    /**
     * The rate at which this triangle descends on-screen.
     */
    private int displacementRate;

    /**
     * The radius of this triangle.
     */
    private int baseRadius;

    /**
     * The initial, absolute offset of the angle this triangle is drawn at.
     */
    private double angleOffset;

    /**
     * The rate at which this triangle rotates.
     */
    private double rotationalVelocity;

    /**
     * Whether or not inscribed circles should be drawn on this triangle.
     */
    private boolean drawCircle;

    /**
     * Whether or not this triangle should be drawn filled in.
     */
    private boolean filled;

    /**
     * The center point of the triangle.
     */
    private Point center;

    /**
     * The change in the primary color required at each level
     * of recursion to generate a gradient-like effect in the image.
     */
    private Color primaryColorStep;

    /**
     * The change in the secondary color required at each level
     * of recursion to generate a gradient-like effect in the image.
     */
    private Color secondaryColorStep;

    /**
     * The background color this triangle is drawn atop of.
     */
    private static final Color BACKGROUND_COLOR = Color.BLACK;

    /**
     * The primary color of the triangle.
     * This color is used to draw the triangles.
     */
    private Color primaryColor;

    /**
     * The secondary color of the triangle.
     * This color is used to draw inscribed circles.
     */
    private Color secondaryColor;

    /**
     * Constructs a SierpinskiTriangle with the
     * specified properties.
     * 
     * @param depth {@link #drawingDepth}
     * @param centerPoint {@link #center}
     * @param radius {@link #baseRadius}
     * @param primaryColor {@link #primaryColor}
     * @param secondaryColor {@link #secondaryColor}
     * @param filled {@link #filled}
     * @param drawCircle {@link #drawCircle}
     */
    public SierpinskiTriangle(int depth, Point centerPoint, int radius,
            Color primaryColor, Color secondaryColor,
            boolean filled, boolean drawCircle)
    {
        this.center = centerPoint;
        this.drawingDepth = depth;
        this.filled = filled;
        this.baseRadius = radius;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.drawCircle = drawCircle;
        setDepth(depth);
    }


    /**
     * Constructs a SierpinskiTriangle with the
     * specified properties.
     * 
     * @param depth {@link #drawingDepth}
     * @param centerPoint {@link #center}
     * @param radius {@link #baseRadius}
     * @param rotationalVelocity {@link #rotationalVelocity}
     * @param displacementRate {@link #displacementRate}
     * @param primaryColor {@link #primaryColor}
     * @param secondaryColor {@link #secondaryColor}
     * @param filled {@link #filled}
     * @param drawCircle {@link #drawCircle}
     */
    public SierpinskiTriangle(int depth, Point centerPoint, int radius,
            double rotationalVelocity,
            int displacementRate, Color primaryColor,
            Color secondaryColor, boolean filled, boolean drawCircle)
    {
        this(depth, centerPoint, radius, primaryColor,
                secondaryColor, filled, drawCircle);

        this.rotationalVelocity = rotationalVelocity;
        this.displacementRate = displacementRate;
    }

    /**
     * Generates a vertex the given distance from the center point,
     * and with the given angle offset.
     * 
     * @param centerPoint {@link #center}
     * @param radius {@link #baseRadius}
     * @param angle The angle this vertex is offset from the vertex
     * at the top of the triangle, given that the triangle is resting
     * evenly on one side.
     * @return The generated vertex.
     */
    public Point computeVertex(Point centerPoint, double radius, double angle)
    {
        double x = centerPoint.x;
        double y = centerPoint.y - radius;

        AffineTransform transform = new AffineTransform();

        Point2D result = new Point2D.Double();

        transform.rotate(angle + angleOffset, centerPoint.x, centerPoint.y);
        transform.transform(new Point((int)x, (int)y), result);

        return new Point((int)result.getX(), (int)result.getY());

        //        // This code doesn't generate the expected points for some re
        //        //If somebody could figure this out that would be great.
        //        x = (x - centerPoint.x) * Math.cos(angle + angleOffset)
        //            - (y - centerPoint.y) * Math.sin(angle + angleOffset)
        //            + centerPoint.x;
        //        
        //        y = (x - centerPoint.x) * Math.sin(angle + angleOffset)
        //            + (y - centerPoint.y) * Math.cos(angle + angleOffset)
        //            + centerPoint.y;
        //        
        //        return new Point((int)x, (int)y);
    }

    /**
     * Helper method for the recursive drawing function, produces
     * a color based on the input parameters.
     * 
     * @param isPrimary If true, generates the appropriate
     * shade of the primary color, otherwise, this generates the
     * appropriate shade of the secondary color.
     * @param depth The current recursion depth, used to
     * produce the appropriate color.
     * @return The generated color.
     */
    public Color generateColor(boolean isPrimary, int depth)
    {
        if (isPrimary)
        {
            return new Color(primaryColorStep.getRed() * depth,
                    primaryColorStep.getGreen() * depth,
                    primaryColorStep.getBlue() * depth);
        }

        return new Color(
                secondaryColorStep.getRed() * (this.drawingDepth + 1 - depth),
                secondaryColorStep.getGreen() * (this.drawingDepth + 1 - depth),
                secondaryColorStep.getBlue() * (this.drawingDepth + 1 - depth));
    }

    /**
     * @return the centerPoint
     */
    public Point getCenterPoint()
    {
        return center;
    }

    /**
     * @return the depth
     */
    public int getDepth()
    {
        return drawingDepth;
    }

    /**
     * @return the displacementRate
     */
    public int getDisplacementRate()
    {
        return displacementRate;
    }

    /**
     * @return the filled
     */
    public boolean isFilled()
    {
        return filled;
    }

    /**
     * @return the radius
     */
    public int getRadius()
    {
        return baseRadius;
    }

    /**
     * @return the rotationalVelocity
     */
    public double getRotationalVelocity()
    {
        return rotationalVelocity;
    }

    /**
     * @return the angleOffset
     */
    public double getRotationOffset()
    {
        return angleOffset;
    }

    /**
     * @param point the point to set
     */
    public void setCenterPoint(Point point)
    {
        center = point;
    }

    /**
     * Computes the change in color required to move evenly
     * from black (0, 0, 0) to the given colors in {@link #drawingDepth} steps.
     */
    public void setColorSteps()
    {
        try
        {
            primaryColorStep = new Color(
                    primaryColor.getRed() / drawingDepth,
                    primaryColor.getGreen() / drawingDepth,
                    primaryColor.getBlue() / drawingDepth);

            secondaryColorStep = new Color(
                    secondaryColor.getRed() / drawingDepth,
                    secondaryColor.getGreen() / drawingDepth,
                    secondaryColor.getBlue() / drawingDepth);
        }
        catch (ArithmeticException e)
        {
            primaryColorStep = primaryColor;
            secondaryColorStep = secondaryColor;
        }
    }

    /**
     * Sets the recursion depth and calls {@link #setColorSteps()}.
     * 
     * @param depth The recursion depth to draw triangles to.
     */
    public void setDepth(int depth)
    {
        this.drawingDepth = depth;

        setColorSteps();
    }

    
    /**
     * @param rate the rate to set
     */
    public void setDisplacementRate(int rate)
    {
        displacementRate = rate;
    }

    /**
     * @param drawCircle Whether or not inscribed circles should be drawn.
     */
    public void setDrawCircle(boolean drawCircle)
    {
        this.drawCircle = drawCircle;
    }

    /**
     * @param filled Whether or not the triangles should be drawn as filled.
     */
    public void setFilled(boolean filled)
    {
        this.filled = filled;
    }

    /**
     * @param color the color to set
     */
    public void setPrimaryColor(Color color)
    {
        primaryColor = color;
        setColorSteps();
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(int radius)
    {
        this.baseRadius = radius;
    }

    /**
     * @param offset the offset to set
     */
    public void setRotationOffset(double offset)
    {
        angleOffset = offset % (2 * Math.PI);
    }

    /**
     * @param velocity the velocity to set
     */
    public void setRotationalVelocity(double velocity)
    {
        rotationalVelocity = velocity;
    }

    /**
     * @param color the color to set
     */
    public void setSecondaryColor(Color color)
    {
        secondaryColor = color;
        setColorSteps();
    }

    /**
     * Draws a triangle, given the requisite information.
     * 
     * @param g the Graphics object to use for drawing.
     * @param centerPoint {@link #center}
     * @param radius {@link #baseRadius}
     * @param rotationOffset The angle offset at which to draw this triangle.
     * @param color The color with which to draw this triangle.
     * @param drawFilled {@link #filled}
     */
    private void drawTriangle(Graphics g, Point centerPoint, int radius,
            double rotationOffset, Color color, boolean drawFilled)
    {
        int[] x = new int[3];
        int[] y = new int[3];
        Point[] points = new Point[3];

        /* Point at the top of the triangle */
        points[0] = computeVertex(centerPoint, radius, rotationOffset);

        /* Right base-point. */
        points[1] = computeVertex(
                centerPoint, radius, rotationOffset + Math.PI * (2.0 / 3));

        /* Left base-point */
        points[2] = computeVertex(
                centerPoint, radius, rotationOffset - Math.PI * (2.0 / 3));

        for (int i = 0; i < points.length; i++)
        {
            x[i] = points[i].x;
            y[i] = points[i].y;            
        }

        g.setColor(color);

        if (drawFilled)
        {
            g.fillPolygon(x, y, 3);
        }
        else
        {
            g.drawPolygon(x, y, 3);
        }        
    }

    /**
     * Helper function for recursive drawing.  This method does the work
     * of recursively computing triangles and drawing them.
     * 
     * @param g The Graphics object to use for drawing.
     * @param depth {@link #drawingDepth}
     * @param centerPoint {@link #center}
     * @param radius {@link #baseRadius}
     * @param rotationOffset The angle offset at which to draw this triangle.
     */
    private void drawHelper(Graphics g, int depth, Point centerPoint,
            int radius, double rotationOffset)
    {
        /*
         * Implement this method per the details in the specification document.
         * This method is responsible for computing the positions of the three
         * smaller surrounding triangles and calling itself to draw those, and
         * then drawing the current triangle.
         * If the drawCircle boolean is set to true, you will also need to
         * draw inscribed circles on each triangle.
         */
        rotationOffset = Math.PI;

        drawTriangle(g, centerPoint, radius, rotationOffset, generateColor(
                true, depth), filled);


        g.setColor(generateColor(false, depth));
        if (drawCircle && filled)
        {
            g.fillOval(centerPoint.x - radius / 2, centerPoint.y - radius / 2,
                    radius, radius);
        } 
        else if (drawCircle)
        {
            g.drawOval(centerPoint.x - radius / 2, centerPoint.y - radius / 2, 
                    radius, radius);
        }






        depth = depth - 1;
        if (depth == 0) 
        {
            return;
        }


        drawHelper(g, depth, computeVertex(centerPoint, radius, 0), 
                radius / 2, rotationOffset);
        drawHelper(g, depth, computeVertex(centerPoint, radius, 4 * 
                Math.PI / 3), radius / 2, rotationOffset);
        drawHelper(g, depth, computeVertex(centerPoint, radius, 2 * 
                Math.PI / 3), radius / 2, rotationOffset);
    }

    /**
     * Draws this Sierpinski triangle.
     * A triangle with color {@link #BACKGROUND_COLOR} should first be drawn
     * before recursively drawing triangles on top of it.  Be mindful of both
     * the orientation of this initial triangle, and the orientation of
     *  the triangles drawn on top of it.
     * 
     * @param g The Graphics object to use for drawing.
     */
    public void draw(Graphics g)
    {
        /*
         * Implement this method.  First, by drawing the base triangle
         * using the provided drawTriangle() method, and then by calling the
         * recursive drawHelper() method to draw the smaller triangles on top.
         */
        drawTriangle(g, center, baseRadius, 0, BACKGROUND_COLOR, 
                filled);
        drawHelper(g, drawingDepth, center, baseRadius / 2, angleOffset);
    }
}
