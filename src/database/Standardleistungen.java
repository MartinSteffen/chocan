package database;
public class Standardleistungen {
    // Stellt dem Benutzer ein Objekt Standardleistungen zur
    // Verf�gung. Unter Angabe einer Leistungsnummer k�nnen
    // aus der Tabelle "ChocAn/Standardleistungen" eine
    // Beschreibung und der Preis abgefragt werden.

    protected long   LeistungsNummer;
    protected String Beschreibung;
    protected float  Preis;
                
    public Standardleistungen()
	//Konstruktor
	{ this.LeistungsNummer=0;
	this.Beschreibung="";
	this.Preis=0;
	}
    public Standardleistungen(long LeistNr) 
	//Konstruktor
	// fragt zus�tzlich die Daten entsprechend der Nummer aus
	// der Tabelle "ChocAn/Standardleistungen" und belegt das 
	// Objekt damit.
	// Exceptions, die in LadeLeistung() auftreten werden 
	// hochpropagiert.
    { Zugriff z = new Zugriff();
	    z.LadeLeistung(this,LeistNr); }
    
    protected void SetLeistNr(long LeistNr)
	{ this.LeistungsNummer=LeistNr; }
    protected void SetPreis(float p)
	{ this.Preis=p; }
    protected void SetBeschreibung(String b)
	{ this.Beschreibung=b; }
    
    public long GetLeistNr()
	// Gibt die Leistungsnummer zur�ck
	{ return LeistungsNummer; }
    public String GetBeschreibung()
	// Gibt die Beschreibung zur�ck
	{ return Beschreibung; }
    public float GetPreis()
	// Gibt den Preis zur�ck
	{ return Preis; }
    
    public void Laden(long LeistNr)
	// holt die Daten aus der Tabelle "Standardleistungen"
	// und schreibt Leistungsnummer, Beschreibung, Preis
	// in das Objekt
	// Exceptions, die in LadeLeistung() auftreten werden 
	// hochpropagiert.
	{ Zugriff z = new Zugriff();
	z.LadeLeistung(this,LeistNr); }
}

        
