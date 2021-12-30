import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sohaib
 */
public class BtnHnd implements ActionListener
{

    MainWindow win;
    GUI g;
    ErrorMsg err;
    QuranNavigation nav;
    
    public void setReferences(GUI g, MainWindow win, ErrorMsg err)
    {
        this.win = win;
        this.g = g;
        this.err = err;
        nav = new QuranNavigation(g);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equalsIgnoreCase("search parah"))
        {
            String str = win.parahText.getText();
            
            if(str.charAt(0) >= '0' && str.charAt(0) <= '9')
            {
                int num = Integer.parseInt(str);
                if(num > 30)
                {
                    displayErrorWindow();
                }
                else
                {
                    setFrameVisibility();
                    nav.getParah(num);
                }
            }
            else 
            {
                int index = nav.getParahIndex(str);
                if(index == -1)
                {
                    displayErrorWindow();
                }
                else
                {
                    setFrameVisibility();
                    nav.getParah(str);
                }
            }
        }
        else if(e.getActionCommand().equalsIgnoreCase("search surah"))
        {
            String str = win.surahText.getText();
            
            if(str.charAt(0) >= '0' && str.charAt(0) <= '9')
            {
                int num = Integer.parseInt(str);
                if(num > 114)
                {
                    displayErrorWindow();
                }
                else
                {
                    setFrameVisibility();
                    nav.getSurah(num);
                }
            }
            else 
            {
                int index = nav.getSurahIndex(str);
                if(index == -1)
                {
                    displayErrorWindow();
                }
                else
                {
                    setFrameVisibility();
                    nav.getSurah(str);
                }
                
            }
            
        }
        else if(e.getActionCommand().equalsIgnoreCase("search verse"))
        {
            
            String surah, verse;            
            StringTokenizer str = new StringTokenizer(win.verseText.getText(), ",");
            
            surah = str.nextToken();
            verse = str.nextToken();
            
            if((surah.charAt(0) > '0' && surah.charAt(0) < '9') && (verse.charAt(0) > '0' && verse.charAt(0) < '9'))
            {
                int surahNum = Integer.parseInt(surah);
                int verseNum = Integer.parseInt(verse);

                if(surahNum > 114 || verseNum > nav.getNumofVerses(surahNum))
                {
                    displayErrorWindow();
                }
                else
                {
                    setFrameVisibility();
                    nav.getVerse(surahNum, verseNum);
                }
            }
            else
                displayErrorWindow(); 
        }
        else if(e.getActionCommand().equalsIgnoreCase("Search string"))
        {
            String str = win.stringText.getText();
            nav.searchString(str);
            setFrameVisibility();
        }
        else if(e.getActionCommand().equalsIgnoreCase("go back"))
        {
            win.frame.setVisible(true);
            g.frame.setVisible(false);
        }
        else if(e.getActionCommand().equalsIgnoreCase("retry"))
        {
            err.frame.setVisible(false);
            win.frame.setVisible(true);
        }
    }
    
    private void setFrameVisibility()
    {
        win.frame.setVisible(false);
        g.frame.setVisible(true);
        err.frame.setVisible(false);
    }
    
    private void displayErrorWindow()
    {
        err.frame.setVisible(true);
        win.frame.setVisible(false);
    }
    
}
