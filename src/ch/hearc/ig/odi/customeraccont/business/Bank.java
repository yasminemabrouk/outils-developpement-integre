package ch.hearc.ig.odi.customeraccont.business;

import java.util.*;

public class Bank {

    Collection<Account> accounts;
    Collection<Customer> customers;
    private int number;
    private String name;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param number
     * @param name
     */
    public Bank(int number, String name) {
        this.number = number;
        this.name = name;
    }

    /**
     *
     * @param number
     */
    public Account getAccountByNumber(String number) {
        Account accountFinal = null;
        Iterator<Account> accountsIterator = accounts.iterator();
        while (accountsIterator.hasNext()) {
            Account accountTemp = accountsIterator.next();
            if (accountTemp.getNumber() == number) {
                accountFinal = accountTemp;
            }
        }
        return accountFinal;
    }

    /**
     *
     * @param number
     */
    public Customer getCustomerByNumber(int number) {
        Customer customerFinal = null;
        Iterator<Customer> customerIterator = customers.iterator();
        while (customerIterator.hasNext()) {
            Customer customerTemp = customerIterator.next();
            if (customerTemp.getNumber() == number) {
                customerFinal = customerTemp;
            }
        }
        return customerFinal;
    }

    /**
     *
     * @param number
     * @param firstName
     * @param lastName
     */
    public void addCustomer(int number, String firstName, String lastName) {
        this.customers.add(new Customer(number, firstName, lastName));
    }

    /**
     *
     * @param number
     * @param name
     * @param rate
     * @param customer
     */
    public void addAccount(String number, String name, double rate, Customer customer) {
        if (customers.contains(customer)) {
            getCustomerByNumber(customer.getNumber()).addAccount(number, name, rate);
        }
    }
}
