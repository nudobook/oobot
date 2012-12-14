package com.oobot.robot;

import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * Joe le robot !
 * 
 * @author nudo
 * 
 */
public class JoeRobot extends Robot {

	private double BATTLE_FIELD_HEIGHT = 0;
	private double BATTLE_FIELD_WIDTH = 0;
	
	/***
	 * Initialisation du robot
	 */
	private void init(){
		BATTLE_FIELD_HEIGHT = getBattleFieldHeight();
		BATTLE_FIELD_WIDTH = getBattleFieldWidth();
	}
	
	/***
	 * Methode par defaut de run
	 */
	public void run() {
		init();
		
		while (true) {
			// On avance
			ahead(100);
			// On tourne la tourelle
			turnGunRight(360);
			
			
			turnRight(100);
			ahead(100);
			// On tourne la tourelle
			turnGunRight(360);
			
			turnRight(100);
			// On recule
			back(100);
			// On tourne la tourelle
			turnGunRight(360);
			
			turnRight(100);
			// On recule
			back(100);
			// On tourne la tourelle
			turnGunRight(360);
			
			
		}
	}

	/***
	 * Scan d'un robot
	 * 
	 * @param e
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		turnGunLeft(5);
		for(int i = 0; i< 3; i++){
			turnGunRight(5);
			fire(0.2);
		}
	}
}
