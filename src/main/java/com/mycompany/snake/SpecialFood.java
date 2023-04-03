/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author alu10211999
 */
public class SpecialFood extends Food {
    
    private int specialFoodRow;
    private int specialFoodCol;

  


    
    public SpecialFood(Snake snake) {
        super(snake);
        
        specialFoodRow = (int) (Math.random()*Config.instance.numRow);
        specialFoodCol = (int) (Math.random()*Config.instance.numCol);
        
        while (snake.containsNode(specialFoodRow, specialFoodCol)) {
            
            specialFoodRow = (int) (Math.random()*Config.instance.numRow);
            specialFoodCol = (int) (Math.random()*Config.instance.numCol);
          
        }
        setRow(specialFoodRow);
        setCol(specialFoodCol);
        
        
        
         
        
    }
    
    
    public void paintSF(Board b, Graphics g) {
        b.drawSquare(g, new Node(specialFoodRow,specialFoodCol), Type.FOOD);
    }
    
    
}
