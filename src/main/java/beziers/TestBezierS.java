/***
Global license : 

    CC Attribution
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

***/


package beziers;

import info.emptycanvas.library.nurbs.SurfaceParametriquePolynomialeBezier;
import info.emptycanvas.library.object.P;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.object.VideoTexture;
import info.emptycanvas.library.testing.TestObjetStub;
import java.io.File;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestBezierS extends TestObjetStub{
    private Point3D[][] coeff = new Point3D[][]{
        {P.n(-1,0,1), P.n(1,-1,0), P.n(1,0,0)},
        {P.n(0,0,1), P.n(0,0,0), P.n(0,0,1)},
        {P.n(1,1,0), P.n(0,1,0), P.n(-1,-1,0)}
            };
    private SurfaceParametriquePolynomialeBezier s = new SurfaceParametriquePolynomialeBezier(coeff);
    VideoTexture videoTexture ;

    @Override
    public void testScene(File f) throws Exception {
    }
    @Override
    public void ginit() { 
        videoTexture = new VideoTexture("C:\\Users\\Se7en\\Documents\\cARTE M2MOIRE\\Videos\\Vid 1\\SVM_A0001.mp4");
        s.texture(videoTexture);
        s.setMaxX(100);
        s.setMaxY(100);
        scene().add(s);
        scene().cameraActive().setCamera(Point3D.Z.mult(-1));
    }
    

    public TestBezierS() {
    }

    @Override
    public void testScene() throws Exception {
        videoTexture.nextFrame();
    }
    public static void main(String [] args)
    {
        
        TestBezierS tss = new TestBezierS();
        tss.setResx(1920);
        tss.setResx(980);
        tss.setMaxFrames(2000);
        tss.loop(true);
              
        new Thread(tss).start();
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
