package hse.course.android_lab2.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hse.course.android_lab2.R;


public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsViewHolder> {

    private final List<String> goods;

    public static class GoodsViewHolder extends RecyclerView.ViewHolder {

        private final TextView good;

        private final Button removeButton;

        public GoodsViewHolder(View view) {
            super(view);
            good = (TextView) view.findViewById(R.id.good);
            removeButton = (Button) view.findViewById(R.id.removeButton);
        }

        public TextView getGood() {
            return good;
        }

        public Button getRemoveButton() {
            return removeButton;
        }
    }

    public GoodsAdapter(List<String> goods) {
        this.goods = goods;
    }

    @NonNull
    @Override
    public GoodsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_item, viewGroup, false);
        return new GoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoodsViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.getGood().setText(goods.get(position));
        holder.getRemoveButton().setOnClickListener(v -> remove(position));
    }

    @Override
    public int getItemCount() {
        return goods.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void save(String productName) {
        if (productName == null || productName.isEmpty()) {
            return;
        }
        goods.add(productName);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void remove(int position) {
        goods.remove(position);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clear() {
        goods.clear();
        notifyDataSetChanged();
    }
}