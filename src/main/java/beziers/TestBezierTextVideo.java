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
public class TestBezierTextVideo extends TestObjetStub{
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
        videoTexture = new VideoTexture("C:\\Emptycanvas\\textures\\Il embrasse sur la bouche.mp4");
        s.texture(videoTexture);
        scene().add(s);
        scene().cameraActive().setCamera(Point3D.Z.mult(-1));
    }
    
    @Override
    public void finit() {
        videoTexture.nextFrame();
    }

    public TestBezierTextVideo() {
    }

    @Override
    public void testScene() throws Exception {
        
    }
    public static void main(String [] args)
    {
        
        TestBezierTextVideo tss = new TestBezierTextVideo();
        tss.setMaxFrames(2000);
        tss.loop(true);
              
        new Thread(tss).start();
    }

}
