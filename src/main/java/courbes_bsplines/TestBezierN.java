/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courbes_bsplines;

import java.awt.Color;
import info.emptycanvas.library.nurbs.*;
import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.testing.TestObjet;

/**
 * Test OK
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestBezierN extends TestObjet{
    private CourbeParametriquePolynomialeBezier b;
    
    @Override
    public void afterRenderFrame() {
    }

    @Override
    public void finit() {
        scene().clear();
        
        b = new CourbeParametriquePolynomialeBezier(TestsBSpline.p(frame()));

        b.texture(new ColorTexture(Color.WHITE));
        
     
        scene().add(b);
        
        scene.cameraActive().setCamera(Point3D.Z.mult(-(2*frame()+2)));
        
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
        TestBezierN ts = new TestBezierN();
        
        ts.setGenerate(GENERATE_IMAGE|GENERATE_MOVIE);
        
        ts.loop(false);
        
        ts.setMaxFrames(10);
        
        new Thread (ts) .start();
        
        
    }
}
