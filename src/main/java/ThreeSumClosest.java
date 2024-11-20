import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();

        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(solution.threeSumClosest(nums, target));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumClosest(int[] nums, int target) {

            int ans = 0, gap = Integer.MAX_VALUE;
            int len = nums.length;
            Arrays.sort(nums);

            for (int i = 0; i < len - 2; i++) {
                int curr = nums[i];
                int l = i + 1, r = len - 1;

                while (l < r) {
                    int sum = curr + nums[l] + nums[r];
                    int newGap = Math.abs(target - sum);

                    ans = newGap < gap ? sum : ans;
                    gap = newGap < gap ? newGap : gap;

                    if (target - sum > 0) {
                        l++;
                    }else{
                        r--;
                    }

                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}