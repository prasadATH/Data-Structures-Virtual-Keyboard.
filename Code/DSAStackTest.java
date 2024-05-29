import java.util.*;
import java.io.*;


public class DSAStackTest 
{

   public static void main(String []args)
   {
      DSAStack stack = new DSAStack();

      System.out.println("====================");
      System.out.println("DSAStack tessharness");
      System.out.println("====================");

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("Testing 'push' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=");

      System.out.println("Inserting 'A' ");
      stack.push("A");

      System.out.println("Inserting 'B' ");
      stack.push("B");

      System.out.println("Inserting 'C' ");
      stack.push("C");

      System.out.println("\nPrint of stack : ");
      stack.printStack();

      System.out.println("\nExpected result : \nElement 1 is :C\nElement 2 is :B\nElement 3 is :A");


      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("\nTesting 'count' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=");

      System.out.println("\ncount : "+stack.count() +"  Expected result : 3");
      if(stack.count() ==3)
      {
         System.out.println("\nTest for count function successful!");
      }else{
         System.out.println("Test for count function failed!");

      }

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("Testing 'top' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=");

      System.out.println("\ncount : "+stack.top() +"  Expected result : C");
      if((stack.top()).equals("C"))
      {
         System.out.println("\nTest for top function successful!");
      }else{
         System.out.println("Test for top function failed!");

      }
      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println("Testing 'pop' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=");

      System.out.println("\ncount : "+stack.pop() +"  Expected result : C");
      if(stack.top().equals("B"))
      {
         System.out.println("\nTest 1 for pop function successful!");
      }else{
         System.out.println("Test 1 for pop function failed!");

      }

      System.out.println("popped value : "+stack.pop() +"  Expected result : B");
      if(stack.top().equals("A"))
      {
         System.out.println("\nTest 1 for pop function successful!");
      }else{
         System.out.println("Test 1 for pop function failed!");

      }

      System.out.println("popped value : "+stack.pop() +"  Expected result : A");
     

      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+");
      System.out.println("Testing 'isEmpty' function");
      System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+");

      System.out.println("\npopped value : "+stack.isEmpty() +"  Expected result : true");

      if(stack.isEmpty()== true)
      {
         System.out.println("\nTest for isEmpty function successful!");
      }else{
         System.out.println("Test for isEmpty function failed!");

      }


      



  

}
}
