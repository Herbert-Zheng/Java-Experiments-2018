abstract class PIMEntity {
    String priority;

    PIMEntity() {
        priority = "Normal";
    }

    PIMEntity(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String p) {
        priority = p;
    }

    // Each PIMEntity needs to be able to set all state information
    // (fields) from a single text string.
    abstract public void setFromString(String s);

    // This is actually already defined by the super class
    // Object, but redefined here as abstract to make sure
    // that derived classes actually implement it
    abstract public String toString();
}
