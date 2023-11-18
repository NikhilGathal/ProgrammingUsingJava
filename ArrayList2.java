import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Participant {
    private String participantName;
    private String participantTalent;
    private double participantScore;

    public Participant(String participantName, String participantTalent, double participantScore) {
        this.participantName = participantName;
        this.participantTalent = participantTalent;
        this.participantScore = participantScore;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantTalent() {
        return participantTalent;
    }

    public void setParticipantTalent(String participantTalent) {
        this.participantTalent = participantTalent;
    }

    public double getParticipantScore() {
        return participantScore;
    }

    public void setParticipantScore(double participantScore) {
        this.participantScore = participantScore;
    }

    @Override
    public String toString() {
        return "Participant Name: " + getParticipantName() + ", Participant Talent: " + getParticipantTalent()
                + ", Participant Score: " + getParticipantScore();
    }

}

class Tester {

    public static List<Participant> generateListOfFinalists(Participant[] finalists) {
        // Implement your logic here and change the return statement accordingly

        List<Participant> participantList = new ArrayList<>();
        for (Participant p : finalists)
            participantList.add(p);
        return participantList;
    }

    public static List<Participant> getFinalistsByTalent(List<Participant> finalists, String talent) {
        // Implement your logic here and change the return statement accordingly
        // List<Participant> list = new ArrayList<Participant>();
        // for (Participant p : finalists)
        // if (p.getParticipantTalent().equals(talent))
        // list.add(p);
        // return list;

        Iterator<Participant> it = finalists.iterator();

        while (it.hasNext()) {
            if (!it.next().getParticipantTalent().equals(talent))
                it.remove();
        }
        return finalists;
    }

    public static void main(String[] args) {
        Participant finalist1 = new Participant("Hazel", "Singing", 91.2);
        Participant finalist2 = new Participant("Ben", "Instrumental", 95.7);
        Participant finalist3 = new Participant("John", "Singing", 94.5);
        Participant finalist4 = new Participant("Bravo", "Singing", 97.6);

        Participant[] finalists = { finalist1, finalist2, finalist3, finalist4 };

        List<Participant> finalistsList = generateListOfFinalists(finalists);

        System.out.println("Finalists");
        for (Participant finalist : finalistsList)
            System.out.println(finalist);

        String talent = "Singing";
        System.out.println("Finalists in " + talent + " category");

        List<Participant> finalistsCategoryList = getFinalistsByTalent(finalistsList, talent);
        for (Participant finalist : finalistsCategoryList)
            System.out.println(finalist);
    }

}