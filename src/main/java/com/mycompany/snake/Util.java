/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;

/**
 *
 * @author irube
 */
public class Util {
    
    public static boolean canMove(int row, int col) {
        if (row >= Config.instance.numRow || row < 0 ||
                col >= Config.instance.numCol || col < 0 ) {
            
            return false;
        }
        return true;
    }
}
