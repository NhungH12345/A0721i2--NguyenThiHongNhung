package bai4_lop_va_doi_tuong_trong_java.bai_tap.Xay_Dung_Lop_StopWatch;

public class StopWatch {
        private long startTime;
        private long endTime;
        public StopWatch(){
            startTime = System.currentTimeMillis();
        }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    public void start(){
            startTime = System.currentTimeMillis();
        }
    public void stop() {
        endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
            return endTime - startTime;
}
}
