public class PIMContact extends PIMEntity{

    private String firstName;
    private String lastName;
    private String emailAddress;

    PIMContact(String inputFirstName, String inputLastName){
        firstName = inputFirstName;
        lastName = inputLastName;
    }

    @Override
    public void setFromString(String inputEmail) {
        emailAddress = inputEmail;
    }

    @Override
    public String toString() {
        return "CONTACT " + this.priority + " " + this.firstName + " " + this.lastName + " " + this.emailAddress;
    }
}
