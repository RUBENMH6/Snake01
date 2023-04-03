/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Math.random;
import static java.lang.StrictMath.random;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author alu10211999
 */
public class Board extends javax.swing.JPanel   {

    private Snake snake;
    private Timer timer;
    private Timer timerStart;
    private Timer timerStop;
    private int deltaTime;
    private Direction direction;
    private MyKeyAdapter myKeyAdapter;
    private Food food;
    private SpecialFood sFood;
    private int score;
    private int counter = 0;
    
    
    public static final int SCORE_FOOD = 10;
    
    private Incrementer incrementer;

    public Incrementer getIncrementer() {
        return incrementer;
    }

    public void setIncrementer(Incrementer incrementer) {
        this.incrementer = incrementer;
    }

    

    
    
    
    
    class MyKeyAdapter extends KeyAdapter {
        
        private int row = snake.getSnake().get(0).getRow();     
        private int col = snake.getSnake().get(0).getCol();
        
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (snake.canMove(row - 1 , col) && !snake.getDirection().equals(Direction.RIGHT)){
                       snake.setDirection(Direction.LEFT);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (snake.canMove(row, col - 1) && !snake.getDirection().equals(Direction.LEFT)){
                       snake.setDirection(Direction.RIGHT);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (snake.canMove(row , col + 1) && !snake.getDirection().equals(Direction.DOWN)){
                       snake.setDirection(Direction.UP);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (snake.canMove(row, col - 1 ) && !snake.getDirection().equals(Direction.UP)){
                       snake.setDirection(Direction.DOWN);
                    }
                    break;
                
                default:
                    break;
            }
            repaint();
        }
    }
    
    
    
    
    public Board() {
        initComponents();
        myInit();
        setFocusable(true);
    }
    
    
    public int squareWidth() {
        return getWidth() / Config.instance.numCol;
    }
    
    public int squareHeight() {
        return getHeight() / Config.instance.numRow;
    }
    
    private void myInit() {
       snake = new Snake();
       food = new Food(snake);
       
          
       
       myKeyAdapter = new MyKeyAdapter(); 
       addKeyListener(myKeyAdapter);
       timer = new Timer(250, new ActionListener() {
       @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start();
    }
            
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        food.paintF(this, g);
        snake.paint(this, g);
        if (existSFood()) {
           sFood.paintSF(this, g); 
        }
        
        
        
        
        
       
        Toolkit.getDefaultToolkit().sync();
    }
    
    
    public Food getFood() {
        return food;
    }
    
    public List getListSnake() {
        return (List) snake.getSnake();
    }
    
    public void drawSquare(Graphics g, Node node, Type type) {
        
 
        Color colors[] = {new Color(204, 102, 102),new Color(204, 102, 204), new Color(218, 170, 0),new Color(218, 0, 204)};
        
        
        int x = node.getCol() * squareWidth();
        int y = node.getRow() * squareHeight();
        
        switch (type) {
            case HEAD:
                g.setColor(colors[0]);
                break;
            case BODY:
                g.setColor(colors[1]);
                break;
            case FOOD:
                g.setColor(colors[2]);
                break;
            case SPECIAL_FOOD:
                g.setColor(colors[3]);
                break;
            default:
                g.setColor(colors[1]);
                break;
        }
        
        
        g.fillRect(x + 1, y + 1, squareWidth() - 2,
                squareHeight() - 2);
        g.setColor(g.getColor().brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);
        g.setColor(g.getColor().darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1,
                y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);
    }
    
    
    
    private void tick() {
        snake.move();
        generateSFood();
        
        checkFood();
        checkSpecialFood();
        processGameOver();
        int random = (int) (Math.random()*2);
        
        if (random == 1) {
            counter++;
        }
        
        repaint();
        Toolkit.getDefaultToolkit().sync();
        
    }
    
    public void checkFood() {
        if (snake.eatsFood(food)) {
            snake.getSnake().add(snake.sizeSnake(), new Node(snake.getRowLastNode() ,  snake.getColLastNode() ));
            food = new Food(snake);
            incrementer.incrementScore(SCORE_FOOD);
            
        }
        
        
            
            
        
    }
    
    public void generateSFood() {
        if (counter == 10) {
            sFood = new SpecialFood(snake);
            counter = 0;
            tickStop();
        }
    }
    
    
    public void tickStop() {
        if (existSFood()) {
           timerStop = new Timer(5000, new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent e) {
                sFood = null;
            }
        }); 
           timerStop.start();
        }
        
        
    }
    
    public void checkSpecialFood() {
        if (existSFood()) {
           if (snake.eatsSpecialFood(sFood)) {
                for (int i = 0; i < 3 ; i++) {
                snake.getSnake().add(snake.sizeSnake(), new Node(snake.getRowLastNode() ,  snake.getColLastNode() ));
                incrementer.incrementScore(SCORE_FOOD);
                }
            
            sFood = new SpecialFood(snake);
            } 
        }
            
            
        
    }
    public boolean existSFood() {
        if (sFood == null) {
            return false;
        }
        return true;
    }
    
    public void processGameOver() {
        if (snake.isGameOver()) {
            JOptionPane.showMessageDialog(this, "YOU LOSE", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
            timer.stop();
        }
    }
    
    public void setDeltaTime() {
        switch (Config.instance.getLevel()) {
            case 0: deltaTime = 500;
                break;
            case 1: deltaTime = 300;
                break;
            case 2: deltaTime = 150;
                break;
            default:
                throw new AssertionError();
        }
    }
    
    
   

    
        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(500, 500));
        setPreferredSize(new java.awt.Dimension(500, 500));
        setLayout(new java.awt.GridLayout());
    }// </editor-fold>//GEN-END:initComponents

    

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

