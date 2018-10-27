package com.test02;

class Account{
	String account;
	int balance;
	double interestRate;
	
	Account(){} //�⺻ ������
	Account(String account,int balance,double interestRate){
		setAccount(account);
		setBalance(balance);
		setInterestRate(interestRate);
	}
	
	public void setAccount(String account) { //����
		this.account = account;
	}
	public String getAccount() {
		return account;
	}
	
	public void setBalance(int balance) { //�ܾ�
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	
	public void setInterestRate(double interestRate) { //������
		this.interestRate = interestRate;
	}
	public double getInterestRate() {
		return interestRate;
	}
	
	public double calculateInterest() { //���ڰ��
		double interest = getBalance() * getInterestRate()/100;
		return interest;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) {
		balance -= money;
	}
	
	@Override
	public String toString() {
		return "��������: " + account + " �����ܾ�: " + balance;
	}
}
public class AccountTest {
	public static void main(String[] args) {
		Account a = new Account("441-0290-1203",500000,7.3);
		System.out.println(a);
		a.deposit(20000);
		System.out.println(a);
		System.out.println("����: " + a.calculateInterest());
	}
}
