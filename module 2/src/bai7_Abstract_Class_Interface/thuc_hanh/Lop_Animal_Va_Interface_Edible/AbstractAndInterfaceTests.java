package bai7_Abstract_Class_Interface.thuc_hanh.Lop_Animal_Va_Interface_Edible;

import bai7_Abstract_Class_Interface.thuc_hanh.Lop_Animal_Va_Interface_Edible.Animal.Animal;
import bai7_Abstract_Class_Interface.thuc_hanh.Lop_Animal_Va_Interface_Edible.Animal.Chicken;
import bai7_Abstract_Class_Interface.thuc_hanh.Lop_Animal_Va_Interface_Edible.Animal.Tiger;
import bai7_Abstract_Class_Interface.thuc_hanh.Lop_Animal_Va_Interface_Edible.Edible.Edible;
import bai7_Abstract_Class_Interface.thuc_hanh.Lop_Animal_Va_Interface_Edible.Fruit.Apple;
import bai7_Abstract_Class_Interface.thuc_hanh.Lop_Animal_Va_Interface_Edible.Fruit.Fruit;
import bai7_Abstract_Class_Interface.thuc_hanh.Lop_Animal_Va_Interface_Edible.Fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
    }
}


