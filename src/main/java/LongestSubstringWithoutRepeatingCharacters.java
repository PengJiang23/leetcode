import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= s.length <= 5 * 10⁴
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 滑动窗口 👍 10445 👎 0
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        String s = "au";
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            if(s.length() == 1) return 1;

            char[] charArray = s.toCharArray();
            Map<Character, Integer> has = new HashMap<>();
            int ans = 0;
            int l = 0;
            for (int i = 0; i < s.length(); i++) {

                while (has.containsKey(charArray[i])) {
                    ans = Math.max(ans, i - l);
                    has.remove(charArray[l++]);
                }

                has.put(charArray[i], 1);
                ans = Math.max(ans, i - l+1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}