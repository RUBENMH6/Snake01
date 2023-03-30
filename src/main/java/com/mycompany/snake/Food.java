/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

/**
 *
 * @author alu10211999
 */
public class Food extends Node {
    
    
    
    public Food(Snake snake) {
        super(0, 0);
        int randomRow = (int) (Math.random()*Config.instance.numRow)+1;
        int randomCol = (int) (Math.random()*Config.instance.numCol)+1;
        
        while (snake.containsNode(randomRow, randomCol)) {
            
            randomRow = (int) (Math.random()*Config.instance.numRow)+1;
            randomCol = (int) (Math.random()*Config.instance.numCol)+1;
          
        }
    }
}
