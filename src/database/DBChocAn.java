package database;
import java.sql.*;

public class DBChocAn
{

 
    private static Connection connection;
    private static Statement  statement; 
 
    public static void openChocAn() throws SQLException
    {
     
	try
	    {
		Class.forName("org.postgresql.Driver");
		
		connection = DriverManager.getConnection("jdbc:postgresql://sokrates/"+"ChocAn", "postgres", "");
	    }

     
    
	catch(java.lang.ClassNotFoundException err)
	    {
		System.err.println("ClassNotFoundException: ");
		System.err.println(err.getMessage());
		throw new SQLException("NoDBDriverFound.");
	    }
          
	catch(SQLException err)
	    {
		System.err.println("SQLException: ");
		System.err.println(err.getMessage());
		throw new SQLException("OpenChocAnFailed");
	    }
    }

    public static void closeChocAn() throws SQLException
    {
	try
	    {
		connection.close();
	    }		
	catch(SQLException e)
	    {
		throw new SQLException("CloseChocAnFailed");
	    }
    }
 

    public static void mitgliedTableCreation() throws Exception
    {
	try
	    {
		String mitgliedTabelle = "CREATE TABLE Mitglied ( nachname VARCHAR(20), vorname  VARCHAR(20), strasse  VARCHAR(25),hausnummer VARCHAR(5),postleitzahl VARCHAR(5), ort VARCHAR(25), telefonnummer VARCHAR(14), bankname VARCHAR(25), blz VARCHAR(15), kontonummer VARCHAR(15), id INTEGER, eintritt VARCHAR(10), austritt VARCHAR(10))";

		openChocAn();
		statement = connection.createStatement();
		statement.executeUpdate(mitgliedTabelle);
		statement.close();
		closeChocAn();
	    }
      
	catch (SQLException err)
	    {
		throw new Exception("MitgliedTableCreationFailed.");
	    }     
    }
  public static void medizinerTableCreation() throws Exception
    {
	try
	    {
		String medizinerTabelle = "CREATE TABLE Mediziner ( nachname VARCHAR(20), vorname  VARCHAR(20), strasse  VARCHAR(25),hausnummer VARCHAR(5),postleitzahl VARCHAR(5), ort VARCHAR(25), telefonnummer VARCHAR(14), bankname VARCHAR(25), blz VARCHAR(15), kontonummer VARCHAR(15),id INTEGER, fachrichtung VARCHAR(30))";

		openChocAn();
		statement = connection.createStatement();
		statement.executeUpdate(medizinerTabelle);
		statement.close();
		closeChocAn();
	    }
      
	catch (SQLException err)
	    {
		throw new Exception("MedizinerTableCreationFailed.");
	    }     
    }


    public static void mitgliedTableDeletion() throws SQLException
    {
	try
	    {
		String delete = "DROP TABLE Mitglied";
		openChocAn();
		statement = connection.createStatement();
		statement.executeUpdate(delete);
		statement.close();
		closeChocAn();
	    }
	catch(Exception err)
	    {
		throw new SQLException("MitgliedTableDeletionFailed.");
	    }
    }

    public static void medizinerTableDeletion() throws SQLException
    {
	try
	    {
		String delete = "DROP TABLE Mediziner";
		openChocAn();
		statement = connection.createStatement();
		statement.executeUpdate(delete);
		statement.close();
		closeChocAn();
	    }
	catch(Exception err)
	    {
		throw new SQLException("MedizinerTableDeletionFailed.");
	    }
    }

    public static Mitglied getMitglied(int id) throws Exception
    {
	String findbyid = "SELECT * FROM Mitglied WHERE id = "+id;
 	
	ResultSet r=null;
	statement=null;
	
	try
	    {
		openChocAn();
		statement=connection.createStatement();
		r=statement.executeQuery(findbyid);
	    }
	
	catch (Exception err)
	    {
		System.out.println(err.getMessage());
		throw new Exception("GetMitgliedFailedException");
	    }

	if (r.next())
	    {
		Mitglied xyz = new Mitglied();
		xyz.setNachname(r.getString(1));
		xyz.setVorname(r.getString(2));
		xyz.setStrasse(r.getString(3));
		xyz.setHausnummer(r.getString(4));
		xyz.setPostleitzahl(r.getString(5));
		xyz.setOrt(r.getString(6));
		xyz.setTelefonnummer(r.getString(7));
		xyz.setBankname(r.getString(8));
		xyz.setBlz(r.getString(9));
		xyz.setKontonummer(r.getString(10));
		xyz.setId(r.getInt(11));
		xyz.setEintritt(r.getString(12));
		xyz.setAustritt(r.getString(13));
	
		statement.close();
		closeChocAn();
		return xyz;
	    }
	
	else 
	    {
		statement.close();
		closeChocAn();
		return null;
	    }
    }
 public static Mediziner getMediziner(int id) throws Exception
    {
	String findbyid = "SELECT * FROM Mediziner WHERE id = "+id;
 	
	ResultSet r=null;
	statement=null;
	
	try
	    {
		openChocAn();
		statement=connection.createStatement();
		r=statement.executeQuery(findbyid);
	    }
	
	catch (Exception err)
	    {
		System.out.println(err.getMessage());
		throw new Exception("GetMedizinerFailedException");
	    }

	if (r.next())
	    {
		Mediziner xyz = new Mediziner();
		xyz.setNachname(r.getString(1));
		xyz.setVorname(r.getString(2));
		xyz.setStrasse(r.getString(3));
		xyz.setHausnummer(r.getString(4));
		xyz.setPostleitzahl(r.getString(5));
		xyz.setOrt(r.getString(6));
		xyz.setTelefonnummer(r.getString(7));
		xyz.setBankname(r.getString(8));
		xyz.setBlz(r.getString(9));
		xyz.setKontonummer(r.getString(10));
		xyz.setId(r.getInt(11));
		xyz.setFachrichtung(r.getString(12));
	
		statement.close();
		closeChocAn();
		return xyz;
	    }
	
	else 
	    {
		statement.close();
		closeChocAn();
		return null;
	    }
    }


    public static synchronized void newMitglied(Mitglied xyz) throws Exception 
    { 
    	int id;
	id=genMitgliedId(); 
	System.out.println("Id generated"); 
	   
	
	xyz.setId(id);  
	try 
	    { 
		openChocAn(); 
    	System.out.println("Database opened ");

		statement = connection.createStatement(); 
	System.out.println("statement created ");
		String insert = "INSERT into Mitglied values('"+xyz.getNachname()+"','"+xyz.getVorname()+"','"+xyz.getStrasse()+"','"+xyz.getHausnummer()+"','"+xyz.getPostleitzahl()+"','"+xyz.getOrt()+"','"+xyz.getTelefonnummer()+"','"+xyz.getBankname()+"','"+xyz.getBlz()+"','"+xyz.getKontonummer()+"',"+xyz.getId()+","+xyz.getEintritt()+","+xyz.getAustritt()+")"; 
	System.out.println("String generated ");
		statement.executeUpdate(insert);
	System.out.println("wrote to DB ");  
		statement.close();     
	System.out.println("Statement dismissed ");
		closeChocAn();    
	System.out.println("DB closed ");
	System.out.println("All good!! ");
	    } 

	catch (SQLException err)
	    {
	System.out.println(err);
		throw new Exception("NewMitgliedFailedException.");
	    }   
    } 
 public static synchronized void newMediziner(Mediziner xyz) throws Exception 
    { 
    	int id;
	id=genMedizinerId(); 
	 
	   
	
	xyz.setId(id);  
	try 
	    { 
		openChocAn(); 
    

		statement = connection.createStatement(); 
		String insert = "INSERT into Mediziner values('"+xyz.getNachname()+"','"+xyz.getVorname()+"','"+xyz.getStrasse()+"','"+xyz.getHausnummer()+"','"+xyz.getPostleitzahl()+"','"+xyz.getOrt()+"','"+xyz.getTelefonnummer()+ "','"+xyz.getBankname()+"','"+xyz.getBlz()+"','"+xyz.getKontonummer()+"',"+xyz.getId()+","+xyz.getFachrichtung()+")";  
 		statement.executeUpdate(insert);  
		statement.close();      		
		closeChocAn();    
	    } 

	catch (SQLException err)
	    {
		throw new Exception("NewMedizinerFailedException.");
	    }   
    } 

  
    public static void changeMitglied(Mitglied xyz) throws SQLException 
    { 
	String change = 
	"UPDATE Mitglied SET nachname='"+xyz.getNachname()+
	"', vorname='"+xyz.getVorname()+
	"', strasse='"+xyz.getStrasse()+
	"', hausnummer='"+xyz.getHausnummer()+
	"', postleitzahl='"+xyz.getPostleitzahl()+
	"', ort='"+xyz.getOrt()+
	"', telefonnummer='"+xyz.getTelefonnummer()+
	"', bankname='"+xyz.getBankname()+
	"', blz='"+xyz.getBlz()+
	"', kontonummer='"+xyz.getKontonummer()+
	"', eintritt="+xyz.getEintritt()+
	", austritt="+xyz.getAustritt()+
	" WHERE  id= "+xyz.getId()+""; 
 
	openChocAn(); 
	statement = connection.createStatement(); 
 
	if (statement.executeUpdate(change)!=1) 
	    throw new SQLException("ChangeMitgliedFailedException");
	statement.close(); 
	closeChocAn(); 
    } 
 
 public static void changeMediziner(Mediziner xyz) throws SQLException 
    { 
	String change = 
	"UPDATE Mitglied SET nachname='"+xyz.getNachname()+
	"', vorname='"+xyz.getVorname()+
	"', strasse='"+xyz.getStrasse()+
	"', hausnummer='"+xyz.getHausnummer()+
	"', postleitzahl='"+xyz.getPostleitzahl()+
	"', ort='"+xyz.getOrt()+
	"', telefonnummer='"+xyz.getTelefonnummer()+
	"', bankname='"+xyz.getBankname()+
	"', blz='"+xyz.getBlz()+
	"', kontonummer='"+xyz.getKontonummer()+
	"', fachrichtung="+xyz.getFachrichtung()+
	
	" WHERE  id= "+xyz.getId()+""; 
 
	openChocAn(); 
	statement = connection.createStatement(); 
 
	if (statement.executeUpdate(change)!=1) 
	    throw new SQLException("ChangeMedizinerFailedException");
	statement.close(); 
	closeChocAn(); 
    } 


    public static int genMitgliedId() 
    {
	int newid=1;
	String findbyid = "SELECT id FROM Mitglied";
	ResultSet r=null;
	statement=null;
	try{
		openChocAn();
		statement = connection.createStatement();
		r=statement.executeQuery(findbyid);   
		while(r.next())
	    		{
			newid=r.getInt("id");	
			newid++;
		
			}
	   
	statement.close();
	closeChocAn();
	}
	catch (SQLException err)
	    {
		System.out.println(err); 
	    }   
    
	return newid;	
    }
 public static int genMedizinerId() 
    {
	int newid=1;
	String findbyid = "SELECT id FROM Mediziner";
	ResultSet r=null;
	statement=null;
	try{
		openChocAn();
		statement = connection.createStatement();
		r=statement.executeQuery(findbyid);   
		while(r.next())
	    		{
			newid=r.getInt("id");	
			newid++;
		
			}
	   
	statement.close();
	closeChocAn();
	}
	catch (SQLException err)
	    {
		System.out.println(err); 
	    }   
    
	return newid;	
    }

}
	

