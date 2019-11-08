
/**
 * Write a description of class name here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class name
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class name
     */
    public name()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void sampleMethod()
    {
        // put your code here
       
       String[] strs = {"a","b","c"};
       for (String str: strs){
         if(str.equals("a"))
         {
           String s = new String("b") ;
           str = s;
          }
        }
       for (int i = 0; i < 3; i++){
        System.out.println(strs[i]);
       }
    }
}
