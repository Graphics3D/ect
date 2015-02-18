package starbuck.tests;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetStub;
import java.awt.Color;

/**
 *
 * @author Manuel DAHMEN
 */
public class TestTriangle extends TestObjetStub{
    @Override
    public void testScene()
    {
        setResx(320);
        setResy(200);
        scene().add(new TRI(new Point3D(0,0,0),new Point3D(1,0,0), new Point3D(0,1,0), Color.green));
        scene().add(new TRI(new Point3D(1,1,0),new Point3D(1,0,0), new Point3D(0,1,0), Color.red));
        
        camera(new Camera(new Point3D(0,0,-1000), new Point3D(0,0,0)));
        description = "Two triangles . One green down left . One red upper right";
    }
    
    public static void main(String [] args)
    {
        TestTriangle testTriangle = new TestTriangle();
        testTriangle.run();
    }

}