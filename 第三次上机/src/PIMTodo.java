import java.util.Date;

public class PIMTodo extends PIMEntity implements PIMDate {

    String todoItem;
    Date todoDate;

    @Override
    public void setFromString(String s) {
        todoItem = s;
    }

    @Override
    public String toString() {
        return "TODO " + this.Priority + " " + this.todoDate + " " + this.todoItem;
    }

    @Override
    public void printDate() {

    }
}
