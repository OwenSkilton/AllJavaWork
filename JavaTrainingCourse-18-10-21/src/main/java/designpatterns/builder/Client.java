package designpatterns.builder;

// Allows construction of a class by passing in arguments in any order and in any increment (from page to page for example)
public class Client {

    private String firstName;
    private String lastName;
    private String email;
    private String houseNum;
    private String street;
    private String city;
    private String postcode;

    // The client constructor does not have to be private but is probs best as only designpatterns.builder is calling it
    private Client(String firstName, String lastName, String email, String houseNum, String street, String city, String postcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.houseNum = houseNum;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String houseNum;
        private String street;
        private String city;
        private String postcode;

        // The designpatterns.builder pattern setter method typically:
        // - has a name that matches the field name
        // - returns a ref to the current objects (this)

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder houseNum(String houseNum) {
            this.houseNum = houseNum;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder postcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public Client build(){
            // Check all necessary fields are set
            return new Client(firstName, lastName, email, houseNum, street, city, postcode);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
