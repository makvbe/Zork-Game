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
public class Weapon {
	
	private int weaponDmg;//a variable that will store the damage of the weapon
	private String name;//a variable that will store the name of the weapon
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 25, 2018 
	 *
	 * 
	 */
	public Weapon()
	{
		this(0, "Fisticuffs");
	}
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 25, 2018 
	 *
	 * 
	 * @param weaponDmg
	 * @param name
	 */
	public Weapon(int weaponDmg, String name)
	{
		setWeaponDmg(weaponDmg);
		setWeaponName(name);
	}
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 25, 2018 
	 *
	 * 
	 * @param copy
	 */
	public Weapon(Weapon copy)
	{
		setWeaponDmg(copy.getWeaponDmg ( ));
	}
	
	/**
	 * getter for weapon damage      
	 *
	 * <hr>
	 * Date created: Apr 25, 2018
	 *
	 * <hr>
	 * @return
	 */
	public int getWeaponDmg() {
		return weaponDmg;
	}
	/**
	 * setter for weapon damage       
	 *
	 * <hr>
	 * Date created: Apr 25, 2018
	 *
	 * <hr>
	 * @param weaponDmg
	 */
	public void setWeaponDmg(int weaponDmg) {
		this.weaponDmg = weaponDmg;
	}
	
	/**
	 *  gerrer for weapon name     
	 *
	 * <hr>
	 * Date created: Apr 25, 2018
	 *
	 * <hr>
	 * @return
	 */
	public String getWeaponName() {
		return name;
	}
	/**
	 * setter for weapon name        
	 *
	 * <hr>
	 * Date created: Apr 25, 2018
	 *
	 * <hr>
	 * @param name
	 */
	public void setWeaponName(String name) {
		this.name = name;
	}

	/**
	 * to string       
	 *
	 * <hr>
	 * Date created: Apr 25, 2018 
	 *
	 * <hr>
	 * @return
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return (getWeaponName() + " which does " + getWeaponDmg());
	}
}
