package leetcode.arr;

public class TrappingRainWatter {


    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int lmax = height[left], rmax = height[right], max = Math.max(lmax, rmax);

        int total = 0;
        while (left <= right) {
            max = Math.max(height[left], max);
            while(left <= right && height[left] < max) {
                lmax = Math.max(lmax, height[left]);
                total += lmax - height[left] <= 0 ? 0 : lmax - height[left];
                left ++;
            }

            max = Math.max(height[right], max);
            while(left <= right && height[right] < max) {
                rmax = Math.max(rmax, height[right]);
                total += rmax - height[right] <= 0 ? 0 : rmax - height[right];
                right --;
            }

            if(height[left] == height[right] && height[left] == max) {
                lmax = Math.max(lmax, height[left]);
                total += lmax - height[left] <= 0 ? 0 : lmax - height[left];
                left ++;
                max = Math.max(lmax, max);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        TrappingRainWatter trappingRainWatter = new TrappingRainWatter();
        int trap = trappingRainWatter.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
    }

}
