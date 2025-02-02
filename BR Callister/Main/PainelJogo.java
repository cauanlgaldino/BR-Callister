package Main;
import Entidades.Nave;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PainelJogo extends JPanel implements Runnable{
    final int originalSkinSize = 26; //tamanho dos sprites: 26x26
    int scale = 4;

    public final int skinSize = originalSkinSize * scale; // 104x104
    public final int skinSizeHeight = skinSize;
    public final int skinSizeWidth = originalSkinSize * scale * 2;
    final int maxColuna = 16;
    final int maxLinha = 12;
    final int larguraTela = skinSize * maxColuna; // 1664 pixeis
    final int comprimentoTela = skinSize * maxLinha; // 1248 pixeis
    
    //FPS
    int fps = 60;

    Controles tecla = new Controles();
    Thread gameThread;
    Nave nave = new Nave(this, tecla);

    public PainelJogo(){
        this.setPreferredSize(new Dimension(larguraTela, comprimentoTela));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(tecla);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double intervaloDesenho = 1000000000/fps;
        double delta = 0;
        long tempoAnterior = System.nanoTime();
        long tempoAtual;

        while(gameThread != null){
            tempoAtual = System.nanoTime();
            delta += (tempoAtual - tempoAnterior) / intervaloDesenho;
            tempoAnterior = tempoAtual;
            if(delta >= 1){
                //Atualiza informações:
                update();
                //Desenha na tela as informações atualizadas:
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        nave.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        nave.draw(g2);
        g2.dispose();
    }
}