package co.maurorondi.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String ag;
    private List<Account> accounts;
    private  int lastAccount = 1;

    public Bank(String ag){
        this.ag = ag;
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public void insertAccount(Account account){
        accounts.add(account);
    }

    // Gerando codigo cc incrementando por usuarios
    public Account generateAccount(String name){
        Account account = new Account(ag, ""+lastAccount, name);
        lastAccount++;
        return account;
    }

    //Total de todas as contas no banco
    public void outputTotal(){
        double total = 0;
        for(Account account : accounts){
            double balance = account.getBalance();
            total += balance;
        }
        System.out.println("Total no Banco: R$" + total);
    }
}
