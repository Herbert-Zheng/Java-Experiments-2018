public class PIMNote extends PIMEntity {

    private String noteItem;

    PIMNote(String inputPriority) {
        priority = inputPriority;
    }
    @Override
    public void setFromString(String inputItem) {
        noteItem = inputItem;
    }

    @Override
    public String toString() {
        return "NOTE " + this.priority + " " + this.noteItem;
    }
}
