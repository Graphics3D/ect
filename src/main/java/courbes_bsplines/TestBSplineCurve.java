/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courbes_bsplines;

import java.awt.Color;
import info.emptycanvas.library.nurbs.BSplineCurve;
import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.testing.TestObjet;

/**
 * Test BAD UGLY COMME TA MERE
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
@Deprecated
public class TestBSplineCurve  extends TestObjet{
    private BSplineCurve b;
    
    @Override
    public void afterRenderFrame() {
    }

    @Override
    public void finit() {
        
        scene().add(b);
        
        scene.cameraActive().setCamera(Point3D.Z.mult(-24));
        
    }

    @Override
    public void ginit() {
        b = new BSplineCurve();
        //TestsBSpline.u(), TestsBSpline.p(), 4);
        b.texture(new ColorTexture(Color.WHITE));
    }

    @Override
    public void testScene() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void afterRender() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String []args)
    {
        TestBSplineCurve ts = new TestBSplineCurve();
        
        ts.setGenerate(GENERATE_IMAGE);
        
        ts.loop(false);
        
        ts.setMaxFrames(10);
        
        new Thread (ts) .start();
        
        
    }
}
