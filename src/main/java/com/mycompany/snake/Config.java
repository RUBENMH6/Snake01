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
            this.level = level;
        }
    }

    public int getDeltaTime(){
        switch(level) {
            case 0: 
                deltaTime = 750;
            case 1: 
                deltaTime = 500;
            case 2: 
                deltaTime = 250;
            default:
                deltaTime = 750;
                
        }
        return deltaTime;
    }
    
    public int getTimeSpecialFood() {
        switch(level){
            case 0:
                timeSpecialFood = 12000;
            case 1:
                timeSpecialFood = 900;
            case 2:
                timeSpecialFood = 6000;
            default:
                timeSpecialFood = 12000;
        }
        return timeSpecialFood;
    }
   
    public int getAppearSpecialFood() {
        switch(level) {
            case 0:
                appearSpecialFood = 20;
            case 1: 
                appearSpecialFood = 35;
            case 2:
                appearSpecialFood = 50;
            default:
                appearSpecialFood = 20;
                    
        }
        return appearSpecialFood;
    }
    
    
    
}
