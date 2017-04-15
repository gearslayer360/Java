package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RainbowGUI extends JPanel implements ActionListener
{
	 JFrame frame;
	 JPanel contentPane;
	 JLabel color, defaults;
	 JComboBox colorTypes;
	 static String[] colorChoices = {"Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Purple"};
	 
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
	 
	 public RainbowGUI()
	    {
		 	frame = new JFrame("RainbowGUI");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        contentPane = new JPanel();
	        contentPane.setLayout(new GridLayout(3, 2, 2 ,3));
	        contentPane.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));     
	        
	        color = new JLabel("Select a color: ");
	        color.setAlignmentX(JLabel.LEFT_ALIGNMENT);
	        contentPane.add(color);
	        
	        colorTypes = new JComboBox(colorChoices);
	        colorTypes.setAlignmentX(JComboBox.LEFT_ALIGNMENT);
	        colorTypes.setSelectedIndex(0);
	        colorTypes.addActionListener(this);
	        contentPane.add(colorTypes);
	        
	        defaults = new JLabel("Color selected: Red");
	        contentPane.add(defaults);
	        
	        frame.setContentPane(contentPane);
	        frame.pack();
	        frame.setVisible(true);
	    }
	 
	 private static void runGUI() 
     {
       JFrame.setDefaultLookAndFeelDecorated(true);
       RainbowGUI rainbow = new RainbowGUI();
      }
	 
	public void actionPerformed(ActionEvent event)
	{
		String  colorChoices = (String)colorTypes.getSelectedItem();
	     String eventName = event.getActionCommand();
	  
	  if (colorChoices == ("Red"))
	  {
		    defaults.setText("Color selected: Red");
		    contentPane.setBackground(Color.RED);
	  }
	  
	  else if (colorChoices == ("Orange"))
	  {
		    defaults.setText("Color selected: Orange");
		    contentPane.setBackground(Color.ORANGE);
	  }
	  
	  else if (colorChoices== ("Yellow"))
	  {
		    defaults.setText("Color selected: Yellow");
		    contentPane.setBackground(Color.YELLOW);
	  }
	  
	  else if (colorChoices == ("Green"))
	  {
		    defaults.setText("Color selected: Green");
		    contentPane.setBackground(Color.GREEN);
	  }
	  
	  else if (colorChoices == ("Blue"))
	  {
		    defaults.setText("Color selected: Blue");
		    contentPane.setBackground(Color.BLUE);
	  }
	  
	  else if (colorChoices == ("Indigo"))
	  {
		    defaults.setText("Color selected: Indigo");
		    contentPane.setBackground(new Color(75,0,130));
	  }
	  
	  else if (colorChoices == ("Purple"))
	  {
		    defaults.setText("Color selected: Purple");
		    contentPane.setBackground(new Color(128,0,128));
	  }
		
	}
}
