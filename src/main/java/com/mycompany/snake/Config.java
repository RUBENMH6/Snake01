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
    private int deltaTime;
    private int timeSpecialFood;
    private int appearSpecialFood;
    private int rule;
    private int food;
    private int background;

    
    public int numRow = 20;
    public int numCol = 20;
    
   
    
    
    
    private Config() {
        level = 0;
    }

    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        if (level <= 0) { 
            this.level = 0;
        } else if (level >= 2) {
            this.level = 2;
        } else {
            this.level = 1;
        }
    }

    public int getDeltaTime(){
        return deltaTime;
    }

    
    
    
    public void setAFood(int food) {
        this.food = food;
    }

    public int getAFood() {
        return food;
    }
    
    
    public int getRule() {
        return rule;
    }

    public void setRule(int rule) {
        if (rule == 0) {
            this.rule = 0;
        } else {
            this.rule = 1;
        }
    }
    
    public int getBackground() {
        return background;
    }
    
    public void setBackground(int b) {
        switch(b){
            case 0: 
                background = 0;
                break;
            case 1:
                background = 1;
                break;
            case 2:
                background = 2;
                break;
        }
    }
    
}
