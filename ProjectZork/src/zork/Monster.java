package zork;

/**
 * A sub class of participant and also a super class of any monster
 *
 * <hr>
 * Date created: Apr 26, 2018
 * <hr>
 * @author Roland Patrick Mahe
 */
public abstract class Monster extends Participant {
	
	private String name;//name of the monster
	
	
	/**
	 * Constructor        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018 
	 *
	 * 
	 */
	public Monster()
	{
		this(10, 2, "Frankenstein");
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
	 * @param name
	 */
	public Monster(int health, int damage, String name)
	{
		super(health, damage);
		setName(name);
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
	public String getName() {
		return name;
	}
	/**
	 * setter        
	 *
	 * <hr>
	 * Date created: Apr 26, 2018
	 *
	 * <hr>
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}