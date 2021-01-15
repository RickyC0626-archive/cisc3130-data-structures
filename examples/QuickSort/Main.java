public class Main
{
    public static <E extends Comparable<? super E>> void quickSort(E[] arr, int begin, int end)
    {
        // 0. base case
        if(end - begin <= 1) return;

        // 1. partition
        // choose a pivot and swap it with the last element
        int pidx = choosePivot(arr, begin, end);
        E temp = arr[end - 1];
        arr[end - 1] = arr[pidx];
        arr[pidx] = temp;

        // start partition
        int lastSmall = begin - 1, i = begin;
        while(i < end - 1)
        {
            if(arr[i].compareTo(arr[pidx]) <= 0)
            {
                temp = arr[i];
                arr[i] = arr[lastSmall + 1];
                arr[++lastSmall] = temp;
            }
        }

        // 2. recurse on smaller elements
        quickSort(arr, begin, lastSmall);

        // 3. recurse on larger elements
        quickSort(arr, lastSmall + 1, end);
    }

    public static <E> int choosePivot(E[] arr, int begin, int end)
    {

    }
}
