package protocol;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/** Textfeld das die Tasten Tab und Enter so definiert,dass der Inhalt 
 *geprüft wird, befor eine Ausgabe aus dem Textfeld erfolgt. Eingebauter
 *Dialog um auf Korrekturen aufmerksam zu machen.
 *
 *@author Bogumil Bartczak
 */
public abstract class MitgliedMakroTextField extends JTextField{

    /**
     *Gibt an ob der Inhalt des Textfeldes zulässig ist oder nicht.
     */
    protected boolean contentvalid = false;


    /**
     *Inhalt des Textfeldes auslesen
     */
    protected abstract void auslesen();

    /**
     *In das Textfeld schreiben
     */ 
    protected abstract void beschreiben();

    /**
     *müssen so neu definiert werden,so das richtig überprüft wird
     *
     */
    protected abstract boolean checkValid();



    /**
     *Setzen von contentvalid
     *@see#contentvalid
     */
    protected void setContentvalid(boolean valid){
	contentvalid = valid; 
    }

    /**
     *auslesen von contentvalid
     */
    protected boolean getContentvalid(){
	return contentvalid;
    }

    /**
     *Fuegt redefinierten ActionListener und FocusListener zum Objekt
     *hinzu
     */
    protected final void addListeners(){

      FocusManager.disableSwingFocusManager();

      this.registerKeyboardAction(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	    if (checknset() == JOptionPane.NO_OPTION) {
		//getNextFocusableComponent().requestFocus();
		transferFocus();
	    }
	}
	  },KeyStroke.getKeyStroke(10,0),0);

      this.registerKeyboardAction(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	    if (checknset() == JOptionPane.NO_OPTION) {
		transferFocus();
	    }
	}
     },KeyStroke.getKeyStroke(9,0),0);
       
      this.addMouseListener(new MouseAdapter(){
	  public void mouseClicked(MouseEvent e){
	    mouseChangedLocation();}
	  });

    this.addFocusListener(new FocusAdapter(){
	    public void focusGained(FocusEvent e){
		setForeground(java.awt.Color.green);
	    }
	    public void focusLost(FocusEvent e){
		if(contentvalid == false) setForeground(java.awt.Color.red);
		else setForeground(java.awt.Color.black);
	    }
      }); 

  }//ende addListeners()

  /**
   *Handlung die ausgefuehrt wird wenn mit der Maus auf das Objekt Gecklicked 
   *wurde.
   *Standart ist keine Handlung
   */
  protected void mouseChangedLocation(){}; 

    /** Überprüfung des Feldinhaltes und Reaktionen
     *
     *@return <code> JOption.NO_Option </code> Focus soll weitergegeben werden.
     *@return <code> JOption.YES_Option </code> Focus verbleibt.
     *
     *Prüft ob der Inhalt den Erwartungen entspricht. Setzt demnach die 
     *Textfarbe fest. 
     *<code>Schwarz</code> für korrekten Text,<code>Rot</code> für falschen 
     *Eintrag.
     *Ist der Inhalt ungültig, so wird ein Warn-Dialogfeld ausgegeben,
     *in welchem entschieden wird, ob der Focus freigegeben wird oder 
     *beibehalten.
     */
    protected final int checknset(){
	contentvalid = this.checkValid();
	    if(contentvalid == true) {
		this.setForeground(java.awt.Color.black);
	      this.auslesen();  
	      return JOptionPane.NO_OPTION;
	    }
	    else {		
	   int entscheidung = JOptionPane.showInternalConfirmDialog(this.getParent(), new String[] {"Der Eintrag ins Datenfeld ist Fehlerhaft!","Datenfeld weiterbearbeiten?"," ","(Siehe InfoTag)"},"Inkorrekter Feldeintrag",0,2);
	      switch(entscheidung){
	      case JOptionPane.YES_OPTION: this.grabFocus(); break;
	      case JOptionPane.NO_OPTION:
		  this.setForeground(java.awt.Color.red);
		  break;
	      }
	      return entscheidung;
	    }
    }

}//Ende MitgliedMakroTextField
