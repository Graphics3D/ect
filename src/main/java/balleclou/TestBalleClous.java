package balleclou;


import info.emptycanvas.library.extra.BalleClous;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.TRISphere;import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Se7en
 */
public class TestBalleClous extends TestObjet{
    public int MAXFRAMES;
    private TColor tc = new TColor(Color.red);
    private BalleClous ballec;
    @Override
    public void ginit() {
        
        
        try {
            super.ginit(); //To change body of generated methods, choose Tools | Templates.

            tc = 
                    new TColor(
                    new ECBufferedImage(ImageIO.read(new File("C:\\Emptycanvas\\textures\\moi1.jpg")))
            );

        
        } catch (IOException ex) {
            Logger.getLogger(TestBalleClous1.class.getName()).log(Level.SEVERE, null, ex);
        }
        ballec = new BalleClous(Point3D.O0, 50);
        
        
        ballec.setMaxX(40);
        
        ballec.setMaxY(40);
        
        
        int m, n ;
        
        m = 5;
        n = 5;
        for(int i=0; i<m; i++)
        for(int j=0; j<n; j++)
        {
            ballec.addPoint(new Point2D(1.0*i/m,1.0*j/n));
        }
        
        
        ballec.texture(tc);
        
        scene().add(ballec);
        
        
        scene().lumieres().add(new LumierePonctuelle(Point3D.Z, Color.YELLOW));
        
        
        Camera camera;
        camera = new Camera(new Point3D(0d,0d,-500d),
         new Point3D(0d,0d,0d));
        
        scene().cameraActive(camera);
        
    }

    
    
    @Override
    public void testScene() throws Exception {
        ballec.param(1.0*(frame+1)/MAXFRAMES);
        exportFrame("export-stl", "export-"+frame+".STL");
        
        
    }
    public static void main(String [] args)
    {
        TestBalleClous th = new TestBalleClous();
        
        th.loop(true);
        
        th.MAXFRAMES = 1000;
        
        th.setResx(400);
        th.setResy(300);
        
        th.setMaxFrames((int)th.MAXFRAMES);
        
        th.setGenerate(GENERATE_MODEL | GENERATE_IMAGE);
     
        th.run();
    }
}

