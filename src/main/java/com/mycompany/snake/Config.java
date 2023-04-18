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
    public ApperianceFood aFood;

    
    

    
    
    public int numRow = 20;
    public int numCol = 20;
    
   
    
    
    
    private Config() {
        level = 0;
    }

    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        if (level < 0) { 
            this.level = 0;
        } else if (level > 2) {
            this.level = 2;
        } else {
            this.level = 1;
        }
    }

    public int getDeltaTime(){
        switch(level) {
            case 0: 
                deltaTime = 500;
            case 1: 
                deltaTime = 250;
            case 2: 
                deltaTime = 100;
            default:
                deltaTime = 500;
                
        }
        return deltaTime;
    }
    
    
    public void setAFood(int food) {
        switch(aFood) {
            case APPLE: 
                food = 1;
                break;
            case PEAR:
                food = 2;
                break;
            case PINEAPPLE:
                food = 3;
                break;
            case PEACH:
                food = 4;
                break;
            default:
                food = 1;          
        }
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
    
}
