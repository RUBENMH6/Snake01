/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;

/**
 *
 * @author alu10211999
 */
public class Game extends javax.swing.JFrame {

    
    /**
     * Creates new form Game
     */
    public Game() {
        initComponents();
        myInit();
        setLocationRelativeTo(null);
    }
    
    private void myInit() {
        board.setIncrementer(scoredboard);
        
        scoredboard.setInitGame(board);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scoredboard = new com.mycompany.snake.Scoredboard();
        board = new com.mycompany.snake.Board();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuGame = new javax.swing.JMenu();
        menuStart = new javax.swing.JMenuItem();
        menuConfig = new javax.swing.JMenuItem();
        menuResetScore = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scoredboard.setBackground(new java.awt.Color(217, 118, 255));
        scoredboard.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        getContentPane().add(scoredboard, java.awt.BorderLayout.PAGE_START);

        board.setBackground(new java.awt.Color(206, 196, 252));
        board.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        board.setLayout(new java.awt.GridLayout(500, 500));
        getContentPane().add(board, java.awt.BorderLayout.CENTER);

        menuGame.setText("Game");
        menuGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGameActionPerformed(evt);
            }
        });

        menuStart.setText("Start");
        menuStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuStartActionPerformed(evt);
            }
        });
        menuGame.add(menuStart);

        menuConfig.setText("Settings");
        menuConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConfigActionPerformed(evt);
            }
        });
        menuGame.add(menuConfig);

        menuResetScore.setText("Reset Score");
        menuResetScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuResetScoreActionPerformed(evt);
            }
        });
        menuGame.add(menuResetScore);

        jMenuBar1.add(menuGame);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGameActionPerformed
        
    }//GEN-LAST:event_menuGameActionPerformed

    private void menuConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConfigActionPerformed
        ConfigDialog dialog = new ConfigDialog(this, true);
        dialog.setInitGame(board);
        dialog.setVisible(true);
    }//GEN-LAST:event_menuConfigActionPerformed

    private void menuStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuStartActionPerformed
        board.initGame();
    }//GEN-LAST:event_menuStartActionPerformed

    private void menuResetScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuResetScoreActionPerformed
        board.setIncrementer(scoredboard);
        scoredboard.resetHighScore();
    }//GEN-LAST:event_menuResetScoreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.snake.Board board;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuConfig;
    private javax.swing.JMenu menuGame;
    private javax.swing.JMenuItem menuResetScore;
    private javax.swing.JMenuItem menuStart;
    private com.mycompany.snake.Scoredboard scoredboard;
    // End of variables declaration//GEN-END:variables

    
}
