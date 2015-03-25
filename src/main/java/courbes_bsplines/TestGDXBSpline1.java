package courbes_bsplines;

import info.emptycanvas.library.gdximports.gdx_BSplineCurve;
import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.testing.TestObjet;
import static info.emptycanvas.library.testing.TestObjet.GENERATE_IMAGE;
import static info.emptycanvas.library.testing.TestObjet.GENERATE_MOVIE;
import info.emptycanvas.library.tribase.TubulaireN2;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestGDXBSpline1 extends TestObjet
{
    private gdx_BSplineCurve b;
 @Override
    public void finit() {
        scene().clear();

        b = new gdx_BSplineCurve();

        b.incr = 0.00001;
        
        
        b.instantiate(TestsBSpline.p(frame()), 3);

        b.texture(new ColorTexture(Color.WHITE));

        TubulaireN2 t = new TubulaireN2(b);
        
        t.nbrAnneaux((int)(1/b.incr));
        t.diam((2 * frame() + 2)/300.0);
        t.nbrRotations(3);
        t.texture(new ColorTexture(Color.WHITE));
        
        scene().add(t);

        scene.cameraActive().setCamera(Point3D.Z.mult(-(2 * frame() + 2)));

    }

    public static void main(String[] args) {
        TestGDXBSpline1 ts = new TestGDXBSpline1();

        ts.setGenerate(GENERATE_IMAGE | GENERATE_MOVIE);

        ts.loop(false);

        ts.setMaxFrames(10);

        new Thread(ts).start();

    }

    @Override
    public void afterRenderFrame() {
    }

    @Override
    public void ginit() {
    }

    @Override
    public void testScene() throws Exception {
    }

    public void afterRender() {
    }
}
