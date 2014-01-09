package linkedlist;

/**
 * A doubly-ended,doubly-linked,unsorted list
 * InsertFirst or Last takes O(1)
 * InsertAfter or delete takes O(n)
 * 
 * @author zhouqing
 *
 */
class Link{
	int data;
	Link next;
	Link prior;

}
public class DoublyLinkedList {
	
	 Link first;
	 Link last;
	
	public DoublyLinkedList(){};
	public DoublyLinkedList(int[] dataA){
		
		for(int data:dataA)
			this.insertLast(data);
	}
	
	private Link findLink(int data){
		Link curlink=first;
		while(curlink!=null){
			if(curlink.data==data)
				return curlink;
			curlink=curlink.next;
		}
		return null;
	}
	
	public void insertFirst(int data){
		Link lk=new Link();
		lk.data=data;
		
		if(first!=null)
			first.prior=lk;
		else
			last=lk;
		
		lk.next=first;
		first=lk;
	}

	public void insertLast(int data){
		Link lk=new Link();
		lk.data=data;
		if(last!=null)
			last.next=lk;
		else
			first=lk;
		lk.prior=last;
		last=lk;
	}
	
	public void insertAfter(int data,int curdata){
		Link lk=new Link();
		lk.data=data;
		Link curlk=findLink(curdata);
		
		if(curlk!=last){
			curlk.next.prior=lk;
			lk.next=curlk.next;
		}
		
		else
			last=curlk;
		
		lk.prior=curlk;
		curlk.next=lk;
	}
	
	public int delete(int data){
		
		Link lk=findLink(data);
		
		if(lk.prior!=null)
			lk.prior.next=lk.next;
		else
			first=lk.next;
		
		if(lk.next!=null)
			lk.next.prior=lk.prior;
		else
			last=lk.prior;
		
		return lk.data;
		
	}
	
	public String display(){
		StringBuilder sbu=new StringBuilder();
		
		for(Link lk=first;lk!=null;lk=lk.next){
			sbu.append(lk.data);
			sbu.append("-->");		
		}
		sbu.append("||");
		return sbu.toString();
	}
	
	
	public Iterator getIterator(){
		
		return new Iterator(this);
	}
	
	
	
	public static void main(String args[]){
		
		int[] dataA={1,3,4,5,6,4,8,4};
		DoublyLinkedList tester=new DoublyLinkedList(dataA);
		
		System.out.println(tester.display());
		
		tester.insertFirst(55);
		tester.insertLast(87);
		tester.insertAfter(567, 3);
		System.out.println(tester.display());
		
		tester.delete(55);
		tester.delete(87);
		tester.delete(3);
		System.out.println(tester.display());
		
		Iterator iter=tester.getIterator();
		
		StringBuilder sbu=new StringBuilder();
		
		while(true){
			sbu.append(iter.getCurrent().data);
			sbu.append("==>");
			
			if(iter.atEnd())
				break;
			iter.nextLink();
		}
		System.out.println(sbu.toString());
		
		iter.reset();

		iter.insertBefore(iter.getCurrent().data-1);
		iter.insertAfter(iter.getCurrent().data+1);
		iter.deleteCurrent();
		
		System.out.println(tester.display());
		
	}
	
}
