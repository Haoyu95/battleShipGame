
import java.util.Scanner;
/**
 * A simple method to print a message to user, then accept a user's input, finally return the input as a 
 * String value.
 * 
 * @author Haoyu Zhang
 * @version 1.0
 */
public class Input
{
    /**
     * print a message to user, then accept a user's input, finally return the input as a 
     * String value.
     * @return The input of the user.
     */
    public String acceptInput(String message)
    {
      Scanner console = new Scanner(System.in);
      System.out.println(message);
      String str = console.nextLine();
      return str;
    }
}