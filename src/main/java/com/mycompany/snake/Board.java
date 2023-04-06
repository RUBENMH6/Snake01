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

    

    
    
    /**
     * Clase KeyAdapter para mover la snake.
     */
    
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
    
    
    
    /**
     * Constructor de la clase Board.
     */
    public Board() {
        initComponents();
        myInit();
        setFocusable(true);
    }
    
    /**
     * Calcula el ancho de cada cuadrado que compone el board.
     * @return 
     */
    public int squareWidth() {
        return getWidth() / Config.instance.numCol;
    }
    /**
     * Calcula el alto de cada cuadrado que compone el board.
     * @return 
     */
    public int squareHeight() {
        return getHeight() / Config.instance.numRow;
    }
    
    /**
     * Inicia atributos.
     */
    private void myInit() {
       snake = new Snake();
       food = new Food(snake);
       
          
       
       myKeyAdapter = new MyKeyAdapter(); 
       addKeyListener(myKeyAdapter);
       timer = new Timer(100, new ActionListener() {
       @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
        timer.start();
    }
            
    /**
     * Pinta en el board los componentes.
     * @param g 
     */
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
    
    /**
     * Devuelve el Food que existe en board.
     * @return - Food
     */
    public Food getFood() {
        return food;
    }
    /**
     * Devuelve la lista de Nodos que representa la Snake.
     * @return - List
     */
    public List getListSnake() {
        return (List) snake.getSnake();
    }
    
    /**
     * Dibuja un nodo y dependiendo del tipo, lo dibuja de un color u otro.
     * @param g - Graphics
     * @param node - El nodo que dibuja
     * @param type - El tipo de nodo que dibuja
     */
    public void drawSquare(Graphics g, Node node, Type type) {
        
 
        Color colors[] = {new Color(204, 102, 102),new Color(204, 102, 204), new Color(218, 170, 0),new Color(150, 0, 204)};
        
        
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
    
    
    /**
     * Método que se ejecuta a cada tick del timer
     */
    private void tick() {
        //Move snake.
        snake.move();
        
        checkFood();
        //It is verified that in the next node there is spcial food or not 
        checkSpecialFood();
        //It is verified that in the next node it is not lost
        processGameOver();
        
        //Two random numbers are created from 0 to 1.
        int random = (int) (Math.random()*2);
        
        //If the number is 1, it is added to the counter (It takes 25 to spawn a food)
        if (random == 1) {
            counter++;
            System.out.println(counter);
        }
        
        
        generateSFood();
        
        //Repaint all components.
        repaint();
        Toolkit.getDefaultToolkit().sync();
        
    }
    /**
     * It is verified that in the next node there is food or not
     */
    public void checkFood() {
        if (snake.eatsFood(food)) {
            snake.getSnake().add(snake.sizeSnake(), new Node(snake.getRowLastNode() ,  snake.getColLastNode() ));
            food = new Food(snake);
            incrementer.incrementScore(SCORE_FOOD);          
        }           
        
    }
    /**
     * Try to create a special food.
     */
    public void generateSFood() {
        if (counter == 50 ) {
            if (timerStop != null) {
                if (timerStop.isRunning()) {
                    timerStop.stop();                      
                }   else {
                    sFood = new SpecialFood(snake);
                    tickStop();
                }
            } else {
                sFood = new SpecialFood(snake);
                tickStop();
            }
            counter = 0;
        }
        
    }
    
    /**
     * A new timer is created to clear the special food when it reaches a certain time.
     */
    public void tickStop() {
        if (existSFood()) {
           timerStop = new Timer(10000, new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent e) {
                sFood = null;
                counter = 0;
                timerStop.stop();
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
            counter = 0;
            sFood = null;
            if (timerStop != null) {
               timerStop.stop(); 
                }
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

