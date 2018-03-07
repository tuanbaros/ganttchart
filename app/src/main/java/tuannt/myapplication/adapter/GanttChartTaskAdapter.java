package tuannt.myapplication.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import tuannt.myapplication.R;
import tuannt.myapplication.data.model.GanttList;
import tuannt.myapplication.data.model.GanttTask;

/**
 * Created by tuannt on 5/8/17.
 * Project: MyApplication
 * Package: tuannt.myapplication
 */
public class GanttChartTaskAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int LIST_TYPE = 0;
    private static final int TASK_TYPE = 1;

    private ArrayList mList = new ArrayList<>();

    public GanttChartTaskAdapter(ArrayList list) {
        mList = list;
    }

    @Override
    public int getItemViewType(int position) {
        if (mList.get(position) instanceof GanttTask) {
            return TASK_TYPE;
        }
        return LIST_TYPE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == TASK_TYPE) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_ganttchart_task, parent, false);
            return new TaskViewHolder(view);
        }
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ganttchart_list, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (mList.get(position) instanceof GanttTask) {
            GanttTask task = (GanttTask) mList.get(position);
            ((TaskViewHolder) holder).bindData(task);
            return;
        }
        GanttList list = (GanttList) mList.get(position);
        ((ListViewHolder) holder).bindData(list);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    private class TaskViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextTask;

        private CardView mCardView;

        private int mWidthUnit;

        TaskViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView.findViewById(R.id.card_task_name);
            mTextTask = (TextView) itemView.findViewById(R.id.text_task_name);
            mWidthUnit = itemView.getContext().getResources().getDimensionPixelSize(R.dimen.dp_41);
        }

        void bindData(GanttTask task) {
            RelativeLayout.LayoutParams params =
                (RelativeLayout.LayoutParams) mCardView.getLayoutParams();
            params.leftMargin = task.getStartDay() * mWidthUnit - 1;
            params.width = task.getDueDay() * mWidthUnit - 8;
            mCardView.setLayoutParams(params);
            mTextTask.setText(task.getName());
        }

    }

    private class ListViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextList;

        ListViewHolder(View itemView) {
            super(itemView);
            mTextList = (TextView) itemView.findViewById(R.id.text_list_name);

        }

        void bindData(GanttList list) {
            mTextList.setText(list.getName());
            mTextList.setBackgroundColor(list.getColor());
        }

    }
}
