package java0302;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/2 22:02
 */
public class CanConstruct {
    public static boolean canConstruct(String ransom, String magazine) {
        if (ransom.length() > magazine.length()) {
            return false;
        }
        int[] cap = new int[26];
        for (char c : ransom.toCharArray()) {
            int index = magazine.indexOf(c, cap[c - 'a']);
            if (index == -1) {
                return false;
            }
            cap[c - 'a'] = index + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("ads", "adacs"));
    }
}
