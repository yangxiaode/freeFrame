package freeframe.test;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import freeframe.system.Scene;
import freeframe.utils.MyArrayList;

public class GameScene extends Scene {

	private static final long serialVersionUID = 1L;

	BgLable bg = null;
	Plane plane = null;
	FpsLabel fps = null;
	Map map = null;
	MyArrayList<Missile>missiles = null;
	
	public GameScene(int x, int y, int width, int height,float alpha) {
		super(x, y, width, height,alpha);
		
		map = new Map(300, 10, 100, 200,this);
		missiles = new MyArrayList<Missile>();
		fps = new FpsLabel();
		plane = new Plane(50, 50, 100, 100,this);
		
		Missile m = new Missile(100, 100, 50,50,2,Direction.R,this);
		Missile m2 = new Missile(150, 200,50,50 ,2,Direction.R,this);
		Missile m3 = new Missile(500, 300,50,50 ,2,Direction.R,this);
		
		missiles.add(m);
		missiles.add(m2);
		missiles.add(m3);
		
		Explode explode = new Explode(100, 300,10,20,this);
		bg = new BgLable(0, 300, width, height,this);
	}

	static BufferedImage img ;
	
	@Override
	public void draw(final Graphics2D g2d) {
		img = getImage();
		
		bg.draw(g2d);
		
		fps.draw(g2d);
		
	/*	for(int i = 0;i<missiles.size();i++){
			Missile missile = missiles.get(i);
			if (missile.isLive()) {
				missile.draw(g2d);
			}else{
				missile.destroy();
				missiles.remove(missile);
				i--;
			}
			 
		}*/
		for (Missile missile : missiles) {
			if (missile.isLive()) {
				missile.draw(g2d);
			}else{
				missile.destroy();
				missiles.remove(missile);
			}
		}
		
//		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));// 透明度
		// draw spirit
		plane.draw(g2d);
	 
		map.draw(g2d);
	}

	@Override
	public void destroy() {

	}

}
