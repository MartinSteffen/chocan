package database;
import java.sql.*;
import java.util.*;

public class Zugriff {
    String url="jdbc:postgresql://sokrates/ChocAn";
    protected void RechnungSchreiben(Rechnungen r) {
	// - bindet den Postgres-Treiber ein, gibt ggf 
	//   ClassNotFoundException zurück.
	// - Baut eine Verbindung zur Datenbank auf
	// - Versucht, die Daten aus dem Objekt in die Tabelle
	//   Arztrechnungen_Q_JJJJ zu schreiben
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
	Connection con;
	String query;
	int q = r.GetQuartal();
	int Jahr = r.GetJahr();
	String Tabelle = "arztrechnungen_"+q+"_"+Jahr;
	query = "SELECT NUMMER FROM "+Tabelle+" WHERE BELEGT = FALSE";
	Statement stmt;
	try { 
	    Class.forName("org.postgresql.Driver"); }
	catch(java.lang.ClassNotFoundException e) {
	    System.err.print("ClassNotFoundException: ");
	    System.err.println(e.getMessage());
	}
	try {
	    con = DriverManager.getConnection(url, "postgres", "");
	    con.setAutoCommit(false);

	    // Hier wird ueberprueft, ob Tabelle vorhanden:
	    DatabaseMetaData dbmd = con.getMetaData();
	    String[] tableType = { "TABLE" };
	    ResultSet Tables = dbmd.getTables(null,null,null,tableType);
	    boolean TabExists=false;
	    while(Tables.next()) {
		if (Tabelle.compareTo(Tables.getString("TABLE_NAME"))==0) TabExists=true;
	    }
	    if (!TabExists) NeuRechTab(q,Jahr);

	    // ab hier wird der neue Eintrag in die Tabelle geschrieben (s.o.)
	    stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    rs.next();
	    long Nummer = rs.getLong("NUMMER");
	    r.SetLaufNr(Nummer);
	    Nummer += 1;
	    stmt.executeUpdate("update "+Tabelle+" set BELEGT = true, VERSICHERTENNUMMER = "+r.GetVersNr()+", ARZTNUMMER = "+r.GetArztNr()+", POSITION1 = "+r.GetLeistNr(0)+", POSITION2 = "+r.GetLeistNr(1)+", POSITION3 = "+r.GetLeistNr(2)+", POSITION4 = "+r.GetLeistNr(3)+", POSITION5 = "+r.GetLeistNr(4)+", POSITION6 = "+r.GetLeistNr(5)+", POSITION7 = "+r.GetLeistNr(6)+", BETRAG = "+r.GetBetrag()+", RECHNUNGSDATUM = '"+r.GetTag()+"/"+r.GetMonat()+"/"+r.GetJahr()+"'");
	    stmt.executeUpdate("insert into ARZTRECHNUNGEN_"+q+"_"+Jahr+" VALUES ("+Nummer+", FALSE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0, '01/01/1900')");
	    con.commit();
	    con.setAutoCommit(true);
	    stmt.close();
	    con.close();
	}
	catch(SQLException ex) {
	    System.err.println("SQLException: " + ex.getMessage());
	}
    }	
        //protected void RechnungLaden(Rechnung r,long LaufNr, int Quartal, int Jahr)
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
        
    protected void LadeLeistung(Standardleistungen s,long  LeistNr) {
	// - bindet den Postgres-Treiber ein, gibt ggf 
	//   ClassNotFoundException
	//   zurück.
	// - Baut eine Verbindung zur Datenbank "ChocAn" auf
	// - Versucht, aus der Tabelle "Standardleistungen" die Reihe zur 
	//   entsprechenden LeistNr abzufraben und schreibt die Daten in das
	//   Objekt s. SQLExceptions werden ggf geworfen.
	// - Verbindung zur Datenbank schließen.
       	Connection con;
	String query;
	query = "SELECT * FROM LEISTUNGEN WHERE LEISTNR = "+LeistNr;
	Statement stmt;
	try { 
	    Class.forName("org.postgresql.Driver"); }
	catch(java.lang.ClassNotFoundException e) {
	    System.err.print("ClassNotFoundException: ");
	    System.err.println(e.getMessage());
	}
	try {
	    con = DriverManager.getConnection(url, "postgres", "");
	    stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    boolean Result = false;
	    while (rs.next()) {
		Result = true;
		s.SetLeistNr(rs.getLong(1));
		s.SetPreis(rs.getFloat(3));
		s.SetBeschreibung(rs.getString(2));
	    }
	    if (!Result) s.SetBeschreibung("");
	    rs.close();
	    stmt.close();
	    con.close();
	}
	 catch(SQLException ex) {
	    System.err.println("SQLException: " + ex.getMessage());
	}
    }   
	
    protected void NeuRechTab(int q, int Jahr) {
	// - bindet den Postgres-Treiber ein, gibt ggf 
	//   ClassNotFoundException
	//   zurück.
	// - Baut eine Verbindung zur Datenbank "ChocAn" auf
	// - Versucht die neue Tabelle "Arztrechnungen_Q_JJJJ"
	//   zu erstellen. Zusätzlich wird in der 
	//	Tabelle "Arztrechnungen_Q_JJJJ" die erste Reihe 
	//   eingefügt (s.o.). Es wird ggf. eine SQLException geworfen.
	// - Verbindung trennen.

	Connection con;
	String createString;
	createString = "create table ARZTRECHNUNGEN_"+q+"_"+Jahr+" (NUMMER INTEGER, BELEGT BOOL, VERSICHERTENNUMMER INTEGER, ARZTNUMMER INTEGER, POSITION1 INTEGER, POSITION2 INTEGER, POSITION3 INTEGER, POSITION4 INTEGER, POSITION5 INTEGER, POSITION6 INTEGER, POSITION7 INTEGER, BETRAG FLOAT, RECHNUNGSDATUM DATE)";
	Statement stmt;
	try { 
	    Class.forName("org.postgresql.Driver"); }
	catch(java.lang.ClassNotFoundException e) {
	    System.err.print("ClassNotFoundException: ");
	    System.err.println(e.getMessage());
	}
	try {
	    con = DriverManager.getConnection(url, "postgres", "");
	    con.setAutoCommit(false);
	    stmt = con.createStatement();
	    stmt.executeUpdate(createString);
	    stmt.executeUpdate("SET DateStyle TO 'European'");
	    stmt.executeUpdate("insert into ARZTRECHNUNGEN_"+q+"_"+Jahr+" VALUES (1, FALSE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0, '8/1/2001')");
	    con.commit();
	    con.setAutoCommit(true);
	    stmt.close();
	    con.close();
	}
	catch(SQLException ex) {
	    System.err.println("SQLException: " + ex.getMessage());
	}
    }

    public static void ZeigeDB() {
	// Liest die Eintraege aus den Arztrechnungstabellen aus und gibt sie
	// auf der Standardausgabe aus (dient nur zum Ueberpruefen)
	Connection con;
	try { 
	    Class.forName("org.postgresql.Driver");
	} catch(java.lang.ClassNotFoundException e) {
	    System.err.print("ClassNotFoundException: ");
	    System.err.println(e.getMessage());
	}
	
	try {
	  con = DriverManager.getConnection(url, "postgres", "");
	  DatabaseMetaData dbmd = con.getMetaData();
	  String[] tableType = { "TABLE" };
	  ResultSet Tables = dbmd.getTables(null,null,null,tableType);
	  Statement stmt;
	  while(Tables.next()) {
	    stmt = con.createStatement();
	    if (Tables.getString("TABLE_NAME").length() == 21) { 
		String st = Tables.getString("TABLE_NAME");
		System.out.println("Tabellenname: "+st);
		ResultSet rs = stmt.executeQuery("SELECT * FROM "+Tables.getString("TABLE_NAME"));
		ResultSetMetaData rsmd = rs.getMetaData();
		while (rs.next()) {
		    for (int x=1;x<=rsmd.getColumnCount();x++) {
			System.out.print(rsmd.getColumnLabel(x)+"="+rs.getString(x)+" ");
		    }
		    System.out.println("");
		}
		rs.close();
		stmt.close();
	    }
	    
	  }
	  Tables.close();
	  con.close();
	}
	catch(SQLException ex) {
	    System.err.println(ex.getMessage());
	}
    }
    
    public static void InitDB()
	// - bindet den Postgres-Treiber ein, gibt ggf 
	//   ClassNotFoundException zurück.
	// - Baut eine Verbindung zur Datenbank "ChocAn" auf
	// - Löscht den Inhalt der Datenbank und initialisiert die Datenbank
	//   mit den nötigen Tabellen und einigen vordefinierten Einträgen.
	// - Verbindung trennen.
    { ClearDB(); CreateStdLeist();}

    protected void ClearDB() {
	Connection con;
	try { 
	    Class.forName("org.postgresql.Driver");
	} catch(java.lang.ClassNotFoundException e) {
	    System.err.print("ClassNotFoundException: ");
	    System.err.println(e.getMessage());
	}
	
	try {
	  con = DriverManager.getConnection(url, "postgres", "");
	  DatabaseMetaData dbmd = con.getMetaData();
	  String[] tableType = { "TABLE" };
	  ResultSet Tables = dbmd.getTables(null,null,null,tableType);
	  Statement stmt;
	  while(Tables.next()) {
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
    protected void CreateStdLeist() {
	Connection con;
	String createString;
	createString = "create table LEISTUNGEN (LEISTNR INTEGER,  BESCHREIBUNG VARCHAR(50), PREIS FLOAT)";
	Statement stmt;
	try { 
	    Class.forName("org.postgresql.Driver"); }
	catch(java.lang.ClassNotFoundException e) {
	    System.err.print("ClassNotFoundException: ");
	    System.err.println(e.getMessage());
	}
	try {
	    con = DriverManager.getConnection(url, "postgres", "");
	    stmt = con.createStatement();
	    stmt.executeUpdate(createString);
	    
	    // füllen der Tabelle mit vordefinierten Werten
	    stmt.executeUpdate("INSERT INTO LEISTUNGEN VALUES (0815, 'Hände schütteln', 21.83)");
	    stmt.executeUpdate("INSERT INTO LEISTUNGEN VALUES (4711, 'Fett absaugen', 481.65)");
	    stmt.executeUpdate("INSERT INTO LEISTUNGEN VALUES (1583, 'Magen auspumpen', 123.45)");
	    stmt.executeUpdate("INSERT INTO LEISTUNGEN VALUES (9834, 'neues Gebiss', 934.99)");
	    stmt.executeUpdate("INSERT INTO LEISTUNGEN VALUES (2223, 'Pickel ausdrücken', 89.63)");
	    stmt.executeUpdate("INSERT INTO LEISTUNGEN VALUES (3858, 'Hormonbehandlung', 89.63)");
	    stmt.executeUpdate("INSERT INTO LEISTUNGEN VALUES (9999, 'Gehirn OP', 3777.04)");
	    stmt.close();
	    con.close();
	}
	catch(SQLException ex) {
	    System.err.println("SQLException: " + ex.getMessage());
	}
    }
}
