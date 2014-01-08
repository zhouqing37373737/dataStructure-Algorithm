package heapQueue;

public class Heap {

	private int[] heaparray;
	private int top;
	private int len;
	
	/**
	 * top points to the next empty cell
	 * @param num
	 */
	public Heap(int num){
		
		heaparray=new int[num];
		top=0;
		len=num;
	}
	
	public void push(int data){
		
		heaparray[top++]=data;
	}
	
	public int pop(){
		
		return heaparray[--top];
	}
	
	public boolean isFull(){
		
		return top==len?true:false;
	}
	
	public boolean isEmpty(){
		return top==0? true:false;
	}
	
	
	public String display(){
		StringBuilder sbu=new StringBuilder();
		for(int i=0;i<top;i++){
			sbu.append(heaparray[i]);
			sbu.append(',');
		}
		
		return sbu.toString();
	}
	
	
	public static void main(String[] args){
		
		int[] dataA={1,2,3,4,5,6,7};
		Heap tester=new Heap(100);
		for(int c : dataA){
			tester.push(c);
		}
		
		System.out.println("inHeap: "+tester.display());
		
		System.out.print("OutHeap: ");
		for(int i=0;i<dataA.length;i++){
			
			System.out.print(tester.pop());
			
		}
	}
}
