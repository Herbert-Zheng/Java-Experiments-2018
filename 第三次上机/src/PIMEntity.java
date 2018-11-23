abstract class PIMEntity {
    String Priority;

    PIMEntity() {
        Priority = "Normal";
    }

    PIMEntity(String priority) {
        Priority = priority;
    }

    public String getPriority() {
        return Priority;
    }

    public void setPriority(String p) {
        Priority = p;
    }

    // Each PIMEntity needs to be able to set all state information
    // (fields) from a single text string.
    abstract public void setFromString(String s);

    // This is actually already defined by the super class
    // Object, but redefined here as abstract to make sure
    // that derived classes actually implement it
    abstract public String toString();
}
