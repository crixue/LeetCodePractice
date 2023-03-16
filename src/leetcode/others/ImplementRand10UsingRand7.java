package leetcode.others;

import java.util.Random;

public class ImplementRand10UsingRand7 {
    public int rand7() {
        return new Random(System.currentTimeMillis()).nextInt(7) + 1;
    }

    public int rand10() {
        while (true) {
            int var0 = (rand7() - 1) * 7 + rand7();
            if (var0 <= 40) {
                return var0 % 10 + 1;
            }
            int var1 = var0 - 40;  // ran9
            int var2 = (var1 - 1) * 7 + rand7();
            if(var2 <= 60) {
                return var2 % 10 + 1;
            }

            int var3 = var2 - 60;  //ran3
            int var4 = (var3 - 1) * rand7() + rand7();
            if(var4 <= 20) {
                return var4 % 10 + 1;
            }
        }
    }

}


