
package Snake;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Food extends JLabel{
    
    int x,y;
    
    
    Food(){
        
        this.x = setX();
        this.y = setY();
        this.setSize(20, 20);
        this.setForeground(Color.yellow);
        
        
        //   I used getClass().getResourse() because it will load the imageIcon
        //   perfectly everytime unlike typing the path of the image 
        //   directly in the imageIcon parameter 
        this.setIcon(new ImageIcon(getClass().getResource("/res/images/food.png")));
        
        
        this.setVisible(true);
        
    }
    
    public int setX(){
        
        int n = newRandom();
        
        this.x = n;
        
        return n;
    }
    
    
    
    public int setY(){
        
        int n = newRandom();
        
        this.y = n;
        
        return n;
    }
    
    
    
    
    
    private int newRandom(){
        
        double d = Math.random()*1000;
        int r = (int)d;
                
        
        while((r%20 != 0) || (r > 380) || (r < 0)){
            d = Math.random()*1000;
            r = (int)d;
        }
        
        return r;
        
    }
    
    
    
    public void newFood(){
        
        this.x = setX();
        this.y = setY();
        
    }
    
    
    
    
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Food();
            }
        });
    }
    
}
