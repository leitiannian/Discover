package com.example.discover.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.discover.R;
import com.example.discover.adapter.AuthorPopAdapter;
import com.example.discover.adapter.CategoryPopAdapter;
import com.example.discover.bean.CategoryDetailBean.ItemList;
import com.example.discover.bean.CategoryDetailBean.SectionList;

import java.util.List;

/**
 * Created by monkeyWiiu on 2018/1/18.
 */

public class DatabingUtil {

    @BindingAdapter("authorData")
    public static void setAuthorData(RecyclerView view, List<ItemList> lists) {
        AuthorPopAdapter authorPopAdapter = new AuthorPopAdapter(view.getContext());
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext()
                , LinearLayoutManager.HORIZONTAL, false);
        authorPopAdapter.addAll(lists);
        view.setLayoutManager(manager);
        view.setAdapter(authorPopAdapter);
    }

    @BindingAdapter("categoryData")
    public static void setCategoryData(RecyclerView view, List<ItemList> list) {

        CategoryPopAdapter categoryPopAdapter = new CategoryPopAdapter(view.getContext());
        categoryPopAdapter.addAll(list);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext()
                , LinearLayoutManager.HORIZONTAL, false);
        view.setLayoutManager(manager);
        view.setAdapter(categoryPopAdapter);
    }

    @BindingAdapter("imageUrl")
    public static void setImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url)
                .crossFade(800)
                .placeholder(R.drawable.cross_image)
                .error(R.drawable.cross_image)
                .into(view);
    }
}