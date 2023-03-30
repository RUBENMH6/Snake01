/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;


import static com.mycompany.snake.Direction.DOWN;
import static com.mycompany.snake.Direction.LEFT;
import static com.mycompany.snake.Direction.RIGHT;
import static com.mycompany.snake.Direction.UP;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class Snake {
    
    private List<Node> snake;
    private Node node;
    private Direction direction;
    private Board board;
    public Snake() {
        direction = Direction.RIGHT;
        snake = new ArrayList<Node>();
        
        for (int i = 0; i < 4; i++) {
            snake.add(new Node(Config.instance.numRow/2, Config.instance.numCol/2 - i));
        }
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public boolean containsNode(int row, int col) {
        for (Node node: snake) {
            if (node.getRow() == row && node.getCol() == col) {
                return true;
            } 
        }
        return false;
    }

    public List<Node> getSnake() {
        return snake;
    }
    
    public void paint(Board b, Graphics g) {
        for (int i = 0; i < snake.size() ; i++) {
            if (i == 0) {
              b.drawSquare(g,snake.get(i), Type.HEAD);  
            } else {
              b.drawSquare(g,snake.get(i), Type.BODY); 
            }
            
            
        }
    }
    public boolean canMove(int row, int col) { 
        if (row >= Config.instance.numRow || row < 0 ||
                col >= Config.instance.numCol || col < 0 || containsNode(row, col) ) {
            
            return false;
        }
        return true;
    }
    
    public void move() {
        
        int row = snake.get(0).getRow();
        int col = snake.get(0).getCol();
        
        
        switch(direction) {
            case UP:
                if (canMove(row - 1, col)) {
                    snake.add(0, new Node(row - 1 , col));
                    snake.remove(snake.size()-1);
                }
                break;
            case DOWN:
                if (canMove(row + 1, col)) {
                    snake.add(0, new Node(row + 1 , col));
                    snake.remove(snake.size()-1);
                }
                break;
            case LEFT:
                if (canMove(row, col - 1)) {
                    snake.add(0, new Node(row , col - 1));
                    snake.remove(snake.size()-1);
                }
                break;
            case RIGHT:
                if (canMove(row, col + 1)) {
                    snake.add(0, new Node(row , col + 1));
                    snake.remove(snake.size()-1);
                    
                }
                break;
        }
    }
    
    
     
}
    
    
  

