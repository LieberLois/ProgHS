package WS1617.KlasseNotenvergabe;

public class TestKlasse {
    public static void main(String[] args) {
        TranscriptOfRecords transcript = new TranscriptOfRecords(4711);
        transcript.awardMark(Exam.Course.PROG1, 2);
        System.out.println("Prog1 Note: " + transcript.getMark(Exam.Course.PROG1));

    }
}
