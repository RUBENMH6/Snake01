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
    private SpecialFood sFood;
    private Food food;
    private boolean gameOver = false;
    public int counterFood = 0;

    public int getCounterFood() {
        return counterFood;
    }

    public void setCounterFood(int counterFood) {
        this.counterFood = counterFood;
    }
    
    
    public Snake() {
        direction = Direction.RIGHT;
        snake = new ArrayList<Node>();
        for (int i = 0; i < 4; i++) {
            snake.add(new Node(Config.instance.numRow/2, Config.instance.numCol/2 - i));
        }
        
        
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
    
    public static boolean canMove(int row, int col) {
        if (Config.instance.getRule() == 1) {
            if (row >= Config.instance.numRow || row < 0 ||
                col >= Config.instance.numCol || col < 0 ) {
            
            return false;
            }
        }
        return true;
        
    }
    
    public void move() {
        
        int row = snake.get(0).getRow();
        int col = snake.get(0).getCol();

        
        switch(direction) {
            case UP:
                if (canMove(row - 1, col) && !containsNode(row - 1, col)) {
                    if (row <= 0) {
                        snake.add(0, new Node(Config.instance.numRow - 1, col));
                    } else {
                        snake.add(0, new Node(row - 1 , col));
                    }
                    snake.remove(snake.size()-1);
                     
                } else {
                    gameOver = true;
                }
                break;
            case DOWN:
                if (canMove(row + 1, col) && !containsNode(row + 1, col)) { 
                    if (row >= Config.instance.numRow - 1) {
                       snake.add(0, new Node(0, col));
                    } else {
                       snake.add(0, new Node(row + 1 , col)); 
                    }
                      
                    snake.remove(snake.size()-1);
                } else {
                    gameOver = true;
                }
                break;
            case LEFT:
                if (canMove(row, col - 1) && !containsNode(row, col - 1)) {
                   if (col <= 0) {
                      snake.add(0, new Node(row , Config.instance.numCol-1));  
                    } else {
                      snake.add(0, new Node(row , col - 1));
                    }
                    
                    snake.remove(snake.size()-1); 
                } else {
                    gameOver = true;
                }
                break;
            case RIGHT:
                if (canMove(row, col + 1) && !containsNode(row, col + 1)) {
                    if (col >= Config.instance.numCol - 1) {
                      snake.add(0, new Node(row , 0));  
                    } else {
                      snake.add(0, new Node(row , col + 1));
                    }
                    snake.remove(snake.size()-1); 
                } else {
                    gameOver = true;
                }
                break;
        }
    }

    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    public boolean eatsFood(Food food) {
        return getSnake().get(0).getRow() == food.getRow() && getSnake().get(0).getCol() == food.getCol();
    }
    
    
    
    
    public int sizeSnake() {
        return snake.size()-1;
    }
     
    public int getRowLastNode() {
        return snake.get(sizeSnake()).getRow();
    }
    
    public int getColLastNode() {
        return snake.get(sizeSnake()).getCol();
    }
}
    
    
  

