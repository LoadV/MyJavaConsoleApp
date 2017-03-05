import com.google.gson.Gson;

public class Main
{

	public static void main(String[] args) {
		Gson gson = new Gson();
		Student student = new Student();
		student.name = "";
		student.content="";
		System.out.println( gson.toJson(student));
	}

}
class Student
{
	String name;
	String content;
}

