// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.Arrays;
import java.util.Comparator;

public class fractionalKnapsack {
   public fractionalKnapsack() {
   }

   public static void main(String[] var0) {
      int[] var1 = new int[]{60, 100, 120};
      int[] var2 = new int[]{10, 20, 30};
      byte var3 = 50;
      double[][] var4 = new double[var1.length][2];

      int var5;
      for(var5 = 0; var5 < var1.length; ++var5) {
         var4[var5][0] = (double)var5;
         var4[var5][1] = (double)var1[var5] / (double)var2[var5];
      }

      Arrays.sort(var4, Comparator.comparingDouble((var0x) -> {
         return var0x[1];
      }));
      var5 = var3;
      int var6 = 0;

      for(int var7 = var1.length - 1; var7 >= 0; --var7) {
         int var8 = (int)var4[var7][0];
         if (var5 < var2[var8]) {
            var6 = (int)((double)var6 + var4[var7][1] * (double)var5);
            boolean var9 = false;
            break;
         }

         var5 -= var2[var8];
         var6 += var1[var8];
      }

      System.out.println("final value = " + var6);
   }
}
