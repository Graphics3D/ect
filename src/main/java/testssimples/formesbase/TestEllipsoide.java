/**
 * *
 * Global license :  *
 * Microsoft Public Licence
 *
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 *
 **
 */
package testssimples.formesbase;

import info.emptycanvas.library.object.Camera;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.testing.TestObjetSub;
import info.emptycanvas.library.tribase.TRIEllipsoide;

/**
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestEllipsoide extends TestObjetSub {

    public static void main(String[] args) {

        new Thread(new TestEllipsoide())

                .start();

    }

    @Override
    public void ginit() {
        setGenerate(GENERATE_IMAGE | GENERATE_MODEL | GENERATE_MOVIE);
        setMaxFrames(1);
        loop(false);
    }

    @Override
    public void testScene() {
        TRIEllipsoide e = new TRIEllipsoide(Point3D.O0, 5, 2, 1);

        e.setMaxX(100);
        e.setMaxY(100);

        scene().add(e);

        scene().cameraActive(new Camera(Point3D.Z.mult(-10), Point3D.O0) );

    }
}
