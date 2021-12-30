
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
    This class will act as a main screen for
    user, by which a user can interact and 
    perform searching operations
*/
public class MainWindow
{
    //Data Memebers
    JFrame frame;   
    JTextField surahText;
    JTextField parahText;
    JTextField verseText;
    JTextField stringText;

    JButton btn1;
    JButton btn2;
    JButton btn3;
    JButton btn4;
    
    JLabel appLabel;
    JLabel surahLabel;
    JLabel parahLabel;
    JLabel verseLabel;
    JLabel stringLabel;
    
    JPanel headingPanel;     //for app name
    JPanel container;       //for all the contents of main screen

    //Default Constructor
    public MainWindow()
    {
        //Init Frame and set its layout to null
        frame = new JFrame("Quran Application");
        frame.setLayout(null);
        
        //Init panels and set their layouts to flow layout
        headingPanel = new JPanel(new FlowLayout());
        container = new JPanel(new FlowLayout());
        
        //Init all textfields of main screen
        surahText = new JTextField(20);
        parahText = new JTextField(20);
        verseText = new JTextField(20);
        stringText = new JTextField(20);
        
        //Give some styling to the text fields
        setTextFieldStyle(surahText);
        setTextFieldStyle(parahText);
        setTextFieldStyle(verseText);
        setTextFieldStyle(stringText);

        //Init all buttons of main screen
        btn1 = new JButton("Search Surah");
        btn2 = new JButton("Search Parah");
        btn3 = new JButton("Search Verse");
        btn4 = new JButton("Search String");
        
        //Init all labels of main screen
        appLabel= new JLabel("Quran Application");
        surahLabel = new JLabel("Search Surah");
        parahLabel = new JLabel("Search Parah");
        verseLabel = new JLabel("Search Verse (Surah Number, Verse Number)");
        stringLabel = new JLabel("Search by String");
        
        //Give some styling to the labels of main screen
        appLabel.setFont(appLabel.getFont().deriveFont(Font.BOLD, 35f));
        setLabelStyle(surahLabel);
        setLabelStyle(parahLabel);
        setLabelStyle(verseLabel);
        setLabelStyle(stringLabel);
        
        //Set the location of the panels
        headingPanel.setBounds(0, 60, 400, 60);
        container.setBounds(0, 150, 400, 300);
        
        //Add main Heading of App name to the heading panel
        headingPanel.add(appLabel);
        
        //Add Surah Searching contents to content panel
        container.add(surahLabel);
        container.add(surahText);
        container.add(btn1);
        
        //Add Parah Searching contents to content panel
        container.add(parahLabel);
        container.add(parahText);
        container.add(btn2);
        
        //Add Verse Searching contents to content panel
        container.add(verseLabel);
        container.add(verseText);
        container.add(btn3); 
        
        //Add String Searching contents to content panel
        container.add(stringLabel);
        container.add(stringText);
        container.add(btn4); 
        
        //Add panels to frame
        frame.add(headingPanel);
        frame.add(container);
        
        /*
            Get Dimension (size) of the screen in order 
            to set location of frame to the center of the 
            screen
        */
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        
        //Center the frame
        width = (width-500)/2;
        height = (height-600)/2;
        
        //Set frame settings
        frame.setResizable(false);
        frame.setSize(400, 550);
        frame.setLocation(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void setLabelStyle(JLabel label)
    {
        /*
            This function will set the style
            of the passed label
        */
        label.setFont(label.getFont().deriveFont(Font.BOLD, 14));
        label.setPreferredSize(new Dimension(340, 20));
    }
    
    private void setTextFieldStyle(JTextField tf)
    {
        /*
            This function will set the style
            of the passed text field
        */
        tf.setPreferredSize(new Dimension(310, 25));
    }
            
}
