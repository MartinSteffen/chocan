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
    Character getChar = new Character(feld[i]);
    
    //�berpr�fungsschleife auf unerw�nschte Zahlen im String
    //Wenn Digits im String vorhanden sind, dann wird i nicht bis
    //length hochgezaehlt, sondern bleibt kleiner
    while(i<length && getChar.isDigit(feld[i])==false) { 
      i++;
    }
    
    if(i<length) return false;
    else return true;
  }

} 
