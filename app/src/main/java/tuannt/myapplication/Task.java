package tuannt.myapplication;

/**
 * Created by tuannt on 5/8/17.
 * Project: MyApplication
 * Package: tuannt.myapplication
 */
public class Task {

    private int mId;

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return "Task " + mId;
    }
}
