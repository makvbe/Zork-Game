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
 * A super class for a plater in the dungeon
 * 
 *Date created: April 19, 2018
 *
 *@author Samuel Timlick
 */
package zork;
public class Player extends Participant{
	
	private Weapon weapon;//stores the weapon the player has

	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018 
	 *
	 * 
	 */
	public Player() {
		super(100, 5);
		setWeapon(new Fisticuffs());
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
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * setter        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param weapon
	 */
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
		setDamage((5 + weapon.getWeaponDmg ( )));//changing damage based on the swords damage plus the players base damage of 5
	}
	
	/**
	 * tostring        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018 
	 *
	 * <hr>
	 * @return
	 * @see zork.Participant#toString()
	 */
	public String toString()
	{
		return ("Health: " + getHealth ( ) +
			    "\nWeapon: " + weapon.getWeaponName ( ) + 
			    "\nTotal Damage: " + getDamage ( ));
	}
}
