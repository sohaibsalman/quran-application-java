
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sohaib
 */
public class QuranNavigation
{
    QuranArabicText text;
    QDH pointers;
    GUI refg;

    public QuranNavigation(GUI g)
    {
        text = new QuranArabicText();
        pointers = new QDH();
        refg = g;
    }
    
    public void getSurah(int n) 
    {
        int start = pointers.SSP[n - 1] - 1;
        int end;
        if(n < 114)
            end = pointers.SSP[n] - 1;
        else 
            end = text.QuranArabicText.length;
        display(start, end);
    }
    
    public void getSurah(String str)
    {        
        int index = getSurahIndex(str);        
        int start = pointers.SSP[index] - 1;
        int end;
        if(index < 113)
            end = pointers.SSP[index + 1] - 1;
        else
            end = text.QuranArabicText.length;
        display(start, end);
    }
    
    public void getParah(int n)
    {
        int start = pointers.PSP[n - 1] - 1;
        int end;
        if(n < 30)
            end = pointers.PSP[n] - 1;
        else 
            end = text.QuranArabicText.length;
        display(start, end);
    }
    
    public void getParah(String str)
    {
        int index = getParahIndex(str);
        int start = pointers.PSP[index] - 1;
        int end;
        if(index < 30)
            end = pointers.PSP[index + 1] - 1;
        else 
            end = text.QuranArabicText.length;
        display(start, end);
    }
    
    public void getVerse(int noOfSurah, int noOfVerse)
    {
        int start = pointers.SSP[--noOfSurah] + noOfVerse - 2; 
        int end = start + 1; 
        display(start, end);
    }
    
    public void display(int start, int end)
    {
        String str = "";
        for (int i = start; i < end; i++)
        {
            str = str + text.QuranArabicText[i] + "\n";
        }
        System.out.println(str);
        refg.textArea.setText(str);
    }
    
    public int getSurahIndex(String str)
    {
        int index = -1;
        for (int i = 0; i < pointers.englishSurahNames.length; i++)
        {
            if(str == null ? pointers.englishSurahNames[i] == null : str.equalsIgnoreCase(pointers.englishSurahNames[i].trim()))
            {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public int getParahIndex(String str)
    {
        int index = -1;
        for (int i = 0; i < pointers.englishParahName.length; i++)
        {
            if(str == null ? pointers.englishParahName[i] == null : str.equalsIgnoreCase(pointers.englishParahName[i]))
            {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public int getNumofVerses(int n)
    {
       int start = pointers.SSP[n - 1] - 1;
        int end;
        if(n < 114)
            end = pointers.SSP[n] - 1;
        else 
            end = text.QuranArabicText.length;
        int num = 0;
        
        for (int i = start; i < end; i++)
        {
            num++;
        }
        return num;
    }

    public void searchString(String str)
    {
        Vector<String> array = new Vector<>();
        for (int i = 0; i < text.QuranArabicText.length; i++)
        {
            if(text.QuranArabicText[i].contains(str))
                array.add(text.QuranArabicText[i]);
        }
        display(array);
    }
    
    public void display(Vector<String> array)
    {
        String str = "";
        for(int i = 0; i < array.size(); i++)
        {
            str = str + array.get(i) + "\n";
        }
        System.out.println(str);
        refg.textArea.setText(str);
    }
    
}