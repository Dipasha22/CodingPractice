import java.util.*;

public  class Example2302 {
    public static void main(String[] args) {
      	  Student[] arr = new Student[3];
        arr[0] = new Student("S1", "Alice", 95);    // Fixed: Added id, name
        arr[1] = new Student("S2", "Bob", 79);
        arr[2] = new Student("S3", "Charlie", 93);
        
        System.out.println("Before: " + Arrays.toString(arr));
        
    	Arrays.sort(arr);
        
        System.out.println("After: " + Arrays.toString(arr));
    }
}
class Student implements Comparable<Student> {
     String id,name;
     int score;
    
    public Student(String id, String name,int score) {
        this.id=id;
        this.name=name;
        this.score=score;
    }
    
  	@Override
    public int compareTo(Student obj) {
        if(this.score > obj.score) 
            return 1;
        else if(this.score < obj.score) 
            return -1;
        else 
            return 0;
    }
    
    @Override
    public String toString() {
        return id + ": "+name+" "+score+"";
    }
}


