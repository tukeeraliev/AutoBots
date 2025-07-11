package com.autobots.java.bank_application;

public class BankDemo {
    public static void main(String[] args) throws Exception {

        MBank aliayMBank = new MBank(123456789081l, 444444444);

//        System.out.println(aliayMBank.getBalance());
        aliayMBank.deposit(100000);
//        System.out.println("_________");
//        System.out.println(aliayMBank.getBalance());

        Optima ulugbekOptima = new Optima(123456789086l, 444444444);
//        System.out.println(ulugbekOptima.getBalance());

        Bank.transferFunds(aliayMBank, ulugbekOptima, 500);

//        System.out.println(aliayMBank.getBalance());
//        System.out.println(ulugbekOptima.getBalance());

        Demir zinaidaDemir = new Demir(123456789786l, 445444444);
        System.out.println(zinaidaDemir.getBalance());

//        zinaidaDemir.withDraw(100000);

        BankBase.allBankRecords.stream().filter(n -> n.getBalance() > 100).forEach(System.out::println);

        double allSumOfFunds = BankBase.allBankRecords.stream()
                .mapToDouble(Bank::getBalance).sum();
        System.out.println(allSumOfFunds);

    }
}
