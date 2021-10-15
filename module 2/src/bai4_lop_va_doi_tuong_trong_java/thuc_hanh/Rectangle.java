package bai4_lop_va_doi_tuong_trong_java.thuc_hanh;

public class Rectangle {
    double width, height;
    public Rectangle(){

    }
    public Rectangle(double weight,double height ){
        this.width = weight;
        this.height = height;
    }

    public double getArea() {

        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }

}
