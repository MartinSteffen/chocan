package database;
public class Mitglied extends Person
{
    protected int id;
    protected Date eintritt;
    protected Date austritt;
    
    public void setEintritt    (Date   d) { eintritt=d; }
    public Date getEintritt    ()         { return eintritt;}
    
    public void setAustritt    (Date   d) { austritt=d; }
    public Date getAustritt    ()         { return austritt;}
    
    public Mitglied() {id=-1;} 
    
    public void setId(int i)
    {
	id=i;
    }
    public int getId() {return id;}
}

