package leetcode.sort;

/**
 * 基本思想： 未排定元素每一次都 两两比较相邻 位置的元素，并将较大的元素放到后面去；
 * 每一轮都会将未排定元素中的最大的值 排到数组的某尾去
 */
public class BubbleSort {

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void bubbleSort(int[] nums) {
        int len  = nums.length;

        boolean sorted = true;  // 优化逻辑：如果每一个元素都比前一个元素要大，就不需要再排序了

        for (int i = 0; i < len - 1; i++) {
            for (int j = 1; j < len - i; j++) {
                if(nums[j-1] > nums[j]) {
                    swap(nums, j-1, j);
                    sorted = false;
                }
            }
            if(sorted) {
                return;
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{-1, 3, 12, 89, -4, 9};
        int[] arr = new int[]{-1, 3, 3, 2, 4, 1, 3, 5, 2, 1};

        bubbleSort(arr);
        for (int num:
                arr) {
            System.out.println(num);
        }
    }

}
