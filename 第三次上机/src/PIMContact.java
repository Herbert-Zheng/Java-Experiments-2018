public class PIMContact extends PIMEntity{

    String firstName;
    String lastName;
    String emailAddress;

    @Override
    public void setFromString(String s) {

    }

    @Override
    public String toString() {
        return "CONTACT " + this.Priority + " " + this.firstName + " " + this.lastName + " " + this.emailAddress;
    }
}
