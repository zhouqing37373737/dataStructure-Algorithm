package array;

/** Uses binary search to implement searching
 * ,which is used also in delete;
 * boundary checks not implemented, must delete
 * before insert
 * 
 * TimeC
 * @author zhouqing
 *
 */
public class OrderedArray {
	
	private int[] array;
	private int len;
	
	/** the constructor should take
	 * a SORTED array from small to 
	 * large
	 * @param array
	 */
	public OrderedArray(int[] array){
		this.array=array;
		this.len=array.length;
		
	}
	public int insert(int key){
		
		//that's a linear search
		int loc;
		for(loc=0;loc<len;loc++){
			if(key<array[loc])
				break;
		}
		
		int i;
		//here's an example of REVERSE TRAVERSING
		for(i=len-1;i>=loc;i--){
			array[i+1]=array[i];
		}
		array[loc]=key;
		len+=1;
		return key;
		
	}
	public int delete(int key){
		
		int loc=search(key);
		//here's an example of REVERSE TRAVERSING
		for(int i=loc+1;i<len;i++){
			array[i-1]=array[i];
			
		}
		len-=1;
		
		return key;
	}
	public int search(int key){
		
		int curr;
		int higherbound=len-1;
		int lowerbound=0;
		
		while(true){
			
			curr=(higherbound+lowerbound)/2;
			
			if(array[curr]==key)
				return curr;
			else if(higherbound<lowerbound)
				return -1;
			else{
				if(key>array[curr])
					lowerbound=curr+1;
				else 
					higherbound=curr-1;			
			}
			
			
		}
		
	}
	
	public String display(){
		StringBuilder sbu=new StringBuilder();
		
		for(int i=0;i<len;i++){
			sbu.append(array[i]);
		}
		return sbu.toString();
	}
	
	public static void main(String[] args){
		
		int[] array={0,2,3,4,5,6,7,9};
		
		OrderedArray tester=new OrderedArray(array);
		
		System.out.println("find 3 :--> "+ tester.search(3));
		
		tester.delete(4);
		System.out.println("delete 4 :--> "+ tester.display());
		
		tester.insert(1);
		System.out.println("insert 1 :--> "+ tester.display());
		
		
	}

}
