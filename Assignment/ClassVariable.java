public class ClassVariable {
public static void main(String[] args) {
		Registration r1 = new Registration();
		Registration r2 = new Registration();
		Registration r3 = new Registration();
		r1.setId(1);
		r1.setName("ABC");
		r1.setBloodGroup("B+");
		r2.setId(2);
		r2.setName("DEF");
		r2.setBloodGroup("A+");
		r3.setId(3);
		r3.setName("GHI");
		r3.setBloodGroup("O+");
		r1.show();
		r2.show();
		r3.show();
		System.out.println("Number of donors registered is " + Registration.donors);
	}
}

class Registration {
	private int id;
	private String name, bloodGroup;
	static  int donors;
	public  Registration()
	{
		donors++;
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
	public void setBloodGroup(String bloodGroup)
	{
		this.bloodGroup = bloodGroup;
	}
	public String getBloodGroup()
	{
		return bloodGroup;
	}
	public void show()
	{
		System.out.println("id: " + id + ", name: " + name + ", bloodGroup: " + bloodGroup);
	}
}
