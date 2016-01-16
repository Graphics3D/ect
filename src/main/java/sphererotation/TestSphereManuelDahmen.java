/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <manuel.dahmen@gmail.com>

***/


package sphererotation;

import SPhere.TestSphere.Trajectoires;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.testing.TestObjetSub;
import info.emptycanvas.library.tribase.TRISphere;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * cette classe produit une image de sphère avec "Manuel Dahmen" écrit dessus. La sphère tourne
 * puis s'en va et revient à l'écran.
 *
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestSphereManuelDahmen extends TestObjetSub
{
    double distance = 35;
    double rayon = 10;
    int maxx=100; int maxy=100;
    TRISphere tp = new TRISphere(Point3D.O0, rayon);




    @Override
    public void ginit() {
        scene().add(tp);
        scene().cameraActive(new Camera(Point3D.X.mult(distance).plus(Point3D.Y.plus(15)), Point3D.O0));

        tp.setRotation(tp.new Rotation(new Matrix33(new Point3D[] {Point3D.Y, Point3D.X, Point3D.Z}), Point3D.O0));

        tp.setMaxX(maxx);
        tp.setMaxY(maxy);
        
        try {
            tp.texture(new ImageTexture(new ECBufferedImage(ImageIO.read(this.getClass().getResourceAsStream("map2.png")))));
        } catch (IOException ex) {
            Logger.getLogger(TestSphereManuelDahmen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void testScene() throws Exception {
        
        scene().cameraActive().setEye(Matrix33.rot(90/360.0*2*Math.PI, 0).mult(Trajectoires.sphere(1.0*frame()/250, 0, distance)));
        
    }

    public static void main(String [] args)
    {
        
        TestSphereManuelDahmen ts = new TestSphereManuelDahmen();

        ts.setGenerate(TestObjet.GENERATE_IMAGE|GENERATE_MOVIE);

        ts.loop(true);
        
        ts.setMaxFrames(500);
        
        new Thread(ts).start();
    }

    @Override
    public void finit() {
    }
}
