/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.diu3;


import static java.lang.Math.abs;

/**
 *
 * @author TESTER
 * Clase que controla la matriz y la randomiza
 */
public class Matriz {
    
    private int[][] m;
    private int minimum;
    private int maximum;
    
    public Matriz() {
        
    }

    public void llenarMatriz(int lower, int upper){
        this.m = new int[10][10];
        this.minimum = lower;
        this.maximum = upper;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.m[i][j] = (int)(Math.random() * ((lower - upper) + 1))+lower;;
            }
        }
    }
    
    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
    
    public int[][] getM() {
        return m;
    }
    
}
