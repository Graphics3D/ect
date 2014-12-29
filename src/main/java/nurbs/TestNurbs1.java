/**
 * *
 * Global license : * Microsoft Public Licence
 *
 * author Manuel Dahmen <ibiiztera.it@gmail.com>
 *
 **
 */
package nurbs;

import info.emptycanvas.library.object.Camera;
import info.emptycanvas.library.object.Point3D;
import be.ibiiztera.md.pmatrix.pushmatrix.base.Nurbs;
import info.emptycanvas.library.nurbs.NurbsSurface;
import info.emptycanvas.library.testing.TestObjet;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestNurbs1 extends TestObjet {

    @Override
    public void testScene() throws Exception {
        NurbsSurface n = new NurbsSurface();
        n.setMaillage(new Point3D[][]{
            {
                new Point3D(-1, -1, -1),
                new Point3D(-1, 1, -1),
                new Point3D(-1, 1, 1),},
            {
                new Point3D(1, 1, 1),
                new Point3D(1, 1, -1),
                new Point3D(1, -1, -1),},
            {
                new Point3D(2, 1, 1),
                new Point3D(2, 2, 1),
                new Point3D(2, 2, 2)
            }
        }, new double[][]{
            {0.9, 0.9, 0.9},
            {0.9, 0.9, 0.9},
            {0.9, 0.9, 0.9}
        });



        n.setReseauFonction(new double[][]{
            {0, 1},
            {0, 1}
        });

        n.creerNurbs();


        scene().add(n);

        scene().cameraActive(new Camera(Point3D.Z.mult(-1), Point3D.O0));
    }

    public static void main(String[] args) {
        TestNurbs1 n = new TestNurbs1();
        n.loop(false);
        new Thread(n).start();
    }
}
