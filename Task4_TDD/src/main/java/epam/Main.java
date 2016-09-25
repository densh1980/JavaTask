package epam;
        /**
 * Created by Denys_Shmyhin on 9/14/2016.
 */
public class Main {


    public static int[] getInt(int[] src, int target) {
        int[] res = new int[src.length];
        int count = 0;
        for (int i = 0; i < src.length; i++) {
            if (src[i] == target) {
                res[count] = i;
                count++;
            }
        }
        int[] result = new int[count];
        System.arraycopy(res, 0, result, 0, count);
        return result;

    }
}




