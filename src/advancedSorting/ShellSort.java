package advancedSorting;

import array.OrderedArray;
public class ShellSort extends OrderedArray{

	public ShellSort(int[] array){
		super(array);
	}
	
	public void shellsort(){
		
		int h=1;
		
		while(h<len/3)
			h=h*3+1;
		
		for(;h>=1;h=(h-1)/3){
			System.out.println("H"+h);
			for(int outer=h;outer<len;outer++){
				
				int temp=array[outer];
				int inner;
			
				//insert After
				for(inner=outer-h;inner>=0;inner-=h){
					System.out.println("INNER"+inner);
					if(array[inner]<temp){
						break;
					}
					array[inner+h]=array[inner];			
							
				}
				array[inner+h]=temp;
				
			}
			
			
		}
		
	}
	
	public static void main(String[] args){
		
		int [] dataA={1,4,2,6,3,7,5,9};
		
		ShellSort tester=new ShellSort(dataA);
		tester.shellsort();
		System.out.println(tester.display());
	}
}
