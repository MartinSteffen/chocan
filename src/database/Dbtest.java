package database;
import java.sql.*;
public class Dbtest{

  public static void main (String[] args ){

    
    Mitglied xyz;
    xyz = new Mitglied();
    try {DBChocAn.mitgliedTableDeletion();}
    catch ( SQLException err ){System.out.println(err); }
    try {DBChocAn.mitgliedTableCreation();}
    catch ( Exception err ){System.out.println(err); }
    xyz.setNachname("Wurst");
    xyz.setVorname("Hans");
    xyz.setStrasse("Dummweech");
    xyz.setHausnummer("13");
    xyz.setPostleitzahl("0815");
    xyz.setOrt("Schildburg");
    xyz.setTelefonnummer("555 Schuh");
    xyz.setBankname("Raffzahn&Gier");
    xyz.setBlz("666");
    xyz.setKontonummer("0001");
	xyz.setEintritt("01.01.01");  xyz.setAustritt("01.01.01");   	
	 Mitglied him1 = new database.Mitglied();
	
try {DBChocAn.newMitglied(xyz);}
catch ( Exception err) { System.out.println(err); }
	
try {DBChocAn.newMitglied(xyz);}
catch ( Exception err) { System.out.println(err); }
	
try {DBChocAn.newMitglied(xyz);}
catch ( Exception err) { System.out.println(err); }


try {him1 = DBChocAn.getMitglied(1);}
catch ( Exception err ) {System.out.println(err);}
System.out.println(him1.getNachname());
System.out.println(him1.getVorname()); 
System.out.println(him1.getId());
System.out.println(him1.getBankname());
try {him1 = DBChocAn.getMitglied(2);}
catch ( Exception err ) {System.out.println(err);}
System.out.println(him1.getNachname());
System.out.println(him1.getVorname()); 
System.out.println(him1.getId());
System.out.println(him1.getBankname());
try {him1 = DBChocAn.getMitglied(3);}
catch ( Exception err ) {System.out.println(err);}
System.out.println(him1.getNachname());
System.out.println(him1.getVorname()); 
System.out.println(him1.getId());
System.out.println(him1.getBankname());

	xyz.setBankname("KKB BANK");
try {DBChocAn.changeMitglied(xyz);}
catch ( Exception err) { System.out.println(err); }

try {him1 = DBChocAn.getMitglied(3);}
catch ( Exception err ) {System.out.println(err);}
System.out.println(him1.getNachname());
System.out.println(him1.getVorname()); 
System.out.println(him1.getId());
System.out.println(him1.getBankname());



}}
