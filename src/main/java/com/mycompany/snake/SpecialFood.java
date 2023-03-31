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
    
    private int specialFoodRow;
    private int specialFoodCol;
    
    
    public SpecialFood(Snake snake) {
        super(snake);
        
        specialFoodRow = (int) (Math.random()*Config.instance.numRow)+1;
        specialFoodCol = (int) (Math.random()*Config.instance.numCol)+1;
        
        while (snake.containsNode(specialFoodRow, specialFoodCol)) {
            
            specialFoodRow = (int) (Math.random()*Config.instance.numRow)+1;
            specialFoodCol = (int) (Math.random()*Config.instance.numCol)+1;
          
        }
    }
    
    
    public void paintSF(Board b, Graphics g) {
        b.drawSquare(g, new Node(specialFoodRow,specialFoodCol), Type.FOOD);
    }
    
    public void move(Snake snake) {
        specialFoodRow = (int) (Math.random()*Config.instance.numRow)+1;
        specialFoodCol = (int) (Math.random()*Config.instance.numCol)+1;
        
        while (Util.canMove(specialFoodRow, specialFoodCol) && snake.containsNode(specialFoodRow, specialFoodCol)) {
            
            specialFoodRow = (int) (Math.random()*Config.instance.numRow)+1;
            specialFoodCol = (int) (Math.random()*Config.instance.numCol)+1;
          
        }
    }
    public int getSpecialFoodRow() {
        return specialFoodRow;
    }
    public int getSpecialFoodCol() {
        return specialFoodCol;
    }
}
