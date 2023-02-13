package leetcode.others;

import java.util.HashSet;
import java.util.Set;

public class UnionFind {

    private int[] parent;
    private int[] size;
    private int count;

    public UnionFind(int[] nums) {
        count = nums.length;
        parent = new int[count];
        size = new int[count];
        for(int i=0; i<nums.length; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findRoot(int x) {
        while(x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q) {
        int rootp = findRoot(p);
        int rootq = findRoot(q);
        if(rootp == rootq) return;

        if(size[rootp] > size[rootq]) {
            parent[rootq] = rootp;
            size[rootp] += size[rootq];
        } else {
            parent[rootp] = rootq;
            size[rootq] += size[rootp];
        }
        count--;
    }

    public int getMaxSeqSize() {
        int sz = size.length;
        int max = 0;
        for(int i=0; i<sz; i++) {
            max = Math.max(max, size[i]);
        }
        return max;
    }


    public static int longestConsecutive(int[] nums) {

        // return solution1(nums);
        Set<Integer> numsSet = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            numsSet.add(nums[i]);
        }


        UnionFind uf = new UnionFind(nums);
        for(int i=0; i<nums.length; i++) {
            if(numsSet.contains(nums[i]-1)) {
                uf.union(nums[i]-1, nums[i]);
            }
            if(numsSet.contains(nums[i]+1)) {
                uf.union(nums[i]+1, nums[i]);
            }
        }

        return uf.getMaxSeqSize();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        longestConsecutive(nums);
        System.out.println(nums);
    }

}
