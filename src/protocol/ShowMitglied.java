package protocol;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/** Oberflaeche in der ein bestehendes Mitglied aus der Datenbank bearbeitet 
 *werden kann. Sowohl anzeigen als auch aendern ist moeglich. 
 *@see MitgliedMakro
 *
 *@author Bogumil Bartczak
 *@version 1.0
 */
public final class ShowMitglied extends MitgliedMakro{

    private boolean loaded;
  private boolean changing = false; //true wenn geaendert werden soll
  private String Titel;
  private javax.swing.JButton ChangeButton;
  //  private database.DBChocAn Database = new database.DBChocAn(); 

  /**
   *@param pane Hauptfenster in dem Innere Fenster geoeffnet werden.
   *@param caller Inneres Fenster welches ShowMitglied Instanziiert.
   */
  public ShowMitglied (javax.swing.JDesktopPane pane, javax.swing.JInternalFrame caller){
    setMakroEnvironment(pane, caller);
    setMitglied(new database.Mitglied()); //wenn Datenbank anschluss moeglich
    // Muss hier geandert werden!
    
    initMitgliedMakro();
    pane.add(this);
    this.moveToFront();
    this.setVisible(true);
    setChanging(false);
    setAllTextValidity(true);
    setauthenticEntries(9); // Alle Texfelder gefuellt
    this.requestFocus();
  }

  /**
   *Definiert zusaetzlichen Button mit Listeners.
   *Bennenung des SpecialButton aus MitgliedMakro und anfaengliches sperren
   *aller Textfelder
   *
   *@see MitgliedMakro
   */
  protected void additionalinit(){
      ChangeButton = new javax.swing.JButton();
      ChangeButton.setBounds(375,250,235,40);
      ChangeButton.registerKeyboardAction(new ActionListener(){
	      public void actionPerformed(ActionEvent e){
		changeButtonAction();
	      }
	  },KeyStroke.getKeyStroke(10,0),0);
      ChangeButton.addMouseListener(new MouseAdapter(){
	      public void mouseClicked(MouseEvent m){
			  changeButtonAction();}});
      getContentPane().add(ChangeButton);

      baptizeSpecialButton("Nächster");
      enableSpecialButton(true);
  }

  /** "Schaltet" zwischen aendern und nur anzeigen einer database.Mitglied 
   *Instanz um. 
   *Der zusaetzliche nicht in MitgliedMakro definierte Button wird beeinflusst.
   *
   *@param enableChanging <code>true</code> das Objekt Mitglied soll geandert werden. <code>false</code> Objekt Mitglied soll nur angezeigt werden.
   *@see MitgliedMakro
   */
    protected void setChanging(boolean enableChanging){
	if((enableChanging == true) && (changing == false)) {
	    this.setSize(700,500);
	    ChangeButton.setText("Änderungen speichern");
	}
	else if(enableChanging == false){
	    this.setSize(700,400);
	    ChangeButton.setText("Daten ändern");
	}
	changing = enableChanging;
	enableAllText(changing);
    }


    /**
     *Über ein Dialog wird die Mitgliedsnummer eingelesen, dann Eintrag aus der
     *Datenbank gelesen. Dialog kann nur verlassen werden, wenn Datenfeld 
     *vorhanden oder wenn Abruch angefordert wird.
     *
     *@return <code> true </code> wenn Mitglied aus der datenbank geholt wurde <code false </code> bei Abbruch.
     */
  protected boolean fetchMitglied(){
    database.Mitglied newmitglied = new database.Mitglied();
    boolean noanswer = true;
    boolean cancel = false;
    int id;
    
    while(noanswer){
      String idnmbr = JOptionPane.showInternalInputDialog(this, new String[]{"Mitgliedsnummer eingeben :"}, "Mitglied bearbeiten", 3);
      if(idnmbr == null) { noanswer = false; cancel = true; }
      else {
	try{ 
	  Integer idWrap = new Integer(idnmbr);
	  id = idWrap.parseInt(idnmbr);
	  newmitglied = database.DBChocAn.getMitglied(id);
	  loaded = true;
	  setMitglied( newmitglied );
	  noanswer = false;
	  setChanging(false);
	  fillMakro();
	}//ende try
	catch(NumberFormatException e){
	  JOptionPane.showInternalMessageDialog(this, new String[] {"Nur Zahlen eingeben!"});
	} 
	catch(Exception e){
	  JOptionPane.showInternalMessageDialog(this, new String[] {"Eintrag nicht gefunden"}, "Datenbankfehler", JOptionPane.ERROR_MESSAGE);
	}
      }//ende else
    }//ende while
    if(cancel = true) return false;
    else return true;
  }//ende fetchMitglied
  
  protected void specialButtonClicked(){ fetchMitglied(); }
  
  protected void actByValidity(boolean condition){
      ChangeButton.setEnabled(condition);
 }

  protected void changeButtonAction(){
    setChanging(true);
    checkAllTextField();
    if((changing == true) && queryValidity() ) {
      try{
	database.DBChocAn.changeMitglied( getMitglied() );
      }
      catch(java.sql.SQLException e){
	 InfoLabel.setText("Speicherung Fehlschlag!");
	  javax.swing.JOptionPane.showInternalMessageDialog(this.getParent(), new String[]{"Datenbankzugriff fehlgeschlagen!"});
      }//ende catch
    }
  }//ende changeButtonAction
}//Ende 
