package com.example.smarttvremote.Smart_Main;

public class AppsDomain {
    private String title;
    private String pic;

    public AppsDomain(String title, String pic){
        this.title = title;
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
