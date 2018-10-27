package com.test02;

class Account{
	String account;
	int balance;
	double interestRate;
	
	Account(){} //기본 생성자
	Account(String account,int balance,double interestRate){
		setAccount(account);
		setBalance(balance);
		setInterestRate(interestRate);
	}
	
	public void setAccount(String account) { //계좌
		this.account = account;
	}
	public String getAccount() {
		return account;
	}
	
	public void setBalance(int balance) { //잔액
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	
	public void setInterestRate(double interestRate) { //이자율
		this.interestRate = interestRate;
	}
	public double getInterestRate() {
		return interestRate;
	}
	
	public double calculateInterest() { //이자계산
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
		return "계좌정보: " + account + " 현재잔액: " + balance;
	}
}
public class AccountTest {
	public static void main(String[] args) {
		Account a = new Account("441-0290-1203",500000,7.3);
		System.out.println(a);
		a.deposit(20000);
		System.out.println(a);
		System.out.println("이자: " + a.calculateInterest());
	}
}
