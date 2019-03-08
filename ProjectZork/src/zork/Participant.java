/**
 * -------------------------------------------------------------
 * File name: Room.java

 * Project name: Project 4 - Zork
 * -------------------------------------------------------------
 * Creator's name and email: Samuel Timlick, timlick@etsu.edu
 * Course: CSCI 1260
 * Creation Date: April 19, 2018
 * -------------------------------------------------------------
 */

/**
 * Implements a set of rooms with a Dungeon
 * 
 *Date created: April 19, 2018
 *
 *@author Samuel Timlick
 */
package zork;

/**
 * Super class for anything that is participating in the game
 *
 * <hr>
 * Date created: Apr 26, 2018
 * <hr>
 * @author Roland Patrick Mahe
 */
public class Participant {
	
	private int health;//stores the health of the participant
	private int damage;//stores the damage of the participant

	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018 
	 *
	 * 
	 */
	public Participant() {
		this(100, 5);
	}
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018 
	 *
	 * 
	 * @param health
	 * @param damage
	 */
	public Participant(int health, int damage) {
		setHealth(health);
		setDamage(damage);
	}
	/**
	 * getter         
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @return
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * setter       
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	/**
	 * getter         
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @return
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * setter        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param damage
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	
	/**
	 * tostring         
	 *
	 * <hr>
	 * Date created: Apr 26, 2018 
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String str = "Health: " + getHealth() +
					"\nDamage: " + getDamage();
		
		return str;
	}
	
}
