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
import info.emptycanvas.library.tribase.TRICylindre;
import info.emptycanvas.library.tribase.TRIEllipsoide;
import info.emptycanvas.library.tribase.TRIObjetGenerateur;
import info.emptycanvas.library.tribase.TRIObjetGenerateurAbstract;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen
 */
public class TestCameraEnMouvementRandomTriangles extends TestObjet {

    private CameraInPath cam;
    private TRIObjetGenerateurAbstract e;
    VideoTexture videoTexture;
    @Override
    public void afterRenderFrame() {

    }

    @Override
    public void finit() {
        cam.setTemps01(frame / 25.0 / 8);
        if (!videoTexture.nextFrame()) {
            this.STOP();
        }
    }

    @Override
    public void ginit() {
        CourbeChoisieRandom cc = new CourbeChoisieRandom(21, 11, 11, 8);

        cam = new CameraInPath(cc);

        e = new TRITRINuage(20.0, 10.0, 10.0, 1.0, 0.4);
        videoTexture = new VideoTexture("C:\\Users\\manue\\Videos\\Beautifull.mp4");
        videoTexture.setTransparent(Color.BLACK);
        e.texture(videoTexture);
        
        e.setMaxX(40);
        e.setMaxY(40);

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
        TestCameraEnMouvementRandomTriangles t = new TestCameraEnMouvementRandomTriangles();
        t.setGenerate(GENERATE_IMAGE|GENERATE_MOVIE);
        t.setMaxFrames(30*25);
        t.setResx(640);
        t.setResy(480);
        new Thread(t).start();
    }
}
