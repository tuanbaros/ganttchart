package tuannt.myapplication.data.model;

/**
 * Created by FRAMGIA\nguyen.thanh.tuan on 09/05/2017.
 */

public class GanttList {
    private String mName;
    private int mColor;
    private int mId;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
