 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

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
    
    
    public void paintF(Board b, Graphics g, int foodType, int width, int height) {
        
        Image image;
        Graphics2D g2d = (Graphics2D) g;
        
        switch (foodType) {
            case 0:
                image = b.getImage( "/images/apple.png");
                
                break;
            case 1:
                image = b.getImage( "/images/pear.png");
                
                break;
            case 2:
                image = b.getImage( "/images/pineapple.png");
                
                break;
            case 3:
                image = b.getImage( "/images/peach.png");
                
                break;
            default:
                image = b.getImage( "/images/apple.png");
                
                break;
        }
        
        g2d.drawImage(image, width * getCol(), height * getRow(), null);
    }
    
    
    
    
    
    
}
