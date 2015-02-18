/*
 * 2013 Manuel Dahmen
 */
package dossierimages;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.Plan3D;
import java.awt.Color;
import java.io.File;

/**
 *
 * @author Se7en
 */
public class TestDossier extends TestObjetStub {

    private int[][] coordCube = new int[][]{{-1, -1, -1, 1}, {-1, 1, 1, 1}, {1, 1, 1, -1}, {1, -1, -1, -1}};
    private int[][] coordCube2 = new int[][]{{-1, -1, -1, 1}, {-1, 1, 1, 1}, {1, 1, 1, -1}, {1, -1, -1, -1}};
    private Dossier dos = new Dossier();

    @Override
    public void ginit() {
        int size = dos.getImages().size();

        for (int i = 0; i < size; i++) {
            Plan3D plan3D = new Plan3D();

            plan3D.setMaxX(1);
            plan3D.setMaxY(1);

            plan3D.texture(new TColor(dos.getImages().get(i)));

            plan3D.pointOrigine(
                    Point3D.O0.plus(Point3D.Z.mult(i / 4)
                            .plus(Point3D.X.mult(coordCube[(i % 4)][0]))
                            .plus(Point3D.Y.mult(coordCube[(i % 4)][1]))));
            ;
            plan3D.pointXExtremite(
                    Point3D.O0.plus(Point3D.Z.mult(i / 4)
                            .plus(Point3D.X.mult(coordCube[(i % 4)][2]))
                            .plus(Point3D.Y.mult(coordCube[(i % 4)][3]))));

            plan3D.pointYExtremite(
                    plan3D.pointOrigine().plus(Point3D.Z)
            );

            scene().add(plan3D);

        }
    }

    public void addDossier(File f) {
        dos.addDossier(f);
    }

    @Override
    public void testScene() throws Exception {
        setCouleurFond(new TColor(Color.white));
        scene().cameraActive(new Camera(
                //Deplace.deplace(1, getMaxFrames(), Point3D.Z.mult(-30), Point3D.Z.mult(30), frame, getMaxFrames()),
                Point3D.O0,
                Point3D.Z.mult(20)
        ));
    }

    public static void main(String[] args) {

        TestDossier td = new TestDossier();

        td.dos.limite = 12;
        if (args != null
                && args.length > 0
                && args[0] != null
                && !args[0].equals("")
                && new File(args[0]).exists()) {
            td.addDossier(new File(args[0]));
        } else {
            td.addDossier(new File("C:\\Users\\Se7en\\Pictures\\Textures\\873-8-tileable-metal-textures\\square-tiles"));
        }
        td.setResx(1000);

        td.setResy(1000);

        td.loop(false);

        td.setFileExtension("png");

        td.setMaxFrames(1);

        //td.setGenerate(GENERATE_OPENGL);
        td.run();
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class Deplace {

    public static Point3D deplace(int framemin, int framemax, Point3D p0, Point3D p1, int framecurr, int nof) {

        return framecurr < framemin
                ? p0
                : (framecurr > framemax
                        ? p1
                        : p0.plus(p1.moins(p0).mult((1.0 * framecurr - framemin) / nof)));
    }
}
