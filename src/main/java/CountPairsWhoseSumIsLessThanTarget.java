import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountPairsWhoseSumIsLessThanTarget{
      public static void main(String[] args) {
           Solution solution = new CountPairsWhoseSumIsLessThanTarget().new Solution();

          List<Integer> nums = new ArrayList<>(Arrays.asList(-1,1,2,3,1));
          int target = 2;
          System.out.println(solution.countPairs(nums, target));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int ans = 0;

        for(int i = 0; i< nums.size() - 1; i++){
            for(int j = i+1; j < nums.size(); j++){
                if(nums.get(i) + nums.get(j) < target) ans +=1;
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }