package com.app24.www.wbwp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app24.www.wbwp.R;
import com.app24.www.wbwp.interfaces.ItemClickListnear;
import com.app24.www.wbwp.model.CategoryItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Viewfinders> {


    private List<CategoryItem> list;
    private Context context;
    private LayoutInflater inflater;
    private ItemClickListnear clickListnear;

    public CategoryAdapter(Context context, List<CategoryItem> list, ItemClickListnear listnear) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
        this.clickListnear = listnear;
    }

    @NonNull
    @Override
    public Viewfinders onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.category_row, viewGroup, false);
        return new Viewfinders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewfinders viewholder, final int i) {
        viewholder.cateroryImg.setImageResource(list.get(i).getImg());
        viewholder.cateroryTitle.setText(list.get(i).getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewfinders extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.cateroryImg)
        ImageView cateroryImg;
        @BindView(R.id.cateroryTitle)
        TextView cateroryTitle;
        Viewfinders(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            clickListnear.onItemClick(v,getAdapterPosition());

        }
    }


}