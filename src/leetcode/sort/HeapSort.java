package leetcode.sort;

public class HeapSort {

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    /**
     * 首先对[0, len//2]部分排定大小,再对第i个元素shiftdown排定，排定len//2的最大元素的顺序，找到最大的那个元素放在第0个位置
     * 然后对[0, len] 排定大小：第0个元素和第i个元素进行交换，
     * 像选择排序一样，每次对对第0个元素到第i-1个元素未排定顺序的元素进行shiftdown排定，依次找到他们所在的位置
     *
     * @param arr
     */
    public void sort(int[] arr) {
        int len = arr.length;
        for (int i = len / 2; i >= 0; i--) {
            shiftDown(arr, len, i);
        }

        for (int i = len-1; i > 0 ; i--) {
            swap(arr,0, i);
            shiftDown(arr, i, 0);
        }
        System.out.println();
    }

    /**
     * 在[0, up]区间，对index进行shiftDown操作
     * 每个元素和其左右子节点进行比较，若当前节点小于左右子节点中的任意一个（右优先），则进行交换，然后shiftDown到下一层继续比较，直到找到合适位置为止
     * @param nums
     * @param up
     * @param index
     */
    private void shiftDown(int[] nums, int up, int index) {
        while (index * 2 + 1 < up) {
            int nxtLv = index * 2;
            if(nums[nxtLv+1] > nums[nxtLv]) {
                nxtLv = nxtLv + 1;
            }
            if(nums[nxtLv] > nums[index]) {
                swap(nums, nxtLv, index);
                index = nxtLv;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 3, 12, 3, 89, 9, -4, 9};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        for (int n: arr) {
            System.out.println(n);
        }
    }

}
