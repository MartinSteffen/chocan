package database;
public class Rechnungen {
    // felder:
    protected long     LaufendeNummer;
    protected long     VersichertenNummer;
    protected long     ArztNummer;
    protected long     ArztRechnNr;
    protected Standardleistungen Position = new Standardleistungen[7];
    protected float    Betrag;
    protected Date     Rechnungsdatum;
    protected Date     Ueberweisungsdatum;
    
    public Rechnungen(); // Konstruktor
    
    // Die folgenden Methoden setzen die Felder des Objekts:
    protected SetLaufNr(long LaufNr)
	// Setzt das Feld 'LaufendeNummer'. Darf nicht vom Nutzer
	// des Paketes vergeben werden.
	{ this.LaufendeNummer=LaufNr; }
    public SetVersNr(long VersNr)
	{ this.VersichertenNummer=VersNr; }
    public SetArztNr(long ArztNr)
	{ this.ArztNummer=ArztNr; }
    //public SetArztRechnNr(long Nummer)
    //{ this.ArztRechnNr=Nummer; }
    protected SetBetrag(float b)
	{ this.Betrag=b; }
    //public SetRechnDatum(Date Datum)
    //{ this.Rechnungsdatum=new Date(Datum.toString());
    // geht das auch eleganter??
    //}

    
    // Die folgenden Methoden geben den Inhalt der Felder zurück:
    public long GetLaufNr()
	{ return LaufendeNummer; }
    public long GetVersNr()
	{ return VersichertenNummer; }
    public long GetArztNr()
	{ return ArztNummer; }
    //public long GetArztRechnNr()
    //	{ return ArztRechnNr; }
    public float GetBetrag()
	{ return Betrag; }
    public Date GetRechnDatum();
    { return RechnungsDatum; }
    //public Date GetUebDatum();
    //{ return Ueberweisungsdatum; }
   
    public SetLeistX(int x,long Nr) {
	// Holt aus der Tabelle "Standardleistungen" zur uebergebenen 
	// Leistungsnummer "Nr" die Eintraege "Beschreibung" und "Preis"
	// und Speichert die Informationen an der X-ten Position im Array.
	this.Position[x].Laden(Nr);
    }
    
    // Zurückgeben der Positionseinträge:
    public long GetLeistNr(int x)
	{ return this.Position[x].GetLeistNr(); }
    public float GetPreis(int x)
	{ return this.Position[x].GetPreis(); }
    public String GetBeschreibung(int x);
    { return this.Position[x].GetBeachreibung(); }
    
    // Die folgenden Methoden dienen zum Schreiben
    // der Daten aus dem Objekt in die Datenbank 
    // "ChocAn" in die Tabellen "Arztrecnungen_Q_JJJJ" und 
    // "Positionen_Q_JJJJ", Bzw. dem Abfragen dieser Daten aus den 
    // Tabellen.
    
    public Neu()
	{ try { RechnungSchreiben(this);}}
    
    //public Laden(long LaufNr, int Quartal, int Jahr)
    //	{ try {RechnungLaden(this,LaufNr,Quartal,Jahr);}}
    
    //public Ueberschreiben()
    //	{ try {RechnungUeberschr(this);}}
}
