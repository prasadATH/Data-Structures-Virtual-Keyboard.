import java.util.*;
import java.io.*;


public class linkedListTest 
{

   public static void main(String []args)
   {
      DSALinkedList list = new DSALinkedList();

      System.out.println("=========================");
      System.out.println("DSALinkedList testharness");
      System.out.println("=========================");

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
      System.out.println("Testing 'insertFirst' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

      System.out.println("Inserting 'A' ");
      list.insertFirst("A");

      System.out.println("Inserting 'B' ");
      list.insertFirst("B");

      System.out.println("Inserting 'C' ");
      list.insertFirst("C");

      System.out.println("\nPrint of linkedList : ");
      list.printList();

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("Testing 'insertLast' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

      System.out.println("Inserting '1' ");
      list.insertLast("1");

      System.out.println("Inserting '2' ");
      list.insertLast("2");


      System.out.println("\nPrint of the linkedList : ");
      list.printList();
 
      System.out.println("\nExpected result : \nElement 1 is :C\nElement 2 is :B\nElement 3 is :A\nElement 4 is :1\nElement 5 is :2");


      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+");
      System.out.println("Testing 'peekFirst' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

      System.out.println("\nFirst Element: "+list.peekFirst() +"  Expected result : C");
      
      if(list.peekFirst().equals("C"))
      {
         System.out.println("\nTest for peekFirst function successful!");
      }else{
         System.out.println("Test for peekFirst function failed!");

      }

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+");
      System.out.println("Testing 'peekLast' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

      System.out.println("\nLast Element : "+list.peekLast() +"  Expected result : C");
      System.out.println("\nPrint of the linkedList : ");
      list.printList();
      if(list.peekLast().equals("2"))
      {
         System.out.println("\nTest for peekLast function successful!");
      }else{
         System.out.println("Test for peekLast function failed!");

      }

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("Testing 'removeNode' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

      System.out.println("\nRemoving 'C' node......");
      list.removeNode("C");
      System.out.println("\nPrint of the linkedList : ");
      list.printList();
      if((list.peekFirst()).equals("C"))
      {
         System.out.println("\nTest for removeNode function failed!");
      }else if((list.peekFirst()).equals("B")){
         System.out.println("Test for removeNode function Successful!");

      }


      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
      System.out.println("Testing 'removeFirst' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");

      System.out.println("\nRemoving first node......");
      list.removeFirst();
      System.out.println("\nPrint of the linkedList : ");
      list.printList();
      if((list.peekFirst()).equals("B"))
      {
         System.out.println("\nTest for removeFirst function failed!");
      }else if((list.peekFirst()).equals("A")){
         System.out.println("\nTest for removeFirst function Successful!");

      }

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("Testing 'RemoveLast' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");

      System.out.println("\nRemoving last node......");
      list.RemoveLast();
      System.out.println("\nPrint of the linkedList : ");
      list.printList();
      if((list.peekLast()).equals("2"))
      {
         System.out.println("\nTest for RemoveLast function failed!");
      }else if((list.peekLast()).equals("1")){
         System.out.println("\nTest for RemoveLast function Successful!");

      }



}
}
