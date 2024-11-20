/**
给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。 

 

 示例 1: 

 
输入: nums = [2,2,3,4]
输出: 3
解释:有效的组合是: 
2,3,4 (使用第一个 2)
2,3,4 (使用第二个 2)
2,2,3
 

 示例 2: 

 
输入: nums = [4,2,3,4]
输出: 4 

 

 提示: 

 
 1 <= nums.length <= 1000 
 0 <= nums[i] <= 1000 
 

 Related Topics 贪心 数组 双指针 二分查找 排序 👍 596 👎 0

*/	
public class ValidTriangleNumber{
      public static void main(String[] args) {
           Solution solution = new ValidTriangleNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int triangleNumber(int[] nums) {
              int len = nums.length;
              if (len < 3) return 0; // 数组长度不足，无法形成三角形

              Arrays.sort(nums); // 先排序
              int ans = 0;

              // 枚举第一个边，倒序找满足条件的组合
              for (int k = len - 1; k >= 2; k--) {
                  int r = k - 1; // 第二边的起点
                  int l = 0; // 第一边的起点

                  while (l < r) {
                      if (nums[l] + nums[r] > nums[k]) {
                          // 满足条件时，左指针到右指针之间的所有元素都可以和 r、k 形成三角形
                          ans += (r - l);
                          r--; // 移动右指针
                      } else {
                          l++; // 不满足条件时，移动左指针
                      }
                  }
              }
              return ans;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }