package com.autobots.java.bank_application;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class BankBase implements Bank{

    private String bankName;
    private long accountNumber;
    private long routingNumber;

    public static Set<BankBase> allBankRecords = new HashSet<>();

    public BankBase(long accountNumber, long routingNumber) {
        if (Long.toString(accountNumber).length() != 12){
            throw new IllegalArgumentException("Account number must be 12 digits: ");
        } else if (Long.toString(routingNumber).length() != 9) {
            throw new IllegalArgumentException("Routing number must be 9 digits:");
        } else {
            this.accountNumber = accountNumber;
            this.routingNumber = routingNumber;
        }
    }



    public static void addToAllBankRecords(BankBase bank) throws Exception{
        for (BankBase bankBase : allBankRecords){
            if (bankBase.accountNumber == bank.getAccountNumber()){
                throw new Exception("Account number already exist: ");
            }
            if (bankBase.accountNumber == bank.getRoutingNumber()){
                throw new Exception("Routing number already exist: ");
            }
        }
        allBankRecords.add(bank);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(long routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BankBase bankBase = (BankBase) o;
        return accountNumber == bankBase.accountNumber && routingNumber == bankBase.routingNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, routingNumber);
    }

    @Override
    public String toString() {
        return "BankBase{" +
                "accountNumber=" + accountNumber +
                ", routingNumber=" + routingNumber +
                '}';
    }
}
