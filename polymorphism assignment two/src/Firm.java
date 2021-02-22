
public class Firm {

	public static void main(String[] args) {

		Staff personnel = new Staff(); 
		personnel.payday();
		
	}

}

 // ------------- Staff Class -----------------------

class Staff 
{ 
	StaffMember[] staffList; 


	public Staff () {
	 
		staffList = new StaffMember[8]; 
		staffList[0] = new Executive ("Daniel", "SY-230 Sunyani", 
				"024343439", "Da-123237", 2021.05); 
		staffList[1] = new Employee ("Dorothy", "SY-237 Sunyani", 
				"020256767", "Do-292345", 1040.10); 
		staffList[2] = new Employee ("Mohammed", "SY-111 Sunyani", 
				"027123435", "Mo-756246", 1160.25); 
		staffList[3] = new Hourly ("Rahinna", "SY-354a Sunyani", 
				"024378946", "958-47-3625", 10.55); 
		staffList[4] = new Volunteer ("Elorm", "SY-792a Sunyani", 
				"024977565") ; 
		staffList[5] = new Volunteer ("Mildred", "SY-430 Sunyani", 
				"050877766"); 
		staffList[6] = new Commission ("Yayra", "SY-579 Sunyani", 
				"024778778", "Ya-990237", 6.25, 0.2 );
		staffList[7] = new Commission("Rita", "SY-889 Sunyani",
				"024122477", "Ri-370370", 9.75, 0.15);

		((Executive) staffList[0]).awardBonus (500.00); 
		((Hourly) staffList[3]).addHours (40); 

		((Commission) staffList[6]).addHours(35);
		((Commission) staffList[6]).addSales(400);
		((Commission) staffList[7]).addHours(40);
		((Commission) staffList[7]).addSales(950);

	} 

	public void payday () {
	
		double amount; 
		for (int count=0; count < staffList.length; count++) {
		
			System.out.println (staffList[count]); 
			amount = staffList[count].pay();  
			System.out.println ("Paid: " + amount); 
			System.out.println ("------------------------------------"); 
		} 
	} 
} 

   // ------------- StaffMember Class ------------------

abstract class StaffMember {

	protected String name;
	protected String address;
	protected String phone;

	public StaffMember (String name, String address, String phone) {
	
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String toString() {
		return ("Name: " + name + "\n"  + "Address: " + address + "\n"
				+ "Phone: " + phone);
	}
	public abstract double pay();
}


   // ----------------- Volunteer Class ----------------------------


class Volunteer extends StaffMember {

	public Volunteer (String name, String address, String phone) {
		super (name, address, phone);
	}
	public double pay() {
		return 0.0;
	}
}

    //--------------- Employee Class -----------------------


class Employee extends StaffMember {

	protected String socialSecurityNumber;
	protected double payRate;


	public Employee (String name, String adddress, String phone,
			String 	socialSecurityNumber, double payRate) {
	
		super (name, adddress, phone);
		this.socialSecurityNumber = 	socialSecurityNumber;
		this.payRate = payRate;
	}
	public String toString() {
		return super.toString() + "\nSocial Security Number: " + socialSecurityNumber;

	}
	public double pay() {
		return payRate;
	}
}

    //------------- Executive Class -----------------------

class Executive extends Employee {

	private double bonus;

	public Executive (String name, String address, String phone,
			String 	socialSecurityNumber, double payRate) {
	
		super (name, address, phone, 	socialSecurityNumber, payRate);
		bonus = 0;  
	}
	public void awardBonus (double bonus) {
		this.bonus = bonus;
	}
	public double pay() {
		double payment = super.pay() + bonus;
		return payment;
	}
}

     //----------------- Hourly Class ----------------------


class Hourly extends Employee {

	private int hoursWorked;

	public Hourly (String name, String address, String phone,
			String 	socialSecurityNumber, double payRate) {

		super (name, address, phone, socialSecurityNumber, payRate);
		hoursWorked = 0;
	}
	public void addHours (int moreHours) {
		hoursWorked += moreHours;
	}
	public double pay() {
		double payment = payRate * hoursWorked;
		return payment;
	}
	public String toString()  {
		return super.toString() + "\nCurrent hours: " + hoursWorked;

	}
}

	//------------------- Commission Class ----------------------


class Commission extends Hourly {
	double totalSales;
	double commission;

	public Commission(String name, String address, String phone,String 	socialSecurityNumber,
			double payRate, double commission) {

		super(name, address, phone, socialSecurityNumber, payRate);
		this.commission = commission;
		totalSales = 0;
	}
	public void addSales(double totalSales) {
		this.totalSales += totalSales;
	}
	public double pay() {
		double payment = super.pay() + (commission * totalSales );
		return payment;
	}

	public String toString() {
		return super.toString() + "\ntotal sales is " + totalSales;
	}
}













