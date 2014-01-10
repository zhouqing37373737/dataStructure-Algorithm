package recursion;

public class Hanoi {

	int[] diskPileA;
	int[] diskPileB;
	int[] diskPileC;
	
	int len;
	
	public Hanoi(int num){
		diskPileA=new int[num];
		len=diskPileA.length;
		for(int i=0;i<len;i++)
			diskPileA[i]=i;
	}
	
	public void run(){
		move(len,'A','B','C');
		
	}
	
	private void move(int diskHeight,char from,char inter,char to){
		
		if(diskHeight==1)
			System.out.println("Moving Disk "+diskHeight+" from "+from+" to "+to);
		else{
			move(diskHeight-1,from,to,inter);
			System.out.println("Moving Disk "+diskHeight+" from "+from+" to "+to);
			move(diskHeight-1,inter,from,to);
			
		}
	}

	
	public static void main(String[] args){
		
		Hanoi tester=new Hanoi(6);
		tester.run();
	}
}
