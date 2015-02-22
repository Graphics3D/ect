/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <manuel.dahmen@gmail.com>

***/


package trigenerateurabstract.triextrusiongeneralisee;

import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.testing.TestObjetStub;
import static info.emptycanvas.library.testing.TestObjetStub.GENERATE_IMAGE;
import static info.emptycanvas.library.testing.TestObjetStub.GENERATE_MODEL;
import info.emptycanvas.library.tribase.*;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <manuel.dahmen@gmail.com>
 */
public class TestTore extends TestObjetStub
{
    @Override
    public void ginit()
    {
        Surface s = new SurfaceCercle(1);
        Chemin c = new CheminCercle(10);
        
        TRIExtrusionGeneralisee tri = new TRIExtrusionGeneralisee();
        
        tri.setCirculaireX(true);
        tri.setCirculaireY(true);
        
        tri.setSurface(s);
        
        tri.setChemin(c);
        
        tri.setMaxX(100);
        tri.setMaxY(100);

        if(tri.texture()==null)
        {
        } else {
            tri.texture(
                    new ColorTexture(new Color(255, 128, 0))
                    
            );
        }
        scene().add(tri);
    }
    
    public static void main(String [] args)
    {
                    TestTore tp = new TestTore();
        tp.setGenerate(GENERATE_IMAGE|GENERATE_MODEL);
        tp.loop(false);
        new Thread(tp).start();
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void testScene() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}