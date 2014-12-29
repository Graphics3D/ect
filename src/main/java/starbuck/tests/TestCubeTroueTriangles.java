/*

    Vous êtes libre de :

*/
package starbuck.tests;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;

/**
 *
 * @author Manuel DAHMEN
 */
public class TestCubeTroueTriangles extends TestObjet {

    @Override
    public void testScene() {

        Cube c = new Cube(1, Point3D.X.mult(3));
        scene().add(c);
        c = new Cube(1, Point3D.X.mult(-3));
        scene().add(c);
        c = new Cube(1, Point3D.Y.mult(3));
        scene().add(c);
        c = new Cube(1, Point3D.Y.mult(-3));
        scene().add(c);
        c = new Cube(1, Point3D.Z.mult(3));
        scene().add(c);
        
        scene().cameraActive(new Camera(new Point3D(0,0,-15), new Point3D(0,0,0)));

        description = "5 cubes";
    }

    public static void main(String[] args) {
        TestCubeTroueTriangles testObjet = new TestCubeTroueTriangles();
        testObjet.run();
    }
}
