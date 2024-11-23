import java.util.HashMap;

/**
 * 给你一个整数数组 nums 和一个整数 k 。
 * <p>
 * 一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
 * <p>
 * 如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
 * <p>
 * 请你返回 nums 中 最长好 子数组的长度。
 * <p>
 * 子数组 指的是一个数组中一段连续非空的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,1,2,3,1,2], k = 2
 * 输出：6
 * 解释：最长好子数组是 [1,2,3,1,2,3] ，值 1 ，2 和 3 在子数组中的频率都没有超过 k = 2 。[2,3,1,2,3,1] 和 [3,1,2
 * ,3,1,2] 也是好子数组。
 * 最长好子数组的长度为 6 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,1,2,1,2,1,2], k = 1
 * 输出：2
 * 解释：最长好子数组是 [1,2] ，值 1 和 2 在子数组中的频率都没有超过 k = 1 。[2,1] 也是好子数组。
 * 最长好子数组的长度为 2 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [5,5,5,5,5,5,5], k = 4
 * 输出：4
 * 解释：最长好子数组是 [5,5,5,5] ，值 5 在子数组中的频率没有超过 k = 4 。
 * 最长好子数组的长度为 4 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁹
 * 1 <= k <= nums.length
 * <p>
 * <p>
 * Related Topics 数组 哈希表 滑动窗口 👍 24 👎 0
 */
public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public static void main(String[] args) {
        Solution solution = new LengthOfLongestSubarrayWithAtMostKFrequency().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubarrayLength(int[] nums, int k) {

            int ans = Integer.MIN_VALUE;

            int l = 0;
            HashMap<Integer, Integer> has = new HashMap<>();

            for (int r = 0; r < nums.length; r++) {


                has.put(nums[r], has.getOrDefault(nums[r], 0) + 1);


                while (has.get(nums[r]) > k) {
                    has.put(nums[l], has.get(nums[l]) - 1);
                    l++;

                }
                ans = Math.max(ans, r - l + 1);

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}