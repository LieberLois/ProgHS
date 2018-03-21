package WS1617.KlasseNotenvergabe;

import static WS1617.KlasseNotenvergabe.Exam.Course.GDI1;
import static WS1617.KlasseNotenvergabe.Exam.Course.PROG1;
import static WS1617.KlasseNotenvergabe.Exam.Course.SE1;

public class TranscriptOfRecords {
    Exam.Course[] courses = {GDI1, SE1, PROG1};
    Exam[] transcript = new Exam[courses.length];
    int matrNum;

    TranscriptOfRecords(int matrNum){
        for(int i = 0; i < transcript.length; i++){
            transcript[i] = new Exam(courses[i]);
        }
        this.matrNum = matrNum;
    }

    public void awardMark(Exam.Course course, int mark){
        for(int i = 0; i < transcript.length; i++){
            if(transcript[i].getCourse() == course){
                if (transcript[i].awardMark(mark)) {
                    transcript[i].awardMark(mark);
                } else {
                    System.out.println("Fehler bei der Notenvergabe!");
                }
            }
        }
    }

    public int getMark(Exam.Course course){
        for(Exam e : transcript){
            if(e.getCourse() == course){
                return e.getMark();
            }
        }
        return -1;
    }

    public double getAverage(){
        double average = 0d;

        for(Exam e : transcript){
            average += e.getMark();
        }


        return average/transcript.length;
    }
}
