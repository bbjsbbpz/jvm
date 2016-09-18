package bbjs.practice.compare;

import java.util.Comparator;

import bbjs.practice.object.Student;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		if(o1.getScore()>o2.getScore()){
			return 1;
		}else if(o1.getScore()<o2.getScore()){
			return -1;
		}else{
			return o2.getAge()-o1.getAge();
		}
	}
	
	public static void main(String[] args) {
		Student stu[] = { new Student("zhangsan", 20, 90.0f),
				new Student("lisi", 22, 90.0f),
				new Student("wangwu", 20, 99.0f),
				new Student("sunliu", 22, 98.0f) };
		System.out.println("========= before sort ===========");
		for (Student s : stu) {
			System.out.println(s);
		}
		System.out.println("========= after sort ===========");
		java.util.Arrays.sort(stu,new StudentComparator());
		for (Student s : stu) {
			System.out.println(s);
		}
	}

}
