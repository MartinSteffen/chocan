package database;
import java.util.Date;
public class Mediziner extends Person
{
    protected int id;
    protected String fachrichtung;
    
    public void setFachrichtung (String s) throws Exception
	{ if (s.length()>30) throw new Exception("StringToLong.");
	fachrichtung = s;}
    public String getFachrichtung () { return fachrichtung;}
   
    public Mediziner() {id=-1;} 
    
    public void setId(int i)
    {
	id=i;
    }
    public int getId() {return id;}
}

