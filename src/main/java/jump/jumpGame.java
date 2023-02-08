package jump;

public class jumpGame {
    public static void main(String[] args) {
        int[] a = {4,1,1,3,1,1,1};
        System.out.println(jump(a));
    }
    public static int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int step = 0;
        int ind = 0;
        int jump = 0;
        while (jump < nums.length) {
            jump = ind + nums[ind];
            int maxJ = jump;
            int i = ind+1;
            ind = jump;
            if (jump >= nums.length-1) {
                step++;
                return step;
            }
            for (; i <= jump; i++) {
                int newj = i + nums[i];
                if (maxJ < newj) {
                    ind = i;
                    maxJ = newj;
                }
            }
            step++;
        }
        return step;
    }
}
