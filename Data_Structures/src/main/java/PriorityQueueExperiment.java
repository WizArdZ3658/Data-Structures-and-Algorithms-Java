import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
class ReportCard {
    private Integer maths;
    private Integer physics;
    private Integer chemistry;

    public ReportCard(Integer maths, Integer physics, Integer chemistry) {
        this.maths = maths;
        this.physics = physics;
        this.chemistry = chemistry;
    }

    @Override
    public String toString() {
        return "ReportCard{" +
                "maths=" + maths +
                ", physics=" + physics +
                ", chemistry=" + chemistry +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ReportCard that = (ReportCard) o;
        return Objects.equals(maths, that.maths) && Objects.equals(physics, that.physics) && Objects.equals(chemistry, that.chemistry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maths, physics, chemistry);
    }
}


class CustomComparator implements Comparator<ReportCard> {

    @Override
    public int compare(ReportCard o1, ReportCard o2) {
        if (!Objects.equals(o1.getMaths(), o2.getMaths())) {
            return Integer.compare(o2.getMaths(), o1.getMaths());
        }
        if (!Objects.equals(o1.getPhysics(), o2.getPhysics())) {
            return Integer.compare(o2.getPhysics(), o1.getPhysics());
        }
        return Integer.compare(o2.getChemistry(), o1.getChemistry());
    }
}


public class PriorityQueueExperiment {

    public static void main(String[] args) {
        PriorityQueue<ReportCard> q = new PriorityQueue<>(new CustomComparator());
        q.add(new ReportCard(99, 93, 92));
        q.add(new ReportCard(99, 99, 95));
        q.add(new ReportCard(91, 95, 92));
        q.add(new ReportCard(91, 95, 99));
        q.add(new ReportCard(89, 83, 82));
        System.out.println(q.peek());
        while(!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
