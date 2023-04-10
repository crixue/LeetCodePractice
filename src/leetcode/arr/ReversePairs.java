package leetcode.arr;

public class ReversePairs {

    public int reversePairs(int[] nums) {
        int len = nums.length;

        int[] temp = new int[len];
        int[] res = new int[len];
        int[] resTemp = new int[len];
        reversePairs(nums, temp, res, resTemp, 0, len-1);
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += res[i];
        }
        return count;
    }

    private void reversePairs(int[] nums, int[] temp, int[] res, int[] resTemp, int left, int right) {
        if(left >= right) {
            return;
        }

        int mid = (right - left) / 2 + left;
        reversePairs(nums, temp, res, resTemp, left, mid);
        reversePairs(nums, temp, res, resTemp, mid+1, right);

        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
            resTemp[i] = res[i];
        }

        for(int i=left, j=mid+1, k=left; k <= right; k++) {
            if(i > mid) {
                nums[k] = temp[j];
                res[k] = resTemp[j];
                j++;
            } else if (j > right) {
                nums[k] = temp[i];
                res[k] = resTemp[i];
                i++;
            } else if(temp[i] > temp[j]) {
                nums[k] = temp[i];
                res[k] = resTemp[i] + (right - j + 1);
                i++;
            } else {
                nums[k] = temp[j];
                res[k] = resTemp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int[] nums = {1,3,2,3,1};
        int i = reversePairs.reversePairs(nums);

        System.out.println(i);
    }

}
