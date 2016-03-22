package com.nyctalcorp.webstore.domain;

/**
 * Created by Giacinto on 22/03/2016.
 */
public class Customer {

    private String customerId;
    private String name;
    private String address;
    private boolean noOfOrdersMade;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(boolean noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (noOfOrdersMade != customer.noOfOrdersMade) return false;
        if (!customerId.equals(customer.customerId)) return false;
        if (!name.equals(customer.name)) return false;
        return address != null ? address.equals(customer.address) : customer.address == null;

    }

    @Override
    public int hashCode() {
        int result = customerId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (noOfOrdersMade ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", noOfOrdersMade=" + noOfOrdersMade +
                '}';
    }
}
