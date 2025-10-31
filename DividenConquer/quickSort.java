public class quickSort{
    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSorting(int arr[], int si, int ei){
        if (si >= ei){
            return;
        }

        int pIdx = partition(arr, si, ei);

        quickSorting(arr, si, pIdx - 1);
        quickSorting(arr, pIdx + 1, ei);
    }

    public static int partition(int arr[], int si, int ei){
        int pivot =  arr[ei];  // last element is the pivot
        int i = si - 1;   // to make place for smaller elements than pivot

        for(int j = si; j < ei; j++){
            if (arr[j] <= pivot){
                i++;

                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        // place the pivot on the right position

        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;


    }

    public static void main(String args[]){
        int arr[] = {6, 3, 9, 5, 2, 8, -5};
        quickSorting(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
