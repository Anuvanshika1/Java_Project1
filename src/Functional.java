import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;



public class Functional {

	public static void main(String[] args) {
		
		
		//Task1
		System.out.println("Task 1:\n");
		//student array
		Student[] studentArray = {
				 new Student("Vijay","Kumar",48, "IT"),
				 new Student("Inder","Sidhu",66, "Science"),
				 new Student("Gurkirat","Singh",94, "IT"),
				 new Student("Rohit","Sharma",91, "Accounts"),
				 new Student("John","Jacobs",79, "Accounts"),
				 new Student("Gurpreet","Chahal",93, "Science"),
				 new Student("Rakesh","Singh",90, "IT")};
		
		//students arraylist
		List<Student> students = Arrays.asList(studentArray);
		System.out.println("Complete Student list:\n");
		students.stream().forEach(Student::display);
		
		//Task2
		System.out.println("Task 2:\n");
		System.out.println("Students who got 50.0-100.0 sorted by grade:");
		students.stream().filter(s -> (s.grade>=50.0 && s.grade<=100)).sorted(Comparator.comparingDouble(Student:: getGrade)).forEach(Student::display);
		
		//Task3
		System.out.println("\nTask 3:\n");
		System.out.println("First Student who got 50.0-100.0:");
		students.stream().filter(s -> (s.grade>=50.0 && s.grade<=100)).findFirst().get().display();

		//Task4
		System.out.println("\nTask 4:\n");
		System.out.println("Students in ascending order by last name then first:");
		List<Student> sortedList = students.stream().
				sorted((stu1, stu2) -> {
	            if(stu1.getLastName().compareTo(stu2.getLastName())==0)
	                return stu1.getFirstName().compareTo(stu2.getFirstName());
	            else if(stu1.getLastName().compareTo(stu2.getLastName())>0)
	                return 1;
	            else return -1;
		}).collect(Collectors.toList());
		sortedList.forEach(Student::display);
		
		System.out.println("\nStudents in descending order by last name then first:");
		List<Student> sortedListDesc = students.stream().
				sorted((stu1, stu2) -> {
	            if(stu1.getLastName().compareTo(stu2.getLastName())==0)
	                return stu1.getFirstName().compareTo(stu2.getFirstName());
	            else if(stu1.getLastName().compareTo(stu2.getLastName())>0)
	                return -1;
	            else return 1;
		}).collect(Collectors.toList());
		sortedListDesc.forEach(Student::display);

		//Task5
		System.out.println("\nTask 5:\n");
		System.out.println("Unique Student last names:");
		Set<String> uniquelastnames = students.stream().map(s -> s.lastName).collect(Collectors.toSet());
		uniquelastnames.stream().sorted().forEach(System.out::println);
		
		//Task6
		System.out.println("\nTask 6:\n");
		System.out.println("Student names in order by last name then first name: ");
		sortedList = students.stream().sorted(Comparator.comparing(Student:: getLastName)
				          .thenComparing(Student:: getFirstName)).collect(Collectors.toList());
		sortedList.forEach(Student::displayFullName);
		
		//Task7
	    System.out.println("\nTask 7:\n");
		System.out.println("Students by department: ");
		Map<String, List<Student>> departMap =  students.stream().collect(Collectors.groupingBy(Student::getDepartment));
		for(String key: departMap.keySet())
		{
			System.out.println(key);
			for(Student s: departMap.get(key))
			{
				System.out.print("   ");
				s.display();
			}
		}
		//Task8
	    System.out.println("\nTask 8:\n");
		System.out.println("Count of Students by department: ");
		Map<String, Long> departmentCountMap =  students.stream().collect(Collectors.groupingBy(Student::getDepartment,Collectors.counting()));
		for(String depString: departmentCountMap.keySet())
		{
			System.out.println(depString + " has "+departmentCountMap.get(depString)+" student(s)");
		}
		
		//Task 9
	    System.out.println("\nTask 9:\n");
		DoubleStream gradeStream1 = students.stream().mapToDouble(s -> s.getGrade());
		double sumGrades = gradeStream1.sum();
		System.out.println("Sum of Students' grades: "+sumGrades);
		
		//Task 10
	    System.out.println("\nTask 10:\n");
		DoubleStream gradeStream2 = students.stream().mapToDouble(s -> s.getGrade());
	    long count = gradeStream2.count();
	    double average = sumGrades/count;
		System.out.printf("Average of Students' grades: %.2f",average);

	}

}

