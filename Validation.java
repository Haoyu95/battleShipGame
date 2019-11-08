/**
 * The validations which are implemented in the input message of users.
 * 
 * @author Haoyu Zhang
 * @version 1.0
 */
public class Validation
{
    
     
    /**
     * Check if the length of input is between the minimun number and the maximun number.
     * @param s The input String type message.
     * @param Minumun The minumun number to limit the length of input message.
     * @param Maximun The Maximun number to limit the length of input message.
     * @return True if the length is within range.Else return false.
     */
    public boolean stringsLengthWithinRange(String s,int Minimun,int Maximun)
    {
        int length = s.length();
        if( length <= Maximun && length >= Minimun)
        { 
          return true;
        }
        return false;
    }
    /**
     * Check if the value of input is between the minimun number and the maximun number.
     * @param s The input integer type message.
     * @param Minumun The minumun number to limit the value.
     * @param Maximun The Maximun number to limit the value.
     * @return True if the value is within range.Else return false.
     */
    public boolean WithinRange(int i,int Minimun,int Maximun)
    {
        if( i <= Maximun && i >= Minimun)
        { 
          return true;
        }
        return false;
    }
}