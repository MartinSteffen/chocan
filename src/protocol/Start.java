/*
 * Start.java
 *
 * Created on 16. Juni 2001, 15:49
 */

package protocol;

import java.util.*;
import javax.swing.*;
import java.lang.*;

/**
 *
 * @author  Günther Zeretzke
 * @version 
 */
public class Start extends javax.swing.JFrame {

    /** Creates new form Start */
    public Start() {
        initComponents ();
        setSize(350, 180);
    }

    private void initComponents() {//GEN-BEGIN:initComponents
        DatenausgabeButton = new javax.swing.JButton();
        DateneingabeButton = new javax.swing.JButton();
        DatenaenderungButton = new javax.swing.JButton();
        BeendenButton = new javax.swing.JButton();
        WillkommenLabel = new javax.swing.JLabel();
        getContentPane().setLayout(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        }
        );
        
        DatenausgabeButton.setText("Datenausgabe");
        DatenausgabeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatenausgabeButtonMouseClicked(evt);
            }
        }
        );
        
        getContentPane().add(DatenausgabeButton);
        DatenausgabeButton.setBounds(20, 80, 130, 30);
        
        
        DateneingabeButton.setText("Dateneingabe");
        DateneingabeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DateneingabeButtonMouseClicked(evt);
            }
        }
        );
        
        getContentPane().add(DateneingabeButton);
        DateneingabeButton.setBounds(20, 40, 130, 30);
        
        
        DatenaenderungButton.setText("Daten\u00e4nderung");
        DatenaenderungButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatenaenderungButtonMouseClicked(evt);
            }
        }
        );
        
        getContentPane().add(DatenaenderungButton);
        DatenaenderungButton.setBounds(170, 40, 130, 30);
        
        
        BeendenButton.setText("Beenden");
        BeendenButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BeendenButtonMouseClicked(evt);
            }
        }
        );
        
        getContentPane().add(BeendenButton);
        BeendenButton.setBounds(170, 80, 130, 30);
        
        
        WillkommenLabel.setText("Bitte w\u00e4hlen Sie eine Funktion.");
        WillkommenLabel.setForeground(java.awt.Color.black);
        
        getContentPane().add(WillkommenLabel);
        WillkommenLabel.setBounds(20, 0, 180, 40);
        
    }//GEN-END:initComponents

  private void BeendenButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BeendenButtonMouseClicked
  System.exit(0);
  }//GEN-LAST:event_BeendenButtonMouseClicked

  private void DateneingabeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateneingabeButtonMouseClicked
     Dateneingabe Test = new Dateneingabe();
    //    Start Test = new Start();
 Test.show();
 Test.setSize(300, 300);
 System.out.println(Test);
  }//GEN-LAST:event_DateneingabeButtonMouseClicked

  private void DatenausgabeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatenausgabeButtonMouseClicked
// Add your handling code here:
  }//GEN-LAST:event_DatenausgabeButtonMouseClicked

  private void DatenaenderungButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatenaenderungButtonMouseClicked
// Add your handling code here:
  }//GEN-LAST:event_DatenaenderungButtonMouseClicked

    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
     
    }//GEN-LAST:event_exitForm

    public static void main (String args[]) {
        new Start ().show ();
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DatenausgabeButton;
    private javax.swing.JButton DateneingabeButton;
    private javax.swing.JButton DatenaenderungButton;
    private javax.swing.JButton BeendenButton;
    private javax.swing.JLabel WillkommenLabel;
    // End of variables declaration//GEN-END:variables

}
