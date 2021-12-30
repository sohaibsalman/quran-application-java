
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sohaib
 */

/*
    Content of Quran after searching 
    from main window will be displayed 
    by using this class
*/
public class GUI
{
    //Data Memebers
    JFrame frame;
    JTextArea textArea;
    JScrollPane scroll;
    JButton btn;    

    //Default Constructor
    public GUI()
    {
       initGUI();
    }
    
    //Function that will initialize the GUI
    private void initGUI()
    {
       //Init the frame
       frame = new JFrame("Quran Application");
       frame.setLayout(null);
       
       //Init text area
       textArea = new JTextArea();
       
       //Set setting of text Area
       textArea.setEditable(false);
       textArea.setFont(textArea.getFont().deriveFont(25f));
       textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
       textArea.setLineWrap(true);
       
       //Init Scroll bar and add text area in this scroll bar
       scroll = new JScrollPane(textArea);
       
       /*
            Get Dimensions (size) of the screen
            so that this GUI can take full height
            and width of screen
       */
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       int width = (int)screenSize.getWidth();
       int height = (int)screenSize.getHeight();
       
       //Set Size of Scroll Bar
       scroll.setSize(width, height - 190);
       scroll.setLocation(0, 0);
       
       //Init button to go back to main screen
       btn =  new JButton("Go Back");
       btn.setBounds((width-300)/2, 620 , 300, 30);
       
       //Set settings of frame
       frame.setExtendedState( frame.getExtendedState()|JFrame.MAXIMIZED_BOTH );
       frame.setMinimumSize(new Dimension(width/2, height/2));
       
       //Add Scroll bar to frame
       frame.add(scroll);
       //Add button to frame
       frame.add(btn);
       
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
       
    }
    
    
    
}
