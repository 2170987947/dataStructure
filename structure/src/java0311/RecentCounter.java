package java0311;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/11 21:41
 */
class RecentCounter {
    int count = 0;
    int[] array;
    public RecentCounter() {
        array = new int[4];
        count = 0;
    }

    public int ping(int t) {
        if (count == 4) {
            // 搬运
            for (int i = 0; i < count - 1 - 1; i++ ) {
                array[i] = array[i + 1];
            }
            array[count - 1] = t;
        }  else {
            array[count++] = t;
        }

        int i = 0;
        // 寻找比
        for (i = 0; i < count; i++) {
            if (array[i] >= t - 4) {
                break;
            }
        }
        System.out.println(count - i);
        return count - i;
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        recentCounter.ping(1);
        recentCounter.ping(100);
        recentCounter.ping(3001);
        recentCounter.ping(3002);
        recentCounter.ping(3003);
        recentCounter.ping(3005);
    }
}