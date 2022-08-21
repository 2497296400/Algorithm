package 动态规划问题.最长递增子串;

public class Dome {
    public static void main(String[] args) {
        Solution01 s = new Solution01();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(s.lengthOfLIS(nums));
    }
}
