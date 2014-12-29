/*

    Vous êtes libre de :

*/
package starbuck.tests;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import java.awt.Color;

/**
 *
 * @author Manuel DAHMEN
 */
public class TestCubeTroue extends TestObjet {

    @Override
    public void testScene() {

        Polygone p = new Polygone(Color.red);
        p.setPoints(new Point3D[]{new Point3D(-0.5, -0.5, -0.5), new Point3D(-0.5, -0.5, 0.5), new Point3D(0.5, -0.5, 0.5), new Point3D(0.5, -0.5, -0.5)});
        scene().add(p);
        p = new Polygone(Color.blue);
        p.setPoints(new Point3D[]{new Point3D(-0.5, -0.5, -0.5), new Point3D(-0.5, -0.5, 0.5), new Point3D(-0.5, 0.5, 0.5), new Point3D(-0.5, 0.5, -0.5)});
        scene().add(p);
        p = new Polygone(Color.green);
        p.setPoints(new Point3D[]{new Point3D(0.5, 0.5, -0.5), new Point3D(0.5, 0.5, 0.5), new Point3D(0.5, -0.5, 0.5), new Point3D(0.5, -0.5, -0.5)});
        scene().add(p);
        p = new Polygone(Color.magenta);
        p.setPoints(new Point3D[]{new Point3D(0.5, 0.5, -0.5), new Point3D(0.5, 0.5, 0.5), new Point3D(-0.5, 0.5, 0.5), new Point3D(-0.5, 0.5, -0.5)});
        scene().add(p);
        p = new Polygone(Color.black);
        p.setPoints(new Point3D[]{new Point3D(-0.5, -0.5, 0.5), new Point3D(0.5, -0.5, 0.5), new Point3D(0.5, 0.5, 0.5), new Point3D(-0.5, 0.5, 0.5)});
        scene().add(p);
		
		scene().cameraActive(new Camera(new Point3D(0,0,-10), new Point3D(0,0,0)));

        description = "Cube troué au centre en perspective";
    }

    public static void main(String[] args) {
        TestCubeTroue testObjet = new TestCubeTroue();
        testObjet.run();
    }
}
