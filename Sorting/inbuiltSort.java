import java.util.*;

public class inbuiltSort{
    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

     public static void printArrayReverse(Integer arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        int arr[] = {4, 8, 1, 3, 9, 10, 5, 7, 0, 2, 6};
        Arrays.sort(arr);
        printArray(arr);

        int arr2[] = {2, 6, 9, 4, 6, 1, 3, 0};
        Arrays.sort(arr2, 0, 4); //toIndex is non-inclusive
        printArray(arr2);

        Integer arr3[] = {3, 6, 9, 12, 15};
        Arrays.sort(arr3, Collections.reverseOrder());
        printArrayReverse(arr3);

        Integer arr4[] = {4, 7, 9, 10, 3, 1};
        Arrays.sort(arr4, 0, 3, Collections.reverseOrder());
        printArrayReverse(arr4);

    }
}
