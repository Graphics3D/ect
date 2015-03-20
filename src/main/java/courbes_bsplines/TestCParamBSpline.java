/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courbes_bsplines;

import info.emptycanvas.library.nurbs.CourbeParametriqueBSpline;
import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.testing.TestObjet;
import static info.emptycanvas.library.testing.TestObjet.GENERATE_IMAGE;
import java.awt.Color;

/**
 *Test BAD UGLY COMME TA MERE
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestCParamBSpline extends TestObjet{
    private CourbeParametriqueBSpline b;
    @Override
    public void afterRenderFrame() {
    }

    @Override
    public void finit() {
        scene().clear();
        
        b = new CourbeParametriqueBSpline(TestsBSpline.u(frame()+1), TestsBSpline.p(frame()), 5);
        
        b.texture(new ColorTexture(Color.WHITE));
        scene().add(b);
        
        scene.cameraActive().setCamera(Point3D.Z.mult(-2*frame()-2));
        
    }

    @Override
    public void ginit() {
        
    }

    @Override
    public void testScene() throws Exception {
        
    }

    public void afterRender() {
        
    }
    
    public static void main(String []args)
    {
        TestCParamBSpline ts = new TestCParamBSpline();
        
        ts.setGenerate(GENERATE_IMAGE|GENERATE_MOVIE);
        
        ts.unterminable(false);
        
        ts.loop(true);
        
        ts.setMaxFrames(200);
        
        new Thread (ts) .start();
        
        
    }


}
