package texturevideo;

import info.emptycanvas.library.object.*;
import info.emptycanvas.library.testing.TestObjetStub;
import info.emptycanvas.library.tribase.Plan3D;
import java.io.File;

/**
 * @author Dahmen Manuel
 */
public class PlansVideo extends TestObjetStub
{
    private final String avi1;
    private final String avi2;
    private final String avi3;
    private final String avi4;

    public PlansVideo(String avi1, String avi2, String avi3, String avi4) {
        this.avi1 = avi1;
        this.avi2 = avi2;
        this.avi3 = avi3;
        this.avi4 = avi4;
    }

    @Override
    public void testScene() throws Exception {
        
        VideoTexture tc1, tc2, tc3, tc4;
        
        tc1 = new VideoTexture(avi1);
        tc2 = new VideoTexture(avi2);
        tc3 = new VideoTexture(avi3);
        tc4 = new VideoTexture(avi4);
        
        Plan3D p1, p2, p3, p4;
        
        p1 = new Plan3D();
        p1.texture(tc1);
        p1.texture(tc1);
        p1.pointOrigine(Point3D.O0);
        p1.pointXExtremite(Point3D.X);
        p1.pointYExtremite(Point3D.Y);
        
        p2 = new Plan3D();
        p2.texture(tc2);
        p2.pointOrigine(Point3D.O0);
        p2.pointXExtremite(Point3D.X.mult(-1));
        p2.pointYExtremite(Point3D.Y);

        p3 = new Plan3D();
        p3.texture(tc3);
        p3.pointOrigine(Point3D.O0);
        p3.pointXExtremite(Point3D.X);
        p3.pointYExtremite(Point3D.Y.mult(-1));
        
        p4 = new Plan3D();
        p4.texture(tc4);
        p4.pointOrigine(Point3D.O0);
        p4.pointXExtremite(Point3D.X.mult(-1));
        p4.pointYExtremite(Point3D.Y.mult(-1));
        
        scene().cameraActive(
                new Camera(
                    new Point3D(0,0,-2),
                    Point3D.O0
                )
        );
        
        
        scene().add(p1);
        scene().add(p2);
        scene().add(p3);
        scene().add(p4);
        
        
    }
    public static void main(String [] args)
    {
       String f1 ;
       String f2 ;
       String f3 ;
       String f4 ;
        if(args.length>=4)
        {
        f1 = args[0];
        f2 = args[1];
        f3 = args[2];
        f4 = args[3];
            
        }
        else
        {
            
            f1 = "C:\\EmptyCanvas\\Textures\\_10.AVI";
            f2 = "C:\\EmptyCanvas\\Textures\\Il embrasse sur la bouche.mp4";
            f3 = "C:\\EmptyCanvas\\Textures\\03.mkv";
            f4 = "C:\\EmptyCanvas\\Textures\\04.mkv";
        }
        
        
        if(new File(f1).isFile()&&new File(f2).isFile()&&new File(f3).isFile()&&new File(f4).isFile())
        {
        
            PlansVideo pc = new PlansVideo(f1, f2, f3, f4);
        
            pc.loop(true);
        
            pc.run();
        
        }
        else
        {
            
            System.err.println("Erreur un fichier ou l'autre n'existe pas");
            
        }
    }
}
