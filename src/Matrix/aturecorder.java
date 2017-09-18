package Matrix;

import java.util.Arrays;

public class aturecorder 
{
	public static void main(String[] args)
	{
		int[] flag={0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2,0,1,2};//1,1,2,2,0,2,1,1,2,2,2,2
		int low=0, high=flag.length-1,mid=0;
		int temp;
		while(mid<=high)
		{
			switch (flag[mid])
			{
			case 0:
				temp= flag[low];
				flag[low]=flag[mid];
				flag[mid]=temp;
				low++; mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
					temp= flag[mid];
					flag[mid]=flag[high];
					flag[high]=temp;
					high--;
					break;
			}
		}
		System.out.println(Arrays.toString(flag));
	}
}