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
    
    public static final int MAX_MOV_LEVEL0 = 1;
    public static final int MAX_MOV_LEVEL1 = 2;
    public static final int MAX_MOV_LEVEL2 = 3;
    
    public Movement() {
        switch(Config.instance.getLevel()) {
            case 0: 
                movements = new Vector<>(MAX_MOV_LEVEL0);
                break;
            case 1:
                movements = new Vector<>(MAX_MOV_LEVEL1);
                break;
            case 2: 
                movements = new Vector<>(MAX_MOV_LEVEL2);
                break;
            default:
                movements = new Vector<>(MAX_MOV_LEVEL0);
                break;
        }
        
        movements.add(Direction.RIGHT);
    }
    
    public boolean isFull() {
        switch(Config.instance.getLevel()) {
            case 0:
                if (movements.size() == MAX_MOV_LEVEL0 ) {
                    return true;
                }
                break;
            case 1:
                if (movements.size() == MAX_MOV_LEVEL1 ) {
                    return true;
                }
                break;
            case 2:
                if (movements.size() == MAX_MOV_LEVEL2 ) {
                    return true;
                }
                break;
            default:
                if (movements.size() == MAX_MOV_LEVEL0) {
                    return true;
                }
                break;
        }
        return false;
    }
    
    public Direction getNextMov() {
        return movements.get(0);
    }
    
    public void insertNewMov(Direction d) {
        if (isFull()) {
            movements.remove(0);
        } 
        movements.add(d);
    }
    public boolean isLastMove() {
        if (movements.size() <= 1) {
            return true;
        }
        return false;
    }
}
