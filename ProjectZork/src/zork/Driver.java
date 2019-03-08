/**
 * ---------------------------------------------------------------------------
 * File name: Driver.java
 * Project name: ProjectZork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Roland Patrick Mahe, maher1@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Apr 23, 2018
 * ---------------------------------------------------------------------------
 */
package zork;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
 * Drives the game
 *
 * <hr>
 * Date created: Apr 23, 2018
 * <hr>
 * @author Roland Patrick Mahe
 */
public class Driver
{
	public static Game g1;//variable for game to be stored in
	public static Monster currentMonster;//variable to store a monster
	
	public static void main(String[] args)
	{
		openSeq();////shows castle, tells user to press enter to continue
		Scanner kb = new Scanner(System.in);//creating new scanner
		Random rand = new Random(); //creates object of random class 
		int columns = rand.nextInt(6) + 5; //invokes nextInt method to assign random number in 5-10 range to int num
		int rows = rand.nextInt(6) + 5;//invokes nextInt method to assign a random number in 5-10 range to int num
		boolean exited = false;//boolean to tell if the player has exited
		g1 = new Game(rows, columns);//creating a new game with a randomly generated rows and columns
		showGrid();//shows the dungeon
		System.out.println("Your choices for movement are 'go north' , 'go east' , 'go south' , and 'go west'");
		kb.nextLine( );//clearing the buffer, from enter to continue
		do {
			movePlayer(getDirection());//getting direction then moving player
			showGrid();//showing dungeon
			showHealth();//showing health
			
			String[] player = g1.findPlayer().split ("\\|");//split the player location string (formatted "Y|X")
			int y = Integer.parseInt(player[0]);//assign the row location to y
			int x = Integer.parseInt (player[1]);//assign the column location to x
			
			
			if(g1.getDungeon ( ).getRooms ( )[y][x].getholdsWeapon ( ))//if player location holds a weapon
			{
			    System.out.println("There is a weapon in this room! Do you want to pick up the weapon?");//asks player if they want to pick up the weapon
			    pickUp(kb.nextLine());//getting user input and putting the input into pickUp method
			}
			
			
			if(g1.actionRequired())//if there is an action sequence required...
			{
				do {
					battleRun(getFightOrRun());//get users input on whether or not to fight and running the battle sequence
				}while(g1.actionRequired ( ));//while action sequence is required
			}
			
			if(g1.canExit ( ))//if user can exit
			{
				System.out.println("\nExiting the dungeon..." +
								   "\n\nCONGLATURATION !!!" +
								   "\n\nYOU HAVE COMPLETED A GREAT GAME." +
								   "\nAND PROOVED THE JUSTICE OF OUR CULTURE." +
								   "\nNOW GO AND REST OUR HEROES !");
				exited = true;//the user has exited
				g1.exitDungeon ( );//exiting dungeon
			}
		}while(g1.getPlayer ( ).getHealth() > 0 && !exited);//while players health is above 0 and the player hasn't exited
		
		kb.close ( );//closing kb
	}//end main
	
	public static void openSeq()
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("                                 o\r\n" + 
						"                             .-\"\"|\r\n" + 
						"                             |-\"\"|\r\n" + 
						"                                 |   ._--+.\r\n" + 
						"                                .|-\"\"      '.\r\n" + 
						"                               +:'           '.\r\n" + 
						"                               | '.        _.-'|\r\n" + 
						"                               |   +    .-\"   J\r\n" + 
						"            _.+        .....'.'|    '.-\"      |\r\n" + 
						"       _.-\"\"   '.   ..'88888888|     +       J''..\r\n" + 
						"    +:\"          '.'88888888888;-+.  |    _+.|8888:\r\n" + 
						"    | \\         _.-+888888888_.\" _.F F +:'   '.8888'....\r\n" + 
						"     L \\   _.-\"\"   |8888_.-\"  _.\" J J J  '.    +88888888:\r\n" + 
						"     |  '+\"        |_.-\"  _.-\"    | | |    +    '.888888'._''.\r\n" + 
						"   .'8L  L         J  _.-\"        | | |     '.    '.88_.-\"    '. \r\n" + 
						"  :888|  |         J-\"            F F F       '.  _.-\"          '.\r\n" + 
						" :88888L  L     _+  L            J J J          '|.               '; \r\n" + 
						":888888J  |  +-\"  \\ L          _.+.|.+.          F '.          _.-\" F\r\n" + 
						":8888888|  L L\\    \\|      _.-\"    '   '.       J    '.     .-\"    |\r\n" + 
						":8888888.L | | \\    ', _.-\"              '.     |      \"..-\"      J'.\r\n" + 
						":888888: |  L L '.    \\     _.-+.          '.   :+-.     |        F88'.\r\n" + 
						":888888:  L | |   \\    ;.-\"\"     '.          :-\"    \":+ J        |88888:\r\n" + 
						":888888:  |  L L   +:\"\"            '.    _.-\"     .-\" | |       J:888888:\r\n" + 
						":888888:   L | |   J \\               '.-'     _.-'   J J        F :888888:\r\n" + 
						" :88888:    \\ L L   L \\             _.-+  _.-'       | |       |   :888888:\r\n" + 
						" :888888:    \\| |   |  '.       _.-\"   |-\"          J J       J     :888888:\r\n" + 
						" :888888'.    +'\\   J    \\  _.-\"       F    ,-T\"\\  | |     .-'      :888888:\r\n" + 
						"  :888888 '.     \\   L    +\"          J    /  | J  J J  .-'        .'888888:\r\n" + 
						"   :8888888 :     \\  |    |           |    F  '.|.-'+|-'         .' 8888888:\r\n" + 
						"    :8888888 :     \\ J    |           F   J     '...           .' 888888888:\r\n" + 
						"     :8888888 :     \\ L   |          J    |      \\88'.''.''''.' 8888888888:\r\n" + 
						"      :8888888 :     \\|   |          |  .-'\\      \\8888888888888888888888:\r\n" + 
						"       :8888888 '.    J   |          F-'  .'\\      \\8888888888888888888.'\r\n" + 
						"        :88888888 :    L  |         J     : 8\\      \\8888888888888888.'\r\n" + 
						"         :88888888 :   |  |        .+  ...' 88\\      \\8888888888.''.'\r\n" + 
						"          :88888888 :  J  |     .-'  .'    8888\\      \\'.'''.'.' \r\n" + 
						"           :88888888 :  \\ |  .-'   .' 888888888.\\    _-'     \r\n" + 
						"           :888888888 :  \\|-'     .' 888888888.' \\_-\"\r\n" + 
						"            '.88888888'..         : 8888888.' \r\n" + 
						"              :88888888  ''''.''.' 88888888:           \r\n" + 
						"              :8888888888888888888888888888:\r\n" + 
						"               :88888888888888888888888888:\r\n" + 
						"                :888888888888888888888888:\r\n" + 
						"                 ''.8888888888888...'.'''\r\n" + 
						"                    '''''......''" +
						"\n\n\rYou have been placed in Castle Zorks dungeon, Prisoner! You must fight your way out!\n\nPress enter to continue...");
		try {//this try catch waits until the user presses enter
			System.in.read ( );
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * gets the direction that the player wants to move       
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @return
	 */
	public static String getDirection()
	{
		Scanner kb = new Scanner(System.in);
		String userInput = "";
		boolean validChoice;
		
		do
		{
		    try
		    { 
		        System.out.println("Make your move: ");

		        userInput = kb.nextLine().toUpperCase();

		        if(!userInput.contains("NORTH") && !userInput.contains("EAST") && !userInput.contains("SOUTH") && !userInput.contains("WEST"))
		        {
		            throw new Exception("That is an invalid entry. Please type your choice again!");
		        }
		        validChoice = true;
		    }
		    catch(Exception ex)
		    {
		        System.out.println(ex.getMessage());
		        validChoice = false;
		    }
		}while(validChoice == false);
		
		return userInput;
	}
	
	/**
	 * moves the player       
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param direction
	 */
	public static void movePlayer(String direction)
	{
		if(direction.contains ("NORTH"))
		{
			try {
				g1.goNorth();
			}
			catch(Exception ex) {
				System.out.println("You can't move north right now!");
			}
		}
		else if(direction.contains("EAST"))
		{
			try {
				g1.goEast();
			}
			catch(Exception ex) {
				System.out.println("You can't move east right now!");
			}
		}
		else if(direction.contains ("SOUTH"))
		{
			try {
				g1.goSouth();
			}
			catch(Exception ex) {
				System.out.println("You can't move south right now!");
			}
		}
		else if(direction.contains ("WEST"))
		{
			try {
				g1.goWest();
			}
			catch(Exception ex) {
				System.out.println("You can't move west right now!");
			}

		}
	}//end movePlayer

	public static void wait(int milliseconds)
	{
		try {
			TimeUnit.MILLISECONDS.sleep (milliseconds);
		}
		catch(Exception ex) {
			System.out.print ("");
		}
	}
	
	public static void pickUp(String userInput)
	{
		Scanner kb = new Scanner(System.in);//creating scanner object
		String[] player = g1.findPlayer().split ("\\|");//split the player location string (formatted "Y|X")
        int y = Integer.parseInt(player[0]);//assign the row location to y
        int x = Integer.parseInt (player[1]);//assign the column location to x
	    userInput = userInput.toUpperCase ( );//converting userinput to upper case
	    boolean validInput = false;//a boolean that will tell whether or not valid input was given
	    do {
	        if(userInput.contains("YES"))//if user enters yes
	        {
	            Weapon weapon = g1.getDungeon ( ).getRooms ( )[y][x].getWeapon ( );//get weapon in room and assign it to weapon
	            g1.pickUpWeapon (weapon);//pick up weapon
	            if(weapon.getWeaponName ( ).equals ("Flail"))
	            {
	            	System.out.println("You picked up a--- uh... wait... I don't know what that's called. You know that swingy spikey ball\n" +
	            					   "from that one medieval movie?? No? Well you should. Wait! They called it--- no nevermind thats not it...\n\n");
	            	wait(11000); 
	            	System.out.println("Let me just google that real quick.");
	            	wait(3000);
	            	System.out.print("g"); wait(200); System.out.print("o"); wait(200); System.out.print("o"); wait(200); System.out.print("g"); wait(200); System.out.print("l"); wait(200); System.out.print("e"); wait(200); System.out.print("."); wait(200); System.out.print("c"); wait(200); System.out.print("o"); wait(200); System.out.print("m");
	            	wait(400);
	            	System.out.println("\n.");
	            	wait(400);
	            	System.out.println(".");
	            	wait(400);
	            	System.out.println(".");
	            	wait(400);
	            	System.out.println(".");
	            	wait(400);
	            	System.out.print("Google: "); 
	            	wait(1000);
	            	System.out.print("s"); wait(200); System.out.print("w"); wait(200); System.out.print("i"); wait(200); System.out.print("n"); wait(200); System.out.print("g"); wait(200); System.out.print("y");
	            	System.out.print(" "); wait(200); System.out.print ("s"); wait(200); System.out.print("p"); wait(200); System.out.print("i"); wait(200); System.out.print("k"); wait(200); System.out.print("e");
	            	System.out.print(" "); wait(200); System.out.print ("b"); wait(200); System.out.print("a"); wait(200); System.out.print("l"); wait(200); System.out.print("l");
	            	wait(1500);
	            	System.out.println("\n\nResults:");
	            	wait(800);
	            	System.out.println("\nYup, thats called a flail, not sure how you didn't know that\n\n");
	            	wait(3500);
	            	System.out.println("Well then google, no need to be rude about it! Now time to finish what I am supposed to say I guess...\n\n");
	            	wait(4000);
	            	showGrid();
	            }
	            System.out.println("You picked up a " + weapon + " damage!");//telling the user they picked up this weapon
	            validInput = true;//valid input was given
	        }
	        else if(userInput.contains ("NO"))//if user enters no
	        {
	            validInput = true;//valid input was given, but do nothing
	        }
	        else
	        {
	            System.out.println("I don't understand... Please enter 'yes' or 'no'");//telling the user i dont understand, since they entered something invalid
	            userInput = kb.nextLine().toUpperCase ( );//getting the users input again
	        }
	    }while(!validInput);//do while there isnt a valid input
	}
	
	/**
	 * Gets whether the player wants to fight or run         
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @return
	 */
	public static String getFightOrRun()
	{
		Scanner kb = new Scanner(System.in);//creating new scanner object

		String userInput = "";//creating variable to userinput to be stored in
		boolean validChoice;//a boolean to store whether valid choice was given
		
		do
		{
		    try
		    { 
		    	String[] player = g1.findPlayer().split ("\\|");//split the player location string (formatted "Y|X")
		        int y = Integer.parseInt(player[0]);//assign the row location to y
		        int x = Integer.parseInt (player[1]);//assign the column location to x
		        currentMonster = g1.getDungeon ( ).getRooms ( )[y][x].getMonster ( );//current monster equals the monster in the players room
	    		System.out.println("\nThere is (a) " + currentMonster.getName ( ) + " in the room! \nDo you want to attack it or run away? (Type 'attack' or 'run'): ");

		        userInput = kb.nextLine().toUpperCase();//getting the users input and converting it to upper case

		        if(!userInput.equals("ATTACK") && !userInput.equals("RUN") )//if user inputs anything else besides attack or run...
		        {
		            throw new Exception("That is an invalid entry. Please type your choice again!");//tell them they entered something invalid and throw exception
		        }
		        validChoice = true;//valid choice is true
		    }
		    catch(Exception ex)
		    {
		        System.out.println(ex.getMessage());//get message of exception
		        validChoice = false;//valid choice is false
		    }
		}while(validChoice == false);//while valid choice is false
		
		return userInput;
	}//end getFightOrRun
	
	/**
	 * Runs the battle     
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param userChoice
	 */
	public static void battleRun(String userChoice)
	{
		Random rand = new Random();//creating new random object
		int num = rand.nextInt(10) + 1;//num will be between 1 and 10 inclusively
		String[] player = g1.findPlayer().split ("\\|");//split the player location string (formatted "Y|X")
        int y = Integer.parseInt(player[0]);//assign the row location to y
        int x = Integer.parseInt (player[1]);//assign the column location to x
		switch(userChoice)
		{
			case "ATTACK"://if userChoice is attack

		        if(num <= 9)//90% chance to hit monster
		        {
		        	System.out.println("\nYou hit the monster for " + g1.getPlayer ( ).getDamage ( ) + " damage!");
		        	g1.attackMonster(currentMonster);//damage monster with players damage stat
		        }
		        else
		        {
		        	System.out.println("\nYou missed!");//tell the user they missed
		        }
		        
		        if(num <= 8)//80% chance for monster to hit player
		        {
		        	System.out.println("The monster hit you for " + currentMonster.getDamage ( ) + " damage!");
		        	g1.dmgPlayer (currentMonster);//damage player with currentMonsters damage stat
		        }
		        else 
		        {
		        	System.out.println("The monster missed!");//tell the user the monster missed
		        }
		        
		        System.out.println ("\nMonster health: " + currentMonster.getHealth ( ) + 
									"\nPlayer health: " + g1.getPlayer ( ).getHealth ( ) + "\n");//tell the userr the monsters health and their health
		        
		        if(g1.getPlayer ( ).getHealth ( ) <= 0)//if users health is less than or equal to 0 then...
		        {
		        	System.out.println("\nYou died!" +
		        					   "\nGAME OVER");//tell the user they died
		        	System.exit (0);//exit
		        }
		        else if(currentMonster.getHealth ( ) <= 0)//if monsters health is <= 0 then...
		        {
		        	g1.getDungeon ( ).getRooms ( )[y][x].setHoldsMonster (false);//players room no longer holds a monster
		        	System.out.println(g1.getDungeon() + "\n\nYou defeated the monster!");//tell the user they defeated the monster
		        }
		        
				break;
				
			case "RUN"://if the userChoice is run
				try
				{
					g1.runAway();//run away
					showGrid();//show grid
				}
				catch(Exception ex)//if the user fails to run away
				{
					System.out.println ("\nYou failed to run away!");//tell them
			        System.out.println("The monster hit you for " + currentMonster.getDamage ( ) + " damage!");//tell the user the monster hit them
			        g1.dmgPlayer (currentMonster);//the monster hits the player 100% of the time if they run away
				}
				break;
		}
	}//end battleRun(String userChoice)
	
	public static void showHealth()
	{
		System.out.println ("Player's Health: " + g1.getPlayer ( ).getHealth ( ));//show health
	}//end showHealth
	
	public static void showGrid()
	{
		System.out.println (g1.getDungeon());//show grid
	}//end showGrid()
}
