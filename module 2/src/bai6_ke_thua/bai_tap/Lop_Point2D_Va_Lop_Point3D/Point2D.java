package bai6_ke_thua.bai_tap.Lop_Point2D_Va_Lop_Point3D;

public class Point2D {
    private float x = 0.0f;
    private float y = 0.0f;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Point2D(){

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float[] getXY(){
        float[] n = new float[2];
        n[0] = this.x;
        n[1] = this.y;
        return n;
    }

    @Override
    public String toString() {
        return "Point2D: " +
                "x: " +x+
                ", y: " +y;

    }
}
