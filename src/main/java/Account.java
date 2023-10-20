public class Account {
    private int balance;
    public Account(int i) {
        balance = i;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int withdraw(int amount){
        balance -= amount;
        return balance;
    }

    public double getCompoundInterest(int money, int year, double interest) {
        Installment installment = new Installment(money, year, interest);
        return installment.getCompoundInterest();
    }

    private class Installment{
        private int installmentMoney;
        private int installmentYear;
        private double interestRate;
        private Installment() throws Exception{
            throw new Exception();
        }
        private Installment(int installmentMoney, int installmentYear, double interestRate) {
            this.installmentMoney = installmentMoney;
            this.installmentYear = installmentYear;
            this.interestRate = interestRate;
        }
        private double getCompoundInterest(){
            double result = 0.0;
            for (int i=0; i<installmentYear; i++){
                result = (this.installmentMoney + result)*(1+interestRate);
            }
            return result;
        }

    }

}
