package sablier;

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
        scene().add(new Sablier());

        scene().cameraActive(new Camera(Point3D.Z.mult(-2), Point3D.O0));

    }

    public void testScene()
    {

    }
    public static void main(String [ ] args)
    {

        TestSablier target = new TestSablier();
        target.setGenerate(GENERATE_IMAGE|GENERATE_MODEL|GENERATE_MOVIE);
        new Thread(target).start();
    }
}
