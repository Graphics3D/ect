/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

***/


package SPhere.TestSphere;
import info.emptycanvas.library.object.Camera;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.object.TColor;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.TRISphere;
import java.awt.Color;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestSphere extends TestObjet
{
    private double longpc[], latpc[], incrpc[][];
    public int size = 10;
    private TRISphere [] s;
    public double taille   = 0.1;
    public double incrlong = 0.01;
    public double incrlat  = 0.01;
    
    
    @Override
    public void ginit() {
        longpc = new double[size];
        latpc = new double[size];
        incrpc = new double[size][2];
        for(int i=0; i<size; i++)
        {
            longpc[i] = 0;
            latpc[i] = 0;
            incrpc[i][0] = Math.random()*0.1;
            incrpc[i][1] = Math.random()*0.1;
        }
        
        s = new TRISphere[size-1];
        
        for(int i=0; i<s.length; i++)
        {
            s[i] = new TRISphere(Point3D.O0, taille);
            s[i].texture(new TColor(Color.PINK));
            scene().add(s[i]);
        }
    }
    public double longpc(int item)
    {
        longpc[item]+=incrpc[item][0];
        return longpc[item];
    }
    public double latpc(int item)
    {
        latpc[item]+=incrpc[item][1];
        return latpc[item];
    }
    @Override
    public void testScene() throws Exception {
        scene().cameraActive(new Camera(
                    Trajectoires.sphere(longpc(0), latpc(0), incrlong),
                    Trajectoires.sphere(longpc(0), latpc(0), incrlat)
                
                ));
    for(int i=0; i<s.length; i++)    
        s[i].setCentre(Trajectoires.sphere(longpc(i+1), latpc(i+1), 1.0));
        
    }
    
    
    public static void main(String []args)
    {
        TestSphere ts = new TestSphere();
        
        ts.setGenerate(GENERATE_IMAGE|GENERATE_MODEL);
        
        ts.loop(true);
        
        ts.setMaxFrames(3000);
        
        new Thread (ts) .start();
        
        
    }
}
