package protocol;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * MitgliedMakro definiert das Basisfenster  
 * f�r die Manipulation von Objekten vom Typ database.Mitglied
 * 
 *@author Bogumil Bartczak
 *@author Thorsten V�lkel 
 */

public abstract class MitgliedMakro extends JInternalFrame{

    /**Dummy: Zu bearbeitendes Objekt des Typs Mitglied*/
    private database.Mitglied mitglied;

    /**setMitglied(database.Mitglied dummy): festlegen von mitglied
     *
     *@param dummy Objekt vom Typ Mitglied, auf welchem geerbeitet werden soll
     *
     *Eine Instanz von MitgliedMakro arbeitet immer auf einem Objekt Mitglied
     */
    protected final void setMitglied(database.Mitglied dummy){
	mitglied = dummy;
    }

    /**
     * 
     *@return Liefert das vom Makro bearbeitete Objekt zur�ck
     */
    protected final database.Mitglied getMitglied(){
	return mitglied;
    }

    /** Aufrufendes Objekt & Desktop
     *
     *Es wird davon ausgegangen, das MitgliedMakro von einem
     *JInternalFrame aufgerufen wird, und in einem JDesktopPane
     *enthalten sein soll. 
     */
    private JDesktopPane Pfanne;
    private JInternalFrame Aufrufender;
 
    /**
     *
     *Es werden das JDesktopPane Objekt �bergeben, in dem sich das Innere
     *fenster MitgliedMakro bfinden soll und die Containerinstanz, die
     *dieses Fenster aufgerufen hat. 
     *
     *@param Base JDesktopPane in dem MitgliedMakro erschaffen werden soll
     *@param Caller Container welcher MitgliedMakro aufruft
     *@see #returnButtonClicked
     */
    protected void setMakroEnvironment(JDesktopPane Base, JInternalFrame Caller){
	Pfanne = Base;
	Aufrufender = Caller;
    }


  /**Eintragszaehler
   *
   *entriesToBeDone: Feld das die Anzahl benoetigter Eintraege halten
   *authenticEntries: Feld in dem die Anzahl der korrekten Feld eintraege
   *haelt. 
   *
   *Es werden nur variable TextFelder beachtet. MitgliedNummer kann nicht vom
   *"User" direkt geaendert werden, also muss dieses Feld nicht mit
   *diesen Zahlen represaentiert werden.  
   */
    private static final int entriesToBeDone = 9;
    private int authenticEntries = 0;
    private int presetEntries = 0;

  /**
   *Setzt die Anzahl der Bereits g�ltigen eintr�ge. Gedacht f�r preinitialisireungen
   *@param doneEntries integer auf den authenticEntries gesetzt werden soll.
   */
  protected void setauthenticEntries(int doneEntries){
      presetEntries = doneEntries;
    authenticEntries = doneEntries;
  }


    /** In-/decrementieren der g�ltigen Eintr�ge
     *
     *@see #queryValidity()
     *@see #actByValidity(boolean)
     *
     *@param authenticity f�r true wird hochgez�hlt sonst heruntergez�hlt  
     *@return <code> true </code> falls alle geforderten eintr�ge korrekt sind, d.h. entriesToBeDone == authenticEntries
     */
    protected boolean entryIsAuthentic(boolean authenticity){
	if(authenticity == true) authenticEntries++;
	else authenticEntries--;
	actByValidity( queryValidity() );
	return queryValidity();
    }


  /** queryValidity()
   *
   *@return </code>true<code> wenn entriesToBeDone = authenticEntries.
   */
  protected boolean queryValidity(){
    if (entriesToBeDone == authenticEntries) return true;
    else return false;
  }


    /** Handlungen bezogen auf die Anzahl korrekter eintr�ge
     *
     *@see #entryIsAuthentic(boolean)
     *
     *Wird von entryIsAuthentic aufgerufen. Ist geeignet um eine
     *Handlung einzuleiten, wenn alle Feldeinr�ge richtig sind.
     */
    protected abstract void actByValidity(boolean condition);


    /** Komponenten eines Fensters*/
    /** Label */
    private JLabel VornameLabel;
    private JLabel TelefonLabel;
    private JLabel OrtLabel;
    private JLabel StrasseLabel;
    private JLabel NummerLabel;
    private JLabel PostleitzahlLabel;
    private JLabel NameLabel;
    private JLabel EintrittsdatumLabel;
    private JLabel MitgliedsnummerLabel;
    private JLabel AustrittsdatumLabel;

    /** InfoLabel
     *
     *Label das im unteren Teils des Fensters erscheint
     *und einen informierenden Text ausgibt
     */
    protected JLabel InfoLabel;
	
    /** Textfelder */
    private MitgliedMakroTextField NameText;
    private MitgliedMakroTextField VornameText;
    private MitgliedMakroTextField StrasseText;
    private MitgliedMakroTextField MitgliedsnummerText;
    private MitgliedMakroTextField NummerText;
    private MitgliedMakroTextField PLZText;
    private MitgliedMakroTextField OrtText;
    private MitgliedMakroTextField TelefonText;
    private MitgliedMakroTextField AustrittsdatumText;
    private MitgliedMakroTextField EintrittsdatumText;

    /** Buttons */
    private JButton ReturnButton;
    protected JButton SpecialButton;

    /*Timer*/ 
    protected Timer InfoLabelClock; 


    /** Initialisierung der Komponenten: initcomponents()
     *
     *Hier ist die Anordnung und Aussehen im Fenster festgelegt.
     *Nach der initialisierung sind alle TextFelder leer
     *und beschreibbar (ausser MitgliedsnummerText). 
     *@see#enableAllTextFields(boolean)
     *@see#enableAustrittsdatumText(boolean)
     *@see#enableSpecialButton(boolean)
     */
    private void initcomponents(){

	//Layout festlegen
	getContentPane().setLayout(null);

	/** Label */
	NameLabel = new JLabel();
	NameLabel.setFont(new java.awt.Font ("TimesRoman", 0, 11));
        NameLabel.setName("NameLabel");
        NameLabel.setBackground(new java.awt.Color (204, 204, 204));
        NameLabel.setForeground(java.awt.Color.black);
        NameLabel.setText("Name");

	//plazierung im fenster        
        getContentPane().add(NameLabel);
        NameLabel.setBounds(30, 30, 90, 30);
	
	VornameLabel = new JLabel();
	VornameLabel.setFont(new java.awt.Font ("TimesRoman", 0, 11));
        VornameLabel.setName("VornameLabel");
        VornameLabel.setBackground(new java.awt.Color (204, 204, 204));
        VornameLabel.setForeground(java.awt.Color.black);
        VornameLabel.setText("Vorname");

	getContentPane().add(VornameLabel);
        VornameLabel.setBounds(30, 70, 90, 30);

        
       	TelefonLabel = new JLabel();
	TelefonLabel.setFont(new java.awt.Font ("TimesRoman", 0, 11));
        TelefonLabel.setName("TelefonLabel");
        TelefonLabel.setBackground(new java.awt.Color (204, 204, 204));
        TelefonLabel.setForeground(java.awt.Color.black);
        TelefonLabel.setText("Telefon");
        
        getContentPane().add(TelefonLabel);
        TelefonLabel.setBounds(30, 230, 90, 30);

        
	StrasseLabel = new JLabel();
	StrasseLabel.setFont(new java.awt.Font ("TimesRoman", 0, 11));
        StrasseLabel.setName("StrasseLabel");
        StrasseLabel.setBackground(new java.awt.Color (204, 204, 204));
        StrasseLabel.setForeground(java.awt.Color.black);
        StrasseLabel.setText("Strasse");
        
        getContentPane().add(StrasseLabel);
        StrasseLabel.setBounds(30, 150, 90, 30);

        
	NummerLabel = new JLabel();
	NummerLabel.setFont(new java.awt.Font ("TimesRoman", 0, 11));
        NummerLabel.setName("NummerLabel");
        NummerLabel.setBackground(new java.awt.Color (204, 204, 204));
        NummerLabel.setForeground(java.awt.Color.black);
        NummerLabel.setText("Nr.");
        
        getContentPane().add(NummerLabel);
        NummerLabel.setBounds(410, 150, 90, 30);

	PostleitzahlLabel = new JLabel();
        PostleitzahlLabel.setFont(new java.awt.Font ("TimesRoman", 0, 11));
        PostleitzahlLabel.setName("PostleitzahlLabel");
        PostleitzahlLabel.setBackground(new java.awt.Color (204, 204, 204));
        PostleitzahlLabel.setForeground(java.awt.Color.black);
        PostleitzahlLabel.setText("PLZ");
        
        getContentPane().add(PostleitzahlLabel);
        PostleitzahlLabel.setBounds(30, 190, 30, 30);

        
	OrtLabel = new JLabel();
        OrtLabel.setFont(new java.awt.Font ("TimesRoman", 0, 11));
        OrtLabel.setName("OrtLabel");
        OrtLabel.setBackground(new java.awt.Color (204, 204, 204));
        OrtLabel.setForeground(java.awt.Color.black);
        OrtLabel.setText("Ort");
        
        getContentPane().add(OrtLabel);
        OrtLabel.setBounds(410, 190, 30, 30);

        
	EintrittsdatumLabel = new JLabel();
	EintrittsdatumLabel.setFont(new java.awt.Font ("TimesRoman", 0, 11));
        EintrittsdatumLabel.setName("EintrittsdatumLabel");
        EintrittsdatumLabel.setBackground(new java.awt.Color (204, 204, 204));
        EintrittsdatumLabel.setForeground(java.awt.Color.black);
        EintrittsdatumLabel.setText("Eintrittsdatum");
        
        getContentPane().add(EintrittsdatumLabel);
        EintrittsdatumLabel.setBounds(30, 270, 90, 30);

        
	MitgliedsnummerLabel = new JLabel();
	MitgliedsnummerLabel.setFont(new java.awt.Font ("TimesRoman", 0, 11));
        MitgliedsnummerLabel.setName("MitgliedsnummerLabel");
        MitgliedsnummerLabel.setBackground(new java.awt.Color (204, 204, 204));
        MitgliedsnummerLabel.setForeground(java.awt.Color.black);
        MitgliedsnummerLabel.setText("Mitgliedsnummer");
        
        getContentPane().add(MitgliedsnummerLabel);
        MitgliedsnummerLabel.setBounds(330, 30, 130, 30);


        AustrittsdatumLabel = new JLabel();
	AustrittsdatumLabel.setFont(new java.awt.Font ("TimesRoman", 0, 11));
        AustrittsdatumLabel.setName("AustrittsdatumLabel");
        AustrittsdatumLabel.setBackground(new java.awt.Color (204, 204, 204));
        AustrittsdatumLabel.setForeground(java.awt.Color.black);
        AustrittsdatumLabel.setText("Austrittsdatum");
        
        getContentPane().add(AustrittsdatumLabel);
        AustrittsdatumLabel.setBounds(30, 310, 90, 30);


//InfoLabel
	InfoLabel = new JLabel();
	InfoLabel.setFont(new java.awt.Font ("TimesRoman", 0, 11));
	InfoLabel.setBackground(java.awt.Color.white);
	InfoLabel.setForeground(java.awt.Color.yellow);
	InfoLabel.setBorder(new javax.swing.border.TitledBorder("InfoTag"));

	getContentPane().add(InfoLabel);
	InfoLabel.setBounds(30,370,580,60);

	//Timer
	InfoLabelClock = new Timer(10000,new ActionListener(){ 
		public void actionPerformed(ActionEvent e){
		    InfoLabel.setText("");}});
	InfoLabelClock.setRepeats(false);


	/** TextFelder */
	NameText = new MitgliedMakroTextField(){
	    protected void auslesen(){
	      mitglied.setNachname(this.getText());
	    }
	    protected void beschreiben(){
	      this.setText(mitglied.getNachname());
	    }
	    protected boolean checkValid(){
	      if (contentvalid == false){ 
		contentvalid = true;
		entryIsAuthentic(contentvalid);
	      }
		return contentvalid;
	    }
	  };

	NameText.setBackground(java.awt.Color.white);
        NameText.setName("NameText");
        NameText.setFont(new java.awt.Font ("TimesRoman", 0, 11));
        NameText.setForeground(java.awt.Color.black);
        
        getContentPane().add(NameText);
        NameText.setBounds(140, 30, 170, 30);
	NameText.addListeners();


        VornameText = new MitgliedMakroTextField(){
	    protected void auslesen(){
	      mitglied.setVorname(this.getText());
	    }
	    protected void beschreiben(){
	      this.setText(mitglied.getVorname());
	    }
	    protected boolean checkValid(){
	      if (contentvalid == false){ 
		contentvalid = true;
		entryIsAuthentic(contentvalid);
	      }
		return contentvalid;
	    }
	  };

        VornameText.setBackground(java.awt.Color.white);
        VornameText.setName("VornameText");
        VornameText.setFont(new java.awt.Font ("TimesRoman", 0, 11));
        VornameText.setForeground(java.awt.Color.black);
	VornameText.addListeners();        

        getContentPane().add(VornameText);
        VornameText.setBounds(140, 70, 170, 30);


        StrasseText = new MitgliedMakroTextField(){
	    protected void auslesen(){
	      mitglied.setStrasse(this.getText());
	    }
	    protected void beschreiben(){
	      this.setText(mitglied.getStrasse());
	    }
	    protected boolean checkValid(){
	      if (contentvalid == false){ 
		contentvalid = true;
		entryIsAuthentic(contentvalid);
	      }
		return contentvalid;
	    }
	  };

	StrasseText.setBackground(java.awt.Color.white);
        StrasseText.setName("Strasse");
        StrasseText.setFont(new java.awt.Font ("TimesRoman", 0, 11));
        StrasseText.setForeground(java.awt.Color.black);
	StrasseText.addListeners();
        
        getContentPane().add(StrasseText);
        StrasseText.setBounds(140, 150, 170, 30);


        MitgliedsnummerText = new MitgliedMakroTextField(){
	    protected void auslesen(){
	      //mitglied.setId(this.getText());
	    }
	    protected void beschreiben(){
	      Integer id = new Integer(mitglied.getId());
	      this.setText(id.toString());
	    }
	    protected boolean checkValid(){
		return contentvalid;
	    }
	  };

        MitgliedsnummerText.setBackground(java.awt.Color.white);
        MitgliedsnummerText.setName("Id");
        MitgliedsnummerText.setFont(new java.awt.Font ("TimesRoman", 0, 12));
        MitgliedsnummerText.setForeground(java.awt.Color.black);
	MitgliedsnummerText.setEnabled(false);

        getContentPane().add(MitgliedsnummerText);
        MitgliedsnummerText.setBounds(440, 30, 170, 30);


        NummerText = new MitgliedMakroTextField(){
	    protected void auslesen(){
	      mitglied.setHausnummer(this.getText());
	    }
	    protected void beschreiben(){
	      this.setText(mitglied.getHausnummer());
	    }
	    protected boolean checkValid(){
	      if (contentvalid == false){ 
		contentvalid = true;
		entryIsAuthentic(contentvalid);
	      }
		return contentvalid;
	    }
	  };

        NummerText.setBackground(java.awt.Color.white);
        NummerText.setName("Nr");
        NummerText.setFont(new java.awt.Font ("TimesRoman", 0, 12));
        NummerText.setForeground(java.awt.Color.black);
	NummerText.addListeners();        

        getContentPane().add(NummerText);
        NummerText.setBounds(440, 150, 170, 30);


        PLZText = new MitgliedMakroTextField(){
	    protected void auslesen(){
	      mitglied.setPostleitzahl(this.getText());
	    }
	    protected void beschreiben(){
	      this.setText(mitglied.getPostleitzahl());
	    }
	    protected boolean checkValid(){
	      if (contentvalid == false){ 
		contentvalid = true;
		entryIsAuthentic(contentvalid);
	      }
		return contentvalid;
	    }
	  };

        PLZText.setBackground(java.awt.Color.white);
        PLZText.setName("plz");
        PLZText.setFont(new java.awt.Font ("TimesRoman", 0, 12));
        PLZText.setForeground(java.awt.Color.black);
	PLZText.addListeners();        

        getContentPane().add(PLZText);
        PLZText.setBounds(140, 190, 170, 30);


        OrtText = new MitgliedMakroTextField(){
	    protected void auslesen(){
	      mitglied.setOrt(this.getText());
	    }
	    protected void beschreiben(){
	      this.setText(mitglied.getOrt());
	    }
	    protected boolean checkValid(){
	      if (contentvalid == false){ 
		contentvalid = true;
		entryIsAuthentic(contentvalid);
	      }
		return contentvalid;
	    }
	  };

        OrtText.setBackground(java.awt.Color.white);
        OrtText.setName("Ort");
        OrtText.setFont(new java.awt.Font ("TimesRoman", 0, 12));
        OrtText.setForeground(java.awt.Color.black);
	OrtText.addListeners();        

        getContentPane().add(OrtText);
        OrtText.setBounds(440, 190, 170, 30);


        TelefonText = new MitgliedMakroTextField(){
	    protected void auslesen(){
	      mitglied.setTelefonnummer(this.getText());
	    }
	    protected void beschreiben(){
	      this.setText(mitglied.getTelefonnummer());
	    }
	    protected boolean checkValid(){
	      if (contentvalid == false){ 
		contentvalid = true;
		entryIsAuthentic(contentvalid);
	      }
		return contentvalid;
	    }
	  };

        TelefonText.setBackground(java.awt.Color.white);
        TelefonText.setName("Telefon");
        TelefonText.setFont(new java.awt.Font ("TimesRoman", 0, 12));
        TelefonText.setForeground(java.awt.Color.black);
	TelefonText.addListeners();        

        getContentPane().add(TelefonText);
        TelefonText.setBounds(140, 230, 170, 30);


//EintrittsdatumText

	EintrittsdatumText = new MitgliedMakroTextField(){
		private java.text.DateFormat converterDate = java.text.DateFormat.getDateInstance(); 
	    protected void auslesen(){
	      try{
		  mitglied.setEintritt( converterDate.parse( this.getText() ) );
	      }
	      catch(java.text.ParseException e){
		  JOptionPane.showInternalMessageDialog(this.getParent(), new String[] {"Ein Datumsfeld muss die Form ", "TT.MM.JJJJ haben!"}, "Inkorrekter Datumseintrag!", 1);
		  this.setForeground(java.awt.Color.red);
		if(contentvalid == true){
		  contentvalid = false;
		  entryIsAuthentic(contentvalid);
		}
	      }
	    }//Ende auslesen

	    protected void beschreiben(){
	      this.setText(converterDate.format(mitglied.getEintritt()));
	    }
	    protected boolean checkValid(){
	      try{
		  java.util.Date d = converterDate.parse( this.getText() );
	      
	      if (contentvalid == false){ 
		  this.setForeground(java.awt.Color.red);
		  contentvalid = true;
		  entryIsAuthentic(contentvalid);
	      }//ende if
		return contentvalid;
	      }
	      catch(java.text.ParseException e){
		  InfoLabel.setText("Gefordertes Format TT.MM.JJJJ");
		  InfoLabelClock.start();
		 
		  this.setForeground(java.awt.Color.red);
		if(contentvalid == true){
		  contentvalid = false;
		  entryIsAuthentic(contentvalid);
		}
		return contentvalid;
	      }//ende catch
	     		
	    }//ende auslesen
	  };//ende felddefinition


        EintrittsdatumText.setBackground(java.awt.Color.white);
        EintrittsdatumText.setName("Eintritt");
        EintrittsdatumText.setFont(new java.awt.Font ("TimesRoman", 0, 12));
        EintrittsdatumText.setForeground(java.awt.Color.black);
	EintrittsdatumText.addListeners();        

        getContentPane().add(EintrittsdatumText);
        EintrittsdatumText.setBounds(140, 270, 170, 30);


//AustrittsdatumText

        AustrittsdatumText = new MitgliedMakroTextField(){
		private java.text.DateFormat converterDate = java.text.DateFormat.getDateInstance(); 
	    protected void auslesen(){
	      try{
	      mitglied.setAustritt( converterDate.parse( this.getText() ) );
	      }
	      catch(java.text.ParseException e){
		  JOptionPane.showInternalMessageDialog(this.getParent(), new String[] {"Ein Datumsfeld muss die Form ", "TT.MM.JJJJ haben!"}, "Inkorrekter Datumseintrag!", 1);
		  this.setForeground(java.awt.Color.red);
		  if(contentvalid == true){
		  contentvalid = false;
		  entryIsAuthentic(contentvalid);
		}
	      }
	    }//Ende auslesen

	    protected void beschreiben(){
	      this.setText(converterDate.format(mitglied.getAustritt()));
	    }
	    protected boolean checkValid(){
	      try{
	      java.util.Date d = converterDate.parse( this.getText() );
	      
	      if (contentvalid == false){ 
		  this.setForeground(java.awt.Color.red);
		  contentvalid = true;
		  entryIsAuthentic(contentvalid);
	      }//ende if
		return contentvalid;
	      }
	      catch(java.text.ParseException e){
		  InfoLabel.setText("Gefordertes Format TT.MM.JJJJ");
		  InfoLabelClock.start();

		  this.setForeground(java.awt.Color.red);
		if(contentvalid == true){
		  contentvalid = false;
		  entryIsAuthentic(contentvalid);
		}
		return contentvalid;
	      }//ende catch
	    }//ende auslesen
	  };//ende felddefinition

        AustrittsdatumText.setBackground(java.awt.Color.white);
        AustrittsdatumText.setName("Austritt");
        AustrittsdatumText.setFont(new java.awt.Font ("TimesRoman", 0, 12));
        AustrittsdatumText.setForeground(java.awt.Color.black);
	AustrittsdatumText.addListeners();        

        getContentPane().add(AustrittsdatumText);
        AustrittsdatumText.setBounds(140, 310, 170, 30);



	/** Buttons */
	ReturnButton = new JButton();
	ReturnButton.setText("Verlassen");
	ReturnButton.addMouseListener( new MouseAdapter(){
		public void mouseClicked(MouseEvent evt){
		    returnButtonClicked();}} );
	ReturnButton.registerKeyboardAction(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    returnButtonClicked();    
		}
	    },KeyStroke.getKeyStroke(10,0),0);


	getContentPane().add(ReturnButton);
        ReturnButton.setBounds(500, 300, 110, 40);
	//	ReturnButton.setRequestFocusEnabled(false);


	SpecialButton = new JButton();
	SpecialButton.addMouseListener( new MouseAdapter(){
		public void mouseClicked(MouseEvent evt){
		    /**
		     *@see#SpecialButtonClicked()
		     */
		    specialButtonClicked();}} );
	SpecialButton.registerKeyboardAction(new ActionListener(){
	public void actionPerformed(ActionEvent e){
	    specialButtonClicked();    
	}
	  },KeyStroke.getKeyStroke(10,0),0);


	getContentPane().add(SpecialButton);
        SpecialButton.setBounds(375, 300, 110, 40);
	// SpecialButton.setRequestFocusEnabled(true);

    }//ende initcomponents()


    /**abstract additionalinit: zus�tzliche Initialisierungen
     *
     *Abgeleitete Klassen muessen evtl zus�tzliche
     *Initialisierungen haben.
     *Kurze Methode, die von initcomponents() aufgerufen wird.
     */
    protected abstract void additionalinit();


    /**init: Initialisierung der Oberfl�che
     *
     *F�gt dem Fenster alle Grundelgenden Komponenten 
     *hinzu. zus�tzlich hinzuzuf�gende komponenten stehen in 
     *@see#additionalinit
     */
    protected void initMitgliedMakro(){
	initcomponents();
	additionalinit();
    }

    /*Methoden zum SpecialButton*/

    /**  
     *Definiert Prozedur wenn auf den SpecialButton gecklickt wurde. 
     */
    protected abstract void specialButtonClicked();


    /**
     *Der SpecialButton hat keine Bezeichnung diese Methode 
     *schreibt ein Wort in den Button.
     *
     *@param name Schriftzug auf dem SpecialButton
     *
     */
    protected void baptizeSpecialButton(String name){
	SpecialButton.setText(name);
    }


    /**
     *Ist der Button aktiviert werden Clicks angenommen und weiterverarbeitet,
     *die Schrift ist schwarz.
     *Deaktiviert werden keine Clicks weiterverarbeitet und die Schrift ist
     *hellgrau.
     *@param status true: aktiviert, false: deaktiviert 
     */
    protected void enableSpecialButton(boolean status){
	SpecialButton.setEnabled(status);
	if(status == true) SpecialButton.setForeground(java.awt.Color.black);
	else SpecialButton.setForeground(java.awt.Color.lightGray);
    }



  /**
   *Wird der ReturnButton geclicked, dann wird gefragt ob trotz Datenverlust
   *die Bearbeitung abgebrochen werden soll. Ist dies der Fall, wird das
   *aufrufende Fenster "Aufrufender", wieder sichtbar gemacht, MitgliedMakro
   *wird geschlossen und aus "Pfanne" entfernt.
   *
   */
  protected void returnButtonClicked(){
      if(authenticEntries > presetEntries){
    int antwort = JOptionPane.showInternalConfirmDialog(this.getParent(), new String[] {"Daten gehen verloren!", "Wollen Sie dennoch beenden?"}, "Wirklich beenden?", 1, 2);
    switch(antwort){
    case JOptionPane.YES_OPTION: 
      this.setVisible(false);
      Aufrufender.setVisible(true);
      Pfanne.remove(this);
      break;
    default: 
      break;
    }
      }
      else { 
	  this.setVisible(false);
	  Aufrufender.setVisible(true);
	  Pfanne.remove(this);
      }
  }


    /* Manipulationsmethoden f�r Textfelder */

    /**
     *Ist das Textfeld deaktiviert reagiert es nicht auf 
     *"Manipulations-anforderungen"
     *@param status true: aktiviert, false: deaktiviert
     */
    protected final void enableAustrittsdatumText(boolean status){
	AustrittsdatumText.setEnabled(status);
    }


    /**
     *aktiviert/deaktiviert alle TextField Objekte mit variablem Inhalt, also
     *nicht MitgliednummerText
     *@param status true: aktiviert, false: deaktiviert
     */
    protected final void enableAllText(boolean status){
	NameText.setEnabled(status);
	StrasseText.setEnabled(status);
	NummerText.setEnabled(status);
	OrtText.setEnabled(status);
	PLZText.setEnabled(status);
	VornameText.setEnabled(status);
	TelefonText.setEnabled(status);
	AustrittsdatumText.setEnabled(status);
	EintrittsdatumText.setEnabled(status);
    }

    /**
     *Fuelled alle TextFelder aus dem Objekt mitglied
     */
    protected final void fillMakro(){
	//	System.out.println("F�llen des Makros!");
	NameText.beschreiben();
	VornameText.beschreiben();
	StrasseText.beschreiben();
	MitgliedsnummerText.beschreiben();
	NummerText.beschreiben();
	OrtText.beschreiben();
	PLZText.beschreiben();
	TelefonText.beschreiben();
	AustrittsdatumText.beschreiben();
	EintrittsdatumText.beschreiben();
    }

    /**
     *Alle MakroMitgliedTextFields contentvalids setzen
     */
    protected final void setAllTextValidity(boolean valid){
	NameText.setContentvalid(valid);
	VornameText.setContentvalid(valid);
	StrasseText.setContentvalid(valid);
	MitgliedsnummerText.setContentvalid(valid);
	NummerText.setContentvalid(valid);
	OrtText.setContentvalid(valid);
	PLZText.setContentvalid(valid);
	TelefonText.setContentvalid(valid);
	AustrittsdatumText.setContentvalid(valid);
	EintrittsdatumText.setContentvalid(valid);
    }


}//Ende



