package database;
import java.sql.*;

public class DBChocAn
{

 
    private Connection connection;
    private Statement  statement; 
 
    public void openChocAn() throws SQLException
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

    public void closeChocAn() throws SQLException
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
 

    public  void mitgliedTableCreation() throws Exception
    {
	try
	    {
		String mitgliedTabelle = "CREATE TABLE Mitglied ( nachname VARCHAR(20), vorname  VARCHAR(20), strasse  VARCHAR(25),hausnummer VARCHAR(5),postleitzahl VARCHAR(5), ort VARCHAR(25), telefonnummer VARCHAR(14), bankname VARCHAR(25), blz VARCHAR(15), kontonummer VARCHAR(15), id INTEGER, eintritt DATE, austritt DATE)";

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


    public void mitgliedTableDeletion() throws SQLException
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

    public Mitglied getMitglied(int id) throws Exception
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

	if (r.next()==true)
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
		xyz.setEintritt(r.getDate(12));
		xyz.setAustritt(r.getDate(13));
	
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


    public synchronized void newMitglied(Mitglied xyz) throws Exception 
    { 
    	int id;
	id=genId(); 
	 
	   
	
	xyz.setId(id);  
	try 
	    { 
		openChocAn(); 
    

		statement = connection.createStatement(); 
		String insert = "INSERT into Mitglied values('"+xyz.getNachname()+"','"+xyz.getVorname()+"','"+xyz.getStrasse()+"','"+xyz.getHausnummer()+"','"+xyz.getPostleitzahl()+"','"+xyz.getOrt()+"','"+xyz.getTelefonnummer()+"','"+xyz.getBankname()+"','"+xyz.getBlz()+"','"+xyz.getKontonummer()+"',"+xyz.getId()+","+xyz.getEintritt()+","+xyz.getAustritt()+")"; 
		statement.executeUpdate(insert);  
		statement.close();     
		closeChocAn();    
	    } 

	catch (SQLException err)
	    {
		throw new Exception("NewMitgliedFailedException.");
	    }   
    } 

  
    public void changeMitglied(Mitglied xyz) throws SQLException 
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
 



    public int genId() 
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
}
	

