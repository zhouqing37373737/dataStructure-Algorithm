package heapQueue;

/**
 * a FIFO queue implemented with array with 
 * wrapAround property
 * 
 * @author zhouqing
 *
 */
public class Queue {

	int[] queuearray;
	int front;
	int rear;
	int len;
	int counter;
	
	/**
	 * front points to the current cell with data;

	 * rear points to the next cell without data;
	 * @param num
	 */
	public Queue(int num){
		queuearray=new int[num];
		rear=0;
		front=0;
		len=num;
		counter=0;
	}
	
	public void inque(int data){
		queuearray[rear++]=data;
		if(rear==len)
			rear=0;
		counter++;
		
	}
	
	public int deque(){
		
		int returnval=queuearray[front++];
		
		if(front==len)
			front=0;
		counter--;
		
		return returnval;

	}
	
	public boolean isFull(){
		
		return counter==len? true:false;
	}
	
	public boolean isEmpty(){
		return counter==0?true:false;
	}
	
	public String display(){
		StringBuilder sbu=new StringBuilder();
		
		for(int data: queuearray){
			sbu.append(data);
			sbu.append(',');
		}
		return sbu.toString();
		
	}
	public static void main(String[] args){
		
		int[] dataA={1,2,3,4,5,6};
		Queue tester=new Queue(10);
		
		
		for(int data:dataA)
			tester.inque(data);
		System.out.println("Inque1: "+tester.display());
		System.out.println("Deque1");
		for(int i=0;i<dataA.length;i++){
			System.out.print(tester.deque()+",");
		}
		
	
		for(int data:dataA)
			tester.inque(data);
		System.out.println("Inque2: "+tester.display());
		System.out.println("Deque2");
		for(int i=0;i<dataA.length;i++){
			System.out.print(tester.deque()+",");
		}
		
	}
	
}
