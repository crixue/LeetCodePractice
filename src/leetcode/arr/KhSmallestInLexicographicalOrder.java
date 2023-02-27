package leetcode.arr;

import java.util.ArrayDeque;
import java.util.Deque;

public class KhSmallestInLexicographicalOrder {

    public int findKthNumber(int n, int k) {

        Deque<Long> stk = new ArrayDeque<>();
        stk.addFirst(0l);

        while (!stk.isEmpty()) {
            Long lastLvVal = stk.pollFirst();
            while (!stk.isEmpty() && (lastLvVal % 10 == 9 || lastLvVal > n - 1)) {
                lastLvVal = stk.pollFirst();
            }
            lastLvVal ++;
            stk.addFirst(lastLvVal);
            int totalLvNodesCount = getLvNodesCount(lastLvVal, lastLvVal, n).intValue();
//            System.out.println("curLvVal:"+ lastLvVal + " & k:" + k + " & totalLvNodesCount:" + totalLvNodesCount);
            if(k - totalLvNodesCount > 0) {
                k -= totalLvNodesCount;
                continue;
            }

            Long curLvVal = stk.peekFirst();
            while (curLvVal <= n) {
                k--;
//                System.out.println("curLvVal:"+ curLvVal + " & k:" + k);
                if(k == 0) {
                    return curLvVal.intValue();
                }
                stk.addFirst(curLvVal);
                curLvVal = stk.peekFirst() * 10;
            }
        }
        return 1;
    }

    private Long getLvNodesCount(long start, long end, long n) {
        if(start > n) {
            return 0l;
        }

        long nxtLvNodes = getLvNodesCount(start * 10, end * 10 + 9, n);
        if(end > n) {
            return nxtLvNodes + n - start + 1;
        } else {
            return nxtLvNodes + end - start + 1;
        }
    }

    public static void main(String[] args) {
        KhSmallestInLexicographicalOrder test = new KhSmallestInLexicographicalOrder();
        long start = System.currentTimeMillis();
//        int lvNodesCount = test.getLvNodesCount(1, 1, 13);
//        System.out.println(lvNodesCount);


        int kthNumber = test.findKthNumber(1, 1);
        long end = System.currentTimeMillis();
//        System.out.println((end - start));
        System.out.println(kthNumber);
    }

}
