package database;
import java.util.Date;

public class Mitglied extends Person
{
    protected int id;
    protected String eintritt;
    protected String austritt;
    
    public void setEintritt    (String   d) { eintritt=d; }
    public String getEintritt    ()         { return eintritt;}
    
    public void setAustritt    (String   d) { austritt=d; }
    public String getAustritt    ()         { return austritt;}
    
    public Mitglied() {id=-1;} 
    
    public void setId(int i)
    {
	id=i;
    }
    public int getId() {return id;}
}

