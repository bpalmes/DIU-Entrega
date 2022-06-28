/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.diu4;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author TESTER
 */
public class Lienzo extends JPanel{
    
    //Colores
    private final Color[] coloresFondo = {Color.WHITE, Color.RED, Color.BLUE};
    private final Color[] coloresPincel = {Color.BLACK, Color.RED, Color.BLUE};
    private int iPincel = 0;
    private int iLienzo = 0;
    
    
    //Coordenadas
    private int x[] = {0,0,0,0,0};
    private int y[] = {0,0,0,0,0};
    private int i = 0;
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(coloresFondo[iLienzo]);
        this.setForeground(coloresPincel[iPincel]);
        
         for(int i = 0; i < 5; i++) {
            if(x[i] != 0 && y[i] != 0) {
                g.fillOval(x[i], y[i], 10, 10);
            }            
        }
    }
    
    public void coordenadas(int x, int y) {
        this.x[this.i] = x;
        this.y[this.i] = y;
        i++;
        if(i > 4) i = 0;
        repaint();
    }
    
    public void pintaLienzo(int index) {
        iLienzo = index;
        repaint();
    }
    
    public void pintaPincel(int index) {
        iPincel = index;
        repaint();
    }
    
}
