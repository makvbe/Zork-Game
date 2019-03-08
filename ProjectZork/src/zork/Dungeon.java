/**
 * -------------------------------------------------------------
 * File name: Dungeon.java
 * Project name: Project 4 - Zork
 * -------------------------------------------------------------
 * Creator's name and email: Samuel Timlick, timlick@etsu.edu
 * Course: CSCI 1260
 * Creation Date: April 19, 2018
 * -------------------------------------------------------------
 */

package zork;

/**
 * Implements completed dungeon into the driver
 * 
 *Date created: April 19, 2018
 *
 *@author Samuel Timlick
 */
import java.util.Random;
public class Dungeon{
	
	private Room [][] rooms; //stores all the rooms
	private int columns;//stores the columns
	private int rows; //stores the rows

	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018 
	 *
	 * 
	 */
	public Dungeon()
	{
		setRows(1);//sets the rows
		setColumns(3);//sets the columns
		setRooms();//sets up the rooms
	}
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018 
	 *
	 * 
	 * @param rows
	 * @param columns
	 */
	public Dungeon(int rows, int columns)
	{
		this.rows = rows;//sets the rows
		this.columns = columns; //columns
		setRooms();
	}
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018 
	 *
	 * 
	 * @param aDungeon
	 */
	public Dungeon(Dungeon aDungeon)
	{
		this(aDungeon.getColumns(), aDungeon.getRows());//copy
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
	public Room[][] getRooms() {
		return rooms;//returns rooms
	}
	/**
	 * setter        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 */
	public void setRooms() 
	{
		int position = 0;//position is set to 0
		rooms = new Room[this.rows][this.columns];//rooms is initialized to the size [this.rows][this.columns]
		Random rand =  new Random();//new random object
		int num = rand.nextInt (this.rows);//num is randomly generated for the amount of rows there are
		Room currentRoom = new Room(true, false, false);//creating the player starting room
		currentRoom.setIsEntrance (true);//setting the player starting room to an entrance
		rooms[0][0] = currentRoom;//adding the player starting room to the array of rooms
		position++;//adding one to position
		for(int y = 0; y < (rooms.length); y++)//for y is less than the length of rooms
		{
			for(int x = 0; position < (rooms[y].length); x++)//for y is less than the length of the current floor of rooms
			{
				rooms[y][position] = new Room(false, rand.nextBoolean(), rand.nextBoolean());//adding a  room at [y][position]
				if(position == (rooms[y].length - 1) && y == num)//if the room is at the end of a floor and is on the floor that was randomly assigned to have an exit then..
				{
					rooms[y][position].setIsExit (true);//make this room an exit
					rooms[y][position].setHoldsMonster (true);
					rooms[y][position].setMonster(11);
				}
				position++;//add one to position
			}
			position = 0;//position = 0
		}
		
		rooms[0][1].setholdsWeapon (false);//set the room to the east of the player starting position to never have a weapon.
		rooms[1][0].setholdsWeapon (false);//set the room to the south of the players starting position to never have a weapon.
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
	public int getColumns() {
		return columns;
	}

	/**
	 * setter         
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param columns
	 */
	public void setColumns(int columns) {
		this.columns = columns;
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
	public int getRows() {
		return rows;
	}

	/**
	 * setter       
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param rows
	 */
	public void setRows(int rows) {
		this.rows = rows;
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
		String str = "";//creating string to be returned later
		
		for(int y = 0; y < rooms.length; y++)//for every floor of the dungeon
		{
			for(int x = 0; x < rooms[y].length; x++)//for every room on this floor of the dungeon
			{
				str += rooms[y][x];//add the room to our str variable
			}
			str += "\n";//new line at the end of every floor
		}
		
		return str;//returning str
	}
}
