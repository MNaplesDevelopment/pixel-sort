package pixSort;

public class Test {
	
	public static void main(String args[])	{
		//int x = Integer.MAX_VALUE;
		int x = -1;
		System.out.println(Integer.toBinaryString(x));
		x &= ~0b11111111000000000000000000000000;
		System.out.println(Integer.toBinaryString(x));
	}
}
