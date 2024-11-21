/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2]、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= nums.length <= 3 * 10⁴
 * 1 <= nums[i] <= 1000
 * 0 <= k <= 10⁶
 * <p>
 * <p>
 * Related Topics 数组 二分查找 前缀和 滑动窗口 👍 817 👎 0
 */
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new SubarrayProductLessThanK().new Solution();
        int[] nums ={1,1,1};
        int k = 1;
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int ans = 0;
        int left = 0;
        int product = 1;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left++];
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}