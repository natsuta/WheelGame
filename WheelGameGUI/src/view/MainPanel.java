package view;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import controller.ContainerListener;
import model.interfaces.GameEngine;
import model.interfaces.Slot;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final double DOUBLE_MODIFIER = 1.0;
	private final int BALL_DIAMETER = 20;
	private final double CIRCLE = 360.0;
	private final double RADIUS_ERROR = 0.92;
	private final double DEGREE_ERROR = 89.5263;
	
	File file = new File("img/Basic_roulette_wheel_1024x1024.png");
	BufferedImage img = processImage(file);
	Image reimg = null;
	
	Slot currentSlot;
	private int ballx;
	private int bally;
	private int imgx;
	private int imgy;
	
	public MainPanel(GameEngine gameEngine) {
		addComponentListener(new ContainerListener() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				repaint();
			}
		});
	}
	
	public static BufferedImage processImage(File f) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(f);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	
	public double getScaleFactor(int iMasterSize, int iTargetSize) {
		double dScale = DOUBLE_MODIFIER;
		if (iMasterSize > iTargetSize)
			dScale = (double) iTargetSize / (double) iMasterSize;
		else 
			dScale = (double) iTargetSize / (double) iMasterSize;
		return dScale;

	}

	public double getScaleFactorToFit(Dimension original, Dimension toFit) {
		double dScale = DOUBLE_MODIFIER;
		if (original != null && toFit != null) {
			double dScaleWidth = getScaleFactor(original.width, toFit.width);
			double dScaleHeight = getScaleFactor(original.height, toFit.height);
			dScale = Math.min(dScaleHeight, dScaleWidth);
		}
		return dScale;
	}
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		double scaleFactor = Math.min(DOUBLE_MODIFIER, 
				getScaleFactorToFit(new Dimension(img.getWidth(), 
						img.getHeight()), getSize()));

		int scaleWidth = (int) Math.round(img.getWidth() * scaleFactor);
		int scaleHeight = (int) Math.round(img.getHeight() * scaleFactor);

		reimg = img.getScaledInstance(scaleWidth, scaleHeight, Image.SCALE_SMOOTH);

		imgx = ((getWidth() - 1) - reimg.getWidth(this)) / 2;
		imgy = ((getHeight() - 1) - reimg.getHeight(this)) / 2;

		g.drawImage(reimg, imgx, imgy, this);
		drawBall(g);
	}
	
	public void drawBall(Graphics g) {
		if(currentSlot != null) {
			//get radius from background size
			double r = (((this.getHeight() / 2) + (this.getHeight()/2))/2) * RADIUS_ERROR;
			
			//get center of background
			int centerx = imgx + reimg.getWidth(this)/2;
			int centery = imgy + reimg.getHeight(this)/2;
			
			//get theta as radians
			double angle = Math.toRadians(currentSlot.getPosition() 
					* (CIRCLE / Slot.WHEEL_SIZE) - DEGREE_ERROR);
			
			//translate coordinates
			ballx = (int) (r * Math.cos(angle)) + centerx - (BALL_DIAMETER/2);
			bally = (int) (r * Math.sin(angle)) + centery - (BALL_DIAMETER/2);
			
			//draw ball
			g.setColor(Color.YELLOW);
			g.drawOval(ballx, bally, BALL_DIAMETER, BALL_DIAMETER);
			g.fillOval(ballx, bally, BALL_DIAMETER, BALL_DIAMETER);
		}
	}
	
	public void updatePosition(Slot slot) {
		currentSlot = slot;
	}
}
