import java.time.LocalDate;

class Client {
    private String name;
    private LocalDate bday;
    private String CNP;
    private Address address;
    private Account[] accounts = new Account[10];
    private int noAccounts = 0;

    public void addAccount(Account a) {
        accounts[noAccounts++] = a;
    }

    public boolean removeAccount(String iban) {
        for (int i = 0; i < noAccounts; i++) {
            if (accounts[i].getIBAN().equals(iban)) {
                for (int j = i; j < noAccounts; j++) {
                    accounts[j] = accounts[j + 1];
                    noAccounts--;
                }
            }
            return true;
        }
        return false;
    }
}
