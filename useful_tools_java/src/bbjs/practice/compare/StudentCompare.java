package bbjs.practice.compare;

class StudentCompare implements Comparable<StudentCompare> {
	private String name;
	private int age;
	private float score;

	public StudentCompare(String name, int age, float score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public String toString() {
		return name + " " + age + " " + score;
	}

	@Override
	public int compareTo(StudentCompare o) {
		// TODO Auto-generated method stub
		/*if (this.score > o.score)// score是private的，为什么能够直接调用,这是因为在Student类内部
			return -1;// 由高到底排序
		else if (this.score < o.score)
			return 1;
		else {
			if (this.age > o.age)
				return 1;// 由底到高排序
			else if (this.age < o.age)
				return -1;
			else
				return 0;
		}*/
		
		if(this.score!=o.score){
			return (int)(this.score-o.score);
		}else{
			return this.age-o.age;
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentCompare stu[] = { new StudentCompare("zhangsan", 20, 90.0f),
				new StudentCompare("lisi", 22, 90.0f),
				new StudentCompare("wangwu", 20, 99.0f),
				new StudentCompare("sunliu", 22, 100.0f) };
		java.util.Arrays.sort(stu);
		for (StudentCompare s : stu) {
			System.out.println(s);
		}
	}
}
