package bai7_Abstract_Class_Interface.bai_tap.Trien_Khai_Interface_Colorable;

public class Square extends Shape implements Colorable {
    private double side;
    public Square(int side){
        this.side = side;

    }
    public double getArea(){
        return side*4;
    }
    public double getSide(){
        return side;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
    }


