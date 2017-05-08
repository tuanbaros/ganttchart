package tuannt.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tuannt on 5/8/17.
 * Project: MyApplication
 * Package: tuannt.myapplication
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private static final int NULL_TYPE = 0;
    private static final int TASK_TYPE = 1;

    private ArrayList<Task> mTasks = new ArrayList<>();

    public TaskAdapter(ArrayList<Task> tasks) {
        mTasks = tasks;
    }

//    @Override
//    public int getItemViewType(int position) {
//        if (mTasks.get(position) == null) {
//            return NULL_TYPE;
//        }
//        return TASK_TYPE;
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent,
            false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = mTasks.get(position);
        holder.bindData(task);
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextTask;

        private int mWidthUnit;

        private int mDp1;

        ViewHolder(View itemView) {
            super(itemView);
            mWidthUnit = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.dp_41);
            mDp1 = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.dp_1);
            mTextTask = (TextView) itemView.findViewById(R.id.text_task_name);
        }

        void bindData(Task task) {
            RelativeLayout.LayoutParams params =
                (RelativeLayout.LayoutParams) mTextTask.getLayoutParams();
            params.leftMargin = randomDay() * mWidthUnit;
            int random = randomDay();
            params.width = (random < 3 ? 3 : random) * mWidthUnit - mDp1;
            mTextTask.setLayoutParams(params);
            mTextTask.setText(task.getName());
        }

        int randomDay() {
            Random random = new Random();
            return random.nextInt(10);
        }
    }
}
