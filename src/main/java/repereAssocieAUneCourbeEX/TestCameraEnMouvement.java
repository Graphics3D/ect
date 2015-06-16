/**
 *
 * Importer une autre test: ah si ca pouvait être fait par classes!
 *
 */
package repereAssocieAUneCourbeEX;

import info.emptycanvas.library.object.Camera;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.object.VideoTexture;
import info.emptycanvas.library.sanorm.TestCourbeCameraEnChemin;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.TRIEllipsoide;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen
 */
public class TestCameraEnMouvement extends TestObjet {

    private TestCourbeCameraEnChemin cam;
    private TRIEllipsoide e;
    VideoTexture videoTexture;
    @Override
    public void afterRenderFrame() {

    }

    @Override
    public void finit() {
        cam.setTemps01(frame / 25.0 * 60);
        videoTexture.nextFrame();
    }

    @Override
    public void ginit() {
        CourbeChoisie cc = new CourbeChoisie(10, 5, 5, 7);

        cam = new TestCourbeCameraEnChemin(cc);

        e = new TRIEllipsoide(Point3D.O0, 20, 10, 10);
        videoTexture = new VideoTexture("D:\\Emptycanvas\\textures\\Il embrasse sur la bouche.mp4");
        videoTexture.setTransparent(Color.BLACK);
        e.texture(videoTexture);
        
        e.setMaxX(100);
        e.setMaxY(100);

        scene().add(e);

        scene().cameraActive(new Camera(new Point3D (30,0,-30) , new Point3D(0,0,0)));
        
        //scene().cameraActive(cam);

    }

    @Override
    public void testScene() throws Exception {

    }

    public void afterRender() {

    }

    public static void main(String[] args) {
        TestCameraEnMouvement t = new TestCameraEnMouvement();

        new Thread(t).start();
    }
}
