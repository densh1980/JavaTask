package phonebook;

import phonebook.controller.PhoneBookController;
import phonebook.model.PhoneBookRecord;

/**
 * Created by Denys_Shmyhin on 9/20/2016.
 */
public class PhoneBookHandler {

    public static void main(String[] args) {
        PhoneBookRecord model = new PhoneBookRecord();
        PhoneBookController controller = new PhoneBookController(model);
        controller.run();
    }



}
