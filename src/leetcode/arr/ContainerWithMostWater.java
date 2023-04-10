package leetcode.arr;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int len = height.length, left = 0, right = len-1, maxArea = (right - left) * Math.min(height[left], height[right]);

        while (left < right) {
            while (left < right && height[left] < height[right]) {
                left++;
                maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            }
            while (left < right &&  height[left] >= height[right]) {
                right--;
                maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int i = containerWithMostWater.maxArea(height);
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);
    }

}
