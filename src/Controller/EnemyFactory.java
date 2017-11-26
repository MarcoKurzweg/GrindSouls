package Controller;

import Model.Enemy;
import Model.Ghost;
import Model.Minotaur;
import Model.Skeleton;

public class EnemyFactory {
	Enemy currentEnemy;
	
	
	public Enemy createEnemy(String enemyType) {
		if (enemyType.equals("Minotaur")) {
			currentEnemy = new Minotaur();
			currentEnemy.setEnemyXP(currentEnemy.getEnemyHealth()/2);
			currentEnemy.generateLoot();
		} else if (enemyType.equals("Skeleton")) {
			currentEnemy = new Skeleton();
			currentEnemy.setEnemyXP(currentEnemy.getEnemyHealth()/2);
			currentEnemy.generateLoot();
		} else if (enemyType.equals("Ghost")) {
			currentEnemy = new Ghost();
			currentEnemy.setEnemyXP(currentEnemy.getEnemyHealth()/2);
			currentEnemy.generateLoot();
		}
		return currentEnemy;
	}
}
