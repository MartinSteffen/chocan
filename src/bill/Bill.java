/**
*@author Gunnar Schaefer
*
*This class provides doctors with a graphical interface to enter,
*process and archive their bills.
*/

import java.lang.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
//import database.*;


public class Bill extends JFrame {
  public Bill() {
   setTitle("Arzt-Rechnung");
    setSize(750,600);
    getContentPane().setLayout(null);
    initComponents();
    }

  private void initComponents() {
    txtDocNum = new JTextField();
    lblDocNum = new JLabel();
    lblDocName = new JLabel();
    lblDocStreet = new JLabel();
    lblDocZipAndCity = new JLabel();
    txtDocNum.grabFocus();

    txtPatientNum = new JTextField();
    lblPatientNum = new JLabel();
    lblPatientName = new JLabel();
    lblPatientStreet = new JLabel();
    lblPatientZipAndCity = new JLabel();

    txtDay = new JTextField();
    txtMonth = new JTextField();
    txtYear = new JTextField();
    lblTreatDate = new JLabel();

    lblTreatCodes = new JLabel();
    txtTreatCode1 = new JTextField();
    txtTreatCode2 = new JTextField();
    txtTreatCode3 = new JTextField();
    txtTreatCode4 = new JTextField();
    txtTreatCode5 = new JTextField();
    txtTreatCode6 = new JTextField();
    txtTreatCode7 = new JTextField();

    lblTreatDescripts = new JLabel();
    lblTreatDescript1 = new JLabel();
    lblTreatDescript2 = new JLabel();
    lblTreatDescript3 = new JLabel();
    lblTreatDescript4 = new JLabel();
    lblTreatDescript5 = new JLabel();
    lblTreatDescript6 = new JLabel();
    lblTreatDescript7 = new JLabel();

    lblTreatCosts = new JLabel();
    lblTreatCost1 = new JLabel();
    lblTreatCost2 = new JLabel();
    lblTreatCost3 = new JLabel();
    lblTreatCost4 = new JLabel();
    lblTreatCost5 = new JLabel();
    lblTreatCost6 = new JLabel();
    lblTreatCost7 = new JLabel();

    btnSum = new JButton();
    lblSum = new JLabel();

    
    btnClear = new JButton();
    btnStore = new JButton();

    lblStatus = new JLabel();

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        exitForm(evt);
      }
    }
    );


    txtDocNum.addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent evt) {
        getDocInfo(evt);
      }
    }
    );

    txtDocNum.setToolTipText("Geben Sie hier die Arztnummer ein.");
    getContentPane().add(txtDocNum);
    txtDocNum.setBounds(20, 10, 140, 30);

    lblDocNum.setText("Arztnummer");
    getContentPane().add(lblDocNum);
    lblDocNum.setLocation(20, 40);
    lblDocNum.setSize(lblDocNum.getPreferredSize());

    lblDocName.setText("<Arztname>");
    getContentPane().add(lblDocName);
    lblDocName.setBounds(20, 80, 230, 20);

    getContentPane().add(lblDocStreet);
    lblDocStreet.setBounds(20, 100, 230, 20);

    getContentPane().add(lblDocZipAndCity);
    lblDocZipAndCity.setBounds(20, 120, 230, 20);


    txtPatientNum.addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent evt) {
        getPatientInfo(evt);
      }
    }
    );

    txtPatientNum.setToolTipText("Geben Sie hier die Patientennummer ein.");
    getContentPane().add(txtPatientNum);
    txtPatientNum.setBounds(310, 10, 130, 30);

    lblPatientNum.setText("Patientennummer");
    getContentPane().add(lblPatientNum);
    lblPatientNum.setLocation(310, 40);
    lblPatientNum.setSize(lblPatientNum.getPreferredSize());

    lblPatientName.setText("<Patientenname>");
    getContentPane().add(lblPatientName);
    lblPatientName.setBounds(310, 80, 230, 20);

    getContentPane().add(lblPatientStreet);
    lblPatientStreet.setBounds(310, 100, 230, 20);

    getContentPane().add(lblPatientZipAndCity);
    lblPatientZipAndCity.setBounds(310, 120, 230, 20);


    

    txtDay.addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent evt) {
        checkDay(evt);
      }
    }
    );

    txtDay.setToolTipText("TT");
    getContentPane().add(txtDay);
    txtDay.setBounds(600, 10, 30, 30);


    txtMonth.addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent evt) {
        checkMonth(evt);
      }
    }
    );

    txtMonth.setToolTipText("MM");
    getContentPane().add(txtMonth);
    txtMonth.setBounds(630, 10, 30, 30);


    txtYear.addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent evt) {
        checkYear(evt);
      }
    }
    );

    txtYear.setToolTipText("JJJJ");
    getContentPane().add(txtYear);
    txtYear.setBounds(660, 10, 40, 30);


    lblTreatDate.setText("Behandlungsdatum");
    getContentPane().add(lblTreatDate);
    lblTreatDate.setLocation(600, 40);
    lblTreatDate.setSize(lblTreatDate.getPreferredSize());


    lblTreatCodes.setText("Behandlungs-Codes");
    getContentPane().add(lblTreatCodes);
    lblTreatCodes.setLocation(20, 220);
    lblTreatCodes.setSize(lblTreatCodes.getPreferredSize());

    txtTreatCode1.addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent evt) {
        getTreatInfo1(evt);
      }
    }
    );
    getContentPane().add(txtTreatCode1);
    txtTreatCode1.setBounds(20, 240, 70, 30);

    txtTreatCode2.addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent evt) {
        getTreatInfo2(evt);
      }
    }
    );
    getContentPane().add(txtTreatCode2);
    txtTreatCode2.setBounds(20, 270, 70, 30);

    txtTreatCode3.addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent evt) {
        getTreatInfo3(evt);
      }
    }
    );
    getContentPane().add(txtTreatCode3);
    txtTreatCode3.setBounds(20, 300, 70, 30);

    txtTreatCode4.addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent evt) {
        getTreatInfo4(evt);
      }
    }
    );
    getContentPane().add(txtTreatCode4);
    txtTreatCode4.setBounds(20, 330, 70, 30);

    txtTreatCode5.addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent evt) {
        getTreatInfo5(evt);
      }
    }
    );
    getContentPane().add(txtTreatCode5);
    txtTreatCode5.setBounds(20, 360, 70, 30);

    txtTreatCode6.addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent evt) {
        getTreatInfo6(evt);
      }
    }
    );
    getContentPane().add(txtTreatCode6);
    txtTreatCode6.setBounds(20, 390, 70, 30);

    txtTreatCode7.addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent evt) {
        getTreatInfo7(evt);
      }
    }
    );
    getContentPane().add(txtTreatCode7);
    txtTreatCode7.setBounds(20, 420, 70, 30);


    lblTreatDescripts.setText("Behandlungs-Beschreibungen");
    getContentPane().add(lblTreatDescripts);
    lblTreatDescripts.setLocation(180, 220);
    lblTreatDescripts.setSize(lblTreatDescripts.getPreferredSize());

    getContentPane().add(lblTreatDescript1);
    lblTreatDescript1.setBounds(180, 250, 290, 20);

    getContentPane().add(lblTreatDescript2);
    lblTreatDescript2.setBounds(180, 280, 290, 20);

    getContentPane().add(lblTreatDescript3);
    lblTreatDescript3.setBounds(180, 310, 290, 20);

    getContentPane().add(lblTreatDescript4);
    lblTreatDescript4.setBounds(180, 340, 290, 20);

    getContentPane().add(lblTreatDescript5);
    lblTreatDescript5.setBounds(180, 370, 290, 20);

    getContentPane().add(lblTreatDescript6);
    lblTreatDescript6.setBounds(180, 400, 290, 20);

    getContentPane().add(lblTreatDescript7);
    lblTreatDescript7.setBounds(180, 430, 290, 20);


    lblTreatCosts.setText("Behandlungs-Preise");
    getContentPane().add(lblTreatCosts);
    lblTreatCosts.setLocation(535, 220);
    lblTreatCosts.setSize(lblTreatCosts.getPreferredSize());

    getContentPane().add(lblTreatCost1);
    lblTreatCost1.setBounds(610, 250, 60, 20);
    lblTreatCost1.setHorizontalAlignment(SwingConstants.RIGHT);

    getContentPane().add(lblTreatCost2);
    lblTreatCost2.setBounds(610, 280, 60, 20);
    lblTreatCost2.setHorizontalAlignment(SwingConstants.RIGHT);

    getContentPane().add(lblTreatCost3);
    lblTreatCost3.setBounds(610, 310, 60, 20);
    lblTreatCost3.setHorizontalAlignment(SwingConstants.RIGHT);

    getContentPane().add(lblTreatCost4);
    lblTreatCost4.setBounds(610, 340, 60, 20);
    lblTreatCost4.setHorizontalAlignment(SwingConstants.RIGHT);

    getContentPane().add(lblTreatCost5);
    lblTreatCost5.setBounds(610, 370, 60, 20);
    lblTreatCost5.setHorizontalAlignment(SwingConstants.RIGHT);

    getContentPane().add(lblTreatCost6);
    lblTreatCost6.setBounds(610, 400, 60, 20);
    lblTreatCost6.setHorizontalAlignment(SwingConstants.RIGHT);

    getContentPane().add(lblTreatCost7);
    lblTreatCost7.setBounds(610, 430, 60, 20);
    lblTreatCost7.setHorizontalAlignment(SwingConstants.RIGHT);


    btnSum.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        calculateSum(evt);
      }
    }
    );

    btnSum.setText("Summe");
    getContentPane().add(btnSum);
    btnSum.setLocation(470, 470);
    btnSum.setSize(btnSum.getPreferredSize());

    getContentPane().add(lblSum);
    lblSum.setBounds(610, 470, 60, 20);
    lblSum.setHorizontalAlignment(SwingConstants.RIGHT);


    btnClear.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        clearForm(evt);
      }
    }
    );

    btnClear.setText("Löschen");
    getContentPane().add(btnClear);
    btnClear.setLocation(160, 510);
    btnClear.setSize(btnClear.getPreferredSize());


    btnStore.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        storeForm(evt);
      }
    }
    );

    btnStore.setText("Speichern");
    getContentPane().add(btnStore);
    btnStore.setLocation(280, 510);
    btnStore.setSize(btnStore.getPreferredSize());


    lblStatus.setText("Status:");
    getContentPane().add(lblStatus);
    lblStatus.setBounds(20, 550, 520, 20);


    

  }//end of initComponents




  private void getDocInfo(FocusEvent evt) {
    if(flag == false) {
      try {
        docNum = Long.parseLong(txtDocNum.getText());
      } catch (NumberFormatException ex) {
          lblStatus.setText("Status: ungültige Arztnummer");
          txtDocNum.setText("");
          txtDocNum.grabFocus();
          return;
        }
      // Objekt der Klasse Mediziner instanziieren mit Parameter docNum
      // Mediziner einArzt = new Mediziner(docNum);
      // lblArztname.setText( einArzt.getNachname() );
      lblStatus.setText("Status:");
      lblDocName.setText("Peter" + " " + "Logen-Zack");
      lblDocStreet.setText("Hauptstraße" + " " + "13");
      lblDocZipAndCity.setText("23455" + " " + "Virginia Beach");
    }
    flag = false;
  }


  private void getPatientInfo(FocusEvent evt) {
    if(flag == false) {
      try {
        patientNum = Long.parseLong(txtPatientNum.getText());
      } catch (NumberFormatException ex) {
          lblStatus.setText("Status: ungültige Patientennummer");
          txtPatientNum.setText("");
          txtPatientNum.grabFocus();
          return;
        }
      // Objekt der Klasse Mitglied instanziieren mit Parameter patientNum
      // Mitglied einPatient = new Mitglied (patientNum);
      // lblPatientenname.setText( einPatient.getNachname() );
      lblStatus.setText("Status:");
      lblPatientName.setText("Detlev" + " " + "Breithanst");
      lblPatientStreet.setText("Nebenstraße" + " " + "12");
      lblPatientZipAndCity.setText("90210" + " " + "Beverly Hills");
    }
    flag = false;
  }


  private void checkDay(FocusEvent evt) {
    if(flag == false) {
      try {
        day = Integer.parseInt(txtDay.getText());
      } catch (NumberFormatException ex) {
          lblStatus.setText("Status: ungültiger Tag");
          txtDay.setText("");
          txtDay.grabFocus();
          return;
        }
      if (day > 31 || day < 1) {
        lblStatus.setText("Status: ungültiger Tag");
        txtDay.setText("");
        txtDay.grabFocus();
        return;
      }
      lblStatus.setText("Status:");
    }
    flag = false;
  }


  private void checkMonth(FocusEvent evt) {
    if(flag == false) {
      try {
        month = Integer.parseInt(txtMonth.getText());
      } catch (NumberFormatException e) {
          lblStatus.setText("Status: ungültiger Monat");
          txtMonth.setText("");
          txtMonth.grabFocus();
          return;
        }
      if (month > 12 || month < 1) {
        lblStatus.setText("Status: ungültiger Monat");
        txtMonth.setText("");
        txtMonth.grabFocus();
        return;
      }
      lblStatus.setText("Status:");
    }
    flag = false;
  }


  private void checkYear(FocusEvent evt) {
    if(flag == false) {
      try {
        year = Integer.parseInt(txtYear.getText());
      } catch (NumberFormatException e) {
          lblStatus.setText("Status: ungültiges Jahr");
          txtYear.setText("");
          txtYear.grabFocus();
          return;
        }
      if (year > 2100 || year < 1900) {
        lblStatus.setText("Status: ungültiges Jahr");
        txtYear.setText("");
        txtYear.grabFocus();
        return;
      }
      lblStatus.setText("Status:");
      
      treatDate = new GregorianCalendar(year,month-1,day);
      GregorianCalendar currentDate = new GregorianCalendar();
      if (treatDate.after(currentDate)) {
        lblStatus.setText("Status: ungültiges Datum");
        txtDay.setText("");
        txtMonth.setText("");
        txtYear.setText("");
        txtDay.grabFocus();
      }
    }
    flag = false;
  }


  private void getTreatInfo1(FocusEvent evt) {
    if(flag == false) {
      try {
        treatCode1 = Long.parseLong(txtTreatCode1.getText());
      } catch (NumberFormatException ex) {
        }
      Standardleistungen S = new Standardleistungen(treatCode1);
      if (S.GetBeschreibung() == "") {
      	lblStatus.setText("Status: ungültige Behandlungsnummer");
        txtTreatCode1.setText("");
        txtTreatCode1.grabFocus();
      }
      else {
        lblTreatDescript1.setText(S.GetBeschreibung());
        lblTreatCost1.setText(Float.toString(S.GetPreis()));
      	lblStatus.setText("Status:");
      }
    }
    flag = false;
  }


  private void getTreatInfo2(FocusEvent evt) {
    if(flag == false) {
      try {
        treatCode2 = Long.parseLong(txtTreatCode2.getText());
      } catch (NumberFormatException ex) {
        }
      Standardleistungen S = new Standardleistungen(treatCode2);
      if (S.GetBeschreibung() == "") {
      	lblStatus.setText("Status: ungültige Behandlungsnummer");
        txtTreatCode2.setText("");
        txtTreatCode2.grabFocus();
      }
      else {
        lblTreatDescript2.setText(S.GetBeschreibung());
        lblTreatCost2.setText(Float.toString(S.GetPreis()));
      	lblStatus.setText("Status:");
      }
    }
    flag = false;
  }


  private void getTreatInfo3(FocusEvent evt) {
    if(flag == false) {
      try {
        treatCode3 = Long.parseLong(txtTreatCode3.getText());
      } catch (NumberFormatException ex) {
        }
      Standardleistungen S = new Standardleistungen(treatCode3);
      if (S.GetBeschreibung() == "") {
      	lblStatus.setText("Status: ungültige Behandlungsnummer");
        txtTreatCode3.setText("");
        txtTreatCode3.grabFocus();
      }
      else {
        lblTreatDescript3.setText(S.GetBeschreibung());
        lblTreatCost3.setText(Float.toString(S.GetPreis()));
      	lblStatus.setText("Status:");
      }
    }
    flag = false;
  }


  private void getTreatInfo4(FocusEvent evt) {
    if(flag == false) {
      try {
        treatCode4 = Long.parseLong(txtTreatCode4.getText());
      } catch (NumberFormatException ex) {
        }
      Standardleistungen S = new Standardleistungen(treatCode4);
      if (S.GetBeschreibung() == "") {
      	lblStatus.setText("Status: ungültige Behandlungsnummer");
        txtTreatCode4.setText("");
        txtTreatCode4.grabFocus();
      }
      else {
        lblTreatDescript4.setText(S.GetBeschreibung());
        lblTreatCost4.setText(Float.toString(S.GetPreis()));
      	lblStatus.setText("Status:");
      }
    }
    flag = false;
  }


  private void getTreatInfo5(FocusEvent evt) {
    if(flag == false) {
      try {
        treatCode5 = Long.parseLong(txtTreatCode5.getText());
      } catch (NumberFormatException ex) {
        }
      Standardleistungen S = new Standardleistungen(treatCode5);
      if (S.GetBeschreibung() == "") {
      	lblStatus.setText("Status: ungültige Behandlungsnummer");
        txtTreatCode5.setText("");
        txtTreatCode5.grabFocus();
      }
      else {
        lblTreatDescript5.setText(S.GetBeschreibung());
        lblTreatCost5.setText(Float.toString(S.GetPreis()));
      	lblStatus.setText("Status:");
      }
    }
    flag = false;
  }


  private void getTreatInfo6(FocusEvent evt) {
    if(flag == false) {
      try {
        treatCode6 = Long.parseLong(txtTreatCode6.getText());
      } catch (NumberFormatException ex) {
        }
      Standardleistungen S = new Standardleistungen(treatCode6);
      if (S.GetBeschreibung() == "") {
      	lblStatus.setText("Status: ungültige Behandlungsnummer");
        txtTreatCode6.setText("");
        txtTreatCode6.grabFocus();
      }
      else {
        lblTreatDescript6.setText(S.GetBeschreibung());
        lblTreatCost6.setText(Float.toString(S.GetPreis()));
      	lblStatus.setText("Status:");
      }
    }
    flag = false;
  }


  private void getTreatInfo7(FocusEvent evt) {
    if(flag == false) {
      try {
        treatCode7 = Long.parseLong(txtTreatCode7.getText());
      } catch (NumberFormatException ex) {
        }
      Standardleistungen S = new Standardleistungen(treatCode7);
      if (S.GetBeschreibung() == "") {
      	lblStatus.setText("Status: ungültige Behandlungsnummer");
        txtTreatCode7.setText("");
        txtTreatCode7.grabFocus();
      }
      else {
        lblTreatDescript7.setText(S.GetBeschreibung());
        lblTreatCost7.setText(Float.toString(S.GetPreis()));
      	lblStatus.setText("Status:");
      }
    }
    flag = false;
  }


  private void calculateSum(MouseEvent evt) {
    flag = true;

    try {
      sum  = Float.parseFloat(lblTreatCost1.getText());
      sum += Float.parseFloat(lblTreatCost2.getText());
      sum += Float.parseFloat(lblTreatCost3.getText());
      sum += Float.parseFloat(lblTreatCost4.getText());
      sum += Float.parseFloat(lblTreatCost5.getText());
      sum += Float.parseFloat(lblTreatCost6.getText());
      sum += Float.parseFloat(lblTreatCost7.getText());
    } catch (NumberFormatException ex) {
      }
      
    sum = (float) Math.round(sum * 100) / 100;
    lblSum.setText(Float.toString(sum));

    lblStatus.setText("Status:");
    btnSum.grabFocus();    
    flag = false;
  }


  private void clearForm(MouseEvent evt) {
    flag = true;

    txtDocNum.setText("");
    lblDocName.setText("<Arztname>");
    lblDocStreet.setText("");
    lblDocZipAndCity.setText("");
    txtPatientNum.setText("");
    lblPatientName.setText("<Patientenname");
    lblPatientStreet.setText("");
    lblPatientZipAndCity.setText("");
    txtDay.setText("");
    txtMonth.setText("");
    txtYear.setText("");
    txtTreatCode1.setText("");
    lblTreatDescript1.setText("");
    lblTreatCost1.setText("");
    txtTreatCode2.setText("");
    lblTreatDescript2.setText("");
    lblTreatCost2.setText("");
    txtTreatCode3.setText("");
    lblTreatDescript3.setText("");
    lblTreatCost3.setText("");
    txtTreatCode4.setText("");
    lblTreatDescript4.setText("");
    lblTreatCost4.setText("");
    txtTreatCode5.setText("");
    lblTreatDescript5.setText("");
    lblTreatCost5.setText("");
    txtTreatCode6.setText("");
    lblTreatDescript6.setText("");
    lblTreatCost6.setText("");
    txtTreatCode7.setText("");
    lblTreatDescript7.setText("");
    lblTreatCost7.setText("");
    lblSum.setText("");
    lblStatus.setText("Status:");

    txtDocNum.grabFocus();
    flag = false;
  }


  private void storeForm(MouseEvent evt) {
    flag = true;

    Rechnungen R = new Rechnungen();  //Objekt instanziieren

    R.SetArztNr(docNum);  //Felder füllen
    R.SetVersNr(patientNum);
    R.SetRechnDatum(treatDate);
    R.SetLeistX(0, treatCode1);
    R.SetLeistX(1, treatCode2);
    R.SetLeistX(2, treatCode3);
    R.SetLeistX(3, treatCode4);
    R.SetLeistX(4, treatCode5);
    R.SetLeistX(5, treatCode6);
    R.SetLeistX(6, treatCode7);
    R.SetBetrag(sum);

    R.Neu();  //Rechnung speichern

    lblStatus.setText("Rechnungs-Nummer: " + R.GetLaufNr());
    btnStore.grabFocus();    
    flag = false;
  }


  private void exitForm(WindowEvent evt) {
    //    ZeigeDB();
    System.exit (0);
  }


  public static void main(String args[]) {
    new Bill().show();
  }


  // Variables declaration
  private JTextField txtDocNum;
  private JLabel lblDocName;
  private JLabel lblDocNum;
  private JLabel lblDocStreet;
  private JLabel lblDocZipAndCity;
  private JTextField txtPatientNum;
  private JLabel lblPatientName;
  private JLabel lblPatientNum;
  private JLabel lblPatientStreet;
  private JLabel lblPatientZipAndCity;
  private JTextField txtDay;
  private JTextField txtMonth;
  private JTextField txtYear;
  private JLabel lblTreatDate;
  private JLabel lblTreatCodes;
  private JTextField txtTreatCode1;
  private JTextField txtTreatCode2;
  private JTextField txtTreatCode3;
  private JTextField txtTreatCode4;
  private JTextField txtTreatCode5;
  private JTextField txtTreatCode6;
  private JTextField txtTreatCode7;
  private JLabel lblTreatDescripts;
  private JLabel lblTreatDescript1;
  private JLabel lblTreatDescript2;
  private JLabel lblTreatDescript3;
  private JLabel lblTreatDescript4;
  private JLabel lblTreatDescript5;
  private JLabel lblTreatDescript6;
  private JLabel lblTreatDescript7;
  private JLabel lblTreatCosts;
  private JLabel lblTreatCost1;
  private JLabel lblTreatCost2;
  private JLabel lblTreatCost3;
  private JLabel lblTreatCost4;
  private JLabel lblTreatCost5;
  private JLabel lblTreatCost6;
  private JLabel lblTreatCost7;
  private JButton btnSum;
  private JLabel lblSum;
  private JButton btnClear;
  private JButton btnStore;
  private JLabel lblStatus;

  private int day;
  private int month;
  private int year;
  private boolean flag;

  private long docNum;
  private long patientNum;
  private GregorianCalendar treatDate;
  private long treatCode1;
  private long treatCode2;
  private long treatCode3;
  private long treatCode4;
  private long treatCode5;
  private long treatCode6;
  private long treatCode7;
  private float sum;
}
