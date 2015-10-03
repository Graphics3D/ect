import SPhere.TestSphere.Trajectoires;
import info.emptycanvas.library.nurbs.ParametrizedSurface;
import info.emptycanvas.library.object.Camera;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.renderer.TestObjet;


/**
 * Created by manue on 03-10-15.
 */
class Forme extends ParametrizedSurface {
    public Point3D P0 = Point3D.O0;

    @Override
    public Point3D calculerPoint3D(double u, double v) {
        Point3D p = Trajectoires.sphere(u, v, 50);
        return p.moins(P0).mult(Math.exp(-10 * Point3D.distance(P0, p) * Point3D.distance(P0, p)));
    }

    @Override
    public Point3D calculerVitesse3D(double v, double v1) {
        return null;
    }
}

public class TriTest extends TestObjet {

    private Forme f;

    @Override
    public void afterRenderFrame() {

    }

    @Override
    public void finit() {

    }

    @Override
    public void ginit() {
        f = new Forme();
        scene().add(f);
    }

    public void afterRender() {

    }

    @Override
    public void testScene() throws Exception {
        scene().cameraActive(new Camera(Point3D.Z.mult(-20), Point3D.O0));

    }

    public static void main(String[] args) {
        TriTest test = new TriTest();
        test.setMaxFrames(100);

        new Thread(test).start();
    }

}
