public class ArrayOfObjectsandEncapsulation {
public static void main(String[] args) {
		Employee [] employee = new Employee[5];
		Employee e1 = new Employee(1, "A", "a@gmail.com", "111", 1000);
		Employee e2 = new Employee(2, "B", "b@gmail.com", "222", 2000);
		Employee e3 = new Employee(3, "C", "c@gmail.com", "333", 3000);
		Employee e4 = new Employee(4, "D", "d@gmail.com", "444", 4000);
		Employee e5 = new Employee(5, "E", "e@gmail.com", "555", 5000);
		employee[0] = e1;
		employee[1] = e2;
		employee[2] = e3;
		employee[3] = e4;
		employee[4] = e5;
		float maxSal  = employee[0].getSalary(), minSal = employee[0].getSalary(), avgSal = 0;
		for (int i = 0; i < 5; i++)
		{
			if (maxSal < employee[i].getSalary())
				maxSal = employee[i].getSalary();
			if (minSal > employee[i].getSalary())
				minSal = employee[i].getSalary();
			    avgSal += employee[i].getSalary();
		}
		System.out.println("Max Salary= " + maxSal);
		System.out.println("Min Salary= " + minSal);
		System.out.println("Average Salary= " + (avgSal / 5));
	}
}

class Employee {
	private int id;
	private String name, email, phone;
	private float salary;
	public  Employee(int id, String name, String email, String phone, float salary)
	{
		this.id     =     id;
		this.name   =   name;
		this.email  =  email;
		this.phone  =  phone;
		this.salary = salary;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return email;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setSalary(float salary)
	{
		this.salary = salary;
	}
	public float getSalary()
	{
		return salary;
	}
	public void show()
	{
		System.out.println("id: " + id + ", name: " + name + ", email: " + email + ", phone: " + phone + ", salary: " + salary);
	}
}
