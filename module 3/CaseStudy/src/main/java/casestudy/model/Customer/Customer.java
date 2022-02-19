package casestudy.model.Customer;

public class Customer {
    private int id;
    private int id_card;
    private String name;
    private String birthday;
    private String gender;
    private String identify_number;
    private String phone_number;
    private String email;
    private String address;
    private int customerType_id;
    private String customerTypeName;

    public Customer() {
    }

    public Customer(int id, int id_card, String name, String birthday, String gender, String identify_number, String phone_number, String email, String address, int customerType_id, String customerTypeName) {
        this.id = id;
        this.id_card = id_card;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.identify_number = identify_number;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.customerType_id = customerType_id;
        this.customerTypeName = customerTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentify_number() {
        return identify_number;
    }

    public void setIdentify_number(String identify_number) {
        this.identify_number = identify_number;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCustomerType_id() {
        return customerType_id;
    }

    public void setCustomerType_id(int customerType_id) {
        this.customerType_id = customerType_id;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
