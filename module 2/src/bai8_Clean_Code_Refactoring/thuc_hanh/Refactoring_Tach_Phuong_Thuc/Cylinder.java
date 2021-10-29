package bai8_Clean_Code_Refactoring.thuc_hanh.Refactoring_Tach_Phuong_Thuc;

   public class Cylinder {
        public static double getVolume(int radius, int height) {
                    double baseArea = getBaseArea(radius);
                    double perimeter = getPerimeter(radius);
                    double volume = perimeter * height + 2 * baseArea;
                    return volume;
                }

                private static double getPerimeter(int radius) {
                    return 2 * Math.PI * radius;
                }

                private static double getBaseArea(int radius) {
                    return Math.PI * radius * radius;
                }
            }
