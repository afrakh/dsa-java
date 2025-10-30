public class mergeSort{
    public static void print_array(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSortFunc(int arr[], int si, int ei){
        if (si >= ei){
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSortFunc(arr, si, mid);
        mergeSortFunc(arr, mid + 1, ei);
        merge(arr, si, ei, mid);
    }

    public static void merge(int arr[], int si, int ei, int mid){
        // (0, 3) = 4, (4, 6) = 3 => temp length = 7 (6 - 0)
        int temp[] = new int[ei - si + 1];

        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // iterator for temp array

        while (i <= mid && j <= ei){
            if (arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;

        }

        while (i <= mid){
                temp[k++] = arr[i++];
            }

            while (j <= ei){
                temp[k++] = arr[j++];
            }

            for (k=0, i=si; k < temp.length; k++, i++){
                // copy temp to original array
                arr[i] = temp[k];
            }

    }
    public static void main(String args[]){
        int arr[] = {6, 3, 9, 5, 2, 8};
        mergeSortFunc(arr, 0, arr.length - 1);
        print_array(arr);

    }
}