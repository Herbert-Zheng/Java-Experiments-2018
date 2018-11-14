/**
 * @author 郑昊鹏
 * @author 16130120181
 * @author 1033998328@qq.com
 */

public class Substring {

    public static void main(String[] args) {
        int beginIndex = Integer.valueOf(args[1]);
        int endIndex = beginIndex + Integer.valueOf(args[2]);

        System.out.println(args[0].substring(beginIndex, endIndex));
    }
}
