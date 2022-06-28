/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.diu5;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import com.mycompany.utils.UtilsPractica5;

/**
 *
 * @author TESTER
 */
public class Lienzo extends JPanel{
    
    private BufferedImage picture = null;
    private BufferedImage logo = null;
    private BufferedImage copia = null;
    private int x;
    private int y;
    private Graphics g;
    private UtilsPractica5 utils;
    
    
    public Lienzo(){
        
       try {
            
            logo = ImageIO.read(new File("src\\files\\starwarsLogo.png"));            
            picture = ImageIO.read(new File("src\\files\\hellothere1.jpg"));
            copia = picture;
        } catch (MalformedURLException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public void paintComponent(Graphics g){
        this.g = g;
        super.paintComponent(g);
        g.drawImage(picture, 0, 0, null);
        g.drawImage(logo, x, y, null);
    }
    public void coordenadas(int x, int y) {
        this.x = x;
        this.y = y;
        this.repaint();
    }
    
    public void pinta(boolean rojo, boolean verde, boolean azul) {
        picture = utils.seleccionarComponentes(copia,rojo,verde,azul);        
        this.repaint();
    }
    
}
