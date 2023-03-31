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
public class Food extends Node {
    
    private int foodRow;
    private int foodCol;
    
    
    public Food(Snake snake) {
        super(0, 0);
        foodRow = (int) (Math.random()*Config.instance.numRow);
        foodCol = (int) (Math.random()*Config.instance.numCol)+1;
        
        while (snake.containsNode(foodRow, foodCol)) {
            
            foodRow = (int) (Math.random()*Config.instance.numRow);
            foodCol = (int) (Math.random()*Config.instance.numCol)+1;
            System.out.println(foodRow + "," + foodCol);
        }
    }
    
    
    public void paintF(Board b, Graphics g) {
        b.drawSquare(g, new Node(foodRow,foodCol), Type.FOOD);
    }
    
    public void move(Snake snake) {
        int row = (int) (Math.random()*Config.instance.numRow)+1;
        int col = (int) (Math.random()*Config.instance.numCol)+1;
        
        while (Util.canMove(foodRow, foodCol) && snake.containsNode(foodRow, foodCol)) {
            
            row = (int) (Math.random()*Config.instance.numRow)+1;
            col = (int) (Math.random()*Config.instance.numCol)+1;
          
        }
        setRow(row);
        setCol(col);
    }
    
    
    
    
    
}
