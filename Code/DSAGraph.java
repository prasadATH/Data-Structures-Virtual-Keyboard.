import java.util.*;
import java.io.*;
public class DSAGraph
{
   
   
    private class DSAGraphVertex 
    {
        private String label;

        private DSALinkedList links;
 
        private boolean visited;

        private DSAGraphVertex( String inpLabel )
        {
            label = inpLabel;
            links = new DSALinkedList();
            visited = false;
        }

        private String getLabel()
        {
            return label;
        }

        private void setLabel(String inLabel)
        {
           label = inLabel;
        }

        private DSALinkedList getAdjacent()
        {
            return links;
        }

        private boolean getVisited()
        {
            return visited;
        }

        public String toString()
        {
            return label;
        }

        private void addEdge( DSAGraphVertex inpVertex )
        {
            links.insertLast( inpVertex );
        }

        private void setVisited()
        {
            visited = true;
        }

        private void clearVisited()
        {
            visited = false;
        }
     
    }

    private DSALinkedList verticies;
    private int mvCount;
    private DSAStack path;
    private int pathCount;
    private int stackCount;
    private int succesPCount;
    private String pathCollector;
    private int min;
    private String minPath;
  
    private String[][] succesPaths;
  
  /***********************************************************************************
   *NAME: DSAGraph(main constructor of graph)
   *PURPOSE: Initializes the fields to be used in functions and creates new objects 
   *         required in processes         
   *IMPORTS:  None 
   *EXPORTS: None
   ************************************************************************************/
    public DSAGraph()
    {
        verticies = new DSALinkedList();
        path = new DSAStack();
        mvCount =0;
        stackCount=0;
        succesPCount=0;
        pathCollector= "";
        min =0;
        minPath="";
        
        succesPaths = new String[8][2];


    }

    public int getMoveCount()
    {
        return mvCount;

    } 

    public int getMin()
    {
        return min;
    }


    public String[][] getPaths()
    {
        return succesPaths;
    }

    public String getMinPath()
    {
        return minPath;
    }

    public int numberOfPaths() 
    {
        return pathCount;
    }

    
    public void clearVisited()
    {
        for( Object o : verticies )
        {
            // Mark all verticies as not visited
            ( (DSAGraphVertex)o ).clearVisited();
        }
    }

  /***********************************************************************************
   *NAME: addVertex
   *PURPOSE: Adds a new vertex to the graph(to the linked list which contains the vertices)        
   *IMPORTS:   String inpLabel (Input is a label of a vertex) 
   *EXPORTS: None
   ************************************************************************************/
    public void addVertex( String inpLabel )
    {
        if( hasVertex( inpLabel ) )
        {
            System.out.println( "Vertex " + inpLabel + " already exists in graph" );
        }
        else
        {

               verticies.insertLast( new DSAGraphVertex( inpLabel ) );
        }
    }

  /***********************************************************************************
   *NAME: addVertex
   *PURPOSE: Adds a new vertex to the graph(to the linked list which contains the vertices)        
   *IMPORTS: DSAGraphVertex inpVertex  (Input is a object of DSAGraphVertex type)   
   *EXPORTS: None
   ************************************************************************************/
    public void addVertex( DSAGraphVertex inpVertex )
    {
        if(hasVertex(inpVertex.getLabel()))
        {
            System.out.println( "Vertex " + inpVertex.getLabel() + " already exists in graph" );
        }
        else{

              verticies.insertLast( inpVertex );
        }
    }

  /***********************************************************************************
   *NAME: addEdge
   *PURPOSE: Adds a link between two vertices of the graph(to the linked list of the
   *         relevant vertices which contains the Adjacency list of each vertex)        
   *IMPORTS:  String firLabel, String secLabel (inputs are two String labels of vertices)    
   *EXPORTS: None
   ************************************************************************************/
    public void addEdge( String firLabel, String secLabel )
    {
        addEdge( getVertex( firLabel ), getVertex( secLabel ) );
    }

  /***********************************************************************************
   *NAME: addEdge
   *PURPOSE: Adds a link between two vertices of the graph(to the linked list of the
   *         relevant vertices which contains the Adjacency list of each vertex)        
   *IMPORTS:  DSAGraphVertex firVertex, DSAGraphVertex secVertex(inputs are two objects of 
   *          DSAGraphVertex type )    
   *EXPORTS: None
   ************************************************************************************/
    public void addEdge( DSAGraphVertex firVertex, DSAGraphVertex secVertex )
    {
        if( isAdjacent( firVertex.getLabel(), secVertex.getLabel()) )
        {
            System.out.println( "Verticies " + firVertex +" and " + secVertex + " are already connected" );
        }
        
        
        {
                 firVertex.addEdge( secVertex );
                //  secVertex.addEdge( firVertex );
        }
        
    }

     /***********************************************************************************
   *NAME: removeNode
   *PURPOSE: Removes a vertex after removing all the links of it in other vertices      
   *IMPORTS:  String input(Input is a label of a vertex)    
   *EXPORTS: None
   ************************************************************************************/
    public void removeNode(String input)
    {
        
        removeVertex(getVertex(input));

    }

    public void removeAllVertex()
    {
        for( Object o : verticies )
        {
            for(Object vert : ((DSAGraphVertex)o).links)
            {
            // Search through every vertex to find matching label
            
                removeEdge((DSAGraphVertex)o,(DSAGraphVertex)vert);
            }
            removeVertex((DSAGraphVertex)o);
            
        }
    
    }

  /***********************************************************************************
   *NAME: removeVertex
   *PURPOSE: Removes a vertex after removing all the links of it in other vertices      
   *IMPORTS:  DSAGraphVertex inVertex (Input is a object of DSAGraphVertex type)     
   *EXPORTS: None
   ************************************************************************************/
    public void removeVertex( DSAGraphVertex inVertex )
    {
        if( !hasVertex( inVertex.getLabel() ) )
        {
            System.out.println( "Vertex containing label '" + inVertex.label + "' does not exist in graph" );
        }
        else{
                    for( Object o : verticies )
                            {
                                 for(Object vert : ((DSAGraphVertex)o).links)
                                 // Search the graph vertices to find a equal label
                                if((inVertex).equals(vert ))
                               {
                                    // if the relevant vertex is found in a adjacency list, remove the link between them
                                    removeEdge((DSAGraphVertex)o,(DSAGraphVertex)vert);
                
                               }
                            }
                            //after all the links are removed, remove the node
                      verticies.removeNode(inVertex);
           }
    }
    
 /***********************************************************************************
   *NAME: removeEdge
   *PURPOSE: Removes the link between two vertices.      
   *IMPORTS:   String firLabel, String secLabel (Inputs are the two vertices labels)     
   *EXPORTS: None
   ************************************************************************************/
    public void removeEdge( String firLabel, String secLabel )
    {
        removeEdge( getVertex( firLabel ), getVertex( secLabel ) );
    }
 /***********************************************************************************
   *NAME: removeVertex
   *PURPOSE:  Removes the link between two vertices.      
   *IMPORTS:   DSAGraphVertex inVertex1, DSAGraphVertex inVertex2 (Inputs are the two vertices objects)      
   *EXPORTS: None
   ************************************************************************************/
    public void removeEdge( DSAGraphVertex inVertex1, DSAGraphVertex inVertex2 )
    {
        if( !isAdjacent( inVertex1.getLabel(), inVertex2.getLabel() ) )
        {
            System.out.println( "Verticies " + inVertex1.label + " and " + inVertex2.label + " are not adjacent" );
        }
        else{
        
        inVertex1.links.removeNode( inVertex2 );
        }
    }

 /***********************************************************************************
   *NAME: getVertex
   *PURPOSE:  Returns the vertex relevant to the label input.     
   *IMPORTS:   String inpLabe.     
   *EXPORTS: DSAGraphVertex vertex
   ************************************************************************************/
    public DSAGraphVertex getVertex( String inpLabel )
    {
        DSAGraphVertex vertex = null;

        if( !hasVertex( inpLabel ) )
        {
            System.out.println( "Vertex " + inpLabel + " not found" );
        }else{

        for( Object o : verticies )
        {
            // Search through every vertex to find matching label
            if( ( (DSAGraphVertex)o ).getLabel().equals( inpLabel ) )
            {
                vertex = (DSAGraphVertex)o;
            }
        }
    }
        return vertex;
    
    }
 /***********************************************************************************
   *NAME: hasVertex
   *PURPOSE:  Returns the Result after searching whether a certain vertex is present in the graph     
   *IMPORTS:   String inpLabe.     
   *EXPORTS: boolean result
   ************************************************************************************/
    public boolean hasVertex( String inpLabel )
    {
        boolean result = false;

       for( Object o : verticies )
        {
            // Search through every vertex to find matching label
            if( ( (DSAGraphVertex)o ).getLabel().equals( inpLabel ))
            {
                result = true;
            }
        }

        return result;
    }
 /***********************************************************************************
   *NAME: getVertexCount
   *PURPOSE: Returns the Result after Counting amount of vertices in the graph     
   *IMPORTS: None     
   *EXPORTS: integer vCount
   ************************************************************************************/
        public int getVertexCount()
        {
            int vCount = 0;
    
            for( Object o : verticies )
            {
                vCount++;
            }
    
            return vCount;
        }
 /***********************************************************************************
   *NAME: getEdgeCount
   *PURPOSE: Returns the Result after Counting amount of Edges(links) in the graph     
   *IMPORTS: None     
   *EXPORTS: integer eCount
   ************************************************************************************/
        public int getEdgeCount()
        {
            int eCount = 0;
    
            for( Object o : verticies )
            {
                for( Object o2 : ( (DSAGraphVertex)o ).getAdjacent() )
                {
                    // Increment for every element in the adjacency list for
                    // every induvidual vertex
                    eCount++;
                }
            }
    
            // Each edge is represented twice as the graph is undirected, so
            // we divide by 2
    
            return ( eCount / 2 );
        }

 /***********************************************************************************
   *NAME: getAdjacent
   *PURPOSE: Returns the Linked list of the relevant vertex(input) which contains all the
   *          adjacent(linked) vertices.  
   *IMPORTS:  String inLabel      
   *EXPORTS: DSALinkedList values
   ************************************************************************************/
        public DSALinkedList getAdjacent( String inLabel )
        {
            DSALinkedList values = new DSALinkedList();
    
            for( Object o : getVertex( inLabel ).links )
            {
                values.insertLast( ( (DSAGraphVertex)o ).getLabel() );
            }
    
            return values;
        }
  /***********************************************************************************
   *NAME: isAdjacent
   *PURPOSE: Returns the result after checking whether the first input vertex is 
   *          adjacent to the second vertex.  
   *IMPORTS:   String firstLabel, String secLabel      
   *EXPORTS: boolean result
   ************************************************************************************/

        public boolean isAdjacent( String firstLabel, String secLabel )
        {
            boolean result = false;

            DSAGraphVertex firstVertex;
            DSAGraphVertex secondVertex;
    
            firstVertex = getVertex( firstLabel );
            secondVertex = getVertex( secLabel );
    
            for( Object o : ( firstVertex.getAdjacent() ) )
            {
                if( ( (DSAGraphVertex)o ).equals( secondVertex ) )
                {
                    result = true;
                }
            }
    
            return result;
        }

  /***********************************************************************************
   *NAME: letterTraverse
   *PURPOSE: Clears all visited records back to intial state and generate paths from 
   *          First input label to second input label 
   *IMPORTS: String src, String dest (src = Source, dest = destination)     
   *EXPORTS: None.
   ************************************************************************************/

        
        public void letterTraverse(String src, String dest)
        {
            int recCount =0;
            mvCount=0;
            succesPCount=0;
            min=0;
          
            clearVisited();
    
            pathFinder(getVertex(src), getVertex(dest));
             
        }
                       
  /***********************************************************************************
   *NAME: pathFinder
   *PURPOSE: generates paths from first vertex to second vertex 
   *IMPORTS:  DSAGraphVertex v, DSAGraphVertex t (src = Source, dest = destination)     
   *EXPORTS: None.
   ************************************************************************************/
       public void pathFinder( DSAGraphVertex sourceV, DSAGraphVertex destinationV) 
         {
           
    
            // add v to current path
            DSAGraphVertex subVertex;
            path.push(sourceV);
            sourceV.setVisited();
    
            // found path from s to t
            if (sourceV == destinationV) {
                
                stackCount= path.count();
                if(stackCount<10)
                {
                    selectedPath();
                }
                
                pathCount++;
                stackCount=0;
            }
    
            // consider all neighbors that would continue path with repeating a node
            else {
                //System.out.println(path.count());
                if(path.count()<16)
                    {
                for (Object w : sourceV.getAdjacent())
                 {
                    subVertex = (DSAGraphVertex)w;
                    
                    if (!subVertex.getVisited())
                    {
                       
                        pathFinder((DSAGraphVertex) w, destinationV);
                    }
                }
                }
            }
        
    
            // done exploring from v, so remove from path
            path.pop();
            sourceV.clearVisited();
       
    
        }

  /***********************************************************************************
   *NAME: selectedPath
   *PURPOSE: process the successful paths to be arranged and saved in a user friendly manner.   
   *IMPORTS:  None.     
   *EXPORTS: None.
   ************************************************************************************/
       
        // this implementation just prints the path to standard output
        public void selectedPath() 
        {
            mvCount=0;
            DSAStack reverse = new DSAStack();
         
         
            for (Object v : path)
            {
                mvCount++;
                reverse.push(v);
                
            }
          
            pathCollector = String.valueOf(reverse.top());
            reverse.pop();

            while (!reverse.isEmpty())
            {            
                pathCollector += ("->" + String.valueOf(reverse.pop()));
                    
            }
           
            if(min==0)
            {
                  min = (mvCount-1);
             }

           if((mvCount-1)<=min)
           {
            minPath = pathCollector;
            min = (mvCount-1);
            
           }
           

           if((succesPCount<8))
           {
               successPath(pathCollector, (mvCount-1));
              // System.out.println(pathCollector);
               //System.out.println((mvCount-1));
           }
          
           succesPCount++;
         //  System.out.println("proper paths "+m);
        
        
            
        }

       
  /***********************************************************************************
   *NAME: successPath
   *PURPOSE: Save all the successful paths and their moves.
   *IMPORTS:  String path, int moves.     
   *EXPORTS: None.
   ************************************************************************************/
      

        public void successPath(String path, int moves)
           {
             
                        succesPaths[succesPCount][0]= String.valueOf(moves);
                        succesPaths[succesPCount][1]= path;
                
           }

  /***********************************************************************************
   *NAME: displayAsList
   *PURPOSE: Displays all the vertices with the relevant adjacecy list.
   *IMPORTS: None.     
   *EXPORTS: None.
   ************************************************************************************/

        public void displayAsList()
        {
            for( Object o : verticies )
            {
                System.out.print( ((DSAGraphVertex)o).getLabel() + " ______>");

                for( Object o2 : ((DSAGraphVertex)o).getAdjacent() )
                {
                    System.out.print( "  " + ((DSAGraphVertex)o2).getLabel() );

                }
                System.out.println("\n");
            }
        }

  /***********************************************************************************
   *NAME: displayKeyboard
   *PURPOSE: returns the keyboard links as a 2D array to be printed/saved
   *IMPORTS: None.     
   *EXPORTS: None.
   ************************************************************************************/

        public String[][] displayKeyboard()
        {
            String[][] keyboard = new String[getVertexCount()][10];
            int k=0;
            int l=0;

            
        for(int i=0; i<(keyboard.length); i++)
        {
            for(int j=0; j<10; j++)
             {
 
                keyboard[i][j]="";
             }
 
           }
            for( Object o : verticies )
            {
                keyboard[l][0] =  (((DSAGraphVertex)o).getLabel());
                k=0;
                
                
                for( Object o2 : ((DSAGraphVertex)o).getAdjacent() )
                {
                    k++;
                    
                    keyboard[l][k] = ( " " + ((DSAGraphVertex)o2).getLabel() );
                  
                }
                l++;
            
            }

            return keyboard;
        }



 /***********************************************************************************
   *NAME: displayAsList
   *PURPOSE: Displays the graph as a adjacency matrix
   *IMPORTS: None.     
   *EXPORTS: None.
   ************************************************************************************/
        public void displayAsMatrix()
     {
             int vertixNum = getVertexCount();
            // Number of verticies in graph
              DSAGraphVertex[] arr;
            // Array of all verticies in graph
             String[][] graphMatrix;
             String collect="";
            // 2D array of matrix, uses 0's for no adjacency and 1's for
            // adjacency
             int idx = 0;
            // index used to fill arr

              arr = new DSAGraphVertex[ vertixNum ];
              graphMatrix = new String[ vertixNum ][ vertixNum ];

             // Populating vertex array
                   for( Object o : verticies )
                       {
                              arr[idx] = (DSAGraphVertex)o;
                              collect = collect + "----";
                             idx++;
                       }

               // Populating matrix
                  for( int i = 0; i < vertixNum; i++ )
                     {
                          for( int j = 0; j < vertixNum; j++ )
                            {
                                  if( isAdjacent( arr[i].getLabel(), arr[j].getLabel() ) )
                                      {
                                          graphMatrix[i][j] = " 1 |";
                                      }
                                  else
                                      {
                                        graphMatrix[i][j] = " 0 |";
                                      }
                            }
                     }
        
        // Printing
             System.out.print( "     " );
               

                        for( int k = 0; k < arr.length; k++ )
                        {
                            System.out.print( " " +arr[k].getLabel() +" |");

                        }
                        System.out.print("\n "+collect + "----");
        

        for( int i = 0; i < vertixNum; i++ )
        {
        
                System.out.print( "\n| " + arr[i].getLabel() +" |");
               

            
            for( int j = 0; j < vertixNum; j++ )
            {

                System.out.print( graphMatrix[i][j] );
            }
            System.out.println();
            System.out.print(" "+collect+ "----");

        }
        System.out.println();
     }

    

    public Iterator iterator()
    {
        return verticies.iterator();
    }

    
}

    

