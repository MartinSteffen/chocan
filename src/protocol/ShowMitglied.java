package protocol;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class ShowMitglied extends MitgliedMakro{

    private boolean loaded;
    private boolean changing = false;
    private String Titel;
    private javax.swing.JButton ChangeButton;
    private database.DBChocAn Database;

  public ShowMitglied (javax.swing.JDesktopPane pane, javax.swing.JInternalFrame caller){
    setMakroEnvironment(pane, caller);
    setMitglied(new database.Mitglied());
    
    initMitgliedMakro();
    pane.add(this);
    this.moveToFront();
    this.setVisible(true);
    setChanging(false);
    this.requestFocus();
  }

  protected void additionalinit(){
      ChangeButton = new javax.swing.JButton();
      ChangeButton.setBounds(375,250,235,40);
      ChangeButton.registerKeyboardAction(new ActionListener(){
	      public void actionPerformed(ActionEvent e){
		  setChanging(true);
	      }
	  },KeyStroke.getKeyStroke(10,0),0);
      ChangeButton.addMouseListener(new MouseAdapter(){
	      public void mouseClicked(MouseEvent m){
			  setChanging(true);}});
      getContentPane().add(ChangeButton);

      baptizeSpecialButton("Nächster");
      enableSpecialButton(true);
  }

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
     *vorhanden oder wenn abbruch angefordert wird.
     *
     *@return <code> true </code> wenn Mitglied aus der datenbank geholt wurde <code false </code> bei Abbruch;
     */
    protected boolean fetchMitglied(){
	database.Mitglied newmitglied;
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
		newmitglied = Database.getMitglied(id);
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
	JOptionPane.showInternalMessageDialog(this, new String[] {"Eintrag nicht gefunden"}, "Datanebankfehler", JOptionPane.ERROR_MESSAGE);
	    }
	}//ende else
	}//ende while
	if(cancel = true) return false;
	else return true;
    }//ende fetchMitglied

    protected void specialButtonClicked(){ fetchMitglied(); }
    
    protected void actByValidity(boolean condition){ }

}//Ende 
