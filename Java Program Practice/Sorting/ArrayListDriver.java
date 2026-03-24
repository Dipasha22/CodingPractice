import java.util.ArrayList;
import java.util.Arrays;


class ArrayListDriver
{
	public static void main(String[] args) {
		UserArrayList<Integer> list1=new UserArrayList<Integer>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		list1.add(50);
		list1.add(60);
		System.out.println(list1);
		//Add First and last
		list1.addFirst(5);
		list1.addLast(50);
		System.out.println("After addFirst and addlast: "+list1);
		//get Methods
		System.out.println("First: "+list1.getFirst());
		System.out.println("Last: "+list1.getLast());
		System.out.println("Index 3: "+list1.get(3));
		//Set
		list1.set(2,222);
		System.out.println("After set: "+list1);

		//Indexof and LastIndexof
		System.out.println("Index of 222 "+ list1.indexOf(222));
		System.out.println("Last Index of: "+list1.lastIndexOf(40));

		//contains
		System.out.println("contains 60: "+list1.contains(60));

		//Add at index
		list1.add(3,777);
		System.out.println("after add: "+list1);

		//Remove operations
		list1.removeFirst();
		System.out.println("After removeFirst: "+list1);

		list1.removeLast();
		System.out.println("After removeLast: "+list1);

		list1.remove(5);
		System.out.println("After remove at index 5: "+list1);

		//capacity
		//System.out.println("Capacity: "+list1.capacity());

		list1.ensureCapacity(20);
		System.out.println("After ensure Capacity: "+list1.capacity());

		//toArray
		Object[] arr=list1.toArray();
		System.out.println("Array: ");
		for(Object obj: arr)
		{
			System.out.print(obj+" ");
		}
		

		//Size 
		System.out.println("Size: "+list1.size());

		//AddAll
		System.out.println("_________________________________________________");
		UserArrayList<Integer> list2=new UserArrayList<>();
		System.out.println(list2);
		list2.add(10);
		list2.add(20);
		
		list1.addAll(list2);
		System.out.println("After Add all: "+list1);

		//RemoveAll
		list1.removeAll(list2);
		System.out.println("After removeAll: "+list1);

	}
}
class UserIndexOutOfBoundsException extends RuntimeException
{
	UserIndexOutOfBoundsException(String desc)
	{
		super(desc);
	}
}
class UserNoSuchElementException extends RuntimeException
{
	UserNoSuchElementException(String desc)
	{
		super(desc);
	}
}
@SuppressWarnings("unchecked")
class UserArrayList<E> implements Cloneable
{
	private final int INITIAL_CAPACITY=10;
	private E [] arr;
	private int indx;

	public UserArrayList()
	{
		arr=(E[])new Object[INITIAL_CAPACITY];
	}
	@Override
	public String toString()
	{
		if(indx==0) return "[]";

		String rep="[";
		for(int i=0;i<size()-1;i++)
		{
			rep+=arr[i]+",";
		}
		return rep+=arr[indx-1]+"]";
	}
	public boolean add(E ele)
	{
		if(arr.length==size())
		{
			E[] newArr= (E[])new Object[newCapacity(arr.length)];
			for(int i=0;i<arr.length;i++)
			{
				newArr[i]=arr[i];
			}
			this.arr=newArr;
		}
		arr[indx++]=ele;
		return true;
	}

	private int newCapacity(int oldCap)
	{
		return (int) (oldCap*1.5);
	}
	public int size()
	{
		return indx;
	}
	public int capacity()
	{
		return this.arr.length;
	}
	public void addLast(E ele)
	{
		add(ele);
	}
	public void addFirst(E ele)
	{
		if(this.arr.length==size())
		{
			E[] newArr=(E []) new Object[newCapacity(arr.length)];
			for(int i=0;i<arr.length;i++)
			{
				newArr[i]=arr[i];
			}
			this.arr=newArr;

		}
		for(int i=indx;i>=1;i--)
		{
			arr[i]=arr[i-1];
		}
		arr[0]=ele;
		indx++;
	}
	public boolean isEmpty()
	{
		return size()==0;
	}
	public void ensureCapacity(int newCap)
	{
		if(newCap<=capacity()) return;
		E[] newArr=(E[])new Object[newCap];
		for(int i=0;i<arr.length;i++)
			{
				newArr[i]=arr[i];
			}
			this.arr=newArr;
	}
	public void trimToSize()
	{
		if(size()==capacity()) return;
		E[] newArr=(E[])new Object[size()];

		for(int i=0;i<arr.length;i++)
			{
				newArr[i]=arr[i];
			}
			this.arr=newArr;
	}

	public int indexOf(Object obj) 
	{
		E ele=(E) obj;
	 if (size()==0 || !contains(obj))
	  {
            return -1;
       }
    for (int i = 0; i < this.size(); i++) {
       
        if (arr[i].equals(ele)) {
            return i;
        }
    }
    return -1; 
}


public int lastIndexOf(Object obj) {
	E ele=(E) obj;
	 if (size()==0 || !contains(obj))
	  {
            return -1;
       }
       for (int i = indx - 1; i >= 0; i--)  {
       
        if (arr[i].equals(ele)) {
            return i;
        }
    }
    return -1; 
 
}
	@Override
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	public Object[] toArray() {
    Object[] newArr = new Object[this.size()];
    for (int i = 0; i < this.size(); i++) {
        newArr[i] = arr[i];
    }
    return newArr;
}
public boolean contains(Object ele) {
    for (int i = 0; i < indx; i++) {
        if (arr[i] == null && ele == null) {
            return true;
        }
        if (arr[i] != null && arr[i].equals(ele)) {
            return true;
        }
    }
    return false;
}
public E getFirst() {
    if (isEmpty()) {
        throw new UserNoSuchElementException("no element present");
    }
    return this.arr[0];
}


public E getLast() {
    if (isEmpty()) {
               throw new UserNoSuchElementException("no element present");

    }
    return this.arr[this.size() - 1];
}
public E get(int index) {
    if (index < 0 || index >= size()) {
        throw new UserIndexOutOfBoundsException("Invalid index: " + index);
    }
    return arr[index];
}
public E set(int index, E ele) {
    if (index < 0 || index >= size()) {
        throw new UserIndexOutOfBoundsException("Invalid index: " + index);
    }
    E oldValue = arr[index];
    arr[index] = ele;
    return oldValue; 
    }

    public void add(int index, E newEle)
    {
    	if(index<0 || indx> this.size())
    	{
    		throw new UserIndexOutOfBoundsException("Ivalid Index");

    	}
    	if(index==0)
    	{
    		addFirst(newEle);
    		return;
    	}
    	if(index==this.size())
    	{
    		addLast(newEle);
    		return;
    	}
    	if(arr.length==size())
		{
			E[] newArr= (E[])new Object[newCapacity(arr.length)];
			for(int i=0;i<arr.length;i++)
			{
				newArr[i]=arr[i];
			}
			this.arr=newArr;
		}

			for(int i=indx;i> index;i--)
			{
				this.arr[i]=this.arr[i-1];
			}
			this.arr[index]=newEle;
			this.indx++;
		
    }
    public E removeLast()
    {
    	if(isEmpty())
    		throw new UserNoSuchElementException("Element not found ");
    	E temp=this.arr[this.size()-1];
    	this.indx--;
    	return temp;
    }
    
	  public E removeFirst()
    {
    	if(isEmpty())
    		throw new UserNoSuchElementException("Element not found ");
    	E temp=this.arr[0];
    	for(int i=1;i<this.size();i++)
    	{
    		arr[i-1]=arr[i];
    	}
    	this.arr[this.size()-1]=null;
    	this.indx--;
    	return temp;
    }
    public E remove(int index)
    {
    	if(index<0 || index>=this.size())
    		throw new UserIndexOutOfBoundsException("Invalid Index");
    	if(index==0)
    	{
    		return removeFirst();
    	}
    	if(index==this.size()-1)
    	{
    		return removeLast();
    	}
    	E temp=this.arr[index];
    	for(int i=index;i<size()-1;i++ ){
    		this.arr[i]=this.arr[i+1];
    	}
    	this.arr[this.size()-1]=null;
    	this.indx--;
    	return temp;
    }

    public boolean addAll(UserArrayList<E> coll)
    {
    	for (int i=0;i<coll.size() ;i++ ) {
    		this.addLast(coll.get(i));
    	}
    return true;

    }
    public boolean removeAll(UserArrayList<E>coll)
    {
    	boolean assump= false;

    	for (int i=0;i<coll.size() ;i++ ) {
    		E ele=coll.get(i);
    		
    		int index=this.indexOf(ele);
    		if(index!=-1)
    		{
    			this.remove(index);
    			assump= true;
    		}
    	}
    	return assump;
    }

}

