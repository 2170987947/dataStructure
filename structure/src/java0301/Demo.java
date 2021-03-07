package java0301;

/**
 * @author FMM
 * @version 7.0
 * @date 2021/3/1 17:37
 */
public class Demo {
        public static void main(String args[]){
            int num = 10;
            System.out.println(test(num));
        }
        public static int test(int b){
            try {
                b += 10;
                return b;
            }catch(RuntimeException e){
            }catch(Exception e2){
            } finally{
                b += 10;
                return b;
            }
        }

}
