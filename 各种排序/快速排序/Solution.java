package 各种排序.快速排序;


import java.util.Arrays;

public class Solution {
    public static void Sort(int[] nums) {
        qsotr(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,5,-1,20,1,1,1,1,1,1,2,32,3,5,5};
        Sort(a);
        System.out.println(Arrays.toString(a));
    }
    private static void qsotr(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = Findprivot(nums, low, high);
        qsotr(nums, low, pivot - 1);
        qsotr(nums, pivot + 1, high);
    }

    private static int Findprivot(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        System.out.println(Arrays.toString(nums));
        return low;
    }
}
