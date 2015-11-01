/*

    Vous êtes libre de :

*/
package starbuck.tests;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Manuel DAHMEN
 */
public class TestPolygones extends TestObjetSub {

    @Override
    public void testScene() {
        description = "octogone jaune";
        Polygone p = new Polygone(Color.yellow);
        ArrayList<Point3D> arrayList = new ArrayList<Point3D>();
        for (int i = 0; i < 8; i++) {
            arrayList.add(new Point3D(Math.cos(i / 8.0 * Math.PI * 2), Math.sin(i / 8.0 * Math.PI * 2), 0));
        }
        p.setPoints(arrayList);
        scene.add(p);
    }

    public static void main(String[] argd) {
        TestPolygones tp = new TestPolygones();
        tp.run();

    }
}
