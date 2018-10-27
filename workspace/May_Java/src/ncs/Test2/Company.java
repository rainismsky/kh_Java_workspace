package ncs.Test2;


interface Bonus{
  void incentive(int pay);
}

abstract class Employee{
   private String name;
   private int number;
   private String department;
   private int salary;
   
   Employee(){}
   
   Employee(String name,int number,String department,int salary){
      super();
      this.name=name;
      this.number=number;
      this.department=department;
      this.salary=salary;
   }
   
   public abstract double tax();
   
   public void setName(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }
   
   public void setNumber(int number) {
      this.number = number;
   }
   public int getNumber() {
      return number;
   }
   
   public void setDepartment(String department) {
      this.department = department;
   }
   public String getDepartment() {
      return department;
   }
   
   public void setSalary(int salary) {
      this.salary = salary;
   }
   public int getSalary() {
      return salary;
   }
}

class Secretary extends Employee implements Bonus{ // Employee를 상속받음 Bonus를 구현
   Secretary(){} //기본생성자
   
   public Secretary(String name, int number, String department,int salary){ //4개의 초기값 받는 생성자
	   super(name,number,department,salary);
   }
   
  @Override
   public void incentive(int pay) { //인센티브계산 80%
	  setSalary(getSalary()+(int)(pay*0.8));
   }
  
  @Override
  public double tax() { //세금계산 10%
	  return getSalary() * 0.1;
  }
}

class Sales extends Employee implements Bonus{ //employee를 상속받음 Bonus를 구현
	public Sales(){} //기본생성자
	
	public Sales(String name,int number,String department,int salary){ //초기값받는 생성자 super인 employee에서 구현된 this로 바로 받아옴
		 super(name,number,department,salary);
	}

	@Override
	public void incentive(int pay) { //인센티브 120%
		setSalary(getSalary()+(int)(pay*1.2));
	}
	
	@Override
	public double tax() { //세금계산 13%
		return getSalary() * 0.13;
	}	
}

public class Company {
	public static void main(String[] args) {
      Employee[] employees = new Employee[2]; 
      employees[0] = new Secretary("Hilery",1,"secretary",800);
      employees[1] = new Sales("Clinten",2,"sales",1200);
      double tax = 0;
     /* Secretary sc = new Secretary();
      Sales sl = new Sales();*/
     
      System.out.println("name\tdepartment\tsalary");
      System.out.println("-------------------------------");
      
      for(int i=0;i<employees.length;i++) {
    	System.out.println(employees[i].getName() + "\t" 
    						+ employees[i].getDepartment() + "\t" 
    						+ employees[i].getSalary());
     }
      
      System.out.println();
      System.out.println("인센티브 100 지급");
      System.out.println("name\tdepartment\tsalary\ttax");
      System.out.println("-------------------------------------");
      
      for(int i=0;i<employees.length;i++) {
    	  if(employees[i] instanceof Secretary) {
    		  Secretary s = (Secretary) employees[i];
    		  s.incentive(100);
    	  }
    	  if(employees[i] instanceof Sales) {
    		  Sales s = (Sales) employees[i];
    		  s.incentive(100);
    	  }
      }
      for(int i=0; i<employees.length;i++) {
    	  
    	  System.out.println(employees[i].getName() + "\t" 
					+ employees[i].getDepartment() + "\t" 
					+ employees[i].getSalary() + "\t"
					+ employees[i].tax());
      }
    	/*if(employees[i].department == "secretary") {
    		employees[i].salary += (100*0.8); //인센티브지급 
    		tax = employees[i].salary/10; //tax 계산
    			
    	  }else if(employees[i].department == "sales") {
    		  employees[i].salary += (100*1.2);
    		  tax = employees[i].salary*0.13; //tax 계산
    	  }
    	*/
    		
      
	}
}



