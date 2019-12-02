import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.border.CompoundBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * The application frame.  This class contains
 * the main method, creating an instance of itself
 * and running the application.
 * 
 * @author Nicholas, modified by Cameron
 * @version 2016-11-10
 */
public class SierpinskiApplication
{
    /**
     * The frame that holds the application.
     */
    JFrame applicationFrame;

    /**
     * Time in milliseconds to wait between animation frames.
     */
    private static final int ANIMATION_TICK = 40;
    
    /**
     * The SierpinskiPanel instance responsible for maintaining
     * and computing the state of the triangles as well as drawing them.
     */
    private SierpinskiPanel sPanel;
    
    /**
     * Slider that specifies how many levels of recursion to draw triangles at.
     */
    private JSlider recursionDepthSlider;
    
    /**
     * Slider that specifies the rotational velocity of the triangles.
     */
    private JSlider rotationSlider;
    
    /**
     * Slider that specifies the radius of the triangles.
     */
    private JSlider sizeSlider;
    
    /**
     * Slider that specifies the rate at which triangles fall.
     */
    private JSlider displacementSlider;

    /**
     * Check box specifying whether or not the triangles should
     * be drawn filled in.
     */
    private JCheckBox wireframeCheckBox;
    
    /**
     * Check box specifying whether or not to draw inscribed circles
     * on the triangles.
     */
    private JCheckBox circleCheckBox;
    
    /**
     * Check box specifying whether or not to draw a triangle at the top of the
     * screen once it has fallen off of the bottom of the screen.
     */
    private JCheckBox recirculateCheckBox;
    
    /**
     * Check box specifying whether or not the current property settings should
     * be applied to all existing triangles or just the next to be drawn.
     */
    private JCheckBox globalCheckBox;
    
    /**
     * The button that shows the current selected primary color.
     */
    private JButton primaryColorButton;
    
    /**
     * The button that shows the current selected secondary color.
     */
    private JButton secondaryColorButton;
    
    /**
     * A boolean that tracks which of the two triangle colors
     * the user has last selected.
     */
    private boolean primaryColorSelected;
    
    /**
     * The color chooser to select new colors for triangles.
     */
    private JColorChooser colorChooser;
    
    /**
     * Timer that fires at regular intervals to animate the triangles.
     */
    Timer timer;

    /**
     * The minimum width of the application.
     */
    private int width;
    
    /**
     * The minimum height of the application.
     */
    private int height;
    
    /**
     * Constructor, creates a new instance of the application and runs it.
     * 
     * @param title The application frame title.
     * @param width The minimum width of the application.
     * @param height The minimum height of the application.
     */
    public SierpinskiApplication(String title, int width, int height)
    {
        /**
         * The panel that holds the application UI.
         */
        JPanel contentPanel;
        
        /**
         * A convenience container to hold labeled UI components.
         */
        ControlPanel controlPanel;

        /**
         * Button that randomizes the primary triangle color.
         */
        JButton primaryRandomButton;
        
        /**
         * Button that randomizes the secondary triangle color.
         */
        JButton secondaryRandomButton;

        applicationFrame = new JFrame(title);
        this.width = width;
        this.height = height;

        /* Setup sliders */
        recursionDepthSlider = new JSlider(JSlider.HORIZONTAL, 1, 7, 4);
        rotationSlider = new JSlider(JSlider.HORIZONTAL, 0, 15, 0);
        sizeSlider = new JSlider(
                JSlider.HORIZONTAL, height / 4, height, height / 4);
        displacementSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 0);

        /* Setup check boxes */
        wireframeCheckBox = new JCheckBox();
        circleCheckBox = new JCheckBox();
        recirculateCheckBox = new JCheckBox();
        globalCheckBox = new JCheckBox();
        
        /* Setup chosen color area */
        primaryColorButton = new JButton();
        primaryColorButton.setBackground(Color.CYAN);
        primaryColorButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
                BorderFactory.createLineBorder(Color.WHITE, 2)));
        primaryColorSelected = true;

        secondaryColorButton = new JButton();
        secondaryColorButton.setBackground(Color.ORANGE);

        primaryRandomButton = new JButton("Random");
        secondaryRandomButton = new JButton("Random");

        /* Create and customize the color chooser */
        colorChooser = new JColorChooser();
        colorChooser.setColor(primaryColorButton.getBackground());
        colorChooser.setPreviewPanel(new JPanel());
        colorChooser.setBorder(
                BorderFactory.createTitledBorder("Color chooser"));

        /* Remove the color chooser panels that aren't the HSV panel. */
        for (AbstractColorChooserPanel panel : colorChooser.getChooserPanels())
        {
            if (!panel.getDisplayName().equals("HSV"))
            {
                colorChooser.removeChooserPanel(panel);
            }
        }
        
        controlPanel = new ControlPanel(4);
        controlPanel.setBorder(
                BorderFactory.createTitledBorder("Display Parameters"));

        sPanel = new SierpinskiPanel();

        JMenuBar menuBar = new JMenuBar();

        // Create the menu bar itself
        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        // Create the menu items
        JMenuItem menuNew = new JMenuItem("New");
        JMenuItem menuOpen = new JMenuItem("Open");
        JMenuItem menuSave = new JMenuItem("Save");
        JMenuItem menuExit = new JMenuItem("Exit");

        // Add the menu items to the menu bar
        menu.add(menuNew);
        menu.add(menuOpen);
        menu.add(menuSave);
        menu.add(menuExit);

        applicationFrame.setJMenuBar(menuBar);

        controlPanel.addControl("Recursion depth", recursionDepthSlider,
                "Changes the depth at which to recursively draw triangles.");
        
        controlPanel.addControl("Rotational velocity", rotationSlider,
                "Changes the rate at which the triangles rotate.");
        
        controlPanel.addControl("Radius", sizeSlider,
                "Changes the radius of the triangles.");
        
        controlPanel.addControl("Displacement rate", displacementSlider,
                "Changes the rate at which the triangles fall.");
        
        controlPanel.addControl("Wireframe", wireframeCheckBox,
                "Specifies whether or not to draw only the outlines "
                + "of the triangles.");
        
        controlPanel.addControl("Draw circles", circleCheckBox,
                "Specifies whether or not to draw inscribed circles on"
                + "the triangles.");
        
        controlPanel.addControl("Recirculate", recirculateCheckBox,
                "Specifies whether or not the triangles should circulate "
                + "back to the top of the screen after falling "
                + "off the bottom of the screen.");
        
        controlPanel.addControl("Global", globalCheckBox,
                "Specifies whether or not the current settings "
                + "should be applied to all triangles.");

        contentPanel = new JPanel(new GridBagLayout());

        JPanel chosenColorsPanel = new JPanel(new GridBagLayout());
        chosenColorsPanel.setBorder(
                BorderFactory.createTitledBorder("Current colors"));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipadx = 50;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        constraints.gridheight = 2;
        chosenColorsPanel.add(new JLabel("Primary"), constraints);

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 5, 10, 10);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.ipadx = 50;
        constraints.gridx = 5;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        constraints.gridheight = 2;
        chosenColorsPanel.add(new JLabel("Secondary"), constraints);

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.5;
        constraints.weighty = 1;
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 4;
        constraints.gridheight = 4;
        chosenColorsPanel.add(primaryColorButton, constraints);

        constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 5, 10, 10);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.5;
        constraints.weighty = 1;
        constraints.gridx = 6;
        constraints.gridy = 3;
        constraints.gridwidth = 4;
        constraints.gridheight = 4;
        chosenColorsPanel.add(secondaryColorButton, constraints);

        constraints = new GridBagConstraints();        
        constraints.insets = new Insets(10, 10, 10, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        constraints.gridx = 1;
        constraints.gridy = 7;
        chosenColorsPanel.add(primaryRandomButton, constraints);

        constraints = new GridBagConstraints();        
        constraints.insets = new Insets(10, 5, 10, 10);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        constraints.gridx = 6;
        constraints.gridy = 7;
        chosenColorsPanel.add(secondaryRandomButton, constraints);

        constraints = new GridBagConstraints();        
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.6;
        constraints.weighty = 0.10;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        contentPanel.add(controlPanel, constraints);

        constraints = new GridBagConstraints();        
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 0.09;
        constraints.weighty = 0.10;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        contentPanel.add(chosenColorsPanel, constraints);   

        constraints = new GridBagConstraints();        
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 0.10;
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        contentPanel.add(colorChooser, constraints);        

        applicationFrame.setLayout(new BorderLayout());
        applicationFrame.add(sPanel, BorderLayout.CENTER);
        applicationFrame.add(contentPanel, BorderLayout.SOUTH);

        /* Setup listeners for the UI. */
        sPanel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent event)
            {
                /*
                 * We add a new triangle to our SierpinskiPanel,
                 * grabbing the current values of our property
                 * controls to pass into the SierpinskiTriangle constructor.
                 */
                sPanel.addTriangle(
                        new SierpinskiTriangle(
                                recursionDepthSlider.getValue(),
                                event.getPoint(),
                                sizeSlider.getValue(),
                                rotationSlider.getValue() * (Math.PI / 180),
                                displacementSlider.getValue(),
                                primaryColorButton.getBackground(),
                                secondaryColorButton.getBackground(),
                                !wireframeCheckBox.isSelected(),
                                circleCheckBox.isSelected()),
                        recirculateCheckBox.isSelected());
            }            
        });

        // Recursion depth slider has changed
        recursionDepthSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent event)
            {
                if (globalCheckBox.isSelected())
                {
                    sPanel.setDepth(recursionDepthSlider.getValue());
                }
            }
        });

        // Rotation rate slider
        rotationSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent event)
            {
                if (globalCheckBox.isSelected())
                {
                    /*
                     * Our slider's values are in degrees.  To convert
                     * to radians, we need to multiply by pi / 180.
                     */
                    sPanel.setRotationalVelocity(
                            rotationSlider.getValue() * (Math.PI / 180));
                }
            }
        });        

        // Size slider
        sizeSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent event)
            {
                if (globalCheckBox.isSelected())
                {
                    sPanel.setRadius(sizeSlider.getValue());
                }
            }
        });

        // Falling rate slider
        displacementSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent event)
            {
                if (globalCheckBox.isSelected())
                {                
                    sPanel.setDisplacementRate(displacementSlider.getValue());
                }
            }
        });

        // Wire frame check box
        wireframeCheckBox.addChangeListener(new ChangeListener()
        {    
            @Override
            public void stateChanged(ChangeEvent e)
            {
                if (globalCheckBox.isSelected())
                {
                    sPanel.setFilled(!wireframeCheckBox.isSelected());
                }        
            }
        });

        // Include circles check box
        circleCheckBox.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                if (globalCheckBox.isSelected())
                {
                    sPanel.setDrawCircles(circleCheckBox.isSelected());
                }
            }        
        });

        // Recirculate triangles (after they have fallen out of visiblility,
        //   reappear at the top of the window
        recirculateCheckBox.addChangeListener(new ChangeListener()
        {    
            @Override
            public void stateChanged(ChangeEvent e)
            {
                if (globalCheckBox.isSelected())
                {
                    sPanel.setRecirculateTriangles(
                            recirculateCheckBox.isSelected());    
                }
            }
        });
        
        // Color choosing
        colorChooser.getSelectionModel().addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent event)
            {
                Color chosenColor = colorChooser.getColor();
                
                /*
                 * Here we are disabling the user's ability to change the
                 * transparency of the chosen color, as drawing with
                 * transparency introduces a large performance hit.
                 */
                chosenColor = new Color(chosenColor.getRed(),
                        chosenColor.getGreen(), chosenColor.getBlue());
                
                colorChooser.setColor(chosenColor);

                if (primaryColorSelected)
                {
                    primaryColorButton.setBackground(chosenColor);

                    if (globalCheckBox.isSelected())
                    {
                        sPanel.setPrimaryColor(chosenColor);
                    }
                }
                else
                {
                    secondaryColorButton.setBackground(chosenColor);

                    if (globalCheckBox.isSelected())
                    {
                        sPanel.setSecondaryColor(chosenColor);
                    }
                }
            }

        });

        // new drawing
        menuNew.addActionListener(new ActionListener()
        {            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                sPanel.clearTriangles();
            }
        });
        
        // Load triangles from a file
        menuOpen.addActionListener(new ActionListener()
        {            
            @Override
            public void actionPerformed(ActionEvent event)
            {
                sPanel.loadTriangles();
            }
        });
        
        
        // Save triangles to a file
        menuSave.addActionListener(new ActionListener()
        {        
            @Override
            public void actionPerformed(ActionEvent event)
            {
                sPanel.saveTriangles();
            }
        });  

        // Exit from the program
        menuExit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        // Color has changed
        ActionListener colorListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                CompoundBorder border = BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.DARK_GRAY, 2),
                        BorderFactory.createLineBorder(Color.WHITE, 2));

                primaryColorSelected = (JButton)event.getSource()
                        == primaryColorButton;

                if (primaryColorSelected)
                {
                    primaryColorButton.setBorder(border);
                    secondaryColorButton.setBorder(null);
                    colorChooser.setColor(primaryColorButton.getBackground());
                }
                else
                {
                    primaryColorButton.setBorder(null);
                    secondaryColorButton.setBorder(border);
                    colorChooser.setColor(
                            secondaryColorButton.getBackground());
                }
            }
        };

        // Note: we are using the same listener for both events
        primaryColorButton.addActionListener(colorListener);
        secondaryColorButton.addActionListener(colorListener);

        // Random button: select a new primary color
        primaryRandomButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ThreadLocalRandom random = ThreadLocalRandom.current();

                primaryColorButton.setBackground(
                        new Color(random.nextInt(0, 256),
                                random.nextInt(0, 256),
                                random.nextInt(0, 256)));

                if (primaryColorSelected)
                {
                    colorChooser.setColor(primaryColorButton.getBackground());
                }

                if (globalCheckBox.isSelected())
                {
                    sPanel.setPrimaryColor(primaryColorButton.getBackground());
                }
            }    
        });

        // Random button: select a new secondary button
        secondaryRandomButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                ThreadLocalRandom random = ThreadLocalRandom.current();

                secondaryColorButton.setBackground(
                        new Color(random.nextInt(0, 256),
                                random.nextInt(0, 256),
                                random.nextInt(0, 256)));

                if (!primaryColorSelected)
                {
                    colorChooser.setColor(
                            secondaryColorButton.getBackground());
                }

                if (globalCheckBox.isSelected())
                {
                    sPanel.setSecondaryColor(
                            secondaryColorButton.getBackground());
                }
            }    
        });

        /* 
         * Initialize the timer variable to a newly created timer
         * that fires at a regular interval, calling a method in
         * SierpinskiPanel causing the next step of animation to
         * be computed, and the screen to be re-drawn.
         */
        timer = new Timer(ANIMATION_TICK, new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e) {
                sPanel.redraw();
            }
        });       
    }

    /**
     * Starts the application.
     */
    public void start()
    {
        timer.start();

        applicationFrame.setMinimumSize(new Dimension(width, height));
        applicationFrame.pack();
        applicationFrame.setLocationRelativeTo(null); // Center of the screen
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationFrame.setVisible(true);
    }

    /**
     * Entry-point for program execution.
     * 
     * @param args Command-line objects.
     */
    public static void main(String[] args)
    {
        new SierpinskiApplication(
                "Sierpinski Triangle Drawer", 1280, 768).start();
    }
}
