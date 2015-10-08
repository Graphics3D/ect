/***
Global license : 


 author Manuel Dahmen <manuel.dahmen@gmail.com>

    Creation time 06-nov.-2014

 Updated 08/09/2015

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
        Cube c = new Cube(0.7, Point3D.O0);

        ts.texture(new ColorTexture(Color.RED));
        c.texture(new ColorTexture(Color.BLUE));
        
        
        scene().add(ts);
        scene().add(c);
    }

    @Override
    public void testScene() throws Exception {
        Point3D sphere = Trajectoires.sphere(1.0*frame()/getMaxFrames(),
                0, 5);
        scene().cameras().clear();
        scene().cameraActive(new Camera(sphere, Point3D.O0));
        
    }
    
    public static void main(String [] args)
    {
        TestSphereRotation tsr = new TestSphereRotation();
        
        tsr.loop(true);
        tsr.setMaxFrames(300);
        //tsr.setResx(100);
        //tsr.setResy(100);
        tsr.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);
        new Thread(tsr).start();
        
        
    }

    @Override
    public void finit() {

    }
    

}
