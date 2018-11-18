package com.app24.www.wbwp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app24.www.wbwp.R;
import com.app24.www.wbwp.adapters.CategoryAdapter;
import com.app24.www.wbwp.interfaces.ItemClickListnear;
import com.app24.www.wbwp.model.CategoryItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {
    private  View view;
    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private CategoryAdapter mAdapter;
    private RecyclerView categoryList;
    private List<CategoryItem> listOfCategory;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_category, container, false);
        categoryList = view.findViewById(R.id.recyclerView);
        listOfCategory=new ArrayList<>();
        categoryList.setLayoutManager(new GridLayoutManager(getContext(),2));
        categoryList.setItemAnimator(new DefaultItemAnimator());
        mAdapter=new CategoryAdapter(getContext(), listOfCategory, new ItemClickListnear() {
            @Override
            public void onItemClick(View view, int pos) {

            }
        });
        categoryList.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        getCategory();
        return  view;
    }
    private void getCategory() {
        listOfCategory.add(new CategoryItem("Nature",R.drawable.ic_favorite_black_24dp));
        listOfCategory.add(new CategoryItem("Cartoon",R.drawable.ic_favorite_black_24dp));
        listOfCategory.add(new CategoryItem("Abstract",R.drawable.ic_favorite_black_24dp));
        listOfCategory.add(new CategoryItem("Classic",R.drawable.ic_favorite_black_24dp));
        listOfCategory.add(new CategoryItem("Colorful",R.drawable.ic_favorite_black_24dp));
        listOfCategory.add(new CategoryItem("Animals",R.drawable.ic_favorite_black_24dp));
        listOfCategory.add(new CategoryItem("Fashion",R.drawable.ic_favorite_black_24dp));
        listOfCategory.add(new CategoryItem("Love",R.drawable.ic_favorite_black_24dp));
        listOfCategory.add(new CategoryItem("Games",R.drawable.ic_favorite_black_24dp));
        listOfCategory.add(new CategoryItem("Dark",R.drawable.ic_favorite_black_24dp));
        listOfCategory.add(new CategoryItem("Celebrity",R.drawable.ic_favorite_black_24dp));
        listOfCategory.add(new CategoryItem("Sports",R.drawable.ic_favorite_black_24dp));
    }

}
