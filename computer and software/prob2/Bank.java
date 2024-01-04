package lab1_hw;

import java.util.ArrayList;
import java.util.Objects;

public class Bank {
    private ArrayList<Loan> loans;

    public Bank(ArrayList<Loan> loans) {
        this.loans = loans;
    }

    public Bank() {
        this.loans = new ArrayList<Loan>();
    }

    public void addLoan(Loan l){
        loans.add(l);
    }

    public boolean removeLoan(Loan l) {
        for(Loan l1 : loans){
            if(l1 == l){
                loans.remove(l1);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Loan> find(String name){
        ArrayList<Loan> loansPrime = new ArrayList<Loan>();
        for(Loan l : loans){
            if (Objects.equals(l.getPerson().getName(), name)) {
                loansPrime.add(l);
            }
        }
        return loansPrime;
    }

    public ArrayList<Loan> find(String name, double minAmount){
        ArrayList<Loan> loansPrime = new ArrayList<Loan>();
        for(Loan l : loans){
            if (Objects.equals(l.getPerson().getName(), name) && l.getAmount() >= minAmount) {
                loansPrime.add(l);
            }
        }
        return loansPrime;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "loans=" + loans +
                '}';
    }
}
