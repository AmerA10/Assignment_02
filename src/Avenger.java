
/*
 * Object class Avenger, encapsulation of names, aliases, and the frequencies of them
 * 
 * COMP 2503 Assignment 1 
 * @author Ali Hassan
 * @date Sept 30, 2020
 * 
 */
public class Avenger implements Comparable <Avenger>
{
	
	private String heroName;
	private String heroAlias;
	private int frequency;
	
	/*
	 * Contructor
	 * @param  name of hero
	 * @param alias of hero
	 */
	public Avenger(String heroName, String heroAlias) 
	{
		this.heroName = heroName;
		this.heroAlias = heroAlias;
		this.frequency = 1;
	}
	
	public String getHeroName() 
	{
		return heroName;
	}
	
	public String getHeroAlias() 
	{
		return heroAlias;
	}
	
	public int getFreq() 
	{
		return frequency;
	}
	
	/*
	 *increment frequency  
	 */
	public void incrementFreq() 
	{
		this.frequency++;
	}
	
	/*
	 * compare Avenger aliases
	 * @param Avenger
	 * @return -1, 0, 1 if this object is less, equal or greater then other
	 */
	@Override
	public int compareTo(Avenger other) 
	{
		return this.heroAlias.compareTo(other.heroAlias);
	}
	
	/*
	 * boolean compare Avengers aliases
	 * @param Avenger
	 * @return true if same alais, false if diff alias
	 */
	public boolean equals(Avenger other) 
	{
		return this.heroAlias.equals(other.heroAlias);
	}
	
	/*
	 * overrides toString to make a phrase
	 * @return String 
	 */
	@Override
	public String toString() 
	{
		return heroAlias + " aka " + heroName + " mentioned " + frequency + " time(s)";
		
	}

}
