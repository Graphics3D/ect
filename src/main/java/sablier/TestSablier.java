package sablier;

import SPhere.TestSphere.Trajectoires;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;

import java.awt.*;


/**
 * Created by manue on 01-11-15.
 */
public class TestSablier extends TestObjetSub
{
    public void ginit()
    {
        this.setMaxFrames(1);
        Sablier s = new Sablier();
        s.texture(new ColorTexture(Color.BLUE));
        scene().add(s);

    }
    private Point2D cercle()
    {
        return Trajectoires.sphere(0.0+1.0*frame/getMaxFrames(),0, 1).get2D();
    }
    public void testScene()
    {
        scene().cameraActive(new Camera(cercle().get3D().mult(10), Point3D.O0));

    }
    public static void main(String [ ] args)
    {

        TestSablier target = new TestSablier();
        target.loop(true);
        target.setMaxFrames(600);
        target.setGenerate(GENERATE_IMAGE|GENERATE_MODEL|GENERATE_MOVIE);
        new Thread(target).start();
    }
}
