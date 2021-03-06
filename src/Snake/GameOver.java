
package Snake;

import java.awt.Color;
import javax.swing.JLabel;


public class GameOver extends JLabel{
    
    
    Thread t = new Thread();
    GameOver(){
        
        
        setSize(180,80);
        setForeground(Color.white);
        setText("GAME OVER");
        setVisible(true);
        
    }
    
    
    
}
