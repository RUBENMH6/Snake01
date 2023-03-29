/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snake;


import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class Snake {
    
    private List<Node> snake;
    private Node node;
    private Direction direction;
    
    public Snake() {
        direction = Direction.RIGHT;
        snake = new ArrayList<Node>();
        
        for (int i = 0; i < 4; i++) {
            snake.add(new Node(Config.instance.numRow/2, (Config.instance.numCol-i)/2));
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
 
}
    
    
  

