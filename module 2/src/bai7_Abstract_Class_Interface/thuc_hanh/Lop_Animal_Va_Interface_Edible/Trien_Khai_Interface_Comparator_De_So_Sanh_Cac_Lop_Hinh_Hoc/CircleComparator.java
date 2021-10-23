package bai7_Abstract_Class_Interface.thuc_hanh.Lop_Animal_Va_Interface_Edible.Trien_Khai_Interface_Comparator_De_So_Sanh_Cac_Lop_Hinh_Hoc;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}
