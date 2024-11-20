/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == height.length
 * 2 <= n <= 10⁵
 * 0 <= height[i] <= 10⁴
 * <p>
 * <p>
 * Related Topics 贪心 数组 双指针 👍 5180 👎 0
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        int[] heigth = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = solution.maxArea(heigth);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int ans = Integer.MIN_VALUE;

            int l = 0, r = height.length - 1;
            int lMax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE;
            while (l < r) {
                lMax = Math.max(lMax, height[l]);
                rMax = Math.max(rMax, height[r]);

                // focus 这里的宽度 r-l eg. 0-2的宽度是2（2-0）
                ans = Math.max(ans, Math.min(lMax, rMax) * (r - l));

                if (lMax < rMax) {
                    l++;
                } else {
                    r--;
                }

            }
            return ans;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}