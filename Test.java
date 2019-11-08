
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    public Test()
    {
        int[] numbers;
        numbers = new int[5];
    }

    /**
     * An example of a method  replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int method(String s){

        if(s.length() == 0){
            return 0;  
        }
        String[] strs = s.split(" ");
        int i = strs[strs.length -1].length();
        return i;

    }
}

