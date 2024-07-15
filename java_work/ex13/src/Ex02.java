import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        int nums[][] = new int[3][3];

        Arrays.fill(nums[0], 10);
        Arrays.fill(nums[1], 20);
        Arrays.fill(nums[2], 30);

        System.out.println(Arrays.toString(nums[0]));
        System.out.println(Arrays.toString(nums[1]));
        System.out.println(Arrays.toString(nums[2]));

        System.out.println();
        int temp[] = nums[2];    // nums2는 1차원 배열임 30|30|30 (2차원 배열은 못넣음)
        nums[2] = nums[0];    //변수에 303030 넣어두고 변경하면 303030을 다시 꺼내서 쓸수있음
        nums[0] = temp;

        System.out.println(Arrays.toString(nums[0]));
        System.out.println(Arrays.toString(nums[1]));
        System.out.println(Arrays.toString(nums[2]));
    }
}
