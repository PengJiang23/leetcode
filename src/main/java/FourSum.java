import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();

        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = solution.fourSum(nums, target);
        System.out.println(lists.toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {

            /**
             * 第二层循环边界，是<len-2
             * 跳过重复元素用while； for只会跳过部分重复元素
             * int可能超出范围，sum用long
             */
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            int len = nums.length;


            for (int i = 0; i < len - 3; i++) {

                if (i > 0 && nums[i] == nums[i - 1]) continue;

                int a1 = nums[i];
                for (int j = i + 1; j < len - 2; j++) {

                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    int a2 = nums[j];
                    int l = j + 1, r = len - 1;
                    while (l < r) {
                        long sum = (long) a1 + a2 + nums[r] + nums[l];
                        if (sum == target) {
                            ans.add(Arrays.asList(a1, a2, nums[r], nums[l]));
                            // 跳过重复的 l 和 r 元素
                            while (l < r && nums[l] == nums[l + 1]) l++;  // 跳过重复的 l
                            while (l < r && nums[r] == nums[r - 1]) r--;  // 跳过重复的 r

                            l++;  // 移动 l
                            r--;  // 移动 r
                        } else if (sum > target) {
                            r--;
                        } else {
                            l++;
                        }
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}