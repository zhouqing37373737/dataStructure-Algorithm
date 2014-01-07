package array;

/**Implemented 3 simpleSorting algorithms
 * Bubble,Selection and Insertion
 * 
 * Bubble takes N^2 for both comparison and copy
 * Selection takes N^2 for comparison and N for copy
 * Insertion takes N^2 for both comparison and copy,
 * BUT GENERALLY ENDS BEFORE REACHES THE END
 * 
 * @author zhouqing
 *
 */
public class SortingArray extends OrderedArray {
	
	public SortingArray(int[] array){
		super(array);
		
	}

	public void bubbleSort(){
		
		for(int out=len-1;out>0;out--){
			for(int in=1;in<=out;in++){
				
				if(array[in]<array[in-1]){
					int temp=array[in];
					array[in]=array[in-1];
					array[in-1]=temp;
				}
									
			}
			
		}
	}
	
	public void selectionSort(){
		
		//!
		int min;
		for(int out=0;out<len-1;out++){
			min=out;
			for(int in=out+1;in<len;in++){
				if(array[in]<array[min])
					min=in;
			}
			
			//!
			int temp=array[min];
			array[min]=array[out];
			array[out]=temp;
			
		}
		
	}
	
	public void insertionSort(){
		
		for(int out=1;out<len;out++){
			//!
			int temp=array[out];
			int in;
			for(in=out;in>0;in--){
				if(array[in-1]<temp)
					break;
				array[in]=array[in-1];
			}
			//!
			array[in]=temp;
		}
		
	}
	
	public static void main(String[] args){
		
		int[] array={5,6,3,5,1,7,3,8,11,56,21,5672,32,8};
		SortingArray tester1=new SortingArray(array);
		SortingArray tester2=new SortingArray(array);
		SortingArray tester3=new SortingArray(array);
		
		tester1.bubbleSort();
		System.out.println("Bubble--> "+tester1.display());
		
		tester2.selectionSort();
		System.out.println("Selection--> "+tester2.display());
		
		tester3.insertionSort();
		System.out.println("Insertion--> "+tester3.display());
		
	}
	
}
