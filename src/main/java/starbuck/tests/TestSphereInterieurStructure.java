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
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.TRISphere;

/**
 *
 * @author Atelier
 */
public class TestSphereInterieurStructure extends TestObjetStub{
        @Override
    public void testScene()
    {
        try {
            setResx(1200);
            setResy(1000);
            TRISphere ts =  new TRISphere(new Point3D(0,0,0), 100);
            
            ts.texture(new TColor(new ECBufferedImage(ImageIO.read(getClass().getResource("Coucherdesoleil.jpg")))));
            ts.setMaxY(200);
            ts.setMaxY(200);
            scene().add(ts);
            
            scene().cameraActive(new Camera(new Point3D(0,0,-200), new Point3D(0,0,0)));
            description("Textured sphere seen from inside");
        } catch (IOException ex) {
            Logger.getLogger(TestSphereInterieurStructure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String [] args)
    {
        TestSphereInterieurStructure to = new TestSphereInterieurStructure();
        to.setStructure(true);
        to.run();
    }


}
