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
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.*;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestArc extends TestObjetStub {

    private TRIExtrusionGeneralisee eg;

    @Override
    public void ginit() {
        eg = new TRIExtrusionGeneralisee();
        //CheminDroite cd = new CheminDroite(new SegmentDroite(Point3D.X, Point3D.Y, new ColorTexture(Color.WHITE)));
      BezierCubique bezierCubique = new BezierCubique();
        bezierCubique.add(Point3D.O0);
        bezierCubique.add(Point3D.X);
        bezierCubique.add(Point3D.X.plus(Point3D.Y));
        bezierCubique.add(Point3D.Y);
        CheminBezier cheminBezier = new CheminBezier(bezierCubique);
       
        eg.setChemin(cheminBezier/*new CheminDroite(new SegmentDroite(Point3D.O0, Point3D.Y.mult(5)))*/);

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
        TestArc tp = new TestArc();
        tp.setGenerate(GENERATE_IMAGE|GENERATE_MODEL);
        tp.loop(false);
        new Thread(tp).start();
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
