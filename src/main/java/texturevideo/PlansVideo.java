package texturevideo;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjet;
import info.emptycanvas.library.tribase.Plan3D;
import java.io.File;

/**
 *
 * @author Se7en
 */
public class PlansVideo extends TestObjet
{
    private File avi1;
    private File avi2;
    private File avi3;
    private File avi4;

    public PlansVideo(File avi1, File avi2, File avi3, File avi4) {
        this.avi1 = avi1;
        this.avi2 = avi2;
        this.avi3 = avi3;
        this.avi4 = avi4;
    }

    @Override
    public void testScene() throws Exception {
        
        TColor tc1, tc2, tc3, tc4;
        
        tc1 = new TColor(avi1);
        tc2 = new TColor(avi1);
        tc3 = new TColor(avi1);
        tc4 = new TColor(avi1);
        
        Plan3D p1, p2, p3, p4;
        
        p1 = new Plan3D();
        p1.texture(tc1);
        p1.texture(tc1);
        p1.pointOrigine(Point3D.O0);
        p1.pointXExtremite(Point3D.X);
        p1.pointYExtremite(Point3D.Y);
        
        p2 = new Plan3D();
        p1.texture(tc2);
        p1.texture(tc2);
        p2.pointOrigine(Point3D.O0);
        p2.pointXExtremite(Point3D.X.mult(-1));
        p2.pointYExtremite(Point3D.Y);

        p3 = new Plan3D();
        p1.texture(tc3);
        p1.texture(tc3);
        p3.pointOrigine(Point3D.O0);
        p3.pointXExtremite(Point3D.X);
        p3.pointYExtremite(Point3D.Y.mult(-1));
        
        p4 = new Plan3D();
        p1.texture(tc4);
        p1.texture(tc4);
        p4.pointOrigine(Point3D.O0);
        p4.pointXExtremite(Point3D.X.mult(-1));
        p4.pointYExtremite(Point3D.Y.mult(-1));
        
        scene().cameraActive(
                new Camera(
                    new Point3D(0,0,-2),
                    Point3D.O0
                )
        );
        
        
        scene().add(scene);
        
        
    }
    public static void main(String [] args)
    {
        File f1,f2,f3,f4;
        f1 = new File(args[0]);
        f2 = new File(args[1]);
        f3 = new File(args[2]);
        f4 = new File(args[3]);
        
        if(f1.isFile()&&f2.isFile()&&f3.isFile()&&f4.isFile())
        {
        
        PlansVideo pc = new PlansVideo(f1, f2, f3, f4);
        
        pc.loop(true);
        
        pc.run();
        
        }
    }
}
