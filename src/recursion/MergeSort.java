package recursion;
import array.OrderedArray;

public class MergeSort extends OrderedArray {

	private int[] workArray;

	public MergeSort(int[] array){
		super(array);
		workArray=new int[array.length];
	}
	
	public void mergesort(){
		sort(workArray,0,array.length-1);
	}
	
	private void sort(int[] workArray,int from,int to){
		if(from==to)
			return;
		int lowerStart=from;
		int lowerEnd=(from+to)/2;
		int higherStart=(from+to)/2+1;
		int higherEnd=to;
		System.out.println(lowerStart+"~~"+lowerEnd+" || "+higherStart+"~~"+higherEnd);
		sort(workArray,lowerStart,lowerEnd);
		sort(workArray,higherStart,higherEnd);
		merge(lowerStart,higherStart,higherEnd);
		
	}
	
	private void merge(int lowerStart,int higherStart,int higherEnd){
		
		int lowerEnd=higherStart-1;
		int i=0;
		System.out.println("M"+lowerStart+":"+lowerEnd+"<-->"+higherStart+":"+higherEnd);
		while(lowerStart<=lowerEnd&&higherStart<=higherEnd){
			if(array[lowerStart]<=array[higherStart])
				workArray[i++]=array[lowerStart++];
			else
				workArray[i++]=array[higherStart++];
		}
		
		while(lowerStart<=lowerEnd)
			workArray[i++]=array[lowerStart++];
		
		while(higherStart<=higherEnd)
			workArray[i++]=array[higherStart++];
		
		int originloc=higherEnd-i+1;
		for(int j=0;j<i;j++){
			
			array[originloc+j]=workArray[j];
		}
		
	}
	
	public static void main(String[] args){
		
		int[] dataA={3,5,1,2,7,8,4};
		MergeSort tester=new MergeSort(dataA);
		tester.mergesort();
		System.out.println(tester.display());
	}
}
