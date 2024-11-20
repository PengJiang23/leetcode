public class ThreeSum{
      public static void main(String[] args) {
           Solution solution = new ThreeSum().new Solution();
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
                  if (i> 0 && nums[i] == nums[i - 1]) continue;

                  if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
                  if (nums[i] + nums[len - 1] + nums[len - 2] < 0) continue;

                  int l = i + 1, r = len - 1;
                  while(l < r){
                      int total = nums[l] + nums[r] + a1;
                      if(total == 0) {
                          ans.add(Arrays.asList(nums[l], nums[r], a1));
                          for(r--; l < r && nums[r] == nums[r+1];r--);
                          for(l++; l < r && nums[l] == nums[l-1];l++);
                      }else if(total > 0){
                          r--;
                      }else{
                          l++;
                      }
                  }

              }


              return ans;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }