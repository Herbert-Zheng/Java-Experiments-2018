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
            IsInputValid(args);
        } else
            SetMonthAndYear();

        PrintMonthAndYear();
        PrintSunToSat();
        PrintDaysAccordingToMonthAndYear();
    }

    private static void IsInputValid(String[] inputString) {
        try {
            int input_month = Integer.valueOf(inputString[0]);
            int input_year = Integer.valueOf(inputString[1]);
            SetMonthAndYear(input_month, input_year);
        } catch (NumberFormatException exce) {
            exce.printStackTrace();
            System.err.println("Please input valid arguments: 'month year'.");
            System.err.println("Now print this month's calender.");
            SetMonthAndYear();
        }
    }

    private static void SetMonthAndYear() {
        int defaultYear = calendar.get(Calendar.YEAR);
        int defaultMonth = calendar.get(Calendar.MONTH);
        calendar.set(defaultYear, defaultMonth, 1);
    }

    private static void SetMonthAndYear(int input_month, int input_year) {
        calendar.set(input_year, input_month - 1, 1);
    }

    private static void PrintMonthAndYear() {
        SimpleDateFormat toPrint = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
        System.out.println(toPrint.format(calendar.getTime()));
    }

    private static void PrintSunToSat() {
        System.out.println("Su Mo Tu We Th Fr Sa");
    }

    private static void PrintDaysAccordingToMonthAndYear() {
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int firstDayOfFirstWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int offset = 3 * (firstDayOfFirstWeek - 1);

        PrintOffset(offset);
        PrintDays(daysInMonth, firstDayOfFirstWeek);
    }

    private static void PrintOffset(int inputOffset) {
        for (int i = 0; i < inputOffset; i++)
            System.out.print(" ");
    }

    private static void PrintDays(int inputDaysInMonth, int inputFirstDayOfFirstWeek) {
        for (int i = 0; i < inputDaysInMonth; i++) {
            if (i < 9)
                System.out.print(" " + (i + 1) + " ");
            else
                System.out.print((i + 1) + " ");

            ChangeLine(i, inputFirstDayOfFirstWeek);
        }
    }

    private static void ChangeLine(int counter, int inputFirstDayOfFirstWeek) {
        if ((counter + inputFirstDayOfFirstWeek) % 7 == 0)
            System.out.println();
    }
}