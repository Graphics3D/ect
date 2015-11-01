package paintingActs;

import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.testing.TestObjetSub;
import info.emptycanvas.library.tribase.TRISphere;

import java.awt.*;

/**
 * Created by manue on 12-10-15.
 */
public class TestSpheres extends TestObjetSub {
    public void ginit() {
        TRISphere sphere = new TRISphere(Point3D.O0, 10);
        sphere.texture(new ColorTexture(Color.GREEN));
        scene().add(sphere);
        sphere.setPaintingAct(getZ(), scene(), new SpheresPA());
    }

    public void testScene() {

    }

    public static void main(String[] args) {
        TestObjet to = new TestSpheres();

        to.loop(true);
        to.unterminable(false);
        to.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);
        to.setMaxFrames(2000);

        new Thread(to).start();
    }
}
