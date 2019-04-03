import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;


class killer implements Runnable {
	int petla;
	
	public void run () {
		
		
//		Thread fred = new Thread();
//		fred.setPriority(5);
//		for (petla=0; petla<=8; petla++) {
//		System.out.println("Pętla " + petla);
//		try {
//			Thread.sleep(1200);
//		} catch (InterruptedException e) {
//			System.out.println("Jakiś błąd z waitem.");
//			e.printStackTrace();
//		}
//		}
		
	}
		
}

class TestMouseMover {
	
	
	static double x,y;
	static int delay = 1;
	static int LiniaX = 1710;	
	static int LiniaY = 1060;
	static Robot robot;
	
	
	protected static void clicker() {
		robot.mouseMove(LiniaX, LiniaY);
		robot.delay(500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//		robot.delay(1000);
//		robot.mouseMove(1750, 970);
//		robot.delay(1000);
//		robot.mouseMove(1700, 970);
//		robot.delay(1000);
//		robot.mouseMove(1700, 890);
//		robot.delay(1000);
//		robot.mouseMove(1750, 890);
//		robot.delay(1000);
//		robot.mouseMove(1750, 970);
	}
	protected static void mover() {
		for (LiniaX=1750;LiniaX>=1650;LiniaX--){
			robot.mouseMove(LiniaX, 970);
			robot.delay(delay);
			}
		for (LiniaY=970;LiniaY>=870;LiniaY--){
			robot.mouseMove(1650, LiniaY);
			robot.delay(delay);
			}
		for (LiniaX=1650;LiniaX<=1750;LiniaX++){
			robot.mouseMove(LiniaX, 870);
			robot.delay(delay);
			}
		for (LiniaY=870;LiniaY<=970;LiniaY++){
			robot.mouseMove(1750, LiniaY);
			robot.delay(delay);
			}
		}
	static void MPositioner() {
		PointerInfo PI = MouseInfo.getPointerInfo();		
		Point MP = PI.getLocation();
		x = MP.getX();
		y = MP.getY();
		}
	
	public static void main(String[] args) throws AWTException, IOException {
		
//		killer DrukPetli = new killer();
//		Thread tred = new Thread(DrukPetli);
//		tred.start(); ale MOŻNA TO NAPISAĆ JAK NA DOLE (JAKO ARGUMENT TWORZYSZ NOWĄ INSTANCJE KLASY)
		
		Thread T = new Thread (new killer());
		T.start();
		
		robot = new Robot();
		
		MPositioner();
		TestMouseMover.clicker();
		System.out.println("Done. Now comes the for loop.");
		for(int i=0;i<5;i++) {
			mover();
		}
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		
		robot.mouseMove(1735, 1060);
		robot.delay(500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		for(int i=0;i<5;i++) {
//			mover();
		}
		
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		robot.mouseMove(1760, 1060);
		robot.delay(500);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		for(int i=0;i<5;i++) {
//			mover();
		}
		
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		
		robot.mouseMove((int)x,(int)y);
		System.out.println("Dokonało się.");	
	}
}
