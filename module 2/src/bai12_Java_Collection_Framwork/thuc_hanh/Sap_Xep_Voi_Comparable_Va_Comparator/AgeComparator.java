package bai12_Java_Collection_Framwork.thuc_hanh.Sap_Xep_Voi_Comparable_Va_Comparator;
import java.util.Comparator;
public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAge() > o2.getAge()){
            return 1;
        }else if(o1.getAge() == o2.getAge()){
            return 0;
        }else{
            return -1;
        }
    }
}

