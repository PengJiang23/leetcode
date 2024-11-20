import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * <p>
 * <p>
 * Related Topics 贪心 数组 双指针 二分查找 排序 👍 596 👎 0
 */
public class ValidTriangleNumber {
    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int triangleNumber(int[] nums) {
            int len = nums.length;
            if (len < 3) return 0;

            Arrays.sort(nums);
            int ans = 0;

            // unsolve
            /** 未解决点
             *  从后往前遍历，找到最大的c
             *  ans 结果累加，排序以后rl之间的数都满足条件，而不是累加1
             */
            for (int k = len - 1; k >= 2; k--) {
                int r = k - 1;
                int l = 0;

                while (l < r) {
                    if (nums[l] + nums[r] > nums[k]) {

                        ans += (r - l);
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}