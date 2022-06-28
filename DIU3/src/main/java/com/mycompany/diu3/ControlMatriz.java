/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.diu3;



/**
 *
 * @author TESTER
 */
public class ControlMatriz {
    
    private Matriz m;
    private String mtexto;

    public ControlMatriz() {
        this.m = new Matriz();
        
        
    }
    
    /**
     * Methods
     */

    public void llenarMatriz(){
        this.m.llenarMatriz(0, 10);
        this.verMatriz(0);
        
    }
    
    public void actualizarMatriz(int lower, int upper , int limite){
        this.m.llenarMatriz(lower, upper);
        this.verMatriz(limite);
        
    }
    
    public void verEstaMatriz(int n){
        this.verMatriz(n);
        
    }
    
    public void verMatriz(int limite){
        int[][] currentMatrix = this.m.getM();
        this.mtexto = new String();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(currentMatrix[i][j] < limite){
                    mtexto += " - ";
                } else {
                    mtexto += " " + currentMatrix[i][j]+" ";
                }
            }
            mtexto += "\n";
        }
    }
    
    public String getTexto(){
        return this.mtexto;
    }
    
    public Matriz getMatriz(){
        return this.m;
    }
    
   
    
}
