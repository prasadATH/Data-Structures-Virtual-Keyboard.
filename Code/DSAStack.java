import java.util.*;
import java.io.*;


public class DSAStack implements Iterable, Serializable 
{
    private DSALinkedList stackList;
  /***********************************************************************************
   *NAME: DSAStack(main constructor of the stack)
   *PURPOSE: Initiates a linked list to to used in operations 
   *IMPORTS: None.    
   *EXPORTS: None.
   ************************************************************************************/ 

     public DSAStack()
     {
        stackList = new DSALinkedList();
     }

 /***********************************************************************************
   *NAME: isEmpty
   *PURPOSE: Checks and returns whether the stack is empty 
   *IMPORTS: None.    
   *EXPORTS: boolean stackList.isEmpty().
   ************************************************************************************/ 
     public boolean isEmpty()
     {
       return stackList.isEmpty();
     }
 /***********************************************************************************
   *NAME: count
   *PURPOSE: Collects all the elements of the stack and return a count
   *IMPORTS: None.    
   *EXPORTS: integer count.
   ************************************************************************************/     
     public int count()
     {
        int count =0;
        for(Object collect :stackList )
        {
            count++;
        }
        return count;
     }

 /***********************************************************************************
   *NAME: push
   *PURPOSE: Adds a new element to the stack.
   *IMPORTS: Object value.    
   *EXPORTS: None.
   ************************************************************************************/

     public void push(Object value)
     {
         stackList.insertFirst(value);
    }
 /***********************************************************************************
   *NAME: pop
   *PURPOSE: Returns and removes the first element.
   *IMPORTS: None.    
   *EXPORTS: Object stackList.removeFirst().
   ************************************************************************************/
     public Object pop()
     {

            return stackList.removeFirst();
     }
 /***********************************************************************************
   *NAME: top
   *PURPOSE: Returns the first element.
   *IMPORTS: None.    
   *EXPORTS: stackList.peekFirst().
   ************************************************************************************/
     public Object top()
     {  
          
        return stackList.peekFirst();

          
     }
 /***********************************************************************************
   *NAME: Iterator
   *PURPOSE: Iterates through the stack elements.
   *IMPORTS: None.    
   *EXPORTS: stackList.iterator();.
   ************************************************************************************/

     public Iterator iterator()
     {  
          
        return stackList.iterator();

     }

 /***********************************************************************************
   *NAME: printStack
   *PURPOSE: Prints all elements of the stack.
   *IMPORTS: None.    
   *EXPORTS: None.
   ************************************************************************************/
     public void printStack()
     {
        int count =0;
        for(Object collect :stackList )
        {
            count++;
            System.out.println("Element "+ (count) +" is :"+ collect);
        }
     }

  

}
