package sidoti.gary.mainpackage;
import java.util.Random;


public class JavaRandomNumber implements RandomGenerator{
	private Random rand;
	
	/**
	 * Constructor for default java random with default seed
	 */
	public JavaRandomNumber(){
		this.rand = new Random();
	}
	
	/**
	 * Constructor for default java random with custom seed
	 * @param seed The seed that will be used
	 */
	public JavaRandomNumber(long seed){
		this.rand = new Random(seed);
	}
	
	@Override
	public int getRandomNum(){
		return rand.nextInt();
	}
	
	public String toString(){
		return "Java Default";
	}

}
