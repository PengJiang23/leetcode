public class TwoSumIiInputArrayIsSorted{
      public static void main(String[] args) {
           Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int[] twoSum(int[] numbers, int target) {

              Map<Integer, Integer> has = new HashMap<>();

              for (int i = 0; i < numbers.length; i++) {
                  has.put(numbers[i], i);
              }

              for(int i =0; i<numbers.length; i++){
                  int remain = target - numbers[i];
                  if(has.containsKey(remain)){
                      return new int[]{i+1, has.get(remain)+1};
                  }
              }

              return new int[]{};
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }