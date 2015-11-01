/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

***/


package dna;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestDH extends TestObjetSub
{

    @Override
    public void testScene() throws Exception {
        DoubleHelice1 doubleHelice1 = new DoubleHelice1(new double [] {20, 5, .2}, 2, new double[] {4, 8, 2}, 0);
        
        doubleHelice1.texture(new TColor(Color.RED));
        
        doubleHelice1.setMaxX(200);
        doubleHelice1.setMaxY(200);
        
        scene().add(doubleHelice1);
        
        /*doubleHelice1 = new DoubleHelice1(new double [] {8.8, 1.0, .2}, 2, new double[] {4, 8, 2}, 180);
        
        doubleHelice1.texture(new TColor(Color.RED));
        
        doubleHelice1.setMaxX(200);
        doubleHelice1.setMaxY(200);
        
        scene().add(doubleHelice1);
        */
        //Camera c = new Camera(Point3D.Z.mult(-20.0), Point3D.O0);
        
        //s//cene().lumieres().add(new LumierePonctuelle(Point3D.O0, Color.WHITE));
        
        //scene().cameraActive(c);
        
    }
    public static void main(String [] args)
    {
        TestDH dh = new TestDH();
        
        dh.loop(false);
        
        
        dh.setGenerate(GENERATE_MODEL);
        
        dh.setResx(1000);
        dh.setResy(1000);
        new Thread(dh).start();
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ginit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
