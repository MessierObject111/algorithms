package com.java.se.priorityQueue;

import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.*;

public class OrderByPriorityTest {
    class DebtAccount implements Comparable{
        double balance;
        private String accountUuid;

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getAccountUuid() {
            return accountUuid;
        }

        public void setAccountUuid(String accountUuid) {
            this.accountUuid = accountUuid;
        }

        public int compareTo(DebtAccount o) {
            return Double.compare(balance, o.balance);
        }

        @Override
        public int compareTo(Object o) {
            DebtAccount account = (DebtAccount) o;
            return Double.compare(account.getBalance(), balance);
        }
    }
    public DebtAccount getGreatestNegativeBalance (List<DebtAccount> debtAccountList) {
        DebtAccount result = new DebtAccount();
        if(debtAccountList.isEmpty()) return result;
        PriorityQueue<DebtAccount> pq = new PriorityQueue();
        pq.comparator();
        pq.addAll(debtAccountList);
        DebtAccount debtAccount = pq.poll();
        result = debtAccount;
        return result;
    }

    public static void main(String[] args) {
        OrderByPriorityTest test = new OrderByPriorityTest();
        List<DebtAccount> debtList = new ArrayList<>();
        int i = 0;
        while(i < 10) {
            Random random = new Random();
            double bal = 10000 * random.nextDouble();
            System.out.println(bal);
            String uuid = UUID.randomUUID().toString();
            OrderByPriorityTest.DebtAccount account = test.new DebtAccount();
            account.setAccountUuid(uuid);
            account.setBalance(bal);
            debtList.add(account);
            i++;
        }
        OrderByPriorityTest.DebtAccount result = test.getGreatestNegativeBalance(debtList);
        System.out.println(result.getBalance());

    }

}
