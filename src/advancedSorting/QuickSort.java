package advancedSorting;
import array.OrderedArray;

public class QuickSort extends OrderedArray{

	public QuickSort(int[] array){
		super(array);
	}
	
	public void quicksort(){
		recQuickSort(0,len-1);
	}
	private void recQuickSort(int start,int end){
		
		if(start>=end)
			return;
		else{
			int pivot=array[end];
			int middle=partitionIt(start,end,pivot);
			recQuickSort(start,middle-1);
			recQuickSort(middle+1,end);
		}	
		
	}
	
	private int partitionIt(int start,int end,int pivot){
		
		int leftptr=start-1;
		int rightptr=end;
		
		while(true){
			
			//array[leftptr] is always >=pivot, so switch end with leftptr
			while(array[++leftptr]<pivot){
				System.out.println(array[leftptr]+ " :: "+pivot);
			}
				
			//array[rightprt] is not
			while(array[--rightptr]>pivot&&rightptr>leftptr)
				;
			if(leftptr>=rightptr)
				break;
			
			int temp=array[leftptr];
			array[leftptr]=array[rightptr];
			array[rightptr]=temp;			
		}
		int temp=array[leftptr];
		array[leftptr]=array[end];
		array[end]=temp;
		return leftptr;
	}
	
	public static void main(String[] args){
		
		int[] arrayA={6,4,7,3,90,5,70,9};
		QuickSort tester=new QuickSort(arrayA);
		tester.quicksort();
		System.out.println(tester.display());
	}
		
}
