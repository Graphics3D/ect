/**
 * *
 * Global license :  *
 * Microsoft Public Licence
 *
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 *
 **
 */
package trigenerateurabstract.triextrusiongeneralisee;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.*;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestCylindre extends TestObjet {

    private TRIExtrusionGeneralisee eg;

    @Override
    public void ginit() {
        eg = new TRIExtrusionGeneralisee();
        CheminDroite cd = new CheminDroite(new SegmentDroite(Point3D.X, Point3D.Y, new ColorTexture(Color.WHITE)));

        eg.setChemin(cd);

        eg.setSurface(new SurfaceCercle(2));

        eg.setMaxX(100);

        eg.setMaxY(100);
        
        eg.texture(new ColorTexture(Color.WHITE));

        this.description = "Cylindre ";
    }

    @Override
    public void testScene() throws Exception {
        scene().clear();
        scene().add(eg);

        scene().cameraActive(new Camera(Point3D.Z.mult(-10), Point3D.O0));
    }

    public static void main(String[] args) {
        TestCylindre tp = new TestCylindre();
        tp.setGenerate(GENERATE_IMAGE|GENERATE_MODEL);
        tp.loop(false);
        new Thread(tp).start();
    }
}
