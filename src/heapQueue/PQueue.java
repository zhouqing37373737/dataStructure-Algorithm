
package heapQueue;

/**Priority Queue implemented with Array
 * Slow Insertion,Fast Deletion
 * Rear at bottom([0])
 * Front points to cell with data
 * @author zhouqing
 *
 */
public class PQueue {

	private int[] PQArray;
	private int front;
	
	public PQueue(int num){
		PQArray=new int[num];
		front=-1;
	}
	
	public void insert(int data){
		if(front<0)
			PQArray[++front]=data;
		else{
			int i;
			for(i=front;i>=0;i--){
				if(data>PQArray[i]){
					PQArray[i+1]=PQArray[i];
				}
				else
					break;
									
			}
			PQArray[i+1]=data;
			front++;			
		}
		
	}
	
	public int delete(){
		return PQArray[front--];
	}
	
	public String display(){
		StringBuilder sbu=new StringBuilder();
		for(int i=0;i<=front;i++){
			sbu.append(PQArray[i]);
			sbu.append(',');
			
		}
		return sbu.toString();
		
	}
	
	public static void main(String[] args){
		
		int[] arr={1,4,2,5,3,7,34,233,64,32};
		PQueue tester=new PQueue(100);
		for(int i : arr){
			tester.insert(i);
		}
		
		System.out.println("PQueue: "+tester.display());
	}
	
}
