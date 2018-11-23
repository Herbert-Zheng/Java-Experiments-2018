import java.util.Date;

public class PIMAppointment extends PIMEntity implements PIMDate {

    Date appointDate;
    String appointDescribe;

    @Override
    public void setFromString(String s) {

    }

    @Override
    public String toString() {
        return "APPOINTMENT " + this.Priority + " " + this.appointDate + " " + this.appointDescribe;
    }

    @Override
    public void printDate() {

    }
}
