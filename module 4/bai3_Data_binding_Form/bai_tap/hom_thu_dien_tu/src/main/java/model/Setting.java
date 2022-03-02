package model;

public class Setting {
    private String languages;
    private int pagesize;
    private boolean spamsfilter;
    private String signature;

    public Setting() {
    }

    public Setting(String languages, int pagesize, boolean spamsfilter, String signature) {
        this.languages = languages;
        this.pagesize = pagesize;
        this.spamsfilter = spamsfilter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public boolean isSpamsfilter() {
        return spamsfilter;
    }

    public void setSpamsfilter(boolean spamsfilter) {
        this.spamsfilter = spamsfilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

