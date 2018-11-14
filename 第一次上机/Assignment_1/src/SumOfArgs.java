import java.util.regex.Pattern;

/**
 * @author 郑昊鹏
 * @author 16130120181
 * @author 1033998328@qq.com
 */

public class SumOfArgs {

    public static void main(String[] args) {
        int argsSum = 0;

        for (int i = 0; i < args.length; i++) {
            if (!isNumeric(args[i])) {  //Check if it's a integer
                if (i == args.length - 1) {  //Check if it's the last one
                    break;
                }
                i++;
            }

            argsSum += Integer.parseInt(args[i]);
        }

        System.out.println(argsSum);
    }

    private static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("^[-+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}


