import java.util.*;


import java.io.*;
import java.io.FileWriter;


public class keyMeUp
{
  /*******************************************************************
   *NAME: main
   *PURPOSE: controls the main functions of the program by displaying 
   *          a interactive menu
   *IMPORTS: Command line arguments
   *EXPORTS: None
   *Assertions:
   ********************************************************************/
    public static void main(String[] args) throws IOException
    {

        
        Scanner sc = new Scanner(System.in);
        int userInp =0;
        String firstlabel ="";
        String seclabel ="";
        String[] words =new String[15];
    
        String fileN = "";
        DSAGraph graph = new DSAGraph();
        int count=0;
        int nodeInp=0;
        int edgeInp=0;
        String[] otherPaths = {"","","","","","","","",""};
       int[] moveCount = new int[8];
       String userCom="";
       String userWord="";
       String[] shortest = new String[2];
       

        if(args.length == 0)
       {
         System.out.println("\nInvalid Number of Command line Argumants!\nplease enter '-i' for interactive mode or '-s <keyFile> <stringFile> <pathFile>' for Silent mode ");
     
       }
       else if(((args[0]).equals("-i")) )
        {
        
 while(userInp !=14)
    {
        
      

        System.out.println("\n<1> Load keyboard file ");
        System.out.println("<2> Node operations (find, insert, delete, update)");
		    System.out.println("<3> Edge operations (find, add, remove, update)");
        System.out.println("<4> Display the Graph");
	    	System.out.println("<5> Display graph information");
	    	System.out.println("<6> Enter string for finding path");
        System.out.println("<7> Generate paths");
        System.out.println("<8> Display path(s)(Ascending)");
        System.out.println("<9> Save keyboard");

	    	System.out.println("<10> Exit");

        System.out.print("\nEnter the required function : ");
      
        userInp = sc.nextInt();

  switch(userInp)
		{
			    case 1:

                 System.out.print("\nEnter the name of file to be imported : ");
                 fileN = sc.next();
                 try
                 {

                  coreClass.loadKeyFile(fileN, graph);
                 }catch( FileNotFoundException e )
                 {
                     System.out.println( "\nFile " + fileN +" not found" );
                 }
        
                 catch( IOException e )
                {
                    System.out.println( "\nFailed to load file : " + e );
                }
                
                    
				break;

		        case 2:
            nodeInp=0;
                
               while(nodeInp!=5)
                   {

                    System.out.println("\n<1> Search for a node(Vertex)");
                    System.out.println("<2> Insert a node(Vertex) ");
                    System.out.println("<3> Delete/Remove a node(Vertex)");
                    System.out.println("<4> Update a node(Vertex)");
                    System.out.println("<5> Return to main menu");


                    System.out.print("\nEnter the required (Vertex)function : ");
                    nodeInp = sc.nextInt();

                    switch(nodeInp)
                    {
                        case 1:

                                 System.out.print("\nEnter vertex label to search : ");
                                 firstlabel = sc.next();
      
                                   if(graph.hasVertex(firstlabel))
                                        {
                                               System.out.println("\nVertex '"+ firstlabel +"' found!");
                                        }else
                                               {
                                                     System.out.println("\nVertex not found! Please check your value");     
                                               }

                        break;

                        case 2:
  
                               System.out.print("\nEnter a label for the vertex : ");
                               firstlabel = sc.next();
          
          
          
                                 System.out.println( "\nAttempting to search label "+ firstlabel +" now......\n" );
                                    while( graph.hasVertex(firstlabel))
                                        {
                                             System.out.println(" vertices cannot contain duplicates! please enter another label value!\n");
                                             System.out.println("\nEnter a label for the vertex : ");
                                             firstlabel = sc.next();
                                        }
          
                                   System.out.println( "\nNo duplicates detected....\n" );
                             
                                   graph.addVertex(firstlabel);
                         
                                  System.out.println("\nVertex "+firstlabel+" Insertion successfull! ");
                                  

                            

                        break;

                        case 3:

                                     System.out.print("\nEnter label of vertex to be removed : ");
                                     firstlabel = sc.next();
                                      System.out.print("\nSearching for vertex............");
      
                                  
                                     if(!graph.hasVertex(firstlabel))
                                          {
                                               System.out.println( "List does not contain value '"+ firstlabel + "'");
                                          }else
                                          {
                                          graph.removeNode(firstlabel);
                                            System.out.print("\nVertex removed successfully!\n");
                                          }

                             break;

                             case 4:

                                    

                              break;
                                        }
                                      }
                        
              
				break;

                case 3:
                edgeInp=0;
                 while(edgeInp!=5)
                     {

                           System.out.println("\n<1> Search for an Edge");
                           System.out.println("<2> Insert a Edge");
                           System.out.println("<3> Delete/Remove an Edge");
                           System.out.println("<4> Update an Edge");
                           System.out.println("<5> Return to main menu");
                
                           System.out.print("\nEnter the required (Edge)function : ");
                           edgeInp = sc.nextInt();

                    switch(edgeInp)
                    {
                      case 1:
                            System.out.print("\nEnter first label for the Edge : ");
                            firstlabel = sc.next();

                            System.out.print("\nEnter Second label for the Edge : ");
                            seclabel = sc.next();

                            if( graph.isAdjacent(firstlabel, seclabel))
                            {
                              System.out.print("\nEdge between vertex '" + firstlabel + "' and vertex '" + seclabel+ "exists");
                            }else{
                              System.out.print("\nEdge between vertex '" + firstlabel + "' and vertex '" + seclabel+ " do not exist");
                            }
                                 


                      break;

                      case 2:

                            System.out.print("\nEnter first label for the Edge : ");
                            firstlabel = sc.next();

                            System.out.print("\nEnter Second label for the Edge : ");
                            seclabel = sc.next();

               
                            graph.addEdge(firstlabel, seclabel);
                        
           
                            System.out.println("\nEdge added successful! ");
                            


                      break;

                      case 3:
                            System.out.print("\nEnter first label for the Edge : ");
                            firstlabel = sc.next();

                            System.out.print("\nEnter Second label for the Edge : ");
                            seclabel = sc.next();

                            System.out.print("\nSearching for first vertex............");

                           
                            if(!graph.hasVertex(firstlabel))
                                          {
                                               System.out.println( "List does not contain the vertex "+ firstlabel);
                                          

                            System.out.print("\nSearching for Second vertex............");

                             if(!graph.hasVertex(seclabel))
                                          {
                                               System.out.println( "List does not contain the vertex " + seclabel);
                                          }
                                        }else{


                                          graph.removeEdge(graph.getVertex(firstlabel), graph.getVertex(seclabel));
                                            System.out.print("\nEdge removed successfully!");
                                        }

                      break;


                      case 4:


                      break;
                    }
                  }


				break;
                 
		        case 4:

                        System.out.println("\nGraph in List view : ");
                        graph.displayAsList();

                        System.out.println();

                         System.out.println("\nGraph in Matrix view : ");
                         graph.displayAsMatrix();
                         System.out.println();

                        System.out.println("\nNumber of vertices : " + graph.getVertexCount());
                        System.out.println("\nGraph: \n");
                        graph.displayAsList();


				break;

                case 5:

                System.out.println("\nNumber of vertices : " + graph.getVertexCount());
                System.out.println("\n\nNumber of edges : " + graph.getEdgeCount());

                        System.out.println("\nGraph in List view : ");
                        graph.displayAsList();

                        System.out.println();

                         System.out.println("\nGraph in Matrix view : ");
                         graph.displayAsMatrix();
                         System.out.println();
				break;

			    case 6:

                    System.out.print("\nEnter word to see number of moves : ");
                    userWord = sc.next();
                    
                    
  
                break;

                case 7:

                          for(int p=0; p<8; p++)
                                     {
                                           otherPaths[p] = "";
                                           moveCount[p] =0;

                                     }

                        System.out.println("\nGenerating paths.........");
                            
                        coreClass.splitWord(userWord, graph, otherPaths, moveCount, shortest);
                                 

                  System.out.println("Paths generated successfully!");
                  //sc.nextLine();
                        
                break;

                case 8:
               

                System.out.println("Word : " + userWord);
                
                  System.out.println("\nShortest path : " + shortest[0] + "(Moves : " +shortest[1]+ ")");
                  System.out.println("\nOther paths : " );

                for (int v=0;v<8; v++)
                {
                  

                  System.out.println(otherPaths[v]+ " ('"+moveCount[v] +"' moves)\n");
                
                }

                System.out.println("\nSave paths ? \n (if you need to save paths insert 'y' else 'n'){y= yes, n=no}");
                
                userCom = sc.next();

               
              if(userCom.equals("y"))
              {
                System.out.println("\nPlease provide a name to save the paths");
               fileN = sc.next();

               coreClass.writeToFile(moveCount, otherPaths, shortest,userWord, fileN);
                  System.out.println("Paths Saved successfully!");
                
              }
                

                break;

                case 9:

               // writeToFile(graph);
               System.out.println("\nPlease provide a name to save the keyboard file");
               fileN = sc.next();


               coreClass.saveKeyFile(graph, fileN);

               

                
                break;


		}
        count++;
      //  sc.close();
    }

  }else if(((args[0]).equals("-s") && args.length==4))
  {
    System.out.println("\nLoading file content.........");

    try
    {
      coreClass.loadKeyFile(args[1], graph);
    }

  catch(IOException e){
           System.out.println("Error file read unsuccesful");
    }

    coreClass.loadFile(args[2],graph, words);

    

    System.out.println("\nGenerating paths.........");
    System.out.println("\nPrinting to file 'paths.txt'.........");
    for (int v=1;v<9; v++)
    {
      coreClass.splitWord(words[v], graph, otherPaths, moveCount, shortest);

     /// System.out.println(words[v]);
     coreClass.writeToFile(moveCount, otherPaths, shortest,words[v],args[3]);
            for(int p=0; p<8; p++)
               {
                 otherPaths[p] = "";
                 moveCount[p] =0;

              }
          
    }
      System.out.println("\nPossible paths will be available in the text file named 'paths.txt' in the same folder");
    
  
  }else
  {
    System.out.println("\nInvalid Number of Command line Argumants!");
    System.out.println("please enter '-i' for interactive mode or '-s <keyFile> <stringFile> <pathFile>' for Silent mode \n");
  }
}
   
  


       
  
}





