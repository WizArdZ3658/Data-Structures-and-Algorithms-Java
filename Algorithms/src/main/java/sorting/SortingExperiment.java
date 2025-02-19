package sorting;

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
        return "sorting.ReportCard{" +
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
        return Integer.compare(o1.getChemistry(), o2.getChemistry());
    }
}


public class SortingExperiment {

    public static void main(String[] args) {

//        List<sorting.ReportCard> reportCards = new ArrayList<>();
//        reportCards.add(new sorting.ReportCard(99, 93, 92));
//        reportCards.add(new sorting.ReportCard(99, 99, 95));
//        reportCards.add(new sorting.ReportCard(91, 95, 92));
//        reportCards.add(new sorting.ReportCard(91, 95, 99));
//        reportCards.add(new sorting.ReportCard(89, 83, 82));
//
//        reportCards.sort(new sorting.CustomComparator());
//
//        for (sorting.ReportCard reportCard : reportCards) {
//            System.out.println(reportCard);
//        }


        ReportCard[] arr = new ReportCard[5];
        arr[0] = new ReportCard(99, 93, 92);
        arr[1] = new ReportCard(99, 99, 95);
        arr[2] = new ReportCard(91, 95, 92);
        arr[3] = new ReportCard(91, 95, 99);
        arr[4] = new ReportCard(89, 83, 82);
        Arrays.sort(arr, new CustomComparator());

        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
    }
}
