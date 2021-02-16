package com.java.se.priorityQueue;

import java.util.*;

public class ComparableObjectsPriorityQueueTest {
    class DebtAccount implements Comparable <DebtAccount>{
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

//        @Override
//        public int compareTo(DebtAccount debitAccount) {
//            return Double.compare(balance, debitAccount.balance);
//        }

        @Override
        public int compareTo(DebtAccount account) {
            if(account.getBalance() - balance > 0) {
                return 1;
            }
            if(account.getBalance() - balance < 0) {
                return -1;
            }
            return 0;
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
        ComparableObjectsPriorityQueueTest test = new ComparableObjectsPriorityQueueTest();
        List<DebtAccount> debtList = new ArrayList<>();
        int i = 0;
        while(i < 10) {
            Random random = new Random();
            double bal = 10000 * random.nextDouble();
            System.out.println(bal);
            String uuid = UUID.randomUUID().toString();
            ComparableObjectsPriorityQueueTest.DebtAccount account = test.new DebtAccount();
            account.setAccountUuid(uuid);
            account.setBalance(bal);
            debtList.add(account);
            i++;
        }
        ComparableObjectsPriorityQueueTest.DebtAccount result = test.getGreatestNegativeBalance(debtList);
        System.out.println("Account with Max debt: " + result.getBalance());

    }

}
