package phonebook.model;

/**
 * Created by Denys_Shmyhin on 9/20/2016.
 */
public class PhoneBookRecord {
    //1.	Фамилия абонента
    private String firstName;
    // 2.	Имя абонента
    private String lastName;
    // 3.	Отчество абонента
    private String middleName;
    //4.	Никнейм
    private String nickName;
    //5.	Комментарий
    private String description;
    //6.	Группы в которую занесен абонент
    private CallerGroup callerGroup;
    //7.	Телефон дом
    private String homePhone;
    //8.	Телефон моб.
    private String  primaryMobPhone;
    //9.	Телефон моб. 2
    private String  seondaryMobPhone;
    //10.	Е-майл
    private String email;
    //11.	Скайп
    private String  skype;
    //12.	Адрес, состоящий из:
            // - Индекс
            //- город проживания
            //- улица
            //- номер дома
    private Address address;


    public String getFirstName() {
        return firstName;
    }

    public PhoneBookRecord setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PhoneBookRecord setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public PhoneBookRecord setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public PhoneBookRecord setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PhoneBookRecord setDescription(String description) {
        this.description = description;
        return this;
    }

    public CallerGroup getCallerGroup() {
        return callerGroup;
    }

    public PhoneBookRecord setCallerGroup(CallerGroup callerGroup) {
        this.callerGroup = callerGroup;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public PhoneBookRecord setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getPrimaryMobPhone() {
        return primaryMobPhone;
    }

    public PhoneBookRecord setPrimaryMobPhone(String primaryMobPhone) {
        this.primaryMobPhone = primaryMobPhone;
        return this;
    }

    public String getSeondaryMobPhone() {
        return seondaryMobPhone;
    }

    public PhoneBookRecord setSeondaryMobPhone(String seondaryMobPhone) {
        this.seondaryMobPhone = seondaryMobPhone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PhoneBookRecord setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSkype() {
        return skype;
    }

    public PhoneBookRecord setSkype(String skype) {
        this.skype = skype;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneBookRecord setAddress(Address address) {
        this.address = address;
        return this;
    }
}
