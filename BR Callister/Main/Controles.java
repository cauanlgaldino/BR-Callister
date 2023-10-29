package Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controles implements KeyListener{
    public boolean cimaPress, baixoPress, esqPress, dirPress;
    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                cimaPress = true;
                break;
            case 's':
                baixoPress = true;
                break;
            case 'a': 
                esqPress = true;
                break;
            case 'd':
                dirPress = true;
                break;
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                cimaPress = false;
                break;
            case 's':
                baixoPress = false;
                break;
            case 'a': 
                esqPress = false;
                break;
            case 'd':
                dirPress = false;
                break;
        }
    }
}
