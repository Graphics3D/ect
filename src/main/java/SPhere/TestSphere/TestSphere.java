/***
Global license : 

    Microsoft Public Licence
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

***/


package SPhere.TestSphere;
import info.emptycanvas.library.object.Camera;
import info.emptycanvas.library.object.ColorTexture;
import info.emptycanvas.library.object.ECBufferedImage;
import info.emptycanvas.library.object.ImageTexture;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.TRISphere;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestSphere extends TestObjetStub
{
    private double longpc[], latpc[], incrpc[][];
    public int size = 10;
    private TRISphere [] s;
    public double taille   = 0.2;
    public double incrlong = 0.001;
    public double incrlat  = 0.001;
    
    
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
            try {
                s[i].texture(new ImageTexture(new ECBufferedImage(ImageIO.read(new File("C:\\Users\\Se7en\\Pictures\\manu2.jpg")))));
            } catch (IOException ex) {
                s[i].texture(new ColorTexture(Color.PINK));
                Logger.getLogger(TestSphere.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        
        ts.setGenerate(GENERATE_IMAGE/*|GENERATE_MODEL*/);
        
        ts.loop(true);
        
        ts.setMaxFrames(3000);
        
        new Thread (ts) .start();
        
        
    }

    @Override
    public void finit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
