/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <manuel.dahmen@gmail.com>

***/


package sphererotation;

import SPhere.TestSphere.Trajectoires;
import info.emptycanvas.library.object.Camera;
import info.emptycanvas.library.object.ECBufferedImage;
import info.emptycanvas.library.object.ImageTexture;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.TRISphere;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestSphereManuelDahmen extends TestObjet
{
    double distance = 35;
    double rayon = 10;
    int maxx=100; int maxy=100;
    TRISphere tp = new TRISphere(Point3D.O0, rayon);
    @Override
    public void ginit() {
        scene().add(tp);
        scene().cameraActive(new Camera(Point3D.X.mult(distance), Point3D.O0));
        
        tp.setMaxX(maxx);
        tp.setMaxY(maxy);
        
        try {
            tp.texture(new ImageTexture(new ECBufferedImage(ImageIO.read(this.getClass().getResourceAsStream("map.png")))));
        } catch (IOException ex) {
            Logger.getLogger(TestSphereManuelDahmen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void testScene() throws Exception {
        
        scene().cameraActive().setCamera(Trajectoires.sphere(1.0*frame()/250, 0, distance));
        
    }

    public static void main(String [] args)
    {
        
        TestSphereManuelDahmen ts = new TestSphereManuelDahmen();
        
        ts.loop(true);
        
        ts.setMaxFrames(500);
        
        new Thread(ts).start();
    }
}
