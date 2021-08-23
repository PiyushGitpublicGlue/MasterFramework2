package org.selenium.pom.objects;

public class CreateCustomer {

    private String name;
    private String company;
    private String address;
    private String city;
    private String phone;
    private String email;

    public CreateCustomer(){

    }

    public CreateCustomer(String name,String company,String address,String city,String phone,String email){
        this.name = name;
        this.company = company;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public CreateCustomer setName(String name) {
        this.name = name;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public CreateCustomer setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CreateCustomer setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public CreateCustomer setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CreateCustomer setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateCustomer setEmail(String email) {
        this.email = email;
        return this;
    }


}
