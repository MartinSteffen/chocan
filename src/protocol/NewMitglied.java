package protocol;

/**
 *Inneresfenster um einen neuen Eintrag in die mit database.DBChocAn verbundene
 *Datenbank vom Typ Mitglied zu schreiben
 *@author Bogumil Bartczak
 *
 *@see database.DBChocAn
 *@see MitgliedMakro  
 */
public final class NewMitglied extends MitgliedMakro{

    private boolean savingstatus = false;
    private database.DBChocAn Database;

  public NewMitglied(javax.swing.JDesktopPane pane, javax.swing.JInternalFrame caller){
    setMakroEnvironment(pane, caller);
    setMitglied(new database.Mitglied());

    initMitgliedMakro();
    pane.add(this);
    this.moveToFront();
    this.setVisible(true);
    this.setSize(700, 500);
    this.setTitle("Neues Mitglied");
    this.requestFocus();
  }

  protected void additionalinit(){
    baptizeSpecialButton("Speichern");
    enableSpecialButton(false);
    enableAustrittsdatumText(false);
    setauthenticEntries(1);
  }
    /**
     *Versucht die database.Mitglied Instanz in die Datenbank zu schreiben
     */
  protected void specialButtonClicked(){
    checkAllTextField();
    if(queryValidity()){
      try{
	  if(savingstatus == false){
	    getMitglied().setAustritt( getMitglied().getEintritt() );
	      Database.newMitglied(getMitglied());
	      savingstatus = true;
	      InfoLabel.setText("Speicherung Erfolgreich");
	      InfoLabelClock.start();
	  }//ende if
	  else{
	      Database.changeMitglied(getMitglied());
	      InfoLabel.setText("Speicherung Erfolgreich");
	      InfoLabelClock.start();
	  }//ende else
      }//ende try
      catch(java.sql.SQLException se){
	  InfoLabel.setText("Speicherung Fehlschlag!");
	  javax.swing.JOptionPane.showInternalMessageDialog(this.getParent(), new String[]{"Datenbankzugriff fehlgeschlagen!"});
	  } 
      catch(java.lang.Exception e){
	  InfoLabel.setText("Speicherung fehlgeschlagen!");
	  javax.swing.JOptionPane.showInternalMessageDialog(this.getParent(), new String[]{"Datenbankkapazität erschöpft oder Verbindung fehlgeschlagen!"},"Datenbank Fehler",0); 
      }
    }
else   javax.swing.JOptionPane.showInternalMessageDialog(this.getParent(), new String[]{"Es existieren noch fehlerhafte Eintraege!"},"Fehler",0);
  };//ende SpecialButtonClicked

    protected void actByValidity(boolean condition){
	enableSpecialButton(condition);
    };

}//Ende 

 


