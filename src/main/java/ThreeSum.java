import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();

        // 生成15三数之和的测试案例
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists.toString());
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            int len = nums.length;
            if (len < 3 || nums == null) return ans;

            /**
             * 排序，遍历 1到n-2 个数，然后双指针检查剩余元素是否满足当前遍历元素
             * 不能出现相同元素，如果接下来的元素和当前元素相等，跳过
             */

            for (int i = 0; i < len - 2; i++) {

                int a1 = nums[i];
                // 跳过相同元素
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
                if (nums[i] + nums[len - 1] + nums[len - 2] < 0) continue;

                int l = i + 1, r = len - 1;
                while (l < r) {
                    int total = nums[l] + nums[r] + a1;
                    if (total == 0) {
                        ans.add(Arrays.asList(nums[l], nums[r], a1));
                        // 指针先动，然后检查下一个当前元素和之前使用过的元素是否相同
                        for (r--; l < r && nums[r] == nums[r + 1]; r--) ;
                        for (l++; l < r && nums[l] == nums[l - 1]; l++) ;
                    } else if (total > 0) {
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