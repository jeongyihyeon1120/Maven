package Macro;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MacroCA {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			while (true) {
				
			Robot robot = new Robot();
			robot.delay(3000);
			robot.mouseMove(1100, 750);
			
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			}
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


}
