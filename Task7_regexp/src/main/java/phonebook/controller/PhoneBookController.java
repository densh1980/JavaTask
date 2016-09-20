package phonebook.controller;

import phonebook.model.Address;
import phonebook.model.CallerGroup;
import phonebook.model.PhoneBookRecord;

import java.util.Scanner;

/**
 * Created by Denys_Shmyhin on 9/20/2016.
 */

public class PhoneBookController {
    public static final String TEXT_PATERN = "^[a-z A-Z 0-9]*";
    public static final String EMAIL_PATTERN = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
    public static final String CALLER_GROUP_TEMPLATE = "(FAMILY)|(FRIENDS)|(WORK)|(EMERGENCY)";

    PhoneBookRecord record;
    Scanner sc =  new Scanner(System.in);


    public PhoneBookController(PhoneBookRecord record){
        this.record = record;
    }
    public void run(){
        String input;
        do {
            showInputMsg("Фамилия абонента");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setFirstName(input);

        do {
            showInputMsg("Имя абонента");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setLastName(input);

        do {
            showInputMsg("Отчество абонента");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setMiddleName(input);
        do {
            showInputMsg("Никнейм");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setNickName(input);

        do {
            showInputMsg("Комментарий");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setDescription(input);

        do {
            showInputMsg("Комментарий");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setDescription(input);

        do {
            showInputMsg("Группы в которую занесен абонент :FAMILY|FRIENDS|WORK|EMERGENCY");
            input = getInputValue();
        } while (!validate(input, CALLER_GROUP_TEMPLATE));
        record.setCallerGroup(CallerGroup.valueOf(input));

        do {
            showInputMsg("Телефон дом");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setHomePhone(input);

        do {
            showInputMsg("Телефон моб.");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setPrimaryMobPhone(input);

        do {
            showInputMsg("Телефон моб.2");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setSeondaryMobPhone(input);

        do {
            showInputMsg("Е-майл");
            input = getInputValue();
        } while (!validate(input, EMAIL_PATTERN));
        record.setEmail(input);

        do {
            showInputMsg("Скайп");
            input = getInputValue();
        } while (!validate(input, TEXT_PATERN));
        record.setSkype(input);

        do {
            showInputMsg("Адрес : index,city,street,number");
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

    public void showInputMsg(String field){
        System.out.println(" Введите " + field);
    }



}
