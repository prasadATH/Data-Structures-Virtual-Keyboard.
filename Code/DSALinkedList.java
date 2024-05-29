import java.util.*;
import java.io.*;
import java.io.FileWriter;

public class DSALinkedList  implements Iterable, Serializable 
{
     private class DSAListNode implements Serializable 
   {
     private Object value;
     private DSAListNode next;
     private DSAListNode prev;



     public DSAListNode(Object inValue)

     {
          value = inValue;
          next =null;
          prev =null;
     }

     public Object getValue()
     {
          return value;
     }

     
     public void setValue(Object inValue)
     {
           value = inValue;
     }

     public DSAListNode getNext()
     {
          return next;
     }

     
     public void setNext(DSAListNode newNext)
     {
           next = newNext;
     }

     public DSAListNode getPrev()
     {
          return prev;
     }

     
     public void setPrev(DSAListNode newPrev)
     {
          prev = newPrev;
     }



}

public  Iterator iterator() 
    { 
    return new ListIterator(this); 
    } 
    private class ListIterator implements Iterator
     {
           private DSAListNode iterNext;
              public ListIterator(DSALinkedList theList) 
    { 
         iterNext = theList.head;
    }

    // Iterator interface implementation
           public boolean hasNext() 
           { 
            return (iterNext != null) ;
           }

    public Object next() 
    { 
             Object value; 
            if (iterNext == null) 
            {
                     value = null; 
            }
            else
             { 
              value = iterNext.getValue(); 
                  iterNext = iterNext.getNext();
             } 
          return value; 
    } 
    } 
    private DSAListNode head;
    private DSAListNode tail;

  /***********************************************************************************
   *NAME: DSALinkedList(main constructor)
   *PURPOSE: Initiates the linked list with a head and tail
   *IMPORTS: None.     
   *EXPORTS: None.
   ************************************************************************************/

     public DSALinkedList()
     {
           head = null;
           tail =null;
     }

  /***********************************************************************************
   *NAME: isEmpty
   *PURPOSE: Checks whether the list is empty.
   *IMPORTS: None.     
   *EXPORTS: None.
   ************************************************************************************/
     public boolean isEmpty()
     {
         boolean empty = false;
 
         if(head==null)
         {
          empty=true;
         }
      
 
         return empty;
     }

  /***********************************************************************************
   *NAME: peekFirst
   *PURPOSE: returns a value of the first node in the list.
   *IMPORTS: None.     
   *EXPORTS: Object nodeVal.
   ************************************************************************************/

     public Object peekFirst()
     { 
          Object nodeVal =null;
          if(isEmpty())
          {
               throw new IllegalArgumentException( "List is empty" );
          }
          else
          {
               nodeVal = head.getValue();
          }
          return nodeVal;
     }

  /***********************************************************************************
   *NAME: peekLast
   *PURPOSE: returns a value of the last node in the list.
   *IMPORTS: None.     
   *EXPORTS: Object nodeVal.
   ************************************************************************************/    

     public Object peekLast()
     { 
          Object nodeVal = null;
          if(isEmpty())
          {
               throw new IllegalArgumentException( "List is empty" );
          }
          else
          {
               nodeVal = tail.getValue();
          }
          return nodeVal;
     }

  /***********************************************************************************
   *NAME: insertFirst
   *PURPOSE: Inserts a new node as the first node to the list .
   *IMPORTS: Object newValue.     
   *EXPORTS: None
   ************************************************************************************/


     public void insertFirst(Object newValue)
     {
          DSAListNode newNode = new DSAListNode(newValue);

          if (isEmpty())
          {
               head  = newNode;
               tail = newNode;

          }
          else
          {
               newNode.setNext(head);
               head.setPrev(newNode);
              
               head = newNode;
          }

     }

   /***********************************************************************************
   *NAME: insertLast
   *PURPOSE: Inserts a new node as the last node to the list .
   *IMPORTS: Object newValue.     
   *EXPORTS: None
   ************************************************************************************/    

     public void insertLast(Object newValue)
     {
          DSAListNode newNode = new DSAListNode(newValue);

          if (isEmpty())
          {
               head  = newNode;
               tail = newNode;
          }
          else
          {
               tail.setNext(newNode);
               newNode.setPrev(tail);
               tail = newNode;
          }

     }
   /***********************************************************************************
   *NAME: removeFirst
   *PURPOSE: Removes and returns the first node of the list .
   *IMPORTS: None.    
   *EXPORTS: Object nodeVal
   ************************************************************************************/     

     public Object removeFirst()
     {
          Object nodeVal ="";

          if(isEmpty())
          {
               System.out.println( "List is empty" );
                   

          }
          else if(head.getNext() ==null)
          {
               nodeVal =head.getValue(); 
               head = null;
               tail  =null;

          }
          else
          {
          
             nodeVal = head.getValue();
             head = head.getNext();

               
          }
          return nodeVal;
   
     }
   /***********************************************************************************
   *NAME: RemoveLast
   *PURPOSE: Removes and returns the last node of the list .
   *IMPORTS: None.    
   *EXPORTS: Object nodeVal
   ************************************************************************************/       

     public Object RemoveLast()
     {
          Object nodeVal = null;

          if (isEmpty())
          {
               throw new IllegalArgumentException( "List is empty" );


          }
          else if(tail.getPrev() ==null)
          {
               nodeVal =tail.getValue(); 

              tail =null;
              head = null;
          }
          else
          {
               nodeVal =tail.getValue(); 
               tail.getPrev().setNext( null );
               tail = tail.getPrev();
          }
        return nodeVal; 
     }

 /***********************************************************************************
   *NAME: removeNode
   *PURPOSE: Removes the input(specified) node of the list .
   *IMPORTS: Object inValue .    
   *EXPORTS: None.
   ************************************************************************************/   

     public void removeNode( Object inValue )
     {
         DSAListNode currentNode;
         DSAListNode prevNode;
         DSAListNode nextNode;
         
        
         if( isEmpty() )
         {
             System.out.println( "Error! List does not contain any values" );
         }
         else
         {
          currentNode = head;
             while( currentNode != null )
             {
               //Searched node is found
                 if( currentNode.value.equals( inValue ) )
                 {
                     
                     prevNode = currentNode.prev;
                     nextNode = currentNode.next;

                     if( currentNode == head || currentNode == tail )
                     {
                         
                         // Multi-element list but removing head or tail
                         if( currentNode == head )
                         {
                            removeFirst();
                         }
                         if( currentNode == tail )
                         {
                            RemoveLast();

                         }
                     }
 
                     
                     //if the seached node is the head or tail of the list
                     else if( prevNode == null && nextNode == null )
                     {
                         // 1-element list
                         head = null;
                         tail = null;
                     }
                     else
                     {
                         
                         // Node to remove is not the head or the tail
                         prevNode.next = nextNode;
                         nextNode.prev = prevNode;
                     }
 
                     currentNode = null;
                    
                 }
                 else
                 {
                    //
                    currentNode = currentNode.next;
                 }
             }
         }
 
       
     }
 /***********************************************************************************
   *NAME: printList
   *PURPOSE: Prints the list .
   *IMPORTS: None.    
   *EXPORTS: None.
   ************************************************************************************/
     public void printList()
     {
        int count =0;
        for(Object collect :this )
        {
            count++;
            System.out.println("Element "+ (count) +" is :"+ collect);
        }
     }


     

}
