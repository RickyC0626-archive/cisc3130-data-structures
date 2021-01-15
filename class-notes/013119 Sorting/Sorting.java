public class Sorting
{
	public static void main(String[] args)
	{
		// Selection sort
		int arr[] = {3, 4, 6, 8, 2, 1};

		int n = arr.length;
		for(int k = 0; k < n; k++)
		{
			int minidx = k;
			for(int i = k + 1; i < n; i++)
			{
				if(arr[i] < arr[minidx]) minidx = i;
			}
			if(minidx != k)
			{
				int temp = arr[minidx];
				arr[minidx] = arr[k];
				arr[k] = temp;
			}
		}

		//Insertion sort
		for(int k = 1; k < n; k++)
		{
			int i = k;
			while(i > 0 && arr[i] > arr[i - 1])
			{
				int temp = arr[i];
				arr[i] = arr[i - 1];
				arr[i - 1] = temp;
				i--;
			}
		}
	}
}
