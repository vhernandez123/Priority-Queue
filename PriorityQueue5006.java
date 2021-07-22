
package assignment5;
import java.util.*;
/*
public class PriorityQueue5006 <E> implements Cloneable
part of the assignment5 Package
this will take a ranking for our queue that way we will know which priorities we will be working with
Algorithm;
1. input a ranking
    1a if a ranking is not entered then 10 will be entered
2. read ranking
3. initilize the qu array with a size of the highest plus one
4. repeat steps 1-3
*/
public class PriorityQueue5006 <E> implements Cloneable
{
private CircularQueue5006<E>[] qu;//this will be separated by rankings and the contents inside every ranking
private int highest;//this will be the highest ranking the can exsist basically the number of elements in the queue
final int STARTER_SIZE=10;//if the user doesnt enter in any starter size then the default will be 10 elements
private int called=0;//this variable will assist the operations in the remove method
public PriorityQueue5006(int highest)
{
    if(highest<=0)
        throw new IllegalArgumentException("you cannot make your priorite less than or equal to zero or else theres no point to this");
    this.highest=highest;
    qu=new CircularQueue5006[highest+1];
}
public void addP(E element,int rank)
{
    /*
    Algorithm:
    1. input in the element to be addded and the ranking that element belongs to
    2. read the element and rank
    3. if the ranking is not valid then throw an error
    3a else we will add the desired element into the appropriate rank
    4. repeat steps 1-3
    */
    if(rank>highest+1)
        throw new IllegalArgumentException("You are not entering a valid ranking");
    else if(qu[rank]==null)
    {
      CircularQueue5006<E> new1=new CircularQueue5006(STARTER_SIZE);
      new1.add(element);
      qu[rank]=new1;
    }
    else if(qu[rank]!=null)
    {
        qu[rank].add(element);
    }
}
public int getHighest() 
{
    /*
    Algorithm:
    1. call the method
    2. return the highest rank
    */
        return highest;
    }

public E removePQ()
{
    /*
    Algorithm:
    1. access the array at the highest rank
    2. check the conditions. There is conditions that will check if a ranking is null to follow through to the next
    3. used the remove method from the circularQueue class in order to properly remove the elements from the queue 
    4. store the removed element into the answer variable
    5. return the answer variable
    */
    int c=highest;
  E answer=null;
    if(qu[c].isEmpty()!=true)
    {
        int x=qu[c].getManyItems();
        if(x==1)
        {
           answer=qu[c].remove();
            called++;
        }
        else if(x==0){System.out.println("no more items to get rid of here");}
        else if(x!=0)
           answer=qu[c].remove();
    }
    else if(qu[c].isEmpty()==true)
    {
        c=c-called;
        if(c==-1)
           throw new NoSuchElementException();
               
        int x=qu[c].getManyItems();
        if(x==1)
        {
        answer= qu[c].remove();
            called++;
        }
        else if(x==0){System.out.println("no more items to get rid of here");}
        else if(x!=0)
        answer= qu[c].remove();
    }
return answer;
}
public int getCapacity()
{
    /*
    Algorithm:
    1. call method
    2. return highest ranking
    */
    return highest;
}
@SuppressWarnings("unchecked")
public PriorityQueue5006<E> clone()
{
    /*
    Algorithm:
    1. call the method
    2. call the .clone method from the object class and cast it
    3. make sure to clone the array properly to account for the array being an object
    4. return cloned object
    */
  PriorityQueue5006<E> ans;
try
{
    ans=(PriorityQueue5006<E>)super.clone();
} 
catch(CloneNotSupportedException e)
{
    throw new RuntimeException("This class does not implement the cloneable class");
}
ans.qu=qu.clone();
return ans;
}
public String displayPQ()
{
    /*
    Algorithm:
    1.call the method
    2.loop through each ranking of the queue and use the circularqueue display method to print everything in order
    3.return the string
    */
    String s="";
    for(int i=0;i<highest+1;i++)
    {
      if(qu[i]==null||qu[i].display().equals("Nothing to display"))  
        s+=" Rank "+i+": Nothing for you to display ";
    else
        s+=" Rank: "+i+" "+" Elements: "+qu[i].display();
    }
return s;
}

}
