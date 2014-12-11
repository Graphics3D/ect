/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package starbuck.tests;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.TRISphere;

/**
 *
 * @author Atelier
 */
public class TestSphereInterieur extends TestObjet{
        @Override
    public void testScene()
    {
        try {
            //setResx(320);
            //setResy(200);
            TRISphere ts =  new TRISphere(new Point3D(0,0,0), 100);
            
            ts.texture(new TColor(new ECBufferedImage(ImageIO.read(getClass().getResource("Coucherdesoleil.jpg")))));
            scene().add(ts);
            
            camera(new Camera(new Point3D(0,0,-10), new Point3D(0,0,0)));
            description("Textured sphere seen from inside");
        } catch (IOException ex) {
            Logger.getLogger(TestSphereInterieur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String [] args)
    {
        TestSphereInterieur to = new TestSphereInterieur();
        to.run();
    }


}
