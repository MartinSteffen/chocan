package database;
import java.sql.*;

public class Zugriff {
    String url="jdbc:postgresql://sokrates/ChocAn";
    //protected RechnungSchreiben(Rechnung r)
	// - bindet den Postgres-Treiber ein, gibt ggf 
	//   ClassNotFoundException zurück.
	// - Baut eine Verbindung zur Datenbank auf
	// - Versucht, die Daten aus dem Objekt in die Tabellen
	//   Arztrechnungen_Q_JJJJ und Positionen_Q_JJJJ zu schreiben
	//   Dies soll in drei Schritten (als atomarer Block!!) geschehen:
	//    (Es sollen in diesem Block nicht nur die Daten geschrieben
	//    werden, sondern ebenfalls eine eindeutige fortlaufende Rech-
	//    nungsnummer vergeben werden. Eine Möglichkeit besteht darin,
	//    ein zusätzliches Feld in der Tabelle aufzunehmen: bool "belegt"
	//    Beim erstellen der Tabellen (s.u.) wird die Tabelle mit einer
	//    ersten Reihe initialisiert. Das Feld "Rechnungsnummer" erhält
	//    den Wert 1, "belegt" den Wert false, alle anderen bleiben leer)
	//   1.Schritt: Abfrage der Reihe mit "belegt" gleich false. Man
	//    erhält eine freie Rechnungsnummer.
	//   2.Schritt: Überschreiben der Reihe mit Daten aus dem Objekt mit
	//    "belegt" = true, sowie der Positionen zur Rechnungsnummer in
	//    der Tabelle Positionen_Q_JJJJ und r.setRechNr(Rechnungsnummer).
	//   3.Schritt: Eine neue Reihe mit Rechnungsnummer=Rechnungsnummer+1
	//    anlegen, "belegt"=false.
	// - Existieren die Tabellen nicht, so wird die Funktion 
	//   "NeuRechTab(Q,Jahr)" aufgerufen. Anschließend wir der Schreib-
	//   versuch wiederholt. Alle anderen SQL-Exceptions werden zurück-
	//   gegeben.
	// - Verbindung schließen
     
     //protected RechnungLaden(Rechnung r,long LaufNr, int Quartal, int Jahr)
	// - bindet den Postgres-Treiber ein, gibt ggf 
	//   ClassNotFoundException
	//   zurück.
	// - Baut eine Verbindung zur Datenbank "ChocAn" auf
	// - Versucht, die Daten aus den Tabellen "Arztrechnungen_Q-JJJJ"
	//   und "Positionen_Q_JJJJ" abzufragen und gibt die Daten des Re-
	//   sultSets in das Objekt. Wirft bei Nichtauffinden entsprechende
	//   SQLException.
	// - Verbindung trennen.
	
        //protected RechnungUeberschr(Rechnung r)
	// - bindet den Postgres-Treiber ein, gibt ggf 
	//   ClassNotFoundException
	//   zurück.
	// - Baut eine Verbindung zur Datenbank "ChocAn" auf
	// - Versucht, die entsprechenden Einträge in der Datenbank zu über-
	//   schreiben. Wirft bei Nichtauffinden entsprechende SQLException
	// - Verbindung trennen.
        
        //protected LadeLeist(Standardleistungen s,long LeisNr)
	// - bindet den Postgres-Treiber ein, gibt ggf 
	//   ClassNotFoundException
	//   zurück.
	// - Baut eine Verbindung zur Datenbank "ChocAn" auf
	// - Versucht, aus der Tabelle "Standardleistungen" die Reihe zur 
	//   entsprechenden LeistNr abzufraben und schreibt die Daten in das
	//   Objekt s. SQLExceptions werden ggf geworfen.
	// - Verbindung zur Datenbank schließen.
	
        //protected NeuRechTab(int q, int Jahr)
	// - bindet den Postgres-Treiber ein, gibt ggf 
	//   ClassNotFoundException
	//   zurück.
	// - Baut eine Verbindung zur Datenbank "ChocAn" auf
	// - Versucht zwei Neue Tabellen "Arztrechnungen_Q_JJJ" und
	//   "Positionen_Q_JJJJ" zu erstellen. Zusätzlich wird in der 
	//	Tabelle "Arztrechnungen_Q_JJJJ" die erste Reihe 
	//   eingefügt (s.o.). Es wird ggf. eine SQLException geworfen.
	// - Verbindung trennen.
        
    public void InitDB()
	// - bindet den Postgres-Treiber ein, gibt ggf 
	//   ClassNotFoundException zurück.
	// - Baut eine Verbindung zur Datenbank "ChocAn" auf
	// - Löscht den Inhalt der Datenbank und initialisiert die Datenbank
	//   mit den nötigen Tabellen und einigen vordefinierten Einträgen.
	// - Verbindung trennen.
    { ClearDB(); }

    protected void ClearDB() {
	Connection con;
	try { 
	    Class.forName("org.postgresql.Driver");
	} catch(java.lang.ClassNotFoundException e) {
	    System.err.print("ClassNotFoundException: ");
	    System.err.println(e.getMessage());
	}
	
	try {
	  System.out.println ("Driver loaded");
	  con = DriverManager.getConnection(url, "postgres", "");
	  System.out.println ("2");
	  DatabaseMetaData dbmd = con.getMetaData();
	  System.out.println ("3");
	  String[] tableType = { "TABLE" };
	  System.out.println ("3a");
	  ResultSet Tables = dbmd.getTables(null,null,null,tableType);
	  System.out.println ("4");
	  Statement stmt;
	  while(Tables.next()) {
	    System.out.println ("5");
	    String loesche = "drop table "+Tables.getString("TABLE_NAME");
	    System.out.println(loesche);
	    stmt = con.createStatement();
	    stmt.executeUpdate(loesche);
	    stmt.close();
	  }
	    Tables.close();
	    con.close();
	}
	catch(SQLException ex) {
	    System.err.println(ex.getMessage());
	}
    }
	//	protected CreateStdLeist()
}
