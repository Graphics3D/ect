/***
Global license : 

    CC Attribution
    
    author Manuel Dahmen <ibiiztera.it@gmail.com>

***/


package feudartifice;

import balleclou.TestBalleClous111;
import info.emptycanvas.library.object.Camera;
import info.emptycanvas.library.object.Point3D;
import info.emptycanvas.library.object.RepresentableConteneur;
import info.emptycanvas.library.testing.TestObjet;

/**
 *
 * @author Manuel Dahmen <ibiiztera.it@gmail.com>
 */
public class TestFeu extends TestObjet {

    @Override
    public void ginit() {
        FeuArbre fey = new FeuArbre();
        RepresentableConteneur generate = fey.generate();
        scene().add(generate);
        System.out.println(generate.getListRepresentable().size());
        
        
    }

    
    @Override
    public void testScene() throws Exception {
        
        scene().cameraActive(new Camera(Point3D.Z.mult(-100+frame/2.0), Point3D.Z.mult(200)));
        
         
    }
     
    public static void main(String[] args) {
        TestFeu th = new TestFeu();

        th.loop(true);

        th.setMaxFrames(400);
        
        th.setResx(1920);

        th.setResy(1080);

        th.setGenerate(TestBalleClous111.GENERATE_IMAGE);

        th.run();
    }

}
