import java.util.*;
import java.io.*;


public class GraphTest 
{

   public static void main(String []args)
   {
      DSAGraph graph = new DSAGraph();

      System.out.println("======================");
      System.out.println("DSAGraph testharness");
      System.out.println("======================");

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
      System.out.println("Testing 'addVertex' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

      System.out.println("Inserting 'A' ");
      graph.addVertex("A");

      System.out.println("Inserting 'B' ");
      graph.addVertex("B");

      System.out.println("Inserting 'C' ");
      graph.addVertex("C");

      System.out.println("\nPrint of graph as a list : ");
      graph.displayAsList();
      System.out.println("Checking whether graph contains 'A' 'B' 'C' verticies....");


      if(graph.hasVertex("A") && graph.hasVertex("B") && graph.hasVertex("C"))
      {
         System.out.println("\nTest for addVertex function successful!");
      }else{
         System.out.println("\nTest for addVertex function failed!");

      }

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
      System.out.println("Testing 'addEdge' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
      

      System.out.println("Adding an edge to 'A' and 'B' ");
      graph.addEdge("A", "B");

      System.out.println("\nAdding an edge to 'B' and 'C' ");
      graph.addEdge("B", "C");
     
      System.out.println("\nChecking whether 'A' and 'B' are adjacent .....");
      if(graph.isAdjacent("A", "B"))
      {
         System.out.println("\nTest 1 for addEdge function successful!(A and B are Adjacent)");
      }
      else{
         System.out.println("\nTest 1 for addEdge function Failed!(A and B are not Adjacent)");
      }

      System.out.println("\nChecking whether 'B' and 'C' are adjacent .....");
      if(graph.isAdjacent("B", "C"))
      {
         System.out.println("\nTest 2 for addEdge function successful!(B and C are Adjacent)");
      }
      else{
         System.out.println("\nTest 2 for addEdge function Failed!(B and C are not Adjacent)");
      }
      System.out.println("\nPrint of graph as a list : ");
      graph.displayAsList();

      
      

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("Testing 'getVertexCount' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");


      System.out.println("\nPrint of the linkedList : ");
      graph.displayAsList();

      System.out.println("\nVerticies count according to the getVertexCount function : " + graph.getVertexCount() + " Expected result : 3");
      if(graph.getVertexCount() ==3)
      {
         System.out.println("\nTest for getVertexCount function successful!");
      }
      else{
         System.out.println("\nTest for getVertexCount function Failed!");
      }

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("Testing 'getEdgeCount' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");


      System.out.println("\nPrint of the linkedList : ");
      graph.displayAsList();

      System.out.println("\nVerticies count according to the getVertexCount function : " + graph.getEdgeCount() + " Expected result : 2");
      if(graph.getEdgeCount() ==2)
      {
         System.out.println("\nTest for getEdgeCount function successful!");
      }
      else{
         System.out.println("\nTest for getEdgeCount function Failed!");
      }

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("Testing 'letterTraverse' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

      System.out.println("\nTraversing through minimum path from 'A' to 'C' .........");
      graph.letterTraverse("A", "C");
      System.out.println("\nPrint of the linkedList : ");
      graph.displayAsList();

      System.out.println("\nPath displayed by the letterTraverse method : " +graph.getMinPath()+ " | Expected : A-B-C ");
      
      
      if((graph.getMinPath()).equals("A-B-C"))
      {
         System.out.println("\nTest for letterTraverse function successful!");
      }
      else{
         System.out.println("\nTest for letterTraverse function Failed!");
      }




      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("Testing 'removeEdge' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

      System.out.println("\nRemoving the Edge between 'B' and 'C' .........");
      graph.removeEdge("B", "C");
      System.out.println("\nPrint of the linkedList : ");
      graph.displayAsList();
      
      System.out.println("\nChecking whether 'B' and 'C' are still adjacent ......  (Should be false)");
      if(graph.isAdjacent("B", "C"))
      {
         System.out.println("\nTest for removeEdge function Failed!");
      }
      else{
         System.out.println("\nTest for removeEdge function successful!");
      }

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("Testing 'removeNode' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

      System.out.println("\nRemoving the 'C' node ......");
      graph.removeNode("C");
      System.out.println("\nPrint of the linkedList : ");
      graph.displayAsList();
      
      System.out.println("\nChecking whether 'C' node is removed ...... ");
      if(graph.hasVertex("C"))
      {
         System.out.println("\nTest for removeNode function Failed!");
      }
      else{
         System.out.println("\nTest for removeNode function successful!");
      }

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("Testing 'removeAllVertex' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

      System.out.println("\nRemoving all the nodes ......");
      graph.removeAllVertex();
      System.out.println("\nPrint of the linkedList : ");
      graph.displayAsList();
      
      System.out.println("\nChecking whether 'A', 'B' nodes are removed ...... ");
      if(graph.hasVertex("A") && graph.hasVertex("B"))
      {
         System.out.println("\nTest for removeAllVertex function Failed!");
      }
      else if(!(graph.hasVertex("A") && graph.hasVertex("B")))
      {
         System.out.println("\nTest for removeAllVertex function successful!");
      }



      System.out.println("=================================");
      System.out.println("---End of DSAGraph testharness---");
      System.out.println("=================================");
 
 
      

      



}
}
