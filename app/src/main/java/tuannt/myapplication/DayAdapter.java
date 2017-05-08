package tuannt.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tuannt on 5/8/17.
 * Project: MyApplication
 * Package: tuannt.myapplication
 */
public class DayAdapter extends RecyclerView.Adapter<DayAdapter.ViewHolder> {
    private ArrayList<Integer> mIntegers = new ArrayList<>();

    public DayAdapter(ArrayList<Integer> integers) {
        mIntegers = integers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day, parent,
            false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mIntegers.get(position));
    }

    @Override
    public int getItemCount() {
        return mIntegers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextDay;

        ViewHolder(View itemView) {
            super(itemView);
            mTextDay = (TextView) itemView.findViewById(R.id.text_day);
        }

        void bindData(int integer) {
            mTextDay.setText(String.valueOf(integer));
        }
    }
}
