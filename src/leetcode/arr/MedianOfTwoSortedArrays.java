package leetcode.arr;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int var0 = (m + n + 1) / 2;
        int var1 = (m + n + 2) / 2;

        int median = findMedianSortedArrays(nums1, 0, m - 1, nums2, 0, n - 1, var0) +
                findMedianSortedArrays(nums1, 0, m - 1, nums2, 0, n - 1, var1);
        return median * 0.5;
    }

    private int findMedianSortedArrays(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int m = nums1.length, n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, start2, end2, nums1, start1, end1, k);
        }

        if(start1 == m) {
            return nums2[start2 + k - 1];
        } else if(start2 == n) {
            return nums1[start1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i1 = Math.min(start1+k/2-1, end1);
        int i2 = Math.min(start2+k/2-1, end2);
        if(nums1[i1] <= nums2[i2]) {
            return findMedianSortedArrays(nums1, i1 + 1, end1, nums2, start2, end2, k - (i1 - start1 + 1));
        } else {
            return findMedianSortedArrays(nums1, start1, end1, nums2, i2 + 1, end2, k - (i2 - start2 + 1));
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
//        int[] nums1 = new int[]{1,3,5};
//        int[] nums2 = new int[]{2,4,5,6,8,10,11};
        int[] nums1 = new int[]{100001};
        int[] nums2 = new int[]{100000};
        double medianSortedArrays = medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

}
