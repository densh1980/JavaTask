package phonebook;

import phonebook.controller.PhoneBookController;
import phonebook.model.PhoneBookRecord;
import phonebook.view.PhoneBookView;

/**
 * Created by Denys_Shmyhin on 9/20/2016.
 */
public class PhoneBookHandler {

    public static void main(String[] args) {
        PhoneBookRecord model = new PhoneBookRecord();
        PhoneBookView view = new PhoneBookView();
        PhoneBookController controller = new PhoneBookController(model,view);
        controller.run();
    }



}
