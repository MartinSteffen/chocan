package protocol;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
                


public class Start extends JFrame {
  public static void main(String[] args) {
    new Start();
  }
   
  public Start() {
    super("ChocAn - Mitgliederverwaltung");
    WindowUtilities.setNativeLookAndFeel();
    addWindowListener(new ExitListener());
    Container content = getContentPane();
    content.setBackground(Color.white);
    JDesktopPane desktop = new JDesktopPane();
    this.setBackground(new java.awt.Color(204, 204, 255));
    content.add(desktop, BorderLayout.CENTER);
    setBounds(10,10,1000,800);
    //setSize(getMaximumSize());
    protocol.Menu test = new protocol.Menu(desktop);     
    setVisible(true);
    
  }
}



























































