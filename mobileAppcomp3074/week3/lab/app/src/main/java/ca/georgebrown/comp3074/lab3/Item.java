package ca.georgebrown.comp3074.lab3;

public class Item {
    private String largeText;
    private int smallText;
    private int icon;

    public Item(String largeText, int smallText, int icon) {
        this.largeText = largeText;
        this.smallText = smallText;
        this.icon = icon;
    }

    public String getLargeText() {
        return largeText;
    }

    public void setLargeText(String largeText) {
        this.largeText = largeText;
    }

    public String getSmallText() {
        return Integer.toString(smallText);
    }

    public void setSmallText(int smallText) {
        this.smallText += smallText;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
