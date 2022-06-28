/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.diu6;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
/**
 *
 * @author TESTER
 */
public class Umbraliza extends JPanel{
    private BufferedImage pic = null;
    private BufferedImage pic2 = null;
    private String nombre;
    private Graphics g;
    
    public Umbraliza(){    
        
    }

    @Override
    public void paintComponent(Graphics g){
        this.g = g ;
        super.paintComponent(g);
        
        
            g.drawImage(pic2, 0, 0, null);
        
        
    }
    
    void reloadCanvas(File fileSelected) throws MalformedURLException, IOException {
        leerArchivo(fileSelected);
        System.out.println(pic2);
        this.repaint();
        
    }


    private void leerArchivo(File fileSelected) throws IOException {
        try {
        pic = ImageIO.read(fileSelected);
        pic2 = pic;
        this.nombre = fileSelected.getName();
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(Umbraliza.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Umbraliza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BufferedImage getCurrentPicture(){
        return this.pic2;
    }

    public void umbralizacion(int factor) throws IOException{
        Mat mat = tresholdingPicture(bufferredAMat(this.pic), factor);
        this.pic2 = matABufferred(mat);
        this.repaint();
    }
    
    public static Mat bufferredAMat(BufferedImage image) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", byteArrayOutputStream);
        byteArrayOutputStream.flush();
        return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.IMREAD_UNCHANGED);
    }
    
    public static BufferedImage  matABufferred(Mat matrix)throws IOException {
        MatOfByte mob=new MatOfByte();
        Imgcodecs.imencode(".jpg", matrix, mob);
        return ImageIO.read(new ByteArrayInputStream(mob.toArray()));
    }
    //Tal cual
    private Mat tresholdingPicture(Mat imagen_original, Integer umbral) {
        // crear dos imágenes en niveles de gris con el mismo
        // tamaño que la original
        Mat imagenGris = new Mat(imagen_original.rows(),
        imagen_original.cols(),
        CvType.CV_8U);
        Mat imagenUmbralizada = new Mat(imagen_original.rows(),
        imagen_original.cols(),
        CvType.CV_8U);
        // convierte a niveles de grises la imagen original
        Imgproc.cvtColor(imagen_original,
        imagenGris,
        Imgproc.COLOR_BGR2GRAY);
        // umbraliza la imagen:
        // - píxeles con nivel de gris > umbral se ponen a 1
        // - píxeles con nivel de gris <= umbra se ponen a 0
        Imgproc.threshold(imagenGris,
        imagenUmbralizada,
        umbral,
        255,
        Imgproc.THRESH_BINARY);
        // se devuelve la imagen umbralizada
        return imagenUmbralizada;
    }
    
    public String getCurrentPictureName() {
        return nombre.substring(0, nombre.lastIndexOf("."));
    }

    
    public String getCurrentPictureFormat(){
        return nombre.substring(nombre.lastIndexOf("."));
    }

}
