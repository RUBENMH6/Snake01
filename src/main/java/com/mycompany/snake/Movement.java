/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;


import java.util.List;
import java.util.Vector;



/**
 *
 * @author alu10211999
 */
public class Movement {
    
    private List<Direction> movements;
    
    public static final int MAX_MOV = 2;
    
    public Movement() {
        movements = new Vector<>(MAX_MOV);
        movements.add(Direction.RIGHT);

    }
    
    public boolean isFull() {
        if (movements.size() == MAX_MOV ) {
            return true;
        }      
        
        return false;
    }
    
    public Direction getNextMov() {
        return movements.get(0);
    }
    
    public void insertNewMov(Direction d) {
        if (isFull()) {
            if (newMovIsValid(d)) {
                movements.remove(0);
                movements.add(d); 
            }
        } else {
            movements.add(d); 
        }
              
    }
    
    public boolean isLastMove() {
        if (movements.size() <= 1) {
            return true;
        }
        return false;
    }
    
    public boolean newMovIsValid(Direction d){
         switch (d) {
             case LEFT:
                 if (movements.get(MAX_MOV - 1).equals(Direction.RIGHT)) {
                     return false;
                 }
                 break;
             case RIGHT:
                 if (movements.get(MAX_MOV - 1).equals(Direction.LEFT)) {
                     return false;
                 }
                 break;
             case UP:
                 if (movements.get(MAX_MOV - 1).equals(Direction.DOWN)) {
                     return false;
                 }
                 break;
             case DOWN:
                 if (movements.get(MAX_MOV - 1).equals(Direction.UP)) {
                     return false;
                 }
                 break;
                 
         }
         return true;
    }
}
