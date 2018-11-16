package com.app24.www.wbwp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Viewholder> implements View.OnClickListener {

    private List<CategoryItem> list;
    private Context context;
    private LayoutInflater inflater;
    private ItemClickListnear clickListnear;

    public  CategoryAdapter(Context context, List<CategoryItem> list, ItemClickListnear listnear){
        this.context=context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
        this.clickListnear=listnear;
    }
    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.category_row,viewGroup,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder viewholder, int i) {
        viewholder.categoryImg.setImageResource(list.get(i).getImg());
        viewholder.categoryTitle.setText(list.get(i).getName());
        viewholder.category.setOnClickListener(this);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
      //  clickListnear.onClick(v,list.get(pos));

    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView categoryImg;
        private TextView categoryTitle;
        ConstraintLayout category;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            categoryImg=itemView.findViewById(R.id.cateroryImg);
            categoryTitle=itemView.findViewById(R.id.cateroryTitle);
            category=itemView.findViewById(R.id.caterory);
        }
    }
}