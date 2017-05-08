package tuannt.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerDay, mRecyclerTask;

    private HorizontalScrollView mHorizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        mRecyclerDay.setAdapter(new DayAdapter(integers));
        mRecyclerDay.setHasFixedSize(true);

        mHorizontalScrollView.setSmoothScrollingEnabled(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ArrayList<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Task task = new Task();
            task.setId(i);
            tasks.add(task);
        }
        mRecyclerTask.setLayoutManager(linearLayoutManager);
        mRecyclerTask.setAdapter(new TaskAdapter(tasks));
        mRecyclerTask.setHasFixedSize(true);

    }
}
