package bai6_ke_thua.bai_tap.Lop_Point2D_Va_Lop_Point3D;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }
    public Point3D(){
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
        setXY(x, y);
        this.z=z;
    }

    public float[] getXYZ(){
        float[] n=new float[3];
        n[0]=this.z;
        n[1]=this.z;
        n[2]=this.z;
        return n;
    }

    @Override
    public String toString(){
        return "Point3D: "+
                " " +getX()+
                " " +getY()+
                " " +getZ();
    }

}
