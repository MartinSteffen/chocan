
package protocol;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author  Bartczak / Voelkel
 * @version 0.1
 */
public class Menu extends javax.swing.JInternalFrame {

    /** Creates new form Menu */ //(STKonstruktor)
    public Menu(JDesktopPane sub) {
        caller = sub;
	initComponents();
        this.moveToFront();
        this.setVisible(true);
        this.setSize(400, 200);
	caller.add(this);
        //this.setClosable(false);
	
    }

  private JDesktopPane caller; 


  /** Show/hide Frame */
  public void visible(){
    setVisible(true);}

  public void invisible(){
    setVisible(false);}


  
  private void initComponents() {//GEN-BEGIN:initComponents
        DateneingabButton = new javax.swing.JButton();
        DatenaenderungButton = new javax.swing.JButton();
        DatenanzeigeButton = new javax.swing.JButton();
        BeendenButton = new javax.swing.JButton();
        getContentPane().setLayout(null);
        setTitle("Hauptmenu");
        setBackground(new java.awt.Color (0, 204, 204));
        
        DateneingabButton.setText("Dateneingabe");
        DateneingabButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DateneingabButtonMouseClicked(evt);
            }
        }
        );
        
        getContentPane().add(DateneingabButton);
        DateneingabButton.setBounds(30, 30, 150, 50);
        
        
        DatenaenderungButton.setText("Daten \u00e4ndern");
        DatenaenderungButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatenaenderungButtonMouseClicked(evt);
            }
        }
        );
        
        getContentPane().add(DatenaenderungButton);
        DatenaenderungButton.setBounds(220, 30, 150, 50);
        
        
        DatenanzeigeButton.setText("Daten anzeigen");
        DatenanzeigeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatenanzeigeButtonMouseClicked(evt);
            }
        }
        );
        
        getContentPane().add(DatenanzeigeButton);
        DatenanzeigeButton.setBounds(30, 100, 150, 50);
        
        
        BeendenButton.setText("Beenden");
        BeendenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BeendenButtonMouseClicked(evt);
            }
        }
        );
        
        getContentPane().add(BeendenButton);
        BeendenButton.setBounds(220, 100, 150, 50);
        
    }//GEN-END:initComponents

  private void BeendenButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeendenButtonMouseClicked
    System.exit(0);
  }//GEN-LAST:event_BeendenButtonMouseClicked

  private void DatenanzeigeButtonMouseClicked(java.awt.event.MouseEvent evt) {
      this.setCursor(new Cursor(3));
      ShowMitglied Anzeigen = new ShowMitglied(caller, this);
      this.setVisible(false);
      this.transferFocus();
 }

  private void DatenaenderungButtonMouseClicked(java.awt.event.MouseEvent evt) {
 this.setCursor(new Cursor(3));
    protocol.Datenanzeige showTestMakro = new protocol.Datenanzeige(this, caller);
    this.setVisible(false);
  }

  private void DateneingabButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateneingabButtonMouseClicked
      this.setCursor(new Cursor(3));
    NewMitglied TestMakro = new NewMitglied(caller, this);
    this.setVisible(false);
    TestMakro.setVisible(true);
    this.transferFocus();
  }//GEN-LAST:event_DateneingabButtonMouseClicked


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton DateneingabButton;
  private javax.swing.JButton DatenaenderungButton;
  private javax.swing.JButton DatenanzeigeButton;
  private javax.swing.JButton BeendenButton;
  // End of variables declaration//GEN-END:variables

}
