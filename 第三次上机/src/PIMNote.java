public class PIMNote extends PIMEntity {

    String noteItem;

    @Override
    public void setFromString(String s) {

    }

    @Override
    public String toString() {
        return "NOTE " + this.Priority + " " + this.noteItem;
    }
}
