package database;
public abstract class Person
{ 
  protected  int[] maxima = { 20,20,25,5,5,25,14,25,15,15 };
  protected String nachname; 
  protected String vorname;
  protected String strasse;
  protected String hausnummer;
  protected String postleitzahl;
  protected String ort;
  protected String telefonnummer;
  protected String bankname;
    protected String blz;
    protected String kontonummer;
    
    protected void checkString (String s, int max) throws Exception
    {
	if (s.length()>maxima[max]) throw new Exception("StringToLong."); 
    } 
	
    public boolean setNachname (String s) 
    { 
	try { checkString(s,0); }
	catch(Exception err){return false;}
	nachname=s;
	return true;
    }

    public boolean setVorname (String s) 
    { 
	try { checkString(s,1) ;}
	catch(Exception err){return false;}
	vorname=s;
	return true;
    }
    public boolean setStrasse (String s) 
    { 
	try { checkString(s,2); }
	catch(Exception err){return false;}
	strasse=s;
	return true;
    }
    
    public boolean setHausnummer(String s) 
    { 
	try { checkString(s,3); }
	catch(Exception err){return false;}
	hausnummer=s;
	return true;
    }
    public boolean setPostleitzahl (String s) 
    { 
	try { checkString(s,4); }
	catch(Exception err){return false;}
	postleitzahl=s;
	return true;
    }
    
    public boolean setOrt(String s) 
    { 
	try { checkString(s,5); }
	catch(Exception err){return false;}
	ort=s;
	return true; 
    } 
    public boolean setTelefonnummer (String s) 
    { 
	try { checkString(s,6) ;}
	catch(Exception err){return false;}
	telefonnummer=s;
	return true;
    }
    public boolean setBankname(String s) 
    { 
	try { checkString(s,7); }
	catch(Exception err){return false;}
	bankname=s;
	return true;
    }
    public boolean setBlz(String s) 
    { 
	try { checkString(s,8); }
	catch(Exception err){return false;}
	blz=s;
	return true;
    }
    public boolean setKontonummer(String s) 
    { 
	try { checkString(s,9); }
	catch(Exception err){return false;}
	kontonummer=s;
	return true;
    }

    public String getNachname      ()         { return nachname;      }
    public String getVorname       ()         { return vorname;       }
    public String getStrasse       ()         { return strasse;       }
    public String getHausnummer    ()         { return hausnummer;    }
    public String getOrt           ()         { return ort;           }
  public String getPostleitzahl (){ return postleitzahl;}
  public String getTelefonnummer ()         { return telefonnummer; }
    public String getBankname      ()         { return bankname  ;    }
    public String getBlz           ()         { return blz ;          }
    public String getKontonummer   ()         { return kontonummer;   }
    
}

