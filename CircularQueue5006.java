package assignment5;
import java.util.*;
/*
Algorithm:
1. call class
2. make an object from initial value entered
3. initilize members
4. continue whenever an object is made
*/
public class CircularQueue5006<E> implements Cloneable
{
  private E[] data;
  private int rear;
  private int front;
  private int manyItems;
  public CircularQueue5006(int initial)
  {
    data=(E[])new Object[initial];
    manyItems=0;rear=-1;front=-1;
  }
 public CircularQueue5006()
  {
      final int FINALCAP=10;
    data=(E[])new Object[FINALCAP];
    manyItems=0;rear=-1;front=-1;
  }
    public int getRear() 
    {
        /*Algorithm:
        1. call method
        2. return rear
        */
        return rear;
    }

    public int getFront() 
    {
        /*Algorithm:
        1. call method
        2. return front
        */
        return front;
    }
  public E getIndexElement(int index)
  {
      /*Algorithm:
        1. call method
        2. return element at index
        */
      return data[index];
  }
  public void ensureCap(int min)
  {
      /*
      Algorithm:
      1. input minimum size for array
      2.read value
      3. make bigger array and copy everything
      4. return resized array
      
      */
    E []biggerArray;
    if(data.length<min)
    {
        biggerArray=(E[])new Object[min];
        System.arraycopy(data, 0, biggerArray, 0, manyItems);
        data=biggerArray;
    }
  }
  public int capacity()
  {
      /*Algorithm:
        1. call method
        2. return length of array
        */
     return data.length;
  }
  public boolean isEmpty()
  {
      /*Algorithm:
        1. call method
        2. return boolean to see if it is empty
        */
      return manyItems==0;
  }
  public void add(E item)
  {
      /*
      algorithm:
      1. input new element
      2. read the element value
      3.check the conditions and add the element
      4. increase the manyItems
      5. element added so repeat 1-4 for whenever method is called
      
      */
      if(manyItems==0)
      {
          data[manyItems]=item;
          rear++;
          front++;
          manyItems++;
      }
      else if(((rear+1)%data.length)==front&&data.length==manyItems)
      {
          ensureCap(manyItems*2+1);
          rear=(rear+1)%data.length;
          data[rear]=item;
          manyItems++;
      }
      else
      {
          rear=(rear+1)%data.length;
          data[rear]=item;
            manyItems++;
      }
  }
  @SuppressWarnings("unchecked")
  public E remove()
  {
      /*
      Algorithm:
      1. locate the front of the queue
      2. answer set equal to first element to rid 
      3. move the front to the next possibility
      4. decrease manyItems
      5. repeat steps 1-4
      */
  E answer=null;
  if(manyItems==0)
      throw new NoSuchElementException();
  else
  {
  answer=data[front];
  front=(front+1)%data.length;
  manyItems--;
  }
  return answer;
  }

    public int getManyItems() 
    {
        /*Algorithm:
        1. call method
        2. return manyItems
        */
        return manyItems;
    }
  public String display()
  {
       /*
    Algorithm:
    1.call the method
    2.loop through each to display method to print everything in order
    3.return the string
    */
    String s="";
    int i=front;
    if(manyItems==0)
    {
        return "Nothing to display";
    }
    while(i!=rear)
    {
      s+=data[i]+" ";  
      i=(i+1)%data.length;
    }
    s+=data[i]+" ";
    return s;
  }
  
}
