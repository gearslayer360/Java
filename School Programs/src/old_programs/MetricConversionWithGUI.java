/* Name: Brian Matthys
 * Date: February 20, 2011
 * Period:05
 */

package old_programs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MetricConversionWithGUI extends JPanel implements ActionListener
{
 JFrame frame;
 JPanel contentPane;
 JTextField input; 
 JButton convert;
 JComboBox convertTypes;
 JLabel convertPrompt, answer,defaults;
 double math1;
 
 public MetricConversionWithGUI()
    {
        frame = new JFrame("MetricConversionWithGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(3, 2, 2 ,3));
        contentPane.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));     
        
         convertPrompt = new JLabel("Select a conversion: ");
         convertPrompt.setAlignmentX(JLabel.LEFT_ALIGNMENT);
         contentPane.add(convertPrompt);
     
     String[] names = {"Inches to Centimeters", "Feet to Centimeters", "Yards to Meters",
       "Miles to Kilometers", "Centimeters to Inches", "Centimeters to Feet",
       "Meters to Yards" , "Kilometers to Miles" };
     
    convertTypes = new JComboBox(names);
    convertTypes.setAlignmentX(JComboBox.LEFT_ALIGNMENT);
    convertTypes.setSelectedIndex(0);
    convertTypes.addActionListener(this);
    contentPane.add(convertTypes);
     
     defaults = new JLabel("1 inch = 2.54 centimeters");
     contentPane.add(defaults);
     
     input = new JTextField(10);
     contentPane.add(input);
          
     convert = new JButton("Convert");
     convert.setActionCommand("Convert");
     convert.addActionListener(this);
     contentPane.add(convert);
     
     answer = new JLabel();
     answer.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
     contentPane.add(answer);
   
     	frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true);
    }

 public void actionPerformed(ActionEvent event) 
    {
     String names = (String)convertTypes.getSelectedItem();
     String eventName = event.getActionCommand();
  
  if (names== "Inches to Centimeters")
  {
    defaults.setText("1 inch = 2.54 centimeters");
    
    if (eventName.equals("Convert"))
    {
    String text = input.getText();
    math1 = (Double.parseDouble(text)*2.54);
    answer.setText(input.getText() + " inches is equal to " + math1 + " centimeters.");
    }
  }
  
 else if (names== "Feet to Centimeters")
  {
    defaults.setText("1 foot = 30.48 centimeters");
    
    if (eventName.equals("Convert"))
    {
    String text = input.getText();
    math1 = (Double.parseDouble(text)*30.48);
    answer.setText(input.getText() + " feet is equal to " + math1 + " centimeters.");
    }
 }
 
 else if (names== "Yards to Meters")
  {
    defaults.setText("1 yard = .9144 meters"); 
    
    if (eventName.equals("Convert"))
    {
    String text = input.getText();
    math1 = (Double.parseDouble(text)*.9144);
    answer.setText(input.getText() + " yards is equal to " + math1 + " meters.");
    }
 }
 
 else if (names== "Miles to Kilometers")
  {
    defaults.setText("1 mile = 1.609344 kilometers"); 
    
    if (eventName.equals("Convert"))
    {
    String text = input.getText();
    math1 = (Double.parseDouble(text)*1.609344);
    answer.setText(input.getText() + " miles is equal to " + math1 + " kilometers.");
    }
 }
 
 else if (names== "Centimeters to Inches")
  {
    defaults.setText("1 centimeter = 0.393700787 inches");
    
    if (eventName.equals("Convert"))
    {
    String text = input.getText();
    math1 = (Double.parseDouble(text)*0.393700787);
    answer.setText(input.getText() + " centimeters is equal to " + math1 + " inches.");
    }
 }
 
 else if (names== "Centimeters to Feet")
  {
    defaults.setText("1 centimeter = 0.032808399 Feet");
    
    if (eventName.equals("Convert"))
    {
    String text = input.getText();
    math1 = (Double.parseDouble(text)*0.032808399);
    answer.setText(input.getText() + " centimeters is equal to " + math1 + " feet.");
    }
 }
 
 else if (names== "Meters to Yards")
  {
    defaults.setText("1 meter = 1.0936133 yards"); 
    
    if (eventName.equals("Convert"))
    {
    String text = input.getText();
    math1 = (Double.parseDouble(text)*1.0936133);
   answer.setText(input.getText() + " meters to equal to " + math1 + " yards.");
    }
 }
 
 else if (names== "Kilometers to Miles")
  {
    defaults.setText("1 kilometer = 0.621371192 miles");
    
    if (eventName.equals("Convert"))
    {
    String text = input.getText();
    math1 = (Double.parseDouble(text)*0.621371192);
    answer.setText(input.getText() + " kilometers is equal to " + math1 + " miles.");
    }
 }
}
  
    private static void runGUI() 
      {
        JFrame.setDefaultLookAndFeelDecorated(true);
        MetricConversionWithGUI spices = new MetricConversionWithGUI();
       }
     
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
         {
            public void run() 
            {
                runGUI();
            }
        }
        );
    }
}  
