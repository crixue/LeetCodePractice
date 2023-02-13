package leetcode.test;

import java.util.*;

class Solution {

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private static Map<Integer, Integer> freqCountMap;
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        freqCountMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            freqCountMap.put(nums[i], freqCountMap.getOrDefault(nums[i], 0) + 1);
        }
        int[] freqNums = freqCountMap.keySet().stream().mapToInt(item -> item).toArray();

        LinkedList<Integer> res = new LinkedList<>();
        sortArr(freqNums, 0, freqNums.length-1, k, res);
        int[] resArr = res.stream().mapToInt(item -> item).toArray();

        return resArr;
    }

    private void sortArr(int[] nums, int left, int right, int k, List<Integer> res) {
        if(left > right) {
            return;
        } else if(left == right) {
            if(k > 0) {
                res.add(nums[left]);
            }
            return;
        }

        int rand = left + new Random(System.currentTimeMillis()).nextInt(right - left + 1);
        swap(nums, left, rand);
        int pivot = freqCountMap.get(nums[left]);

        int lt = left, gt = right + 1, i = left + 1;

        while (i < gt) {
            int frequency = freqCountMap.get(nums[i]);
            if(frequency > pivot) {
                lt++;
                swap(nums, lt, i);
                i++;
            } else if(frequency == pivot) {
                i++;
            } else {
                gt--;
                swap(nums, gt, i);
            }
        }

        swap(nums, left, lt);

        if(lt - left > k) {
            sortArr(nums, left, lt - 1, k, res);
        } else if(k <= gt - left) {
            for (int j = left, count = 0; j <= gt - 1 && count < k; j++, count++) {
                res.add(nums[j]);
            }
            return;
        } else {
            for (int j = left; j <= gt - 1; j++) {
                res.add(nums[j]);
            }
            sortArr(nums, gt, right, k - gt, res);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 > len2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            len1 = nums1.length;
            len2 = nums2.length;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0; i < len1; i++) {
            int searchVal = nums1[i];

            startIndex = searchInTheArr(nums2, startIndex, searchVal);
            if(nums2[startIndex] == searchVal) {
                res.add(nums2[startIndex] );
                startIndex ++;
            }
        }
        return res.stream().mapToInt(item -> item).toArray();

    }

    private int searchInTheArr(int[] nums, int startIndex, int target) {
        int left = startIndex, right = nums.length-1, mid = startIndex;
        while (left <= right) {
            mid = (left + right) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(left >= startIndex && left < nums.length && nums[left] == target) {
            return left;
        }
        return startIndex;
    }

    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }



    public int kthSmallest(int[][] matrix, int k) {
        if(k == 0) {
            return matrix[0][0];
        }
        int n = matrix.length;

       int left = matrix[0][0], right = matrix[n-1][n-1], mid = left;
       while (left <= right) {
           mid = (left + right) / 2;
           int midRank = findMidRank(matrix, mid, n);
           if(midRank == k) {
               right = mid - 1;
           } else if(midRank > k) {
               right = mid - 1;
           } else {
               left = mid + 1;
           }

       }

       return left;
    }

    private int findMidRank(int[][] matrix, int mid, int n) {
        int row = n-1, col = 0, rank = 0;
        while (row >= 0 && col <= n-1) {
            int cur = matrix[row][col];
            if(cur <= mid) {
                rank++;
            }
            col++;
            if(col >= n || matrix[row][col] > mid) {
                row--;
                col = 0;
            }
        }
        return rank;
    }


    private static Map<Integer /*target*/, Integer/*nums1+nums2 count*/> twoSumMemo;
    private static Map<Integer /*target*/, Integer/*nums1+nums2 count*/> threeSumMemo;

    private int twoSumCount(int[] nums1, int[] nums2, int target) {
        if(twoSumMemo.containsKey(target)) {
            return twoSumMemo.get(target);
        }

        Map<Integer /*target-nums[i]*/, Integer /*n times*/> sumMap = new HashMap<>();
        for (int num : nums1) {
            sumMap.put(target-num, sumMap.getOrDefault(target-num, 0) + 1);
        }

        int count = 0;
        for (int num : nums2) {
            if (sumMap.containsKey(num)) {
                count += sumMap.get(num);
            }
        }
        twoSumMemo.put(target, count);
        return count;
    }

    private int threeSumCount(int[] nums1, int[] nums2, int[] nums3, int target) {
        if(threeSumMemo.containsKey(target)) {
            return threeSumMemo.get(target);
        }

        int count = 0;
        for (int num :
                nums3) {
            int restVal = target - num;
            count += twoSumCount(nums1, nums2, restVal);
        }
        threeSumMemo.put(target, count);
        return count;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        twoSumMemo = new HashMap<>();
        threeSumMemo = new HashMap<>();
        int count = 0;
        for (int num :
                nums4) {
            int restVal = 0 - num;
            count += threeSumCount(nums1, nums2, nums3, restVal);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{-1,-2};
        int[] nums3 = new int[]{-1,2};
        int[] nums4 = new int[]{0,-2};
        int res = s.fourSumCount(nums1,nums2, nums3, nums4);
        System.out.println(res);
        String str = "ababacb";

    }
}






