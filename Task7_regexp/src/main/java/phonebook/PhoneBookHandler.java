package phonebook;

import phonebook.controller.PhoneBookController;
import phonebook.model.PhoneBookRecord;
import phonebook.view.PhoneBookView;

/**
 *  Init and run  phone book app
 */
public class PhoneBookHandler {

    public static void main(String[] args) {
        PhoneBookRecord model = new PhoneBookRecord();
        PhoneBookView view = new PhoneBookView();
        PhoneBookController controller = new PhoneBookController(model ,view);
        controller.run();
    }



}
