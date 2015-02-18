/*

    Vous êtes libre de :

*/

package starbuck.tests;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.TRISphere;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Manuel DAHMEN
 * @date
 */
public class TestSphere extends TestObjetStub{

    @Override
    public void testScene() {
        TRISphere s;
        s = new TRISphere(Point3D.X.mult(3), 2);
        try {
            s.texture(new TColor(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("2456614033-blue-texture.jpg")))));
        } catch (IOException ex) {
            Logger.getLogger(TestSphere.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene().add(s);
        s = new TRISphere(Point3D.X.mult(-3), 2);
        try {
            s.texture(new TColor(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("2456614033-blue-texture.jpg")))));
        } catch (IOException ex) {
            Logger.getLogger(TestSphere.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene().add(s);
        s = new TRISphere(Point3D.Y.mult(3), 2);
        try {
            s.texture(new TColor(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("2456614033-blue-texture.jpg")))));
        } catch (IOException ex) {
            Logger.getLogger(TestSphere.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene().add(s);
        s = new TRISphere(Point3D.Y.mult(-3), 2);
        try {
            s.texture(new TColor(new ECBufferedImage(ImageIO.read(getClass().getResourceAsStream("2456614033-blue-texture.jpg")))));
        } catch (IOException ex) {
            Logger.getLogger(TestSphere.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene().add(s);
        scene().cameraActive(new Camera(new Point3D(0,0,-4), new Point3D(0,0,0)));

        description = "4 spheres with textures";
    }
    public static void main(String[] args)
    {
        TestSphere ts = new TestSphere();
        ts.run();
    }
}
