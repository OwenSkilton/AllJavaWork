package builder;

// The builder pattern is a creational pattern
// It is used to simplify the creation of objects with many fields
public class Client {

    private String firstName;
    private String lastName;
    private String email;
    private String houseNumber;
    private String street;
    private String city;
    private String postcode;

    // The Client constructor does not have to be private but is probably better off being so
    private Client(String firstName, String lastName, String email, String houseNumber, String street, String city, String postcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private String email;
        private String houseNumber;
        private String street;
        private String city;
        private String postcode;

        // The builder pattern setter method typically:
        // - has a name that matches the field name
        // - returns a ref to the current object (this)
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

        public Builder houseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
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

        public Client build() {
            // TODO: check that all the necessary fields have been set
            return new Client(firstName, lastName, email, houseNumber, street, city, postcode);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public Client setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Client setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public Client setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Client setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Client setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostcode() {
        return postcode;
    }

    public Client setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }
}
