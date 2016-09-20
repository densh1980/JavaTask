package phonebook.model;

/**
 * Created by Denys_Shmyhin on 9/20/2016.
 */
public class Address {
    String  index;
    String city;
    String street;
    String number;

    public Address(String  adr){

        String [] adrArr = adr.split(",");
        index = adrArr[0];
        city = adrArr[1];
        street = adrArr[2];
        number = adrArr[3];

    }

}
