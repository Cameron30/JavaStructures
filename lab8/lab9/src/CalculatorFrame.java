import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * 
 * @author CS2334. Modified by: Cameron Ray
 * @version 2016-10-14
 *          <P>
 *          Lab 9
 *          <P>
 *          This class creates a GUI for simple number conversion calculator
 *          application
 * 
 */
public class CalculatorFrame extends JFrame
{

    /** Use default UID */
    private static final long serialVersionUID = 1L;

    /** panel for the number sentence */
    protected JPanel panel1;
    /** panel for the error message */
    protected JPanel panel2;
    /** panel for the calculate translateButton */
    protected JPanel panel3;
    /** panel for the function radio buttons */
    protected JPanel panel4;

    /*
     * Create objects for translateButton, Label for number system, error
     * message Text field for input Radio buttons for Binary, Octal, Decimal,
     * Hexadecimal
     */
    /** Group of operation buttons */
    protected ButtonGroup operationButtonGroup;
    /** Binary operation radio button */
    protected JRadioButton binaryButton;
    /** Octal operation radio button */
    protected JRadioButton octalButton;
    /** Decimal operation radio button */
    protected JRadioButton decimalButton;
    /** Hexadecimal operation radio button */
    protected JRadioButton hexadecimalButton;

    /** Translate button */
    protected JButton translateButton;
    /** Text that describes which number system is being used */
    protected JLabel numberSystemText;
    /** Text that contains the translation result */
    protected JTextField resultText;
    /** Text field for the user input */
    protected JTextField inputText;
    /** Text for the error message */
    protected JLabel errorMessageText;

    /**
     * Constructor : build the GUI and define its behavior
     * 
     * @param title
     *            The title of the window.
     */
    public CalculatorFrame(String title)
    {
        // Initialize the frame
        super(title);

        // Initialize objects within the frame
        operationButtonGroup = new ButtonGroup();
        binaryButton = new JRadioButton("Binary");
        octalButton = new JRadioButton("Octal");
        decimalButton = new JRadioButton("Decimal");      
        hexadecimalButton = new JRadioButton("Hexadecimal");

        translateButton = new JButton("Translate");
        numberSystemText = new JLabel();
        resultText = new JTextField(8);
        inputText = new JTextField(8);
        errorMessageText = new JLabel();

        // Create the sub-panels
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        // Create the objects in the sub-panels
        

        // Set names of frame Object for testing purposes
        // NOTE: DO NOT CHANGE THESE
        errorMessageText.setName("errorMessageText");
        resultText.setName("resultText");
        inputText.setName("input");
        translateButton.setName("translateButton");
        binaryButton.setName("opBinary");
        octalButton.setName("opOctal");
        decimalButton.setName("opDecimal");
        hexadecimalButton.setName("opHexadecimal");

        // Change resultText to be non-editable
        resultText.setEditable(false);

        // sets the layout grid for the GUI of dimension 4*1
        setLayout(new GridLayout(4, 1));

        // Add the components to the panels
        panel1.add(inputText);
        panel1.add(numberSystemText);
        panel1.add(resultText);
        
        panel2.add(errorMessageText);
        
        panel3.add(translateButton);
        
        panel4.add(binaryButton);
        panel4.add(octalButton);
        panel4.add(decimalButton);
        panel4.add(hexadecimalButton);

        // Add the buttons to the button group
        operationButtonGroup.add(binaryButton);
        operationButtonGroup.add(octalButton);
        operationButtonGroup.add(decimalButton);
        operationButtonGroup.add(hexadecimalButton);

        // Add the panels to the frame
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);

        // Initialize the button in the button group
        binaryButton.setSelected(true);
        numberSystemText.setText("to Binary");

        /*
         * All ActionListeners: change the numberSystemText text to the name of
         * the respective radio translateButton and clear the resultText text
         * field
         */
        binaryButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                numberSystemText.setText("to Binary");
                resultText.setText("");
            }
        });    
        
        octalButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                numberSystemText.setText("to Octal");
                resultText.setText("");
            }
        });    
        
        decimalButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                numberSystemText.setText("to Decimal");
                resultText.setText("");
            }
        });    
        
        hexadecimalButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                numberSystemText.setText("to Hexadecimal");
                resultText.setText("");
            }
        });   
        
        /*
         * When the translate translateButton is pressed, perform the
         * appropriate number translation using the Integer class.
         */
        translateButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                errorMessageText.setText("");
                try
                {
                    String userInput = inputText.getText();
                    int convert = Integer.parseInt(userInput);
                    if (binaryButton.isSelected())
                    {
                        resultText.setText(Integer.toBinaryString(convert));
                        
                    } 
                    else if (octalButton.isSelected())
                    {
                        
                        resultText.setText(Integer.toOctalString(convert));
                    } 
                    else if (hexadecimalButton.isSelected())
                    {
                        resultText.setText(Integer.toHexString(convert));
                    } 
                    else
                    {
                        resultText.setText(Integer.toString(convert));
                    }

                }
                /*
                 * Catch the Number Format Excepts when the user enters
                 * something other than a number
                 */
                catch (NumberFormatException error)
                {
                    resultText.setText("ERROR");
                    errorMessageText.setText("Please enter a number.");
                }
            }
        });

        // Finish off configuring the frame
        setSize(400, 200);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Used to create the Calculator Frame
     * 
     * @param args
     *            command-line arguments - not used
     */
    public static void main(String[] args)
    {
        CalculatorFrame frame = 
                new CalculatorFrame("Decimal Conversion Window");
        
        // Force Web-Cat to not be unhappy with not using 
        // the "frame" variable
        frame.getTitle();
    }

}
