package protocol;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/** Das Hauptmenu aus dem das jeweilige ArbeitsMakro aufgerufen wird.
 *@see NewMitgliedM
 *@see ShowMitglied
 */
public class MainMitgliedMenu extends JInternalFrame {

    private FocusManager Knot;
    private JDesktopPane Environment;

    /**
     *@param Caller erwartet als Übergabe das aufrufende JDesktopPane
     */
    public MainMitgliedMenu(JDesktopPane Caller){
	Environment = Caller;
	Environment.add(this);

	//int posx = (getContentPane().getWidth()/2)+170;
	//int posy = (getContentPane().getHeight()/2)+200;
	setBounds(330,200,320,400);
	moveToFront();
	setVisible(true);
	initMenu();
	//setSize(340,400);
	setTitle("Mitgliederverwaltung Hauptmenue");
	this.requestFocus();
    }

    /*Enhaltene Komponenten*/

    private JLabel ExitLabel;
    private JLabel NewMitgliedLabel;
    private JLabel ExistingMitgliedLabel;

    protected void initMenu(){
        getContentPane().setLayout(null);

	NewMitgliedLabel = new JLabel();
	getContentPane().add(NewMitgliedLabel);
	NewMitgliedLabel.setForeground(java.awt.Color.black);
	NewMitgliedLabel.setText("Neuen Eintrag erstellen");

	NewMitgliedLabel.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent e){
		    NewMitgliedLabel.setForeground(java.awt.Color.magenta);
		}
		public void mouseExited(MouseEvent e){
		    NewMitgliedLabel.setForeground(java.awt.Color.black);
		}
		public void mouseClicked(MouseEvent e){
		    callNewMitglied();
		}});

	ExistingMitgliedLabel = new JLabel();
	getContentPane().add(ExistingMitgliedLabel);
	ExistingMitgliedLabel.setForeground(java.awt.Color.black);
	ExistingMitgliedLabel.setText("Bestehenden Eintrag bearbeiten");

	ExistingMitgliedLabel.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent e){
		    ExistingMitgliedLabel.setForeground(java.awt.Color.magenta);
		}
		public void mouseExited(MouseEvent e){
		    ExistingMitgliedLabel.setForeground(java.awt.Color.black);
		}
		public void mouseClicked(MouseEvent e){
		    callShowMitglied();		}});


	ExitLabel = new JLabel();
	getContentPane().add(ExitLabel);
	ExitLabel.setForeground(java.awt.Color.black);
	ExitLabel.setText("Beenden");
	ExitLabel.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent e){
		    ExitLabel.setForeground(java.awt.Color.magenta);
		}
		public void mouseExited(MouseEvent e){
		    ExitLabel.setForeground(java.awt.Color.black);
		}
		public void mouseClicked(MouseEvent e){
		    System.exit(0);
		}});

	ExitLabel.setBounds(130,210,100,75);
	NewMitgliedLabel.setBounds(80,50,300,75);
	ExistingMitgliedLabel.setBounds(50,130,300,75);
	ExistingMitgliedLabel.requestFocus();
    }

    protected final void callNewMitglied(){
	this.setCursor(new Cursor(3));
	NewMitglied New = new NewMitglied(Environment, this);
	this.setVisible(false);
	this.transferFocus();
	this.setCursor(new Cursor(0));}

    protected final void callShowMitglied(){
	this.setCursor(new Cursor(3));
	ShowMitglied New = new ShowMitglied(Environment, this);
	this.setVisible(false);
	this.transferFocus();
	this.setCursor(new Cursor(0));}
}
  
