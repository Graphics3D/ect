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

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.TRIEllipsoide;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestEllipsoide extends TestObjetStub {

    @Override
    public void ginit() {
        setMaxFrames(1);
        loop(false);
        setGenerate(GENERATE_IMAGE);
    }

    @Override
    public void testScene() {
        TRIEllipsoide e = new TRIEllipsoide(Point3D.O0, 5, 2, 1);
        
        e.setMaxX(10);
        e.setMaxY(10);
        
        scene().add(e);
        
        scene().cameraActive(new Camera(Point3D.Z.mult(-10), Point3D.O0) );
        
    }

    public static void main(String[] args) {
        
        new Thread(new TestEllipsoide())
        
        .start();
        
    }
}
