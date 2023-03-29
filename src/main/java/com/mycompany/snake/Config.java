/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package com.mycompany.snake;

/**
 *
 * @author alu10211999
 */
public class Config {
    
    public static Config instance = new Config();
    private int level; 
    private String name;
    
    public int numRow = 20;
    public int numCol = 20;

    
    
    
    
    
    private Config() {
        level = 0;
        name = "Player";
    }

    public void setLevel(int level) {
        if (level < 0) { 
            this.level = 0;
        } else if (level > 2) {
            this.level = 2;
        } else {
            this.level = level;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
 
    public int getNumRow() {

        return numRow;
    }

    public void setNumRow(int rows) {
        this.numRow = rows;
    }

    public int getNumCol() {
        return numCol;
    }

    public void setNumCol(int cols) {
        this.numCol = cols;
    }
    
    
    
    
    
}
