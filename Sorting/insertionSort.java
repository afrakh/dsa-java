import java.util.*;

public class insertionSort{
    public static void insertionSorting(int arr[]){
        for (int i = 0; i < arr.length; i++){
            int curr = arr[i];
            int prev = i - 1;
            //finding out the corrrect position to insert
            while (prev >= 0 && arr[prev] > curr){
                arr[prev + 1] = arr[prev];
                prev--;
            }
            //insertion
            arr[prev + 1] = curr;
        }
    }


    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]){
        int arr[] = {4, 8, 1, 3, 9, 10, 5, 7, 0, 2, 6};
        insertionSorting(arr);
        printArray(arr);
    }
}
