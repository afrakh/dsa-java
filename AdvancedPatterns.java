import java.util.*;

public class AdvancedPatterns{

    //hollow rectangle

    public static void hollowRectangle(int totRows, int totCols){
        for (int i = 1; i <= totRows; i++){
            for(int j = 1; j<=totCols; j++){
                if (i == totRows || j == 1 || j == totCols || i == 1) {
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }



    //inverted & rotated half pyramid

    public static void inRotHalfPyramid(int n) {
        for (int i = 1; i <= n; i++){
            //spaces
            for (int j = 1; j<= n - i; j++){
                System.out.print(" ");
            }

            //stars
            for (int j = 1; j<=i;j++){
                System.out.print("*");
            }

        System.out.println();
        }
        
    }



    //inverted half pyramid with numbers
    public static void invertedHalfPyramid(int n){
        for (int i = 1; i<=n;i++){
            for (int j = 1; j<=n-i+1; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }




    //Floyd's Triangle
    public static void floydsTriangle(int n){
        int counter = 1;
        for (int i = 1; i<= n; i++){
            for (int j = 1; j<=i;j++){
                System.out.print(counter + " ");
                counter ++;
            }
            System.out.println();
        }
    }




    //0-1 Triangle
    public static void zeroOneTriangle(int n) {
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                if ((i + j) % 2 == 0) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }





    //butterfly pattern
    public static void butterfly(int n) {
        //1st half

        for(int i = 1; i <= n; i++){
            //stars
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }

            //spaces
            for (int j = 1; j <= 2 * (n - i); j++){
                System.out.print(" ");
            }

            //stars
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //2nd half

        for(int i = n; i >= 1; i--){
            //stars
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }

            //spaces
            for (int j = 1; j <= 2 * (n - i); j++){
                System.out.print(" ");
            }

            //stars
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }





    //solid rhombus

    public static void solidRhombus(int n){
        for (int i = 1; i <= n; i++){
            //spaces
            for (int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }

            //stars
            for(int j = 1; j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }





    //hollow rhombus

    public static void hollowRhombus(int n){
        for (int i = 1; i <= n; i++){
            //spaces
            for (int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }
            //hollow rectangle
            for(int j = 1; j<=n; j++){
                if (i == n || j == 1 || j == n || i == 1) {
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }





    //diamond pattern
    public static void diamond(int n) {
        //1st half

        for (int i = 1; i <= n; i++){
            // spaces
            for (int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }
            //stars
            for (int j = 1; j <= (2 * i) - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //2nd half

        for (int i = n; i >= 1; i--){
            // spaces
            for (int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }
            //stars
            for (int j = 1; j <= (2 * i) - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
    

    public static void main(String[] args){
        // hollowRectangle(10, 11);
        // inRotHalfPyramid(7);
        // invertedHalfPyramid(11);
        // floydsTriangle(6);
        // zeroOneTriangle(8);
        // butterfly(6);
        // solidRhombus(8);
        // hollowRhombus(9);
        // diamond(9);
    }
}