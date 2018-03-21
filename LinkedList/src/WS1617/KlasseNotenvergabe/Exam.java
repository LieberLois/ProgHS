package WS1617.KlasseNotenvergabe;

public class Exam {

    private final Course course;
    private int mark;
    private int trial;

    Exam(Course course){
        this.course = course;
        mark = 0;
        trial = 0;
    }

    public boolean awardMark(int mark){
        if(1 <= mark && mark <= 5 && trial < 3  && (this.mark == 5 ||  this.mark == 0)){
            this.mark = mark;
            trial++;
            return true;
        }
        return false;
    }

    public boolean failedFinally(){
        return (mark == 5 && trial == 3);
    }

    public String toString(){
        String output = "";

        output += "Course: " + course + " Mark: " + mark + " Trial: " + trial;
        return output;
    }


    public enum Course{
        PROG1, SE1, GDI1;
    }

    public Course getCourse() {
        return course;
    }

    public int getMark() {
        return mark;
    }

    public int getTrial() {
        return trial;
    }


}
