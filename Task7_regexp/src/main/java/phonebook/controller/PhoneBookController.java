package phonebook.controller;

import phonebook.model.Address;
import phonebook.model.CallerGroup;
import phonebook.model.PhoneBookRecord;
import phonebook.view.PhoneBookView;

import java.util.Scanner;

/**
 *@param
 * @Created by Denys_Shmyhin on 9/20/2016.
 */

public class PhoneBookController {
    public static final String TEXT_PATERN = "^[a-z A-Z 0-9]*";
    public static final String EMAIL_PATTERN = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
    public static final String CALLER_GROUP_TEMPLATE = "(FAMILY)|(FRIENDS)|(WORK)|(EMERGENCY)";

    PhoneBookRecord record;
    PhoneBookView view;
    
    Scanner sc =  new Scanner(System.in);


    public PhoneBookController(PhoneBookRecord record,PhoneBookView view){
        this.record = record;
        this.view = view;
    }
    public void run(){
        String input;
        do {
            view.showInputMsg("Фамилия абонента");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setFirstName(input);

        do {
            view.showInputMsg("Имя абонента");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setLastName(input);

        do {
            view.showInputMsg("Отчество абонента");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setMiddleName(input);
        do {
            view.showInputMsg("Никнейм");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setNickName(input);

        do {
            view.showInputMsg("Комментарий");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setDescription(input);

        do {
            view.showInputMsg("Группы в которую занесен абонент :FAMILY|FRIENDS|WORK|EMERGENCY");
            input = getInputValue();
        } while (!validate(input, CALLER_GROUP_TEMPLATE));
        record.setCallerGroup(CallerGroup.valueOf(input));

        do {
            view.showInputMsg("Телефон дом");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setHomePhone(input);

        do {
            view.showInputMsg("Телефон моб.");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setPrimaryMobPhone(input);

        do {
            view.showInputMsg("Телефон моб.2");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setSeondaryMobPhone(input);

        do {
            view.showInputMsg("Е-майл");
            input = getInputValue();
        } while (!validate(input, EMAIL_PATTERN));
        record.setEmail(input);

        do {
            view.showInputMsg("Скайп");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setSkype(input);

        do {
            view.showInputMsg("Адрес : index,city,street,number");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setAddress(new Address(input));


    };

    public  boolean validate(String input,String pattern){
        if(input.matches(pattern)) return true;
        return false;
    }
    public  String getInputValue(){

        return sc.nextLine();
    }

    



}
