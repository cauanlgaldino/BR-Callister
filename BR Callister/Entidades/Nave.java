package Entidades;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.Controles;
import Main.PainelJogo;

public class Nave extends Entidade{
    PainelJogo pj;
    Controles tecla;

    public Nave(PainelJogo pj, Controles tecla){
        this.pj = pj;
        this.tecla = tecla;

        setValoresPadroes();
        getImagemNave();
    }
    public void getImagemNave(){
        try{
            nave = ImageIO.read(getClass().getResourceAsStream("/assets/nave.png"));
        } catch(IOException e ){
            e.printStackTrace();
        }
    }
    public void setValoresPadroes(){
        x = 100;
        y = 100;
        velocidade = 4;
    }
    public void update(){
        if (tecla.cimaPress) {
            y -= velocidade;
            if(tecla.dirPress){
                y -= velocidade / 4;
                x += velocidade / 2;
            } else if (tecla.esqPress){
                y -= velocidade / 4;
                y -= velocidade / 2;
            } else if (tecla.baixoPress){
                y += velocidade;
            }
        }
        else if (tecla.baixoPress) {
            y += velocidade;
            if (tecla.dirPress){
                y += velocidade / 4;
                x += velocidade / 2;
            } else if (tecla.esqPress){
                y += velocidade / 4;
                x -= velocidade / 2;
            } else if (tecla.cimaPress){
                y -= velocidade;
            }
        }
        else if (tecla.esqPress) {
            x -= velocidade;
            if (tecla.dirPress){
                x += velocidade;
            }
        }
        else if (tecla.dirPress) {
            x += velocidade;
            if (tecla.esqPress){
                x -= velocidade;
            }
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = nave;
        g2.drawImage(image, x, y, pj.skinSize, pj.skinSize, null);
    }
}
