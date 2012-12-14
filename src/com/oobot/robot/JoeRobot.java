package com.oobot.robot;

import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * Joe le robot qui poutre !
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
			fire(0.2);
			while(getGunHeat() > 0){
				turnGunRight(1);
			}
		}
	}
	
	/***
	 * Si on entre en collision avec un autre robot
	 * On tourne la tourelle vers lui et on tire a puissance maximum
	 */
	public void onHitRobot(HitRobotEvent event){
		
		// Si on a la possibilite de tirer rapidement
		
		double whereIsIt = event.getBearing();
		
		// Calculer si on pourra tourner assez rapidement la tourelle pour shooter le type
		// if(getGunHeat())
		
		// On tourne soit a gauche, soit a droite
		if(whereIsIt < 0){
			turnGunLeft(whereIsIt);
		}else{
			turnGunRight(whereIsIt);
		}
		waitAndFire(3.0);
		//
		// Tirer un boulet de 3
	}
	
	/**
	 * Attend que la tourelle soit prete et tire
	 * @param firePower
	 */
	private void waitAndFire(double firePower){
		
		while(getGunHeat() > 0){
			
		}
		fire(firePower);
	}

	// Methode pour savoir s'il vaut mieux tourner a gauche ou a droite pour rattraper un certain degre
}
