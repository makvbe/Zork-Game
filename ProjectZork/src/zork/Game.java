/**
 * ---------------------------------------------------------------------------
 * File name: Game.java
 * Project name: ProjectZork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Roland Patrick Mahe, maher1@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 24, 2018
 * ---------------------------------------------------------------------------
 */

package zork;


/**
 * To create and manage a game
 *
 * <hr>
 * Date created: Apr 24, 2018
 * <hr>
 * @author Roland Patrick Mahe
 */
import java.util.Random;

public class Game
{
	private Player player;//a variable to store a player object named player
	private Dungeon dungeon;//a variable to store a dungeon object named player
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 25, 2018 
	 *
	 * 
	 */
	public Game()
	{
		setPlayer(new Player());
		setDungeon(new Dungeon());
	}
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 25, 2018 
	 *
	 * 
	 * @param dungeonColumns
	 * @param dungeonRows
	 */
	public Game(int dungeonRows, int dungeonColumns)
	{
		setPlayer(new Player());
		setDungeon(new Dungeon(dungeonRows, dungeonColumns));
	}

	
	/**
	 * @return player
	 */
	public Player getPlayer ( )
	{
		return player;
	}

	
	/**
	 * @param player the player to set
	 */
	public void setPlayer (Player player)
	{
		this.player = player;
	}

	
	/**
	 * @return dungeon
	 */
	public Dungeon getDungeon ( )
	{
		return dungeon;
	}

	
	/**
	 * @param dungeon the dungeon to set
	 */
	public void setDungeon (Dungeon dungeon)
	{
		this.dungeon = dungeon;
	}
	
	/**
	 * a method that returns the location of the player        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @return
	 */
	public String findPlayer()
	{
		String playerLocation = "";//creating player location string to be returned later on
		boolean playerFound = false;//a boolean to store whether or not the player was found
		for(int y = 0; y < dungeon.getRooms().length; y++)//A for loop that will loop through all of the floors of your dungeon
		{
			for(int x = 0; x < dungeon.getRooms()[y].length; x++)//A for loop that will search through all of the dungeons rooms on the current floor
			{
				if(dungeon.getRooms ( )[y][x].getHoldsPlayer())//if the room sub [y][x] holds a player, do this
				{
					playerLocation  = y + "|" + x;
					playerFound = true;//storing the fact that the player was found
					break;//break out of the inner loop, you have found the player
				}
			}
			if(playerFound)//if player was found then do this
			{
				break;//break out of the outer loop
			}
		}
		
		return playerLocation;//returns player location
	}
	
	/**
	 * a method that finds the location of the exit         
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @return
	 */
	public String findExit()
	{
		String exitLocation = "";//creating 
		boolean exitFound = false;//a boolean to store whether or not the player was found
		for(int y = 0; y < dungeon.getRooms().length; y++)//A for loop that will loop through all of the floors of your dungeon
		{
			for(int x = 0; x < dungeon.getRooms()[y].length; x++)//A for loop that will search through all of the dungeons rooms on the current floor
			{
				if(dungeon.getRooms ( )[y][x].getIsExit())//if the room sub [y][x] holds a player, do this
				{
					exitLocation  = y + "|" + x;
					exitFound = true;//storing the fact that the exit was found
					break;//break out of the inner loop, you have found the exit
				}
			}
			if(exitFound)//if exit was found then do this
			{
				break;//break out of the outer loop
			}
		}
		
		return exitLocation;
	}
	
	/**
	 * a method that determines if an action sequence is required       
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @return
	 */
	public boolean actionRequired()
	{
		boolean actionRequired = false;//creating variable that will tell whether or not an action sequence is required
		String[] player = findPlayer().split ("\\|");//split the player location string (formatted "Y|X")
		int y = Integer.parseInt(player[0]);//assign the row location to y
		int x = Integer.parseInt (player[1]);//assign the column location to x
		
		if(dungeon.getRooms ( )[y][x].getHoldsMonster ( ))//if the players location holds a monster
		{
			actionRequired = true;//action is required
		}
		
		return actionRequired;
	}
	
	/**
	 * Moves the player east         
	 *
	 * <hr>
	 * Date created: Apr 25, 2018
	 *
	 * <hr>
	 * @throws Exception
	 */
	public void goEast() throws Exception
	{
		String[] player = findPlayer().split ("\\|");//split the player location string (formatted "Y|X")
		int y = Integer.parseInt(player[0]);//assign the row location to y
		int x = Integer.parseInt (player[1]);//assign the column location to x
		dungeon.getRooms ( )[y][x + 1].setHoldsPlayer(true);//add the player to the room at sub [y][x + 1] (or the room to the east
		//of the players original room) this is where we are basically making the move east
		dungeon.getRooms ( )[y][x].setHoldsPlayer (false);//remove the player from the room at sub [y][x]
	}
	
	/**
	 * Moves the player west        
	 *
	 * <hr>
	 * Date created: Apr 25, 2018
	 *
	 * <hr>
	 * @throws Exception
	 */
	public void goWest() throws Exception
	{
		String[] player = findPlayer().split ("\\|");//split the player location string (formatted "Y|X")
		int y = Integer.parseInt(player[0]);//assign the row location to y
		int x = Integer.parseInt (player[1]);//assign the column location to x
		dungeon.getRooms ( )[y][x - 1].setHoldsPlayer(true);//add the player to the room at sub [y][x - 1] (or the room to the west
		//of the players original room) this is where we are basically making the move west
		dungeon.getRooms ( )[y][x].setHoldsPlayer (false);//remove the player from the room at sub [y][x]
	}
	
	/**
	 * Moves the player north       
	 *
	 * <hr>
	 * Date created: Apr 25, 2018
	 *
	 * <hr>
	 * @throws Exception
	 */
	public void goNorth() throws Exception
	{
		String[] player = findPlayer().split ("\\|");//split the player location string (formatted "Y|X")
		int y = Integer.parseInt(player[0]);//assign the row location to y
		int x = Integer.parseInt (player[1]);//assign the column location to x
		dungeon.getRooms ( )[y - 1][x].setHoldsPlayer(true);//add the player to the room at sub [y - 1][x] (or the room to the north 
		//of the players original room) this is where we are basically making the move north
		dungeon.getRooms ( )[y][x].setHoldsPlayer (false);//remove the player from the room at sub [y][x]
	}
	
	/**
	 * Moves the player south   
	 *
	 * <hr>
	 * Date created: Apr 25, 2018
	 * array[1].length
	 * <hr>
	 * @throws Exception
	 */
	public void goSouth() throws Exception
	{
		String[] player = findPlayer().split ("\\|");//split the player location string (formatted "Y|X")
		int y = Integer.parseInt(player[0]);//assign the row location to y
		int x = Integer.parseInt (player[1]);//assign the column location to x
		dungeon.getRooms ( )[y + 1][x].setHoldsPlayer(true);//add the player to the room at sub [y + 1][x] (or the room to the south 
		//of the players original room) this is where we are basically making the move south
		dungeon.getRooms ( )[y][x].setHoldsPlayer (false);//remove the player from the room at sub [y][x]
	}
	
	/**
	 * Finds out whether or not you can exit the dungeon        
	 *
	 * <hr>
	 * Date created: Apr 25, 2018
	 *
	 * <hr>
	 * @return boolean
	 */
	public boolean canExit()
	{
		boolean canExit = false;//boolean to tell whether or not the player can exit
		String[] player = findExit().split ("\\|");//split the exit location string (formatted "Y|X")
		int y = Integer.parseInt(player[0]);//assign the row location to y
		int x = Integer.parseInt (player[1]);//assign the column location to x
		
		if(findPlayer().equals (findExit()) && !dungeon.getRooms ( )[y][x].getHoldsMonster ( ))//if the player location is equal to exit location and the location doesnt hold a monster
		{
			canExit = true;//can exit is true
		}
		
		return canExit;
	}
	
	/**
	 * a method for exiting the dungeon         
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 */
	public void exitDungeon()
	{
		String[] player = findPlayer().split ("\\|");//split the player location string (formatted "Y|X")
		int y = Integer.parseInt(player[0]);//assign the row location to y
		int x = Integer.parseInt (player[1]);//assign the column location to x
		dungeon.getRooms ( )[y][x].setHoldsPlayer (false);//remove the player from the room at sub [y][x]
	}
	
	/**
	 * a method for picking up a weapon        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param weapon
	 */
	public void pickUpWeapon(Weapon weapon)
	{
		player.setWeapon(weapon);
		String[] player = findPlayer().split ("\\|");//split the player location string (formatted "Y|X")
		int y = Integer.parseInt(player[0]);//assign the row location to y
		int x = Integer.parseInt (player[1]);//assign the column location to x
		dungeon.getRooms ( )[y][x].setholdsWeapon (false);//the player has picked up the weapon, thus this room no longer holds a weapon
	}
	
	/**
	 * a method for attacking a monster        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param monster
	 * @return
	 */
	public Monster attackMonster(Monster monster)
	{
		int newHealth = monster.getHealth ( );//stores the new health of the monster after the player attacks it
		
		newHealth -= player.getDamage ( );//damage monster
		
		if(newHealth < 0)//if newHealth is less than 0 do this..
		{
			newHealth = 0;//set newHealth to 0
		}
		
		monster.setHealth (newHealth);//set monsters health to the value of newHealth.
		
		return monster;
	}

	/**
	 * a method for damaging the player        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param monster
	 */
	public void dmgPlayer(Monster monster)
	{
		int newHealth = player.getHealth ( );//stores the new health of the player after the monster attacks it
		
		newHealth -= monster.getDamage ( );//damage player

						
		if(newHealth < 0)//if new health is less than 0 do this..
		{
			newHealth = 0;//set newhealth to 0
		}
		
		player.setHealth (newHealth);//set players health to the value of newhealth
	}
	/**
	 * A method for running east away from a monster, with a 40% chance.       
	 *
	 * <hr>
	 * Date created: Apr 25, 2018
	 *
	 * <hr>
	 * @throws Exception
	 */
	public void runAway() throws Exception
	{
		Random rand = new Random();//creating new random object
		int chance = rand.nextInt(10) + 1;//creating random variable between 1 and 10 that will determine if the player ran away
		int direction = rand.nextInt(4) + 1;//creating variable between 1 and 4 that will determine the direction the player runs in
		
		if(chance <= 4)//40% chance (10% for south, 10% for north, 10% for east, 10% for south) if player cannot run anyone of these directions, the chances 
																						//of them running away are reduced by 10% per direction they can run
		{
			switch(direction)
			{
				case 1://if direction is 1
					goEast();//go east (throws exception if player cant run east)
					break;
				case 2://if direction is 2 (throws exception if player cant run west)
					goWest();//go west
					break;
				case 3://if direction is 3 (throws exception if player cant run north)
					goNorth();//go north
					break;
				case 4://if direction is 4 (throws exception if player cant run south)
					goSouth();// go south
					break;
			}
		}
		else//if the player doesn't get the chance to run away, throw an exception
		{
			throw new Exception();
		}
		
	}//end runaway

	public void animateRoom()
	{
		String room =   "  -\\                         -                           |                           -                          --\r\n" + 
						"   ---\\----------------------\\-                         |--------------------------/                       ---/  \r\n" + 
						"       ---\\                    \\-                       |                       -/                     ---/   |  \r\n" + 
						"          |--\\                   \\----------------------|                     -/----------------------/       |  \r\n" + 
						"          |   ---\\                 \\-                   |                   -/                  --/           |  \r\n" + 
						"          |       ---\\---------------\\-                 |------------------/                ---/|             |  \r\n" + 
						"          |           --\\              \\-               |               -/              ---/    |             |  \r\n" + 
						"          |            | ---\\            \\--------------|             -/---------------/        |             |  \r\n" + 
						"-----     |            |     ---\\----------\\-           |------------/          ---/            |           -----\r\n" + 
						"   | \\-------          |        ----------------------------------------------/   |              |   -------/     \r\n" + 
						"   |         \\-------- |         |          |          |          |          |    |       --------/  |          \r\n" + 
						"   |            |     \\-------   |          |          |          |          |    -------/           |          \r\n" + 
						"   |            |             \\--|-------------------------------------------|----/   |              |          \r\n" + 
						"   |            |             |   |    |          |           |          |    |        |              |          \r\n" + 
						"   |            |             |   |    |          |           |          |    |        |              |          \r\n" + 
						"----------------------------------|-------------------------------------------|----------------------------------\r\n" + 
						"          |            |          |         |           |          |          |     |            |             |  \r\n" + 
						"          |            |        /-|-------------------------------------------|-\\  |            |             |  \r\n" + 
						"          |            |  /-----  |    |          |           |          |    |  -----\\         |             |  \r\n" + 
						"          |         /-----    |   |    |          |           |          |    |        -----\\   |             |  \r\n" + 
						"          |    /----          |  /-----------/----------|----------\\-----------\\       |     ----\\            |  \r\n" + 
						"         /----- |             /--          /------------|           -\\------------\\    |          -----\\      |  \r\n" + 
						"   /-----       |          /--            /             |             \\            --\\ |              | -----\\|  \r\n" + 
						"---|            |       /---------------/-              |---------------\\             --\\             |       ---\r\n" + 
						"   |            |    /--               /                |                \\               --\\          |          \r\n" + 
						"   |            |/---                -------------------|                 -\\-------------------\\      |          \r\n" + 
						"   |          /--                  /-                   |                   -\\                  --\\   |          \r\n" + 
						"   |       /----------------------/                     |---------------------\\                    --\\|          \r\n" + 
						"   |    /--                     /-                      |                      -\\                     --\\        \r\n" + 
						"   | /--                       /                        |                        \\                       --\\     \r\n" + 
						"  /--                        /--------------------------|                         -\\--------------------------\\  \r\n" + 
						"--                          -                           |                           -                          --";
		String[] player = findPlayer().split ("\\|");//split the player location string (formatted "Y|X")
		int y = Integer.parseInt(player[0]);//assign the row location to y
		int x = Integer.parseInt (player[1]);//assign the column location to x
		Room currentRoom = dungeon.getRooms ( )[y][x];
		
		if(currentRoom.getHoldsMonster ( )) 
		{
			if(currentRoom.getMonster ( ).getName().equals ("Warlock"))
			{
				room =		"  -\\                         -                           |                           -                          --\r\n" + 
							"   ---\\----------------------\\-                         |--------------------------/                       ---/  \r\n" + 
							"       ---\\                    \\-                       |                       -/                     ---/   |  \r\n" + 
							"          |--\\                   \\----------------------|                     -/----------------------/       |  \r\n" + 
							"          |   ---\\                 \\-                   |                   -/                  --/           |  \r\n" + 
							"          |       ---\\---------------\\-                 |------------------/                ---/|             |  \r\n" + 
							"          |           --\\              \\-               |               -/              ---/    |             |  \r\n" + 
							"          |            | ---\\            \\--------------|             -/---------------/        |             |  \r\n" + 
							"-----     |            |     ---\\----------\\-           |------------/          ---/            |           -----\r\n" + 
							"   | \\-------          |        ----------------------------------------------/   |              |   -------/     \r\n" + 
							"   |         \\-------- |         |          |          |          |          |    |       --------/  |          \r\n" + 
							"   |            |     \\-------   |          |          |          |          |    -------/           |          \r\n" + 
							"   |            |             \\--|-------------------------------------------|----/   |              |          \r\n" + 
							"   |            |             |   |    |          |           |          |    |        |              |          \r\n" + 
							"   |            |             |   |    |          |           |          |    |        |              |          \r\n" + 
							"----------------------------------|-------------------------------------------|----------------------------------\r\n" + 
							"          |            |          |         |           |          |          |     |            |             |  \r\n" + 
							"          |            |        /-|-------------------------------------------|-\\  |            |             |  \r\n" + 
							"          |            |  /-----  |    |          |           |          |    |  -----\\         |             |  \r\n" + 
							"          |         /-----    |   |    |          |           |          |    |        -----\\   |             |  \r\n" + 
							"          |    /----          |  /-----------/----------|----------\\-----------\\       |     ----\\            |  \r\n" + 
							"         /----- |             /--          /------------|           -\\------------\\    |          -----\\      |  \r\n" + 
							"   /-----       |          /--            /             |             \\            --\\ |              | -----\\|  \r\n" + 
							"---|            |       /---------------/-              |---------------\\             --\\             |       ---\r\n" + 
							"   |            |    /--               /                |                \\               --\\          |          \r\n" + 
							"   |            |/---                -------------------|                 -\\-------------------\\      |          \r\n" + 
							"   |          /--                  /-      ||        ccc/                 -\\                  --\\   |          \r\n" + 
							"   |       /----------------------/        ||           |---------------------\\                    --\\|          \r\n" + 
							"   |    /--                     /-                      |                      -\\                     --\\        \r\n" + 
							"   | /--                       /                        |                        \\                       --\\     \r\n" + 
							"  /--                        /--------------------------|                         -\\--------------------------\\  \r\n" + 
							"--                          -                           |                           -                          --";
			}
		}
	}
}
