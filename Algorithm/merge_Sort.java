package Searching_and_Sorting;

public class merge_Sort {

    private static void mergeSort(int [] arr, int sp, int ep)
    {
        //code here

        if(ep > sp){

            int mid = sp + (ep - sp) / 2;

            mergeSort(arr, sp, mid);
            mergeSort(arr, mid+1, ep);


            merge(arr, sp, mid, ep);
        }
    }


    private static void merge(int [] arr, int sp, int m, int ep)
    {
        // Your code here

        //Size of two Sub Array
        int n1 = m - sp + 1;
        int n2 = ep - m;

        int [] l = new int [n1];
        int [] r = new int [n2];


        //Adding data to both array
        for(int i=0; i<n1; ++i)
            l[i] = arr[sp + i];

        for(int i=0; i<n2; ++i)
            r[i] = arr[m + 1 + i];



        //Merge both array
        int i=0, j=0;

        int k = sp;
        while(i < n1  &&  j < n2){

            if(l[i] <= r[j]){

                arr[k] = l[i];

                i++;
            }

            else{

                arr[k] = r[j];

                ++j;

            }

            ++k;
        }



        //Copying remaining elements IF LEFT of both arrays
        while(i < n1){
            arr[k] = l[i];

            i++;
            ++k;
        }

        while(j < n2){
            arr[k] = r[j];

            ++j;
            k++;
        }


    }

    public static void main(String [] args)
    {
        int [] arr = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    private static void printArray(int [] arr)
    {
        for (int j : arr)
            System.out.print( j + " " );

        System.out.println();
    }
}
