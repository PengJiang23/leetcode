import java.util.HashMap;

/**
 * 给你一个下标从 0 开始的字符串 s ，这个字符串只包含 0 到 9 的数字字符。
 * <p>
 * 如果一个字符串 t 中至多有一对相邻字符是相等的，那么称这个字符串 t 是 半重复的 。例如，"0010" 、"002020" 、"0123" 、"2002
 * " 和 "54944" 是半重复字符串，而 "00101022" （相邻的相同数字对是 00 和 22）和 "1101234883" （相邻的相同数字对是 11
 * 和 88）不是半重复字符串。
 * <p>
 * 请你返回 s 中最长 半重复 子字符串 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "52233"
 * <p>
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 最长的半重复子字符串是 "5223"。整个字符串 "52233" 有两个相邻的相同数字对 22 和 33，但最多只能选取一个。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "5494"
 * <p>
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * s 是一个半重复字符串。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "1111111"
 * <p>
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 最长的半重复子字符串是 "11"。子字符串 "111" 有两个相邻的相同数字对，但最多允许选取一个。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 50
 * '0' <= s[i] <= '9'
 * <p>
 * <p>
 * Related Topics 字符串 滑动窗口 👍 32 👎 0
 */
public class FindTheLongestSemiRepetitiveSubstring {
    public static void main(String[] args) {
        Solution solution = new FindTheLongestSemiRepetitiveSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSemiRepetitiveSubstring(String s) {

            if (s.length() <= 1) return s.length();

            int ans = Integer.MIN_VALUE;
            int l = 0;
            int lastRepeatIndex = -1;

            for (int i = 1; i < s.length(); i++) {

                if (s.charAt(i - 1) == s.charAt(i)) {
                    if (lastRepeatIndex != -1) {
                        l = lastRepeatIndex + 1;
                    }
                    lastRepeatIndex = i - 1;
                }

                ans = Math.max(ans, i - l + 1);

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}