/*
 * Dateneingabe.java
 *
 * Created on 16. Juni 2001, 16:26
 */

package protocol;

import javax.swing.*;
import java.util.*;
import java.lang.*;
/**
 *
 * @author  Günther Zeretzke
 * @version 
 */
public class Dateneingabe extends javax.swing.JFrame {

    /** Creates new form Dateneingabe */
    public Dateneingabe() {
        initComponents ();
    }

    private void initComponents() {//GEN-BEGIN:initComponents
        NameText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        VornameLabel = new javax.swing.JLabel();
        AlterText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        NationalitaetLabel = new javax.swing.JLabel();
        AlterLabel = new javax.swing.JLabel();
        StrasseText = new javax.swing.JTextField();
        VornameText = new javax.swing.JTextField();
        StrasseLabel = new javax.swing.JLabel();
        Postleitzahl = new javax.swing.JLabel();
        NummerLabel = new javax.swing.JLabel();
        NationalitaetText = new javax.swing.JTextField();
        OrtText = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        MitgliedsnummerText = new javax.swing.JTextField();
        OrtLabel = new javax.swing.JLabel();
        MitgliedsnummerLabel = new javax.swing.JLabel();
        EintrittsdatumLabel = new javax.swing.JLabel();
        AustrittsdatumLabel = new javax.swing.JLabel();
        PLZText = new javax.swing.JTextField();
        AustrittsdatumText = new javax.swing.JTextField();
        EintrittsdatumText = new javax.swing.JTextField();
        OKButton = new javax.swing.JButton();
        Neu = new javax.swing.JButton();
        AbbrechenButton = new javax.swing.JButton();
        setLayout(null);
        
        
        
        add(NameText);
        NameText.setBounds(90, 30, 190, 20);
        
        
        jLabel4.setText("jLabel4");
        
        add(jLabel4);
        jLabel4.setBounds(370, 120, 0, 0);
        
        
        VornameLabel.setText("Vorname");
        VornameLabel.setForeground(java.awt.Color.black);
        
        add(VornameLabel);
        VornameLabel.setBounds(20, 50, 60, 40);
        
        
        
        add(AlterText);
        AlterText.setBounds(90, 90, 190, 20);
        
        
        jLabel6.setText("Name");
        jLabel6.setForeground(java.awt.Color.black);
        
        add(jLabel6);
        jLabel6.setBounds(20, 20, 40, 40);
        
        
        NationalitaetLabel.setText("Nationalitaet");
        NationalitaetLabel.setForeground(java.awt.Color.black);
        
        add(NationalitaetLabel);
        NationalitaetLabel.setBounds(20, 110, 70, 40);
        
        
        AlterLabel.setText("Alter");
        AlterLabel.setForeground(java.awt.Color.black);
        
        add(AlterLabel);
        AlterLabel.setBounds(20, 80, 60, 40);
        
        
        
        add(StrasseText);
        StrasseText.setBounds(90, 150, 130, 20);
        
        
        
        add(VornameText);
        VornameText.setBounds(90, 60, 190, 20);
        
        
        StrasseLabel.setText("Strasse");
        StrasseLabel.setForeground(java.awt.Color.black);
        
        add(StrasseLabel);
        StrasseLabel.setBounds(20, 140, 60, 40);
        
        
        Postleitzahl.setText("PLZ");
        Postleitzahl.setForeground(java.awt.Color.black);
        
        add(Postleitzahl);
        Postleitzahl.setBounds(20, 170, 60, 40);
        
        
        NummerLabel.setText("Nr.");
        NummerLabel.setForeground(java.awt.Color.black);
        
        add(NummerLabel);
        NummerLabel.setBounds(230, 140, 30, 40);
        
        
        
        add(NationalitaetText);
        NationalitaetText.setBounds(90, 120, 190, 20);
        
        
        
        add(OrtText);
        OrtText.setBounds(160, 180, 190, 20);
        
        
        
        add(jTextField7);
        jTextField7.setBounds(250, 150, 30, 20);
        
        
        
        add(MitgliedsnummerText);
        MitgliedsnummerText.setBounds(400, 30, 70, 20);
        
        
        OrtLabel.setText("Ort");
        OrtLabel.setForeground(java.awt.Color.black);
        
        add(OrtLabel);
        OrtLabel.setBounds(140, 170, 30, 40);
        
        
        MitgliedsnummerLabel.setText("Mitgliedsnummer");
        MitgliedsnummerLabel.setForeground(java.awt.Color.black);
        
        add(MitgliedsnummerLabel);
        MitgliedsnummerLabel.setBounds(310, 20, 100, 40);
        
        
        EintrittsdatumLabel.setText("Eintrittsdatum");
        EintrittsdatumLabel.setForeground(java.awt.Color.black);
        
        add(EintrittsdatumLabel);
        EintrittsdatumLabel.setBounds(310, 50, 80, 40);
        
        
        AustrittsdatumLabel.setText("Austrittsdatum");
        AustrittsdatumLabel.setForeground(java.awt.Color.black);
        
        add(AustrittsdatumLabel);
        AustrittsdatumLabel.setBounds(310, 80, 100, 40);
        
        
        
        add(PLZText);
        PLZText.setBounds(90, 180, 40, 20);
        
        
        
        add(AustrittsdatumText);
        AustrittsdatumText.setBounds(400, 90, 70, 20);
        
        
        
        add(EintrittsdatumText);
        EintrittsdatumText.setBounds(400, 60, 70, 20);
        
        
        OKButton.setText("OK");
        OKButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OKButtonMouseClicked(evt);
            }
        }
        );
        
        add(OKButton);
        OKButton.setBounds(90, 220, 50, 40);
        
        
        Neu.setText("Neu");
        Neu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NeuMouseClicked(evt);
            }
        }
        );
        
        add(Neu);
        Neu.setBounds(20, 220, 60, 40);
        
        
        AbbrechenButton.setText("Abbrechen");
        AbbrechenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbbrechenButtonMouseClicked(evt);
            }
        }
        );
        
        add(AbbrechenButton);
        AbbrechenButton.setBounds(150, 220, 90, 40);
        
    }//GEN-END:initComponents

  private void AbbrechenButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbbrechenButtonMouseClicked
// Add your handling code here:
  }//GEN-LAST:event_AbbrechenButtonMouseClicked

  private void NeuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NeuMouseClicked
// Add your handling code here:
  }//GEN-LAST:event_NeuMouseClicked

  private void OKButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKButtonMouseClicked
// Add your handling code here:
  }//GEN-LAST:event_OKButtonMouseClicked


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField NameText;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel VornameLabel;
  private javax.swing.JTextField AlterText;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel NationalitaetLabel;
  private javax.swing.JLabel AlterLabel;
  private javax.swing.JTextField StrasseText;
  private javax.swing.JTextField VornameText;
  private javax.swing.JLabel StrasseLabel;
  private javax.swing.JLabel Postleitzahl;
  private javax.swing.JLabel NummerLabel;
  private javax.swing.JTextField NationalitaetText;
  private javax.swing.JTextField OrtText;
  private javax.swing.JTextField jTextField7;
  private javax.swing.JTextField MitgliedsnummerText;
  private javax.swing.JLabel OrtLabel;
  private javax.swing.JLabel MitgliedsnummerLabel;
  private javax.swing.JLabel EintrittsdatumLabel;
  private javax.swing.JLabel AustrittsdatumLabel;
  private javax.swing.JTextField PLZText;
  private javax.swing.JTextField AustrittsdatumText;
  private javax.swing.JTextField EintrittsdatumText;
  private javax.swing.JButton OKButton;
  private javax.swing.JButton Neu;
  private javax.swing.JButton AbbrechenButton;
  // End of variables declaration//GEN-END:variables

}
