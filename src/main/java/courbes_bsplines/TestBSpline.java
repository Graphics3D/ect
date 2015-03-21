/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courbes_bsplines;

import info.emptycanvas.library.object.BSpline;
import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.testing.TestObjet;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestBSpline extends TestObjet {

    private BSpline b;

    @Override
    public void finit() {
        scene().clear();

        b = new BSpline();

        for(Point3D p : TestsBSpline.p(frame()))
        {
            b.add(p);
        }
        b.texture(new ColorTexture(Color.WHITE));

        scene().add(b);

        scene.cameraActive().setCamera(Point3D.Z.mult(-(2 * frame() + 2)));

    }

    public static void main(String[] args) {
        TestBSpline ts = new TestBSpline();

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
