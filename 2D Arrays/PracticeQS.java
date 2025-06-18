public class PracticeQS {
    public static void printCount(int matrix[][], int key){
        int count = 0;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == key){
                    count++;
                }
            }
        }
        System.out.println("The key " + key + " has occurred " + count + " times");
    }

    public static void printSumOfSecondRow(int matrix[][]){
        int sum = 0;
        for (int j = 0; j < matrix[0].length; j++){
            sum += matrix[1][j];
        }
        System.out.println("The sum of elements in second row is: " + sum);
    }


    public static void main(String args[]){
        int matrix[][] = {{4, 7, 8}, {8, 8, 7}};
        printCount(matrix, 7);

        int nums[][] = {{1, 4, 9}, {11, 4, 3}, {2, 2, 3}};
        printSumOfSecondRow(nums);

    }
}
