import java.util.*;

public class selectionSort{
    public static void selectionSorting(int arr[]){
        for (int i = 0; i < arr.length - 1; i++){
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            //swap 
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }


    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        int arr[] = {4, 8, 1, 3, 9, 10, 5, 7, 0, 2, 6};
        selectionSorting(arr);
        printArray(arr);
    }
}
