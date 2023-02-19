package leetcode.arr;

public class MergeArr {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m];
        for (int i = 0; i < m; i++) {
            temp[i] = nums1[i];
        }
        mergeTwoArr(nums1, nums2, temp);
    }

    private void mergeTwoArr(int[] nums1, int[] nums2, int[] temp) {
        int m = temp.length, n = nums2.length, i = 0, j = 0;
        for (int k = 0; k < nums1.length; k++) {
            if (i >= m) {
                nums1[k] = nums2[j];
                j++;
            } else if(j >= n) {
                nums1[k] = temp[i];
                i++;
            } else if(temp[i] <= nums2[j]) {
                nums1[k] = temp[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
        }
    }

}
