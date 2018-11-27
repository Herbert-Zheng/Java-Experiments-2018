import java.util.Date;

public class PIMAppointment extends PIMEntity implements PIMDate {

    private Date appointDate;
    private String appointDescribe;

    PIMAppointment(String inputPriority){
        priority = inputPriority;
    }

    @Override
    public void setFromString(String inputDescribe) {
        appointDescribe = inputDescribe;
    }

    @Override
    public String toString() {
        return "APPOINTMENT " + this.priority + " " + this.appointDate + " " + this.appointDescribe;
    }

    @Override
    public void setMyDate(Date inputDate) {
        appointDate = inputDate;
    }
}
