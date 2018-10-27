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

class Secretary extends Employee implements Bonus{ // Employee�� ��ӹ��� Bonus�� ����
   Secretary(){} //�⺻������
   
   public Secretary(String name, int number, String department,int salary){ //4���� �ʱⰪ �޴� ������
	   super(name,number,department,salary);
   }
   
  @Override
   public void incentive(int pay) { //�μ�Ƽ���� 80%
	  setSalary(getSalary()+(int)(pay*0.8));
   }
  
  @Override
  public double tax() { //���ݰ�� 10%
	  return getSalary() * 0.1;
  }
}

class Sales extends Employee implements Bonus{ //employee�� ��ӹ��� Bonus�� ����
	public Sales(){} //�⺻������
	
	public Sales(String name,int number,String department,int salary){ //�ʱⰪ�޴� ������ super�� employee���� ������ this�� �ٷ� �޾ƿ�
		 super(name,number,department,salary);
	}

	@Override
	public void incentive(int pay) { //�μ�Ƽ�� 120%
		setSalary(getSalary()+(int)(pay*1.2));
	}
	
	@Override
	public double tax() { //���ݰ�� 13%
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
      System.out.println("�μ�Ƽ�� 100 ����");
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
    		employees[i].salary += (100*0.8); //�μ�Ƽ������ 
    		tax = employees[i].salary/10; //tax ���
    			
    	  }else if(employees[i].department == "sales") {
    		  employees[i].salary += (100*1.2);
    		  tax = employees[i].salary*0.13; //tax ���
    	  }
    	*/
    		
      
	}
}



