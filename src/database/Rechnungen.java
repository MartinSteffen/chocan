package database;
import java.util.*;
public class Rechnungen {
    // felder:
    protected long     LaufendeNummer;
    protected long     VersichertenNummer;
    protected long     ArztNummer;
    // protected long     ArztRechnNr;
    protected Standardleistungen Position[]=new Standardleistungen[7];
    protected float    Betrag;
    protected GregorianCalendar     Rechnungsdatum;
    //protected Date     Ueberweisungsdatum;
    
    public Rechnungen() {
	for (int x=0;x<7;x++) Position[x]=new Standardleistungen();}
    // Die folgenden Methoden setzen die Felder des Objekts:
    protected void SetLaufNr(long LaufNr)
	// Setzt das Feld 'LaufendeNummer'. Darf nicht vom Nutzer
	// des Paketes vergeben werden.
	{ this.LaufendeNummer=LaufNr; }
    public void SetVersNr(long VersNr)
	{ this.VersichertenNummer=VersNr; }
    public void SetArztNr(long ArztNr)
	{ this.ArztNummer=ArztNr; }
    //public SetArztRechnNr(long Nummer)
    //{ this.ArztRechnNr=Nummer; }
    public void SetBetrag(float b)
	{ this.Betrag=b; }
    public void SetRechnDatum(GregorianCalendar Datum)
    {  
	this.Rechnungsdatum=Datum;
    }

    
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
    public GregorianCalendar GetRechnDatum()
    { return Rechnungsdatum; }
    //public Date GetUebDatum();
    //{ return Ueberweisungsdatum; }
   
    public void SetLeistX(int x,long Nr) {
	// Holt aus der Tabelle "Standardleistungen" zur uebergebenen 
	// Leistungsnummer "Nr" die Eintraege "Beschreibung" und "Preis"
	// und Speichert die Informationen an der X-ten Position im Array.
	Position[x].Laden(Nr);
    }
    
    // Zurückgeben der Positionseinträge:
    public long GetLeistNr(int x) {
	return Position[x].GetLeistNr(); }
    public float GetPreis(int x)
	{ return this.Position[x].GetPreis(); }
    public String GetBeschreibung(int x)
    { return this.Position[x].GetBeschreibung(); }
    
    // Zurueckgeben von Jahr, Quartal, Monat und Tag:
    protected int GetTag() {
	return this.Rechnungsdatum.get(5); }
    
    protected int GetMonat() {
	return this.Rechnungsdatum.get(2)+1; }

    protected int GetQuartal() {
	int m = this.Rechnungsdatum.get(2)+1;
	if ((m==1) || (m==2) || (m==3)) return 1;
	if ((m==4) || (m==5) || (m==6)) return 2;
	if ((m==7) || (m==8) || (m==9)) return 3;
	else return 4;
    }

    protected int GetJahr() {
	return this.Rechnungsdatum.get(1)-1; }


    // Die folgenden Methoden dienen zum Schreiben
    // der Daten aus dem Objekt in die Datenbank 
    // "ChocAn" in die Tabellen "Arztrecnungen_Q_JJJJ" und 
    // "Positionen_Q_JJJJ", Bzw. dem Abfragen dieser Daten aus den 
    // Tabellen.
    
    public void Neu(){
	Zugriff z = new Zugriff();
        z.RechnungSchreiben(this);}
    
    //public Laden(long LaufNr, int Quartal, int Jahr)
    //	{ try {RechnungLaden(this,LaufNr,Quartal,Jahr);}}
    
    //public Ueberschreiben()
    //	{ try {RechnungUeberschr(this);}}
}
