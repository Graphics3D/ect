/*

    Vous êtes libre de :

*/
package starbuck.tests;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.script.Loader;
import info.emptycanvas.library.testing.TestObjet;
import java.util.ResourceBundle;

/**
 *
 * @author Manuel DAHMEN
 */
public class TestMartienSpheres extends TestObjet
{
    public static void main(String [] args)
    {
        TestMartienSpheres to = new TestMartienSpheres();
        to.camera(new Camera(new Point3D(0,0,-10), new Point3D(0,0,0)));
        to.run();
        
    }
    @Override
    public void testScene()
    {
        ResourceBundle rb = ResourceBundle.getBundle("starbuck/tests/Mite");
        String mite = rb.getString("sphere1");
        new Loader().loadIF(mite, scene());
        description = "Primitive model. Green face made up with spheres";
    }
            
    


}
