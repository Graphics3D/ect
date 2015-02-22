/**
 * *
 * Global license :  *
 * Microsoft Public Licence
 *
 * author Manuel Dahmen <manuel.dahmen@gmail.com>
 *
 **
 */
package trigenerateurabstract.paraboloidehyperbolique;

import info.emptycanvas.library.object.Camera;
import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.LumierePointSimple;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.ParaboloideHyperbolique;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestPH extends TestObjet {

    private ParaboloideHyperbolique ph = null;

    public static void main(String[] argd) {
        TestPH tth = new TestPH();

        tth.loop(true);
        tth.setMaxFrames(250);

        new Thread(tth).start();
    }

    @Override
    public void afterRenderFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void finit() {
        double angleU = Math.abs(Math.cos(2.0 * Math.PI * frame() / getMaxFrames() * 6));
        double angleV = Math.abs(Math.sin(2.0 * Math.PI * frame() / getMaxFrames() * 6));
        ph = new ParaboloideHyperbolique(angleU , angleV, 1);
        scene().add(ph);
        ph.texture(new ColorTexture(Color.RED));
    }

    @Override
    public void ginit() {

    }

    @Override
    public void testScene() throws Exception {
        scene().cameraActive(new Camera(Point3D.Z.mult(-5), Point3D.O0));
        scene().lumieres().add(new LumierePointSimple(Color.WHITE, Point3D.X.plus(Point3D.Y), 1));
    }

    public void afterRender() {

    }
}
