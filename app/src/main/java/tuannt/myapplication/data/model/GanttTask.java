package tuannt.myapplication.data.model;

/**
 * Created by FRAMGIA\nguyen.thanh.tuan on 09/05/2017.
 */

public class GanttTask {

    private int mId;

    private String mName;

    private int mStartDay;

    private int mDueDay;

    public void setId(int id) {
        mId = id;
    }

    public int getId() {
        return mId;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getName() {
        return "Task " + mId;
    }

    public int getStartDay() {
        return mStartDay;
    }

    public void setStartDay(int startDay) {
        mStartDay = startDay;
    }

    public int getDueDay() {
        return mDueDay;
    }

    public void setDueDay(int dueDay) {
        mDueDay = dueDay;
    }
}
