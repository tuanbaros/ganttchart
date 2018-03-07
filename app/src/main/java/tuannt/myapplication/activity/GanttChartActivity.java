package tuannt.myapplication.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.HorizontalScrollView;
import java.util.ArrayList;
import java.util.Random;
import tuannt.myapplication.R;
import tuannt.myapplication.adapter.GanttChartDayAdapter;
import tuannt.myapplication.adapter.GanttChartTaskAdapter;
import tuannt.myapplication.data.model.GanttList;
import tuannt.myapplication.data.model.GanttTask;

public class GanttChartActivity extends AppCompatActivity {

    private RecyclerView mRecyclerDay, mRecyclerTask;

    private HorizontalScrollView mHorizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gantt_chart_layout);
        viewById();
        setUpView();
    }

    private void viewById() {
        mRecyclerDay = (RecyclerView) findViewById(R.id.recycler_day);
        mRecyclerTask = (RecyclerView) findViewById(R.id.recycler_task);
        mHorizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizontal_scroll);
    }

    private void setUpView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager
                .HORIZONTAL, false);
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            integers.add(i);
        }
        mRecyclerDay.setLayoutManager(manager);
        mRecyclerDay.setAdapter(new GanttChartDayAdapter(integers));
        mRecyclerDay.setHasFixedSize(true);

        mHorizontalScrollView.setSmoothScrollingEnabled(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ArrayList tasks = new ArrayList<>();
        for (int i = 0; i < 20000; i++) {
            if (i % 5 == 0) {
                GanttList ganttList = new GanttList();
                ganttList.setName("List " + i);
                ganttList.setColor(Color.RED);
                tasks.add(ganttList);
                continue;
            }
            GanttTask task = new GanttTask();
            task.setId(i);
            task.setStartDay(randomDay());
            task.setDueDay(randomDay());
            tasks.add(task);
        }
        mRecyclerTask.setLayoutManager(linearLayoutManager);
        mRecyclerTask.setAdapter(new GanttChartTaskAdapter(tasks));
        mRecyclerTask.setHasFixedSize(true);
    }

    int randomDay() {
        Random random = new Random();
        int i = random.nextInt(10);
        return i > 0 ? i : 1;
    }
}
