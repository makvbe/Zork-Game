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

import java.util.Random;


/**
 * A class that creates a room
 *
 * <hr>
 * Date created: Apr 26, 2018
 * <hr>
 * @author Roland Patrick Mahe
 */
public class Room {
	
	private boolean holdsMonster;//stores whether or not there is a monster in the dungeon
	private boolean holdsPlayer;//stores whether or not there is a player in the dungeon
	private boolean holdsWeapon;//stores whether or not there is a weapon in the dungeon
	private boolean isExit;//stores whether or not the room is an exit
	private boolean isEntrance;//stores whether or not the room is an entrance
	private Weapon weapon;//stores the rooms weapon
	private Monster monster;//stores the rooms monster
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018 
	 *
	 * 
	 */
	public Room()
	{
		this(false, false, false);
		isExit = false;
		isEntrance = false;
		setWeapon();
		setMonster(0);
	}
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018 
	 *
	 * 
	 * @param holdsPlayer
	 * @param holdsMonster
	 * @param holdsWeapon
	 */
	public Room(boolean holdsPlayer, boolean holdsMonster, boolean holdsWeapon) {
		this.holdsMonster = holdsMonster;
		this.holdsPlayer = holdsPlayer;
		this.holdsWeapon = holdsWeapon;
		isEntrance = false;
		isExit = false;
		setWeapon();
		setMonster(0);
	}
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018 
	 *
	 * 
	 * @param aRoom
	 */
	public Room(Room aRoom)
	{
		this(aRoom.getHoldsPlayer(), aRoom.getHoldsMonster(), aRoom.getholdsWeapon());
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
	public boolean getHoldsMonster() {
		return holdsMonster;
	}
	/**
	 * setter        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param holdsMonster
	 */
	public void setHoldsMonster(boolean holdsMonster) {
		this.holdsMonster = holdsMonster;
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
	public boolean getHoldsPlayer() {
		return holdsPlayer;
	}
	/**
	 * setter        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param holdsPlayer
	 */
	public void setHoldsPlayer(boolean holdsPlayer) {
		this.holdsPlayer = holdsPlayer;
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
	public boolean getholdsWeapon() {
		return holdsWeapon;
	}
	/**
	 * setter        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param holdsWeapon
	 */
	public void setholdsWeapon(boolean holdsWeapon) {
		this.holdsWeapon = holdsWeapon;
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
	public boolean getIsExit() {
		return isExit;
	}
	/**
	 * setter        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param isExit
	 */
	public void setIsExit(boolean isExit) {
		this.isExit = isExit;
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
	public boolean getIsEntrance() {
		return isEntrance;
	}
	/**
	 * setter       
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param isEntrance
	 */
	public void setIsEntrance(boolean isEntrance) {
		this.isEntrance = isEntrance;
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
	public Weapon getWeapon()
	{
		return weapon;
	}
	/**
	 * creates a weapon for the room w/ a random chance for both weapons       
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 */
	public void setWeapon()
	{
		Random rand = new Random();//creating new random object
		int num = rand.nextInt (100) + 1;//num that will be between 1 and 10 inclusively
		
		if(num <= 50)//50% chance
		{
			weapon = new Stick();
		}
		else if(num > 50 && num <= 70)//20% chance
		{
			weapon = new Sword();
		}
		else if(num > 70 && num <= 85)//15% chance
		{
			weapon = new Axe();
		}
		else if(num > 85 && num <= 95)//10% chance
		{
			weapon = new Flail();
		}
		else if(num > 95 && num <= 100)//5% chance
		{
			weapon = new Lightsaber();
		}
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
	public Monster getMonster()
	{
		return monster;
	}
	
	/**
	 * creates a monster for the room w/ random chances for each monster         
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 */
	public void setMonster(int num)
	{
		Random rand = new Random();//creating new random object
		if(num == 11)//if num is not 10, or asked to be KingKong
		{
			monster = new Warlock();
		}
		
		if(num <= 5)//60% chance
		{
			monster = new Frankenstein();
		}
		else if(num > 5 && num <= 8)//30% chance
		{
			monster = new Cyclops();
		}
		else if(num > 8 && num <= 10)//10% chance
		{
			monster = new KingKong();
		}
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
		StringBuilder str = new StringBuilder("|____|");
		
		if(this.holdsPlayer)
		{
			str.setCharAt (1, 'P');
		}
		if(this.holdsMonster)
		{
			str.setCharAt (2, 'M'); 
		}
		if(this.holdsWeapon)
		{
			str.setCharAt (3, 'W');
			str.setCharAt (4, 'e');
		}
		if(this.isExit)
		{
			str.setCharAt (5, ' ');
		}
		if(this.isEntrance)
		{
			str.setCharAt (0, ' ');
		}
		return str.toString();
	}
	
	
}
