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
    
    
    public Food(Snake snake) {
        super(0, 0);
        int foodRow = (int) (Math.random()*Config.instance.numRow);
        int foodCol = (int) (Math.random()*Config.instance.numCol);
        
        while (snake.containsNode(foodRow, foodCol)) {
            
            foodRow = (int) (Math.random()*Config.instance.numRow);
            foodCol = (int) (Math.random()*Config.instance.numCol);
            
        }
        setRow(foodRow);
        setCol(foodCol);
    }
    
    
    public void paintF(Board b, Graphics g) {
        b.drawSquare(g, new Node(getRow(),getCol()), Type.FOOD);
    }
    
    
    
    
    
    
}
