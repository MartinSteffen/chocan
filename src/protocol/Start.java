package protocol;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
                


public class Start extends JFrame {
  public static void main(String[] args) {
    new Start();
  }

    /**
      *Enthaltene InternalFrameobjekte
      *
      *test Hauptmenu 
      *showTestMakro Datenanzeigefenster
      */

  //protocol.Datenanzeige showTestMakro = new protocol.Datenanzeige();    


    
   
  public Start() {
    super("Cool Staff This Vers. 1.0");
    WindowUtilities.setNativeLookAndFeel();
    addWindowListener(new protocol.ExitListener());
    Container content = getContentPane();
    content.setBackground(Color.white);
    JDesktopPane desktop = new JDesktopPane();
    this.setBackground(new java.awt.Color(204, 204, 255));
    content.add(desktop, BorderLayout.CENTER);
    //setSize(900, 800);
    setBounds(10,10,1000,800);
    protocol.Menu test = new protocol.Menu(desktop);     
    setVisible(true);
    
  }
}



























































