/**
 *
 * Importer une autre test: ah si ca pouvait être fait par classes!
 *
 */
package repereAssocieAUneCourbeEX;

import info.emptycanvas.library.object.Camera;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.object.VideoTexture;
import info.emptycanvas.library.sanorm.CameraInPath;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.TRIEllipsoide;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen
 */
public class TestCameraEnMouvement extends TestObjet {

    private CameraInPath cam;
    private TRIEllipsoide e;
    VideoTexture videoTexture;
    @Override
    public void afterRenderFrame() {

    }

    @Override
    public void finit() {
        cam.setTemps01(frame / 25.0 / 8);
        videoTexture.nextFrame();
    }

    @Override
    public void ginit() {
        CourbeChoisie cc = new CourbeChoisie(21, 11, 11, 2);

        cam = new CameraInPath(cc);

        e = new TRIEllipsoide(Point3D.O0, 20, 10, 10);
        videoTexture = new VideoTexture("../Videos/H3-test-from-youtube.mp4");
        videoTexture.setTransparent(Color.BLACK);
        e.texture(videoTexture);
        
        e.setMaxX(20);
        e.setMaxY(20);

        scene().add(e);

        scene().cameraActive(new Camera(new Point3D (30,0,-30) , new Point3D(0,0,0)));
        
        scene().cameraActive(cam);

    }

    @Override
    public void testScene() throws Exception {

    }

    public void afterRender() {

    }

    public static void main(String[] args) {
        TestCameraEnMouvement t = new TestCameraEnMouvement();
        t.setGenerate(GENERATE_IMAGE|GENERATE_MOVIE);
        t.setMaxFrames(30*25);
        t.setResx(640);
        t.setResy(480);
        new Thread(t).start();
    }
}
