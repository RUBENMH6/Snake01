/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.snake;

/**
 *
 * @author alu10211999
 */
public interface Incrementer {
    public void incrementScore(int increment);
    public void resetScore();
    public int getScore();
    public void setScore(int score);
    public void updateHighScore(int score);
}
