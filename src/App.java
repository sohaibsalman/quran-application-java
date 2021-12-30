/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sohaib
 */
public class App
{
    GUI g;
    MainWindow win;
    ErrorMsg err;
    BtnHnd hnd;

    public App()
    {
        g = new GUI();
        win = new MainWindow();
        hnd = new BtnHnd();
        err = new ErrorMsg();
        setBinds();
    }
    
    public void setBinds()
    {
        this.win.btn1.addActionListener(hnd);
        this.win.btn2.addActionListener(hnd);
        this.win.btn3.addActionListener(hnd);
        this.win.btn4.addActionListener(hnd);
        this.g.btn.addActionListener(hnd);
        this.err.btn.addActionListener(hnd);
        this.hnd.setReferences(g, win, err);
    }
    
    
}
