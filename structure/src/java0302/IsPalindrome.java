package java0302;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/2 22:42
 */
public class IsPalindrome {
    public static boolean isPalindrome(int num) {
        if (num < 0 || (num != 0 && num % 10 == 0)) {
            return false;
        }
        int yuan = num;
        int fan = 0;
        while (yuan > fan) {
            fan = fan * 10 + yuan % 10;
            yuan /= 10;
        }
        return yuan == fan || yuan == fan / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1000));
    }
}
