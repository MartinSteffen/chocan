package protocol;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class MitgliedMakroTextField extends JTextField{
    
    /**contentvalid 
     *
     *Gibt an ob der Inhalt des Textfeldes zul�ssig ist oder nicht.
     */
    private boolean conentvalid;

    /**isValid()
     *
     *@return <code>true</code> wenn g�ltiger Eintrag <code>false</code> sonst
     */
    protected boolean isValid(){
	return contentvalid;
    }


    /* Abstrakte Methoden */

    /**
     *werden so redifiniert, dass auf mitglied die richtigen 
     *Methoden zum Auslesen und Einlesen aufgerufen werden.
     */
    protected abstract void auslesen(); 
    protected abstract void beschreiben();

    /**
     *m�ssen so neu definiert werden,so das richtig �berpr�ft wird
     *
     */
    protected abstract boolean checkValid();


  /* addListeners()
   *
   *Fuegt redefinierten ActionListener und FocusListener zum Objekt
   *hinzu
   */
  protected void addListeners(){
    this.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	  enterpressed();
	}
      });

    this.addFocusListener(new FocusAdapter(){
	public void focusLost(FocusEvent e){
	  enterpressed();
	}
      });
  }

	/** enterpressed
	 *
	 *mit dieser Funktion wid �berpr�ft, ob der Inhalt zul�ssig ist 
	 *und ins n�chste Feld gesprungen.
	 *Ist der Eintrag ungueltig wird Dialogfeld geoeffnet
	 *und angemerkt, dass Eintrag falsch! Weitermachen oder 
	 *Aendern als Entscheidung 
	 *
	 */
	protected final void enterpressed(){
	    contentvalid = this.checkValid();
	    if(contentvalid == true) this.auslesen();
	    else {
	      int entscheidung = JOptionPane.showInternelConfirmDialog(getContentPane(),"Inkorrekter Feldeintrag!","Datenfeld weiterbearbeiten?",0,2);
	      switch(entscheidung){
	      case JOptionPane.YES_OPTION: this.requestFocus();
	      case JOptionPane.NO_OPTION: this.transferFocus();
	      }
	    }
	}
}//Ende MitgliedMakroTextField


