
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sohaib
 */
public class ErrorMsg
{
    JFrame frame;
    JLabel label;
    JButton btn;

    public ErrorMsg()
    {
        frame = new JFrame("Error");
        label = new JLabel("INVALID ENTRY");
        btn = new JButton("Retry");
        
        frame.setLayout(new FlowLayout());
        
        label.setPreferredSize(new Dimension(180, 70));
        label.setFont(label.getFont().deriveFont(20f));
        
        frame.add(label);
        frame.add(btn);
        
        frame.setSize(250, 200);
        frame.setResizable(false);
        frame.setLocation(500, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    } 
}
