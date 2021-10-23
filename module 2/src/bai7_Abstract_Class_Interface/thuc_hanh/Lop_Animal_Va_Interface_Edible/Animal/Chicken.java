package bai7_Abstract_Class_Interface.thuc_hanh.Lop_Animal_Va_Interface_Edible.Animal;

import bai7_Abstract_Class_Interface.thuc_hanh.Lop_Animal_Va_Interface_Edible.Edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }

    @Override
    public String howToEat() {
        return "could be fried";
    }
}