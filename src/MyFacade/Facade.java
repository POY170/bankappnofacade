/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFacade;
import bankcustomers.BankAccount;
import bankcustomers.BankCustomer;
import gencustaccount.AccountIf;
import gencustaccount.CustomerIf;
import java.util.ArrayList;
/**
 *
 * @author POY
 */
public class Facade {
    private static Facade MyFacadeObj = null;
        ArrayList<CustomerIf> custacc = new ArrayList();
        private Facade(ArrayList<CustomerIf> cust) {
            custacc = cust;
        }
        public static Facade getMyFacadeObject(ArrayList<CustomerIf> custacc) {
            if(MyFacadeObj == null) {
                MyFacadeObj = new Facade(custacc);
            }
            return MyFacadeObj;
        }
        public void doDeposit(double amt, CustomerIf cust, int accNo){
            
            AccountIf acc = new BankAccount(accNo);
            acc = cust.getAccount(accNo);
            acc.deposit(amt);
            
        }
        
        public void getBankAccount(CustomerIf cust, int accNo){
            AccountIf acc = new BankAccount(accNo);
            acc = cust.getAccount(accNo);
            System.out.println("Account Number: " + acc.getAccountNumber() + " has " + acc.getBalance());
        }
        public void getBanCustomer(String custName){
            
            for(CustomerIf  account : custacc) {
               if(account.getCustomerName().equals(custName)){
                   ArrayList<AccountIf> accounts = account.getllAccounts();      
                   System.out.println("Customer and account information");
                    System.out.println("Name = " + account.getCustomerName());
                    System.out.println("Has " + account.getNumAccounts() + " accounts");
               for(AccountIf accounted : accounts) {
                    
                    System.out.println("Account number " + accounted.getAccountNumber() + " has " + accounted.getBalance());
                }
               }
            }       
        }
}
