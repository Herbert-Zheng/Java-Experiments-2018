import java.util.Date;

public class PIMTodo extends PIMEntity implements PIMDate {

    private String todoItem;
    private Date todoDate;

    PIMTodo(String inputPriority) {
        priority = inputPriority;
    }

    @Override
    public void setFromString(String inputItem) {
        todoItem = inputItem;
    }

    @Override
    public String toString() {
        return "TODO " + this.priority + " " + this.todoDate + " " + this.todoItem;
    }

    @Override
    public void setMyDate(Date inputDate) {
        todoDate = inputDate;
    }
}
