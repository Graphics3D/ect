/***
Global license : 

    CC Attribution
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

***/


package videotexture;

import info.emptycanvas.library.object.P;
import info.emptycanvas.library.object.TRI;
import info.emptycanvas.library.object.VideoTexture;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.Plan3D;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
class TestVideoTexture extends TestObjet {
    TRI tri = null;
    VideoTexture videoTexture;
    public String moviefilename;

    private TestVideoTexture(String arg) {
        moviefilename = arg;
    }
    
    
    @Override
    public void ginit() {
        videoTexture = new VideoTexture(moviefilename);
        Plan3D plan3d = new Plan3D();
        plan3d.pointOrigine(P.n(-100, -100, 0));
        plan3d.pointYExtremite(P.n(-100, 100, 0));
        plan3d.pointXExtremite(P.n(100, -100, 0));
        plan3d.texture(videoTexture);
        scene().add(plan3d);
    }

    @Override
    public void testScene() throws Exception {
        videoTexture.nextFrame();
    }

    public static void testing(String arg) {
        TestObjet to;
        to = new TestVideoTexture(arg);
        to.setMaxFrames(25*60*120);
        to.setResx(600);
        to.setResy(400);
        to.loop(true);

        new Thread(to).start();
    }

    public static void main(String[] args) {
        String arg = "F:\\Bibliothèque Portable\\Films\\Cinema anglais" + "\\" + "Sailor.Et.Lula.1990.FRENCH.BRRiP.XViD.AC3-HuSh.avi";
        if (args.length > 0) {
            arg = args[0];
         }
        testing(arg);

    }

}
