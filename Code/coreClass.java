import java.util.*;
import java.io.*;
import java.io.FileWriter;


public class coreClass 
{
  
     /*******************************************************************
   *NAME: splitWord
   *PURPOSE: Splits the Input String to characters and save the paths 
   *         from each character to the next character of the string
   *         and sort other paths generated.        
   *IMPORTS: String word,  DSAGraph splitGraph, String[] otherPa, int[] cnt, String[] pShortest 
   *EXPORTS: None
   ********************************************************************/
   public static void splitWord(String word,  DSAGraph splitGraph, String[] otherPa, int[] cnt, String[] pShortest )
  {
   // Scanner scan = new Scanner(System.in);
      

       char[] splArry ;
       String[][] pathArry = new String[8][2];
       int count=0;
       String collect = "";
       char [] splitTwo;
       int minCount=0;
       
       char [] splitThree;
       

      splArry = word.toCharArray();


       for(int i=0; i<(splArry.length-1); i++)
       {


            splitGraph.letterTraverse(String.valueOf(splArry[i]), String.valueOf(splArry[i+1]));
              // System.out.println("\nMinimum number of moves to reach from '"+String.valueOf(splArry[i])+ "' to " +String.valueOf(splArry[i+1]) + "' : " + splitGraph.getMin());
              minCount = minCount + splitGraph.getMin();
           //   System.out.println(splitGraph.getMin());

              if(count != (splArry.length-2))
              {
                splitTwo = (splitGraph.getMinPath()).toCharArray();
                splitTwo[(splitTwo.length-1)] = ' ';
                for(int f=0;f<(splitTwo.length-1);f++)
                {
                    collect+= splitTwo[f];
                }
                
              }
              else
              {
                collect+= splitGraph.getMinPath();
               
              }
 
            pathArry= splitGraph.getPaths();

             for(int kk=0;kk<8;kk++)
                {
                    splitThree = (pathArry[kk][1].toCharArray());
              if(count != (splArry.length-2))
              {

                //splitThree = (splitGraph.getMinPath()).toCharArray();
                splitThree[(splitThree.length-1)] = ' ';
                for(int f=0;f<(splitThree.length-1);f++)
                {
                    otherPa [kk]+= splitThree[f];
                }
               
                
              }
              else
              {
                otherPa[kk] += pathArry[kk][1];
                
               
              }
                      
                        cnt[kk] +=Integer.parseInt(pathArry[kk][0]);
                } 

                count++;
             
           //     scan.close();
       }
       bubbleSort(cnt, otherPa);
    
       
                                pShortest[0] = collect;
                                pShortest[1] = String.valueOf(minCount);

                                
              
         }
  /************************************************************************
   *NAME: bubbleSort
   *PURPOSE: Sorts the array of paths containing different number of moves       
   *IMPORTS: int[] moves, String[] paths 
   *EXPORTS: None
   ************************************************************************/

         public static void bubbleSort(int[] moves, String[] paths)
         {
           int temp =0 ;
           String tempPath = "";
       
           for (int pass = 0 ; pass<=((moves.length -1)-1); pass++ )
            {
                    for (int ii=0 ; ii <= ((moves.length -1 - pass)-1) ;ii++ )
                    {
                     if (moves[ii]>moves[ii+1] )
                                {
                                 temp = moves[ii] ;
                                 moves[ii] =  moves[ii+1];
                                 moves[ii+1] =  temp;  
       
                                 tempPath = paths[ii];
                                 paths[ii] =  paths[ii+1];
                                 paths[ii+1] =  tempPath; 
             
       
                                }
                                
                    }
                    
             }
         }

  /***********************************************************************************
   *NAME: writeToFile
   *PURPOSE: Writes the generated paths to a file defined by the user        
   *IMPORTS: int[] Moves, String[] paths, String[] pShortest, String word, String file 
   *EXPORTS: None
   ************************************************************************************/

         public static void writeToFile(int[] Moves, String[] paths, String[] pShortest, String word, String file)
         {
           try 
           {
                FileWriter print = new FileWriter(file, true);
                print.write("\nWord : "+word +"\n");
                print.write("\nPaths arranged in ascending order considering number of moves\n\n");
                print.write("Shortest path : " + pShortest[0]+ " ('"+pShortest[1] +"' moves)\n\n");
                print.write("\nOther paths :\n");
       
                 for(int i=0; i<8; i++)
                                    {
                                       //print.write(paths[i]+ " ('"+Moves[i] +"' moves)\n");
                                       print.append(paths[i]+ " ('"+Moves[i] +"' moves)\n");
                                    }
                                   
                print.close();
                //System.out.println("Possible paths will be available in the text file named 'paths.txt' in the same folder");
           }
       
       catch (IOException e)
           {
               System.out.println("An error occurred in writing to the file 'paths.txt'");
               System.out.println(" The error : " + e);
           }
         }

  /***********************************************************************************
   *NAME: loadFile
   *PURPOSE: Loads the file of strings in silent mode to check paths.         
   *IMPORTS: String fileName, DSAGraph fileGraph , String[] pWords 
   *EXPORTS: None
   ************************************************************************************/
  public static void loadFile( String fileName, DSAGraph fileGraph , String[] pWords) throws IOException
  {
      
   
      String data;
      String[] splitArry ;
      int count=0;
      try
      {
          FileInputStream strm = new FileInputStream( fileName );
          InputStreamReader inpRdr = new InputStreamReader( strm );
          BufferedReader bffr = new BufferedReader( inpRdr );

          while( (data=bffr.readLine()) != null )
          {

            splitArry = data.split(" ");
              // Save lines to linked list
             

              for(int aa=0; aa< splitArry.length; aa++)
              {
                count++;
                //System.out.println(splitArry[aa]);
                //splitWord(splitArry[aa], fileGraph);
                pWords[count] = splitArry[aa];
              }
          }
      
          bffr.close();
          strm.close();
          
      }
      
    
      catch( FileNotFoundException e )
      {
          System.out.println( "File " + fileName +" not found" );
      }
      catch( IOException e )
      {
        System.out.println( "Error! failed to load file  : " + e);
    }

     
    }

  /***********************************************************************************
   *NAME: loadKeyFile
   *PURPOSE: Loads the keyborad file of strings to a graph by creating vertices
   *         and adding edges accordingly.         
   *IMPORTS:  String fileName , DSAGraph loadGraph 
   *EXPORTS: None
   ************************************************************************************/

      public static void loadKeyFile( String fileName , DSAGraph loadGraph) throws IOException
      {
          
          DSALinkedList fileLine = new DSALinkedList();
              // List of lines in file as strings
          String data ="";
          String[] splitArry ;

          FileInputStream strm = new FileInputStream( fileName );
            InputStreamReader inpRdr = new InputStreamReader( strm );
            BufferedReader bffr = new BufferedReader( inpRdr );
   
          try
          {
            
             while( (data=bffr.readLine()) != null )
            {
                  // Save lines to linked list
                  fileLine.insertLast( data );
        
              }
         
  
          // Populatiing graph
          for( Object o : fileLine )
          {
              splitArry = ( (String)o ).split(" ");
                 
  
              // Adding verticies
              for( String labl : splitArry )
              {
                  // Add each vertex in the array that isnt already in the
                  // graph
                  if( !loadGraph.hasVertex( labl ) )
                  {
                    loadGraph.addVertex( labl );
                  }
              }
  
              // Adding edges
            for (int i=1;i<(splitArry.length);i++)
            {
              loadGraph.addEdge(splitArry[0], splitArry[i]);
            }
          
          
         }
              System.out.println("\nKeyboard file read successfully!");
      }
         catch( FileNotFoundException e )
         {
             System.out.println( "File " + fileName +" not found" );
         }

         catch( IOException e )
        {
            System.out.println( "failed to load file : " + e );
        }
        finally {
          try {
            bffr.close();
          }
          catch(IOException ex) {
             System.out.println("Error! " + ex);
          }
      }

        }
 /***********************************************************************************
   *NAME: saveKeyFile
   *PURPOSE: Saves the keyboard with changes done by the user(If any) to a file
   *           mentioned by the user       
   *IMPORTS:  DSAGraph keyGraph, String fileName 
   *EXPORTS: None
   ************************************************************************************/
        public static void saveKeyFile(DSAGraph keyGraph, String fileName)
        {
  
          try{
            FileWriter print = new FileWriter(fileName, true);
          // print.write("\nWord : "+word +"\n");
          String [][] keyBoards = new String [keyGraph.getVertexCount()][10];
          keyBoards = keyGraph.displayKeyboard();
  
          
  
          for(int i=0; i<(keyBoards.length); i++)
         {
             for(int j=0; j<10; j++)
              {
                
  
                print.append(keyBoards[i][j]);
              }
              if(i !=(keyBoards.length-1))
                {
                  print.append("\n");
                }
             // print.append("\n");
  
              
  
            }
  
            print.close();
  
            System.out.println("\nKeyboard links will be available in a file named " + fileName + " in the same folder");
          }catch (IOException e)
          {
              System.out.println("An error occurred in writing to the file 'paths.txt'");
              System.out.println(" The error : " + e);
          }
  
          
  
        }

   
  

}
