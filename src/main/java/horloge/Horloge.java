/*
 * 2013 Manuel Dahmen
 */
package horloge;

import java.awt.Color;
import java.awt.Dimension;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.tribase.TRISphere;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Horloge extends JFrame{
    Configuration c = new Configuration();
    Color h;
    Color m;
    Color s;
    Dimension res;
    private boolean montre = true;
    private TRISphere s0;
    private TRISphere sH;
    private TRISphere sS;
    private TRISphere sM;
    Scene sc;
    private final JLabel label;

    public Horloge(Color h, Color m, Color s) {
        super("Horloge 3D");
        this.h = h;
        this.m = m;
        this.s = s;
        label = new JLabel("Horloge");

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                
                System.out.println("Resize ...");
                
            }
        });
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==new Character('f'))
                {
                } else {                    
                    c.showAndReturnBack();
                    
                    update(c);
                }
            }
});
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setContentPane(label);

        setSize(1024, 768);

        
        
        setVisible(true);

    }

    public void initTime() {
        double f = 2 * Math.PI;

        Date d = new Date();

        sc = new Scene();

        s0 = new TRISphere(Point3D.O0, 10);
        sH = new TRISphere(position(f * d.getHours() / 12)
                .mult(80), 12);
        sM = new TRISphere(position(f * d.getMinutes() / 60)
                .mult(80), 8);
        sS = new TRISphere(position(f * d.getSeconds() / 60)
                .mult(80), 6);
        TRISphere sG0 = new TRISphere(position(f*0.0 / 12)
             .mult(80), 10);
        TRISphere sG3 = new TRISphere(position(f*3.0/ 12)
                .mult(80), 10);
        TRISphere sG6 = new TRISphere(position(f*6.0 / 12)
                .mult(80), 10);
        TRISphere sG9 = new TRISphere(position(f*9.0/ 12)
                .mult(80), 10);   
        sG0.texture(new ColorTexture(Color.GREEN));
        sG3.texture(new ColorTexture(Color.GREEN));
        sG6.texture(new ColorTexture(Color.GREEN));
        sG9.texture(new ColorTexture(Color.GREEN));
        s0.texture(new ColorTexture(Color.WHITE));
        sH.texture(new ColorTexture(Color.MAGENTA));
        sM.texture(new ColorTexture(Color.BLUE));
        sS.texture(new ColorTexture(Color.RED));
        try {
            s0.texture(
                    new ImageTexture(
                            new ECBufferedImage(
                                    ImageIO.read(new File("c:\\Emptycanvas\\textures\\troisbandes.jpg")))));
            sH.texture(
                    new ImageTexture(
                            new ECBufferedImage(
                                    ImageIO.read(new File("c:\\Emptycanvas\\textures\\moi1.jpg")))));
            sM.texture(
                    new ImageTexture(
                            new ECBufferedImage(
                                    ImageIO.read(new File("c:\\Emptycanvas\\textures\\spheres.jpg")))));
            sS.texture(
                    new ImageTexture(
                            new ECBufferedImage(
                                    ImageIO.read(new File("c:\\Emptycanvas\\textures\\paillettes.jpg")))));

        } catch (IOException ex) {
            Logger.getLogger(Horloge.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0; i<12; i++)
        {
            TRISphere sGm = new TRISphere(position(f * i / 12)
                    .mult(80), 6);
            sGm.texture(new ColorTexture(Color.BLUE));
            sc.add(sGm);
        }
        sc.add(s0);
        sc.add(sH);
        sc.add(sM);
        sc.add(sS);
        sc.add(sG0);
        sc.add(sG3);
        sc.add(sG6);
        sc.add(sG9);

        sc.cameraActive(new Camera(Point3D.Z.mult(-200), Point3D.O0));
    }

    public void time() {
        double f = 2 * Math.PI;
        Date d = new Date();

        sH.setCentre(position(f * d.getHours() / 12).mult(60));
        sM.setCentre(position(f * d.getMinutes() / 60).mult(80));
        sS.setCentre(position(f * d.getSeconds() / 60).mult(100));
    }

    public Point3D position(double angle) {

        Point3D p0
                = new Point3D(
                        -Math.sin(angle),
                        Math.cos(angle),
                        0
                );

        return p0;
    }

    public void montrer() {
        initTime();

        

        while (montre) {

        ZBuffer z = ZBufferFactory.instance(
                (int) this.getWidth(),
                (int) this.getHeight());
            time();
            z.suivante();
            z.couleurDeFond(new ColorTexture(Color.WHITE));
            z.scene(sc);
            z.dessinerSilhouette3D();

            Image bi = ((ZBufferImpl) z).image();
            try
            {
            label.getGraphics().drawImage(bi, 0, 0, (int) this.getWidth(), (int) this.getHeight(), null);
            }
            catch(Exception ex){}
        }
    }

    public static void main(String[] args) {
       
        Horloge h = new Horloge(null, null, null);
        h.montrer();
    }

    /**
     *
     * @param c
     */
    public void update(Configuration<Horloge> c)
    {
    }
    private static class Configuration<T extends JFrame> {

        public Configuration() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private void showAndReturnBack() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
