package linkedlist;

/**
 * An iterator of Doubly Linked List
 * 
 * @author zhouqing
 *
 */
public class Iterator {

	Link current;
	DoublyLinkedList mylist;
	
	public Iterator(DoublyLinkedList DList){
		mylist=DList;
		reset();
	}
	
	public void reset(){
		current=mylist.first;
	}
	public void laset(){
		current=mylist.last;
	}
	public void nextLink(){
		current=current.next;
	}
	public void priorLink(){
		current=current.prior;

	}
	public Link getCurrent(){
		return current;
	}
	public boolean atEnd(){
		return current.next==null? true:false;
	}
	
	
	public void insertBefore(int data){
		Link lk=new Link();
		lk.data=data;
		
		if(current.prior!=null){
			current.prior.next=lk;
			lk.prior=current.prior;
		}
		else
			mylist.first=lk;
		lk.next=current;
		current.prior=lk;		
		
	}

	public void insertAfter(int data){
		Link lk=new Link();
		lk.data=data;
		
		if(current.next!=null){
			current.next.prior=lk;
			lk.next=current.next;
		}
		else{
			mylist.last=lk;
		}
		lk.prior=current;
		current.next=lk;
			
	}
	
	public int deleteCurrent(){
		
		if(current.prior!=null){
			current.prior.next=current.next;
			current=current.prior;
		}
		else
			mylist.first=current.next;
		
		if(current.next!=null){
			current.next.prior=current.prior;
			current=current.next;
		}
		else
			mylist.last=current.prior;
		
		return current.data;
			
	}
	
	
}
