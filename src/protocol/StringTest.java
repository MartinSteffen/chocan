package protocol;

public class StringTest{
 
  public static boolean stringToTestForDigit(String stringToTest) {
    int length = stringToTest.length();
    
    //Falls die Laenge gleich null, dann ist es ein schlechter String
    if(length==0) {
      return false;
    }
    
    char feld[] = stringToTest.toCharArray();
    int i=0; //Z�hlvariable f�r die while-Schleife
    
    //�berpr�fungsschleife auf unerw�nschte Zahlen im String
    while(i<length) {
      Character getChar = new Character(feld[i]);
      if(getChar.isDigit(feld[i])==true) {
        return false;
      }
      i++;
    }
    
    return true;
  }

} 
