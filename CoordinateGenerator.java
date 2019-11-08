import java.util.Random;

/**
 * A simple class to generate a ramdon number using the range given by user.
 * 
 * @author Haoyu Zhang
 * @version 1.0
 */
public class CoordinateGenerator
{
    //The minimum value of the number generated.
    private int minimumValue;
    //The maximu vmalue of the number generated.
    private int maximumValue;

    /**
     * Create an object with default constructor.
     */
    public CoordinateGenerator()
    {
        minimumValue = 0;
        maximumValue = 0;
    }
    /**
     * Create an object with given numbers which indicate its range.
     */
    public CoordinateGenerator(int minimumValue,int maximumValue)
    {
        
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
    }
    

   
    /**
     * Set the minimum value.
     * @param minimumValue The minimum value.
     */
    public void setminimumValue(int minimumValue)
    {
      this.minimumValue = minimumValue;
      
    }
    /**
     * Set the maximum value.
     * @param maximumValue The maximum value.
     */
    public void setmaximumValue(int maximumValue)
    {
      this.maximumValue = maximumValue;
      
    }
    /**
     * Get the maximum value.
     * @return maximumValue The maximum value.
     */
    public int getmaxmumValue()
    {
      return maximumValue;
      
    }
    /**
     * Get the minimum value.
     * @return minimumValue The minimum value.
     */
    public int getminimumValue()
    {
      return minimumValue;
      
    }
    /**
     * Get a ramdon number.
     * @return a ramdom number between maximum value and minimum value.
     */
    public int getRandomNumber()
    {
       return minimumValue + (int)(Math.random() *(maximumValue-minimumValue+1));   
        
    }
}