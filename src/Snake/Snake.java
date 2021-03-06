

package Snake;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;





public class Snake extends JLabel{
    
    

    int x,
        y;
   
    private int move;
    
    
    private int total = 0;
    ArrayList <Snake> tail = new ArrayList();
    
    public ArrayList <Point> locations = new ArrayList();
    
    
    
    Snake(){
        
        this.move = 20;
//        this.setText("O");
        this.setIcon(new ImageIcon(getClass().getResource("/res/images/snake.png")));
        this.setSize( 20, 20);
        this.setVisible(true);

        
    }


    
    
        
    
    
    public void moveSnake() {

        
        
        if(GamePlay.up)
            if(this.y < 20)
                this.y = 380;
            else
                this.y-=move;
        else if(GamePlay.right)
            if(this.x > 360)
                this.x = 0;
            else
                this.x+=move;
        else if(GamePlay.down)
            if(this.y > 360)
                this.y = 0;
            else
                this.y+=move;
        else if(GamePlay.left)
            if(this.x < 20)
                this.x = 380;
            else
                this.x-=move;
        
        this.locations.add(this.locations.size(), new Point(this.x, this.y));
        
        
       
        
    }
    
    
    
    public void update(int body){    
        
    }
    
    
    
    
   
    public boolean eat(Food food){
        
        boolean b = false;
        if (this.x == food.x && this.y == food.y){
            System.out.println("eaten");
            food.newFood();
            food.setLocation(food.x, food.y);
            b = true;
        }
            
            this.total++;
        
        return b;
    }
    

    
        
 

   
    
    
    
}


