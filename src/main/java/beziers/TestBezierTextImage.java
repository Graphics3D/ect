/***
Global license : 

    CC Attribution
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

***/


package beziers;

import info.emptycanvas.library.nurbs.SurfaceParametriquePolynomialeBezier;
import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.ECBufferedImage;
import info.emptycanvas.library.object.ImageTexture;
import info.emptycanvas.library.object.P;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.testing.TestObjetStub;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestBezierTextImage extends TestObjetStub{
    private final Point3D[][] coeff = new Point3D[][]{
        {P.n(2,-2,0), P.n(2,-1,0),P.n(2,0,0), P.n(2,1,0), P.n(2,2,0)},
        {P.n(1,-2,0), P.n(1,-1,0),P.n(1,0,0), P.n(1,1,0), P.n(1,2,0)},
        {P.n(0,-2,0), P.n(0,-1,0),P.n(0,0,0), P.n(0,1,0), P.n(0,2,0)},
        {P.n(-1,-2,0), P.n(-1,-1,0),P.n(-1,0,0), P.n(-1,1,0), P.n(-1,2,0)},
        {P.n(-2,-2,0), P.n(-2,-1,0),P.n(-2,0,0), P.n(-2,1,0), P.n(-2,2,0)}
            };
    private SurfaceParametriquePolynomialeBezier s = new SurfaceParametriquePolynomialeBezier(coeff);
    ImageTexture imgTexture ;

    @Override
    public void testScene(File f) throws Exception {
    }
    @Override
    public void ginit() { 
        try {
            imgTexture = new ImageTexture(ECBufferedImage.getFromFile(new File("C:\\Emptycanvas\\textures\\text1.jpg")));
            s.texture(imgTexture);
        } catch (IOException ex) {
            s.texture(new ColorTexture(Color.WHITE));
            Logger.getLogger(TestBezierTextImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        scene().add(s);
        scene().cameraActive().setCamera(Point3D.Z.mult(-1));
        
    }
    
    @Override
    public void finit() {
        System.gc();
    }

    public TestBezierTextImage() {
    }

    @Override
    public void testScene() throws Exception {
        
    }
    public static void main(String [] args)
    {
        
        TestBezierTextImage tss = new TestBezierTextImage();
        tss.setMaxFrames(2000);
        tss.loop(true);
        tss.setGenerate(GENERATE_IMAGE|GENERATE_MOVIE);
        new Thread(tss).start();
    }

}
