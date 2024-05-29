import java.util.*;
import java.io.*;


public class coreClassTest 
{

   public static void main(String []args) throws IOException
   {
      coreClass mainClass = new coreClass();
      DSAGraph graph = new DSAGraph();

      System.out.println("====================");
      System.out.println("keyMeUp tessharness");
      System.out.println("====================");

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("\nTesting 'loadKeyFile' function(best case)");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");


try{
            mainClass.loadKeyFile("testingFile.al", graph);
            System.out.println("\nChecking whether graph is created successfully.............");
            if(graph.hasVertex("1") && graph.hasVertex("2") && graph.hasVertex("3") && graph.hasVertex("4")  )
            {
               

               System.out.println("\nTest 1 for file reading passed!");
            }
            
           
} catch( FileNotFoundException e )
{
    System.out.println( "File not found" );
}

catch( IOException e )
{
   System.out.println( "failed to load file : " + e );
}

System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
System.out.println("Testing 'loadKeyFile' function(File not found)");
System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

System.out.println( "\nTrying to input a file which does not exist in the folder...............");
try{

      mainClass.loadKeyFile("testing.al", graph);
} catch( FileNotFoundException e )
{
System.out.println( "\nFile not found error is handled successfully!\n test 2 passed!" );
}

catch( IOException e )
{
System.out.println( "failed to load file : " + e );
}

System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
System.out.println("Testing 'bubbleSort' function");
System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

int[] id = {5,1,3,6,2};
String[] str = {"aa", "bb", "cc", "dd", "ee"};

mainClass.bubbleSort(id, str);

if((id[0] == 1) && (id[1] == 2) && (id[2] == 3) && (id[3] == 5) && (id[4] == 6))
{
   if((str[0] == "bb") && (str[1] == "ee") && (str[2] == "cc") && (str[3] == "aa") && (str[4] == "dd"))
   {
      System.out.println("\nArray is sorted in ascending order \n test passed successfully!");
   }
}else
{
   System.out.println("\ntest failed!");
}




   
  

}
}
