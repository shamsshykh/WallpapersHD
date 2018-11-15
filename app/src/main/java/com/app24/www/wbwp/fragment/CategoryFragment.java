package com.app24.www.wbwp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app24.www.wbwp.R;
import com.app24.www.wbwp.adapters.CategoryAdapter;
import com.app24.www.wbwp.model.Categorymodel;
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
    private List<Categorymodel> listCategoryAdapter;
    private RecyclerView.LayoutManager layoutManager;


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_category, container, false);
        categoryList = view.findViewById(R.id.recyclerView);
        listCategoryAdapter=new ArrayList<>();
        layoutManager =new LinearLayoutManager(getContext());
        categoryList.setLayoutManager(layoutManager);
        categoryList.setItemAnimator(new DefaultItemAnimator());
        mAdapter=new CategoryAdapter(getContext(),listCategoryAdapter);
        categoryList.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        getCategory();

        return  view;
    }

    private void getCategory() {
    Categorymodel categorymodel=new Categorymodel();

        listCategoryAdapter.add(categorymodel);
    }

}
