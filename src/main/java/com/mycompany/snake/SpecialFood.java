/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Graphics;

/**
 *
 * @author alu10211999
 */
public class SpecialFood extends Food {
    
    private int row;
    private int col;
    
    
    public SpecialFood(Snake snake) {
        super(snake);
        
        row = (int) (Math.random()*Config.instance.numRow)+1;
        col = (int) (Math.random()*Config.instance.numCol)+1;
        
        while (snake.containsNode(row, col)) {
            
            row = (int) (Math.random()*Config.instance.numRow)+1;
            col = (int) (Math.random()*Config.instance.numCol)+1;
          
        }
    }
    
    
    public void paintSF(Board b, Graphics g) {
        b.drawSquare(g, new Node(row,col), Type.FOOD);
    }
}
