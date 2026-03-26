import java.util.*;

class DriverExampleSinglyLinkedlist
{
	public static void main(String[] args) {
		UserLinkedList<Integer> list= new UserLinkedList<Integer>();
		System.out.println(list);
		list.addFirst(10);
		list.addFirst(20);
		list.addFirst(30);
		list.addFirst(40);
		list.addFirst(50);
	System.out.println("Initial list: "+list);
	System.out.println("After addFirst: " + list);
        // addLast
        list.addLast(40);
        list.addLast(50);
        System.out.println("After addLast: "+list);

        // size
        System.out.println("Size"+list.size());

        // getFirst & getLast
        System.out.println("First: " + list.getFirst());
       System.out.println("Last: " + list.getLast());

        // get(index)
        System.out.println("Element at index 2: " + list.get(2));

        // set(index, value)
       System.out.println("Old value at index 2: " + list.set(2, 99));
        System.out.println("After set: " + list);

        // contains
        System.out.println("Contains 20: " + list.contains(20));
        System.out.println("Contains 100: " + list.contains(100));

        // indexOf & lastIndexOf
        list.addLast(20);
        System.out.println("List: " + list);
        System.out.println("indexOf 20: " + list.indexOf(20));
        System.out.println("lastIndexOf 20: " + list.lastIndexOf(20));

        // add at index
        list.add(2, 77);
        System.out.println("After add at index 2: " + list);
        // removeFirst
        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("After removeFirst: " + list);

        // removeLast
        System.out.println("Removed last: " + list.removeLast());
        System.out.println("After removeLast: " + list);

        // remove(index)
        System.out.println("Removed index 2: " + list.remove(1));
        System.out.println("After remove index: " + list);
        // toArray
        Object[] arr = list.toArray();
        System.out.println("Array: " + Arrays.toString(arr));

        // clear
        list.clear();
        System.out.println("After clear: " + list);

        // addAll
        UserLinkedList<Integer> list2 = new UserLinkedList<>();
        list2.add(11);
        list2.add(32);
        list2.add(34);
        list.addAll(list2);
        System.out.println("After addAll: " + list);



	}
	
}
class UserNoSuchElementException extends RuntimeException{
	public UserNoSuchElementException()
	{
		this(" ");
	}
	public UserNoSuchElementException(String desc)
	{
		super(desc);
	}

}
class UserIndexOutOfBoundsException extends RuntimeException{
	UserIndexOutOfBoundsException(String desc)
	{
		super(desc);
	}
}
@SuppressWarnings("unchecked")
class UserLinkedList<E> implements Cloneable
{
	private int indx;
	private  Node<E> head;
	private Node<E> tail;

	
	private class Node<E>
	{
		Node<E> next;
	 	E ele;
		Node( E ele)
		{
		this.ele=ele;
		}
	}
	UserLinkedList()
	{
		super();
	}
	public int size()
	{
		return this.indx;
	}

	
	@Override
	public String toString()
	{
		if(this.size()==0)
			return "[]";
		String rep="[";
		Node<E> currNode=this.head;
		while(currNode.next!=null)
		{
			rep+=currNode.ele+", ";
	 		currNode=currNode.next;
		}
		rep+=currNode.ele+"]";
		return rep;
	}
	public void addFirst(E ele)
	{
		Node<E> newNode= new Node<E>(ele);
		if(this.size()==0)
		{
			this.head=newNode;
			this.tail=newNode;
		}
		else {
			newNode.next=this.head;
			this.head=newNode;
		}
		indx++;
	}
	public E getFirst()
	{
		return this.head.ele;
	}
	public E getLast()
	{
		return this.tail.ele;
	}
	public boolean add(E ele)
	{
		addLast(ele);
		return true;
	}
	public void addLast(E ele)
	{
		Node<E> newNode= new Node<E>(ele);
		if(this.size()==0)
		{
			this.head=newNode;
			this.tail=newNode;
		}
		else
		{
			this.tail.next=newNode;
			this.tail=newNode;
		}
		this.indx++;
	}
	public E removeFirst()
	{
		if(this.size()==0)
		{
			throw new UserNoSuchElementException();
		}
		Node<E> temp= this.head;
		this.head=this.head.next;
		temp.next=null;
		this.indx--;
		if(this.size()==0)
		{
			this.tail=null;
			
		}
		return temp.ele;
	}
	public E removeLast()
	{
		if(this.size()==0)
		{
			throw new UserNoSuchElementException();
		}
		E temp=null;
		if(this.size()==1)
		{
			temp= this.tail.ele;
			this.head=null;
			this.tail=null;
		}
		else{
			Node<E> currNode=this.head;
			for(int i=0;i<this.size()-2;i++)
			{
				currNode=currNode.next;
			}
			temp=this.tail.ele;
			currNode.next=null;
			this.tail=currNode;
		}
		this.indx--;
		return temp;
	}
	public boolean contains(Object obj)
	{
		E ele=(E) obj;
		if(this.size()==0) return false;

		Node<E> currNode= this.head;
		while(currNode.next!=null)
		{
			if(currNode.ele.equals(ele))
				return true;
			currNode=currNode.next;
		}
		if(currNode.ele.equals(ele))
			return true;
		return false;
	}
	public void add(int indx, E ele)
	{
		if(indx<0 || indx>=this.size())
			throw new UserIndexOutOfBoundsException(indx+"no such index");
		if(this.size()==0 || indx==0)
		{
			addFirst(ele);
			return;
		}
		if(indx==this.size()-1)
		{
			addLast(ele);
			return;
		}
		Node<E> newNode= new Node<E>(ele);
		Node<E> currNode1=this.head;
		for(int i=0;i<indx;i++)
		{
			currNode1=currNode1.next;
		}
		newNode.next= currNode1.next;
		currNode1.next=newNode;
		this.indx++;
	}
	public E remove(int indx)
	{
		if(indx<0 || indx>=this.size())
			throw new UserIndexOutOfBoundsException(indx+"no such index");
		if(this.size()==0 || indx==0)
		{
			return removeFirst();
		}
		if(indx==this.size()-1)
		{
			return removeLast();
		}
		Node<E> curr1=this.head;
		for(int i=0;i<indx-1;i++)
		{
			curr1=curr1.next;
		}
		Node<E> curr2= curr1.next;
		curr1.next=curr2.next;
		curr2.next=null;
		this.indx--;
		return curr2.ele;
		
	}
	public int indexOf(Object obj)
	{
		E ele=(E) obj;
		if(this.size()==0) return -1;

		Node<E> currNode= this.head;
		for(int i=0;i<this.size();i++)
		{
			if(currNode.ele.equals(ele)) return i;
			currNode=currNode.next;
		}
		return -1;
	}
	public int lastIndexOf(Object obj)
	{
		E ele=(E) obj;
		if(this.size()==0) return -1;

		Node<E> currNode=this.head;
		for(int i=0;i<this.size();i++)
		{
			if(currNode.ele.equals(ele)) indx=i;
			currNode=currNode.next;
		}
		return indx;
	}
	public E get(int indx)
	{
		if(this.size()==0)
			throw new UserNoSuchElementException();
		if(indx<0 || indx>=this.size())
			throw new UserIndexOutOfBoundsException(indx+" is not valid ");
		if(indx==0)
		{
			return getFirst();
		}
		if(indx==this.size()-1)
		{
			return getLast();
		}
		Node<E> currNode=this.head;
		for(int i=0;i<indx;i++)
		{
			currNode=currNode.next;
		}
		return currNode.ele;
	}
		public E set(int indx, E newEle)
	{
		if(this.size()==0)
			throw new UserNoSuchElementException();
		if(indx<0 || indx>=this.size())
			throw new UserIndexOutOfBoundsException(indx+" is not valid ");
		if(indx==0)
		{
			return getFirst();
		}
		if(indx==this.size()-1)
		{
			return getLast();
		}
		Node<E> currNode=this.head;
		for(int i=0;i<indx;i++)
		{
			currNode=currNode.next;
		}
		E temp=currNode.ele;
		currNode.ele=newEle;
		return temp;
	}
	public E remove()
	{
		return removeLast();
	}
	public void clear()
	{
		int len=this.size();
		for(int i=0;i<len;i++)
		{
			remove();
		}
	}
	public UserLinkedList.Node node(int indx)
	{
		if(this.size()==0) throw new UserNoSuchElementException();
		if(indx<0 || indx>=this.size())
		{
			throw new UserIndexOutOfBoundsException(indx+"invalid index");
		}
		Node<E> currNode=this.head;
		for(int i=0;i<indx;i++)
		{
			currNode=currNode.next;
		}
		return currNode;
	}
	public boolean addAll(UserLinkedList<E>coll)
	{
		if(coll.size()==0) return false;
		Node<E> currNode= coll.node(0);
		for (int i=0;i<coll.size() ;i++ ) {
			this.addLast(currNode.ele);
			currNode=currNode.next;
		}
		return true;
	}
	public boolean addAll(int indx, UserLinkedList<E> coll)
	{
		if(coll==null) throw new NullPointerException("obj is null");
		if(indx==0 || indx>this.size())
			throw new UserIndexOutOfBoundsException(indx+"is invalid");
		int tempindx=indx;
		Node<E> currNode=coll.node(0);
		for(int i=0;i<coll.size();i++)
		{
			this.add(tempindx++,currNode.ele);
			currNode=currNode.next;
		}
		return true;
	}
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	public Object[] toArray()
	{
		if(this.size()==0) return new Object[0];
		Object [] arr= new Object[this.size()];
		Node<E> currNode= this.head;
		for(int i=0;i<this.size();i++)
		{
			arr[i]=currNode.ele;
			currNode=currNode.next;
		}	
		return arr;
	}
	public List<E> reversed()
	{
		ArrayList<E> list= new ArrayList<E>();
		Node<E> currNode= this.head;
		for (int i=0;i<this.size() ;i++ ) {
			list.addFirst(currNode.ele);
			currNode=currNode.next;
		}
		return list;
	}
}

// Output
// []
// Initial list: [50, 40, 30, 20, 10]
// After addFirst: [50, 40, 30, 20, 10]
// After addLast: [50, 40, 30, 20, 10, 40, 50]
// Size7
// First: 50
// Last: 50
// Element at index 2: 30
// Old value at index 2: 30
// After set: [50, 40, 99, 20, 10, 40, 50]
// Contains 20: true
// Contains 100: false
// List: [50, 40, 99, 20, 10, 40, 50, 20]
// indexOf 20: 3
// lastIndexOf 20: 3
// After add at index 2: [50, 40, 99, 20, 10, 40, 50, 20, 77]
// Removed first: 50
// After removeFirst: [40, 99, 20, 10, 40, 50, 20, 77]
// Removed last: 77
// After removeLast: [40, 99]
// Removed index 2: 99
// After remove index: [40]
// Array: [40]
// After clear: []
// After addAll: [11, 32, 34]