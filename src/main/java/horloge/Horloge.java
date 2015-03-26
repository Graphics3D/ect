/*
 * 2013 Manuel Dahmen
 */
package horloge;

import java.awt.Color;
import java.awt.Dimension;
import info.emptycanvas.library.object.*;
import info.emptycanvas.library.tribase.TRISphere;
import java.awt.Container;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Horloge {

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

    public Horloge(Color h, Color m, Color s, Dimension res) {
        super();
        this.h = h;
        this.m = m;
        this.s = s;
        this.res = res;
    }

    public void initTime() {
        double f = 2 * Math.PI;

        Date d = new Date();

        sc = new Scene();

        s0 = new TRISphere(Point3D.O0, 10);
        sH = new TRISphere(position(f * d.getHours() / 12)
                .mult(60), 12);
        sM = new TRISphere(position(f * d.getMinutes() / 60)
                .mult(80), 8);
        sS = new TRISphere(position(f * d.getSeconds() / 60)
                .mult(100), 6);

        s0.texture(new TColor(Color.WHITE));
        sH.texture(new TColor(Color.GREEN));
        sM.texture(new TColor(Color.BLUE));
        sS.texture(new TColor(Color.RED));
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
        sc.add(s0);
        sc.add(sH);
        sc.add(sM);
        sc.add(sS);

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

    public void montrer(Container c) {
        initTime();

        ZBuffer z = ZBufferFactory.instance(
                (int) res.getWidth(),
                (int) res.getHeight());
        z.suivante();
        

        while (montre) {

            time();
            z.suivante();
            z.couleurDeFond(new ColorTexture(Color.WHITE));
            z.scene(sc);
            z.dessinerSilhouette3D();

            Image bi = ((ZBufferImpl) z).image();

            c.getGraphics().drawImage(bi, 0, 0, (int) res.getWidth(), (int) res.getHeight(), null);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Horloge 3D");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel b = new JLabel("Horloge");

        f.setContentPane(b);

        f.setSize(1024, 768);

        f.setVisible(true);

        Horloge h = new Horloge(null, null, null, b.getSize());

        h.montrer(b);
    }
}
