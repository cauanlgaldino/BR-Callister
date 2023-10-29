package Main;
import javax.swing.JFrame;

public class App {
    public static void main (String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("BR Callister: A Revolta dos Robôs");
  
        PainelJogo painelJogo = new PainelJogo();
        window.add(painelJogo);
        
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        painelJogo.startGameThread();
    }
}