public class Main
{
    public static void main(String[] args)
    {

    }

    public static <E extends Comparable<? super E>> void mergeSort(E[] arr)
    {
        mergeSort(arr, 0, arr.length);
    }

    public static <E extends Comparable<? super E>> void mergeSort(E[] arr, int begin, int end)
    {
        if(end - begin <= 1) return;
        int m = (end - begin) / 2;

        mergeSort(arr, begin, begin + m);
        mergeSort(arr, begin + m, end);

        E[] scratch = (E) (new Object[m]);
        System.arraycopy(arr, begin, scratch, 0, m);

        int first = 0, second = begin + m, next = begin;

        while(first < m && second < end)
        {
            arr[next++] = (scratch[first].compareTo(arr[second]) <= 0) ? scratch[first++] : arr[second++];
        }

        while(first < m)
            arr[next++] = scratch[first++];
        while(second < end)
            arr[next++] = arr[second++];
    }
}
