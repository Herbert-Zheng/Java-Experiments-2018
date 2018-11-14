import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * @author 郑昊鹏
 * @author 16130120181
 * @author 1033998328@qq.com
 */

public class cal {
    private static Calendar calendar = Calendar.getInstance();

    public static void main(String[] args) {
        if (args.length != 0) {
            try {
                int input_month = Integer.valueOf(args[0]);
                int input_year = Integer.valueOf(args[1]);
                SetMonthAndYear(input_month, input_year);
            } catch (NumberFormatException exce) {
                exce.printStackTrace();
            }
        }

        SetMonthAndYear();

        PrintMonthAndYear();
        PrintSunToSat();
        PrintDays();
    }

    // With no argument
    static void SetMonthAndYear() {
        int defultYear = calendar.get(Calendar.YEAR);
        int defultMonth = calendar.get(Calendar.MONTH);
        calendar.set(defultYear, defultMonth, 1);
    }

    // With full argument, overload
    static void SetMonthAndYear(int input_month, int input_year) {
        calendar.set(input_year, input_month - 1, 1);
    }

    // Print first line, using SimpleDateFormat
    static void PrintMonthAndYear() {
        SimpleDateFormat toPrint = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
        System.out.println(toPrint.format(calendar.getTime()));
    }

    // Print from Su to Sa
    static void PrintSunToSat() {
        System.out.println("Su Mo Tu We Th Fr Sa");
    }

    // Print days according to month and year
    static void PrintDays() {
        int daysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int firstDayInWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Offset
        for (int i = 0; i < 3 * (firstDayInWeek - 1); i++)
            System.out.print(" ");

        for (int i = 0; i < daysOfMonth; i++) {
            // Print spaces according to date
            if (i < 9)
                System.out.print(" " + (i + 1) + " ");
            else
                System.out.print((i + 1) + " ");

            // Change line
            if ((i + firstDayInWeek) % 7 == 0) {
                System.out.println();
            }
        }
    }
}
