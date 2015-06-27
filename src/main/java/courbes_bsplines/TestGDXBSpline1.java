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
    TubulaireN2 t = new TubulaireN2();
    private static final double INCR_PRECISION = 0.00001;
    
    @Override
    public void finit() {
        

        b = new gdx_BSplineCurve();

        b.incr = INCR_PRECISION;
        
        
        b.instantiate(TestsBSpline.p2(frame()), 6);

        b.texture(new ColorTexture(Color.WHITE));

        t.curve(b);
        
        t.nbrAnneaux((int)(1/INCR_PRECISION));
        t.diam(1);
        t.nbrRotations(10);
        t.texture(new ColorTexture(Color.WHITE));
        
        scene().add(t);

        scene.cameraActive().setEye(Point3D.Z.mult(-(2 * frame() + 2)));

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
