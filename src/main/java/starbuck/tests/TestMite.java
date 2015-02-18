/*

    Vous êtes libre de :

*/
package starbuck.tests;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.script.Loader;
import info.emptycanvas.library.testing.TestObjetStub;
import java.util.ResourceBundle;

/**
 *
 * @author Manuel DAHMEN
 */
public class TestMite extends TestObjetStub{
    public static void main(String [] args)
    {
        TestMite to = new TestMite();
        to.camera(new Camera(new Point3D(0,0,-30), new Point3D(0,0,0)));
       to.run();
        
    }
    @Override
    public void testScene()
    {
        ResourceBundle rb = ResourceBundle.getBundle("starbuck/tests/Mite");
        String mite = rb.getString("mite");
        new Loader().loadIF(mite, scene);
        description = "Primtive model. triangle mesh";
    }
            
    
}
