/**
 * ---------------------------------------------------------------------------
 * File name: Potion.java
 * Project name: ProjectZork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Roland Patrick Mahe, maher1@etsu.edu
 * Course:  CSCI 1260
 * Creation Date: Jul 1, 2018
 * ---------------------------------------------------------------------------
 */

package zork;


/**
 * Enter type purpose here
 *
 * <hr>
 * Date created: Jul 1, 2018
 * <hr>
 * @author Roland Patrick Mahe
 */
public class Potion
{
	private int power;
	private String name;
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Nov 24, 2018 
	 *
	 * 
	 */
	public Potion()
	{
		this(15,"Small Potion of Healing");
	}
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Nov 24, 2018 
	 *
	 * 
	 * @param healPower
	 * @param name
	 */
	public Potion(int power, String name)
	{
		setPower(power);
		setName(name);
	}
	
	/**
	 * Getter for healing power       
	 *
	 * <hr>
	 * Date created: Nov 24, 2018
	 *
	 * <hr>
	 * @return
	 */
	public int getPower()
	{
		return power;
	}
	
	/**
	 * setter for power     
	 *
	 * <hr>
	 * Date created: Nov 24, 2018
	 *
	 * <hr>
	 * @param power
	 */
	public void setPower(int power)
	{
		this.power =  power;
	}
	
	/**
	 * GETTER FOR NAME        
	 *
	 * <hr>
	 * Date created: Nov 24, 2018
	 *
	 * <hr>
	 * @return
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * setter for name         
	 *
	 * <hr>
	 * Date created: Nov 24, 2018
	 *
	 * <hr>
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
}
