package trihole;

import info.emptycanvas.library.extra.Polyhedre;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import java.awt.Color;

/**
 *
 * @author Se7en
 */
public class TestTriHole extends TestObjet
{
    private Polyhedre th;
    private Polyhedre th2;

    public TestTriHole() {
    }

    @Override
    public void ginit() {
        th = new Polyhedre();
        
        th.texture(new TColor(Color.GREEN));
        
        scene().add(th);
        
        scene().cameraActive(new Camera(Point3D.Z.mult(-2), Point3D.O0));
        LumierePonctuelle lumierePonctuelle = new LumierePonctuelle(Point3D.O0,Color.YELLOW);
        lumierePonctuelle.setR0(1);
        
        scene().lumieres().add(lumierePonctuelle);
        
//        lumierePonctuelle = new LumierePonctuelle(Point3D.Y,Color.BLUE);
//        lumierePonctuelle.setR0(1);
//        
//        scene().lumieres().add(lumierePonctuelle);

        
        th2 = new Polyhedre();
        
        th2.texture(new TColor(Color.RED));
        
        scene().add(th2);
        
        
    }

    
    
    
    @Override
    public void testScene() throws Exception {
        th.add(new Point3D(Math.random()-0.5, Math.random()-0.5, Math.random()-0.5));
        th2.add(new Point3D(Math.random()-0.5, Math.random()-0.5, Math.random()-0.5));

        //exportFrame("stl", "Polyhedre"+frame()+".stl");
    
    }
    public static void main(String [] ar)
    {
        TestTriHole tth = new TestTriHole();
        
        tth.loop(true);
        tth.setResx(2000);
        tth.setResy(1500);
        
        tth.setMaxFrames(25*10);
        
        new Thread(tth).start();
    }
}
