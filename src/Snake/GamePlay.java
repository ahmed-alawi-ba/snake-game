
package Snake;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;


public class GamePlay extends JFrame implements KeyListener{
    
    
    
    
    // static variables for key codes
    public static int
    
        KEY_UP_1 = KeyEvent.VK_UP,
        KEY_DOWN_1 = KeyEvent.VK_DOWN,
        KEY_LEFT_1 = KeyEvent.VK_LEFT,
        KEY_RIGHT_1 = KeyEvent.VK_RIGHT,

        KEY_UP_2 = KeyEvent.VK_W,
        KEY_DOWN_2 = KeyEvent.VK_S,
        KEY_LEFT_2 = KeyEvent.VK_A,
        KEY_RIGHT_2 = KeyEvent.VK_D;
    
    
    
    private int move,
            body;
    
    ArrayList <Snake> snakes = new ArrayList();
    
    Snake[] snakesArray = new Snake[2];
    
    private long speed;
    
    public static boolean up = false,
            right = true,
            down = false,
            left = false;
    
    private Timer timer = new Timer();
    
    
    Snake snake = new Snake();
    
    Food food = new Food();
    
    GamePlay(){
        
        init();
        
    }

    
    
    
    
    private void init() {
        
        // initialize the JFrame
        setSize(416,439); // 20 cells x 20 cells
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(10,10,10));
        setTitle("Snake");
        setResizable(false);
        addKeyListener(this);
  
        
        // sadd the JLabel(which is the snake head
        add(snake);
        
        
        // adding the food JLabel
        food.setLocation(food.x, food.y);
        add(food);
        System.out.println("( " + food.x + " ,, " + food.y + " )");
        
        
        // initialize variables
        this.move = 20;
        this.speed = 100l;
        this.body = 0;

        
        
        
        
        // initializing the timer
        timer.schedule(new Movement(), new Date(), speed);
        
    }
    
    
    
    
    
    private void update(){
  
        
        snake.moveSnake();
        snake.setLocation(snake.x, snake.y);
        add(snake);
        
        
        // this for loop is to remove all the elements of locations arraylist
        // in every snake object that exist in the snakes arraylist
        for(int i=0; i<snakes.size(); i++){
            for (int j=0; j<snakes.get(i).locations.size(); j++){
                snakes.get(i).locations.remove(j);
            }
        }
        
        int snakePos = 2;
        for(int i=0; i<body; i++){
            
            snakes.get(i).x = snake.locations.get(snake.locations.size()-snakePos).x;
            snakes.get(i).y = snake.locations.get(snake.locations.size()-snakePos).y;
            snakes.get(i).setLocation(snakes.get(i).x, snakes.get(i).y);
            ++snakePos;
            
            
            
            System.out.println("Snake.locations: " + snake.locations.get(snake.locations.size()-1).x + 
                    "," +snake.locations.get(snake.locations.size()-1).y);
            
            System.out.println("snake.locations.size: " + snake.locations.size());
                        
            add(snakes.get(i));
            
            System.out.println("snakes[" + i +"] "+ "Loc :("+ snakes.get(i).x+ ", " + snakes.get(i).y + ")");
        
            
        }
        
        if(snake.locations.size() >= snakePos){
            snake.locations.remove(0);
        }
        
        
        
        System.out.println(snakes.size());
        
        
           
    }
    
    
    
    
    private boolean isFoodEaten(){
         
        boolean b = false;
        if (snake.eat(food)){
            System.out.println("eaten");
            
            
            /* to check the food location so it will not be on the snake */     
            for(int i=0; i<snakes.size(); i++){
                if((snakes.get(i).x == food.x) && (snakes.get(i).y == food.y)){
                    food.newFood();
                }
            }
            if ((snake.x == food.x) && (snake.y == food.y)){
                food.newFood();
            }
            /*************************************************************/
            
            
            food.setLocation(food.x, food.y);
            b = true;
            
            
            this.body++;
            snakes.add(new Snake());
            
        } 
        else
            b = false;
        
        
        return b;
    }
    
    
    
    
    private void start(){
        
        snake.x = 0;
        snake.y = 0;
        body = 0;
        
        GamePlay.up = false;
        GamePlay.left = false;
        GamePlay.down = false;
        GamePlay.right = true;
        
        for(int i=0; i<snakes.size(); i++)
            this.remove(snakes.get(i));
        this.repaint();
        
        snakes.removeAll(snakes);
        
    }
    
    
    
    
    
    private boolean isGameOver(){
        
        boolean b = false;
        
        for(int i=3; i<snakes.size(); i++){
            if((snake.x == snakes.get(i).x) && (snake.y == snakes.get(i).y)){
                b = true;
                System.out.println("\n\n\n===== Game Over =====  \n");
//                GameOver gameover = new GameOver();
//                gameover.setLocation((getWidth()/2)-(gameover.getWidth()/2), (getHeight()/2)-(gameover.getHeight()/2));
//                add(gameover);
//                gameover.start();
                start();
                repaint();
            }
        }
        
        return b;
    }
    
    
    
    
    
    
    

    
    
    // implemented methods from KeyListener
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
        if(ke.getKeyCode() == KEY_UP_1 || ke.getKeyCode() == KEY_UP_2){
            GamePlay.right = false;
            if(GamePlay.down)
                ;
            else{
                GamePlay.up = true;
            }
            GamePlay.left = false;
        }
        else if(ke.getKeyCode() == KEY_RIGHT_1 || ke.getKeyCode() == KEY_RIGHT_2){
            GamePlay.up = false;
            GamePlay.down = false;
            if(GamePlay.left)
                ;
            else{
                GamePlay.right = true;
            }
            
        }
        else if(ke.getKeyCode() == KEY_DOWN_1 || ke.getKeyCode() == KEY_DOWN_2){
            if(GamePlay.up)
                ;
            else{
                GamePlay.down = true;
            }
            GamePlay.right = false;
            GamePlay.left = false;
        }
        else if(ke.getKeyCode() == KEY_LEFT_1 || ke.getKeyCode() == KEY_LEFT_2){
            GamePlay.up = false;
            if(GamePlay.right)
                ;
            else{
                GamePlay.right = false;
                GamePlay.left = true;
            }
            
            GamePlay.down = false;
            
        }
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
    
    
    
    
    
    
    
    
    // TimerTask subclass
    private class Movement extends TimerTask{

        
        

        @Override
        public void run(){
            
            if(!(isGameOver()))
                update();
            
            isFoodEaten();
            System.out.println("( " + snake.x + " , " + snake.y + " )");
            
            
        }
    

    
    }
    
    
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GamePlay();
            }
        });
    }
}
