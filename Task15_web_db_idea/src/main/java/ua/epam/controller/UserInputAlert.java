package ua.epam.controller;



public class UserInputAlert{
    private final String FIELD_ALERT_COLOR ="red";
    private final String FIELD_COLOR ="white";
    private String message ="";
    private String[] fieldBgColor = new String[]{FIELD_COLOR, FIELD_COLOR,FIELD_COLOR,FIELD_COLOR};

    public void setMessage(String message) {
        this.message += message + "</br>";
    }

    public void toggleFieldToAlert(int field) {
        fieldBgColor[field] = FIELD_ALERT_COLOR;
    }
    public String  getFieldBgColor(int n){
        return fieldBgColor[n];
    }
    public String getMessage(){
        return message;
    }

}
