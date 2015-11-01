/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

***/


package cadeau;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetSub;
import info.emptycanvas.library.tribase.TRISphere;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class SphereCube extends TestObjetSub

{
    double d = 90;
    private final double t0 = -1;
    private final double t1 = 1;
    private TRISphere s;

    @Override
    public void ginit() {
        
        Cube c;
        
        //c.texture(new TColor(Color.RED));
        c = new Cube(d/10, Point3D.O0);
        
        
        c.texture(new ColorTexture(Color.BLUE));
        
        s = new TRISphere(Point3D.X.mult(t0), d/10);
        
        s.texture(new ColorTexture(Color.YELLOW));
        
        scene().add(c);
        scene().add(s);
        
        
    }
    
    
    
    @Override
    public void testScene() throws Exception {
        
        double pc  = 1.0 * frame() / getMaxFrames();
        
        double TT;
        TT = t0+(t1-t0)*pc;
        
        s.setCentre(Point3D.X.mult(TT*d));
        
    }
    
    public static void main(String [] args)
    {
        
        
        SphereCube sc = new SphereCube();
        
        sc.setMaxFrames(300);
        
        sc.loop(true);
        
        new Thread(sc).start();
        
        
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
