/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

    Creation time 05-nov.-2014

***/


package getobjectat;

import info.emptycanvas.library.object.Camera;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.object.TColor;
import info.emptycanvas.library.object.TRI;
import info.emptycanvas.library.testing.TestObjetStub;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestGetObjectAt extends TestObjetStub
{

    @Override
    public void testScene() throws Exception {
        scene().clear();
        scene().add(new TRI(Point3D.O0,Point3D.X,Point3D.Y,new TColor(Color.BLUE)));
        scene().cameraActive(new Camera(Point3D.Z.mult(-1), Point3D.O0));
        
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ginit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
