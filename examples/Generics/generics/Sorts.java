package generics;

public class Sorts
{
    public static <E extends Comparable<? super E>> void insertionSort(E[] arr)
    {
        for(int k = 1; k < arr.length; k++)
        {
            int j = k;

            while(j > 0 && arr[j].compareTo(arr[j - 1]) > 0)
            {
                E temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }
}
