import java.io.*;
import java.util.Scanner;
/**
 * A class to help write some data to a file, or read the data from a file.
 * 
 * @author Haoyu Zhang
 * @version 1.0
 */
public class FileIO
{
    //Declare a filename if it is needed to read data from this file.
    private String fileName;
    
    /**
     * Create a object with default constructor.
     */
    public FileIO()
    {
       fileName = "";
    }
    /**
     * Create a object with non-default constructor.
     * @param fileName The name of the file. 
     */
    public FileIO(String fileName)
    {
       this.fileName = fileName;
    }

    
    /**
     * Read data from a file and store the values in an array then return that array.
     * @param fileName The name of the file which you want read data from.
     * @return An array which contains the settings of game.
     * @throws FileNotFoundException if file is not found.
     */
    public static String[] readFile(String fileName)
    {
        String[] settings = new String[4];
        try
        {  
           FileReader file = new FileReader(fileName);
           try 
           {
            Scanner scan;
            for(scan = new Scanner(file);scan.hasNextLine();)
            {
              String str = scan.nextLine();
              settings = str.split(",");
            }
           }
           finally
           {
            file.close();
           }
        }
        catch (FileNotFoundException e)
        {
         System.out.println(fileName + " not found");
        }
        catch (Exception e)
        {
         System.out.println("Exception" + e);
        }
        return settings;
    }
    
    /**
     * Write the result of the game to a file.
     * @param fileName The name of the file which you want wirte data to.
     * @param winner The winner of the game.
     * @param playerScore The final score of the player.
     * @param computerScore The final score of the computer.
     * @throws FileNotFoundException if file is not found.
     */
    public void WriteFile(String fileName, String winner, int playerScore, int comuputerScore) 
    {
        
        try
        {
            PrintWriter output = new PrintWriter(fileName);
            output.println(winner + " wins. Final Score Player (" + playerScore + ") and Computer (" + comuputerScore + ")");
            output.close();
        }
        catch (FileNotFoundException e)
        {
         System.out.println(fileName + "is not existed." + e);
        }
        catch (Exception e)
        {
         System.out.println("Exception" + e);
        }

    }
}
