/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;

/**
 *
 * @author alu10211999
 */
public class Board extends javax.swing.JPanel {

    private Snake snake;
    private Food food;
    private SpecialFood sFood;
    
    
    
    
    public Board() {
        initComponents();
        myInit();
    }
    public int squareWidth() {
        return getWidth() / Config.instance.numCol;
    }
    
    public int squareHeight() {
        return getHeight() / Config.instance.numRow;
    }
    
    private void myInit() {
        snake = new Snake();
        setBackground(Color.LIGHT_GRAY);
        
            
        
    } 
    
    public boolean canMove(int row, int col) {
        
        
        if (row > Config.instance.numRow || row < 0 ||
                col > Config.instance.numCol || col < 0 || snake.containsNode(row, col)) {
            return false;
        }
        return true;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       
        snake.paint(this, g);
        Toolkit.getDefaultToolkit().sync();
    }
    
    public void drawSquare(Graphics g, Node node, Type type) {
        Color colors[] = {new Color(204, 102, 102),new Color(204, 102, 204), new Color(218, 170, 0),new Color(218, 170, 204)};
        Color color;
        int x = node.getCol() * squareWidth();
        int y = node.getRow() * squareHeight();
        
        switch (type) {
            case HEAD:
                color = colors[0];
                g.setColor(color);
                break;
            case BODY:
                color = colors[1];
                g.setColor(color);
                break;
            case FOOD:
                color = colors[2];
                g.setColor(color);
                break;
            case SPECIAL_FOOD:
                color = colors[3];
                g.setColor(color);
                break;
            default:
                color = colors[1];
                break;
        }
        
        
        g.fillRect(x + 1, y + 1, squareWidth() - 2,
                squareHeight() - 2);
        //g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1,
                y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);
    }
    
    public void paintFood(Board b, Graphics g, Node node) {
        b.drawSquare(g, node, Type.FOOD);
    }
    
    public void paintSpecialFood(Board b, Graphics g, Node node) {
        b.drawSquare(g, node, Type.SPECIAL_FOOD);
    }
        
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));
        setLayout(new java.awt.GridLayout());
    }// </editor-fold>//GEN-END:initComponents

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

