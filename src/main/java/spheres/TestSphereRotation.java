/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

    Creation time 06-nov.-2014

***/


package spheres;

import SPhere.TestSphere.Trajectoires;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.TRISphere;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestSphereRotation extends TestObjetStub

{
TRISphere ts;
    @Override
    public void ginit() {
        ts = new TRISphere(Point3D.O0, 1);
        
        
        ts.texture(new TColor(Color.RED));
        
        
        
        scene().add(ts);
        
    }

    @Override
    public void testScene() throws Exception {
        Point3D sphere = Trajectoires.sphere(1.0*frame()/getMaxFrames(), 
                             1.0*frame()/getMaxFrames(), 2);
        scene().cameras().clear();
        scene().cameraActive(new Camera(sphere, Point3D.O0));
        
    }
    
    public static void main(String [] args)
    {
        TestSphereRotation tsr = new TestSphereRotation();
        
        tsr.loop(true);
        tsr.setMaxFrames(300);
        tsr.setResx(100);
        tsr.setResy(100);
        
        new Thread(tsr).start();
        
        
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
