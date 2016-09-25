package phonebook.model;

/**
 * Address class data holder
 */
public class Address {


    private String index;
    private String city;
    private String street;
    private String number;

/**
 * set Address from  string  as a  comma  separated value :
 * @params adr  String  "index, city,street,number"
 */
    public Address(String adr) {

        String[] adrArr = adr.split(",");
        this.index = adrArr[0];//index
        this.city = adrArr[1]; //city
        this.street = adrArr[2];//street
        this.number = adrArr[3];//number
    }
    public void setIndex(String index) {
        this.index = index;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "index='" + index + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

}
