import java.util.Objects;


public class Student {
	String firstName;
	String lastName;
	double grade;
	String department;
	
	public Student(String firstName, String lastName, double grade, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.department = department;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getName()
	{
		return firstName + " " + lastName;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", grade=" + grade + ", department="
				+ department + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, firstName, grade, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(department, other.department) && Objects.equals(firstName, other.firstName)
				&& Double.doubleToLongBits(grade) == Double.doubleToLongBits(other.grade)
				&& Objects.equals(lastName, other.lastName);
	}
	
	public void display()
	{
		 System.out.format("%-9s      %-9s       %.2f          %s\n" , firstName, lastName, grade, department);
	}
	
	public void displayFullName() {
		System.out.println(getName());
	}
	
}