import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import database.*;

public class RechnAusg {

    public static void main(String[]  args){
	(new RechnAusg()).init()
	    ;} 

    private JTextField arztnummer = new JTextField();
    private JTextField quartal = new JTextField();
    private JTextField jahr = new JTextField();	
    private JFrame win;
    private Long num;
    private Integer quar;
    private Integer jahre;
    private JPanel ausgabefeld = new JPanel();

    public void init() {

	win = new JFrame("RechnungsAusgabe");
	win.getContentPane().setLayout(null);
	win.setSize(400,400);
	
	
	JButton ausgabeButton = new JButton();
	JButton druckenButton = new JButton();
	JButton endeButton = new JButton();
	
	win.getContentPane().add(ausgabeButton);
	win.getContentPane().add(druckenButton);
	win.getContentPane().add(endeButton);
	
	ausgabeButton.setText("Ausgabe");
	druckenButton.setText("Drucken");
	endeButton.setText("Ende");
	
	ausgabeButton.setBounds(30, 330, 100, 30);
	ausgabeButton.setVisible(true);

	druckenButton.setBounds(150, 330, 100, 30);
	druckenButton.setVisible(true);
	
	endeButton.setBounds(270, 330, 100, 30);
	endeButton.setVisible(true);
	
        JLabel msg1Label = new JLabel();
	JLabel msg2Label = new JLabel();
	JLabel msg3Label = new JLabel();
   
	msg1Label.setText("Arztnummer");
	msg2Label.setText("Quartal");
	msg3Label.setText("Jahr");

	msg1Label.setBounds(20, 50, 100, 30);
	msg1Label.setVisible(true);
	msg2Label.setBounds(20, 120, 60, 30);
	msg2Label.setVisible(true);
	msg3Label.setBounds(20, 190, 60, 30);
	msg3Label.setVisible(true);

	win.getContentPane().add(msg1Label);
	win.getContentPane().add(msg2Label);
	win.getContentPane().add(msg3Label);


	win.getContentPane().add(arztnummer);
	win.getContentPane().add(quartal);
	win.getContentPane().add(jahr);
	
	arztnummer.setBounds(20, 20, 50, 20);
	quartal.setBounds(20, 90, 50, 20);
	jahr.setBounds(20, 160, 50, 20);
	
	
	ausgabefeld.setBounds(120, 20, 270, 300);
	ausgabefeld.setBackground(Color.white);
	win.getContentPane().add(ausgabefeld);
	
	arztnummer.registerKeyboardAction(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    checkarztnummer();
		    // arztnummer.transferFocus();
		}
	    },KeyStroke.getKeyStroke(10,0),0);
	
	quartal.registerKeyboardAction(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
		    checkquartal();
		    // quartal.transferFocus();
		}
	    },KeyStroke.getKeyStroke(10,0),0);
	
	jahr.registerKeyboardAction(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    checkjahr();
		    // jahr.transferFocus();
		}
	    },KeyStroke.getKeyStroke(10,0),0);
	
	
	
	ausgabeButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		    Ausgabe(num, quar, jahre);
		}
	    });
	
	druckenButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
		    JOptionPane.showMessageDialog(win, new String[] {"Dieser Button ist noch nicht funktionsbereit."});
		}
		
	    });
	
	
	endeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);}
	    });


	win.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
		    System.exit(0);}
	    });
	
	win.show();
	
    }
    
    public void checkarztnummer()
    {
	try{
	    long nummer;
	    Long b = new Long(arztnummer.getText());
	    nummer = b.parseLong(arztnummer.getText());
	    long num;
	    Long a = new Long(nummer);
	    //num = a.GetArztNr(nummer);
	    //if (num==0)
	    //    JOptionPane.showMessageDialog(win, new String[] {"Die Arztnummer ist nicht korrekt. Try it again."});
	}
	catch (NumberFormatException e){
	    JOptionPane.showMessageDialog(win, new String[] {"Bitte nur Zahlen eingeben. Try it again."});
	    arztnummer.requestFocus();
	    arztnummer.setText("");
	}
	
	
    }
    public void checkquartal()
    {
	try {
	    //    String text = new String(quartal.getText());
	    quar = new Integer(Integer.parseInt(quartal.getText()));
	    if (quar.intValue() > 4 || quar.intValue() < 1)
		{
		    JOptionPane.showMessageDialog(win, new String[] {"Die von Ihnen eingegebene Quartalzahl ist nicht zulaessig. Try it again."});
		    quartal.requestFocus();
		    quartal.setText("");
		}
	    else 
		{quartal.transferFocus();}}
	catch (NumberFormatException e){JOptionPane.showMessageDialog(win, new String[] { "Eine Zahl zwischen 1 und 4. Try it again."});
	quartal.requestFocus();
	quartal.setText("");}
    }
    
    public void checkjahr()
    {
	try {	     
	    jahre = new Integer(Integer.parseInt(jahr.getText()));
	    if (jahre.intValue() > 2050 || jahre.intValue() < 1900)
		{ JOptionPane.showMessageDialog(win, new String[] { "Die von Ihnen eingegebene Jahreszahl ist nicht aktuell. Try it again."});
		jahr.requestFocus();
		jahr.setText("");}
	    else
		 {jahr.transferFocus();}
	}
	catch (NumberFormatException e) {
	    JOptionPane.showMessageDialog(win, new String[] { "Eine Jahreszahl eingeben. Try it again."});
	    jahr.requestFocus();
	    jahr.setText("");
	}
	
    }
    private void Ausgabe(Long x, Integer y, Integer z) 
    {
	int u = jahr.getText().length();
	int v = quartal.getText().length();
	int s = arztnummer.getText().length();

	if(s == 0)
	    {JOptionPane.showMessageDialog(win, new String[] { "Geben Sie noch eine Arztnummer an."});
	    arztnummer.requestFocus();}
	else
	    {
	    if(v == 0)
	    {JOptionPane.showMessageDialog(win, new String[] { "Geben Sie noch einen Quartalsabschnitt an."});
	    quartal.requestFocus();}
	    else
		{
		    if(u == 0)
			{JOptionPane.showMessageDialog(win, new String[] { "Geben Sie noch eine Jahreszahl an."});
			jahr.requestFocus();}
		
	    

		    else
	    {

	String url="jdbc:postgresql://sokrates/ChocAn";
	Connection con;
	String query="SELECT * FROM arztrechnungen_"+quar+"_"+jahre+" WHERE ARZTNUMMER="+num;
	Statement stmt;
	
	// treiber fuer datenbank
	try{
	    Class.forName("org.postgresql.Driver"); }
	
	catch(java.lang.ClassNotFoundException e) {
	    System.err.print("ClassNotFoundException: ");
	    System.err.println(e.getMessage()); }
	// ende treiber datenbank

	try {
	    con = DriverManager.getConnection(url, "postgres", "");
	    stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    
	    while(rs.next())
		{
		    for (int i=1;i<=13;i++)
			{
			    if (i!=2)
				{
				    //ausgabefeld.setText(rs.getString(i));
				}
			}
		}
	    stmt.close();
	    con.close();
	}
	catch(SQLException ex) {
	    System.err.println("SQLException: " + ex.getMessage());
	}
    }
    }
	    }
    }
}
