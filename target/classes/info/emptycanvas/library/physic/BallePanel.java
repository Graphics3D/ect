package info.emptycanvas.library.physic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import info.emptycanvas.library.object.Point3D;

public class BallePanel extends DataPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4876595577262483236L;
	Bille[] positions;
	private int noBilles = 20;
	private boolean init;
	private double distanceSouris = 10;
	private double coefficient = 1;

	public BallePanel() {
		
		//setMinimumSize(new Dimension(RESX, RESY));
		
		//setSize(new Dimension(RESX, RESY));
		
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				Point p = e.getPoint();

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				
			}
		});
		
		addMouseListener(new MouseListener() {
			
			private Bille activee;

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(activee!=null)
				{
					Point3D v2 = new Point3D(arg0.getX(), arg0.getY(),0).moins(activee.position).mult(coefficient);
				
					activee.vitesse = activee.vitesse.plus(v2);
				
				}
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {	
				activee = getBille(e.getPoint());
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public Bille getBille(Point p) {
		for (int i = 0; i < positions.length; i++)
			if (proche(new Point((int) positions[i].position.getX(),
					(int) positions[i].position.getY()), p)) {
				return positions[i];
			}

		return null;
	}

	private boolean proche(Point point, Point p) {
		return p.distance(point) < distanceSouris;
	}

	public void init(int noBilles) {
		this.noBilles = noBilles;

		positions = new Bille[noBilles * 2];

		for (int c = 0; c < 2; c++) {
			for (int i = 0; i < noBilles / 5; i++) {
				for (int j = 0; j < 5; j++) {
					positions[c * noBilles + (i * 5 + j)] = new Bille();
					positions[c * noBilles + (i * 5 + j)].color = c == 0 ? Color.RED
							: Color.BLUE;

					int pasx = getWidth() / 4 / (noBilles + 1);
					int pasy = getHeight() / (5 + 1);

					positions[c * noBilles + (i * 5 + j)].position = c == 0 ? new Point3D(
							10 + i * pasx, 10 + j * pasx, 0) : new Point3D(getWidth()
							- 10 - i * pasx, 10 + j * pasx, 0);

					positions[c * noBilles + (i * 5 + j)].vitesse = Point3D.X
							.mult(10);
				}
			}
		}

		init = true;
	}

	public void afficher(BufferedImage bi) {
		
		Graphics g = bi.getGraphics();
		
		
		
		for (int i = 0; i < positions.length; i++) {
			if (positions[i] != null && positions[i].color != null
					&& positions[i].position != null) {
				
				
				Point p = new Point((int) positions[i].position.getX(),
						(int) positions[i].position.getY());
				
				
				if(p.getX()<0 || p.getX()>getWidth() )
					positions[i].vitesse.setX(positions[i].vitesse.getX()*-1);
					if(p.getY()<0 || p.getY()>getHeight())
					
						positions[i].vitesse.setY(positions[i].vitesse.getY()*-1);
				if (g != null) {

					g.setColor(positions[i].color);
					g.fillOval((int) (p.getX() - 5), (int) (p.getY() - 5), 10,
							10);
				}
			}
		}
	}
	
	BufferedImage bi ;
	
	
	public void paint()
	{
		//afficher(bi);
	}
	
	@Override
	public void run() {
		init(20);
		
		
		Force f = new Force();
		
		
		f.configurer(positions);
		
		
		bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		
		
		while (true) {
			f.calculer();
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());
			
			
			afficher(bi);
			
			getGraphics().drawImage(bi, 0, 0, getWidth(), getHeight(), null);
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}

}
