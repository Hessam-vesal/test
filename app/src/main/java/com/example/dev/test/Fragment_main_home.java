package com.example.dev.test;


import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.inputmethod.InputMethodManager;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_main_home extends Fragment {

    public static Fragment_main_home newInstance() {
        return new Fragment_main_home();
    }


    private List<Model_Post_Home> model_post_homes = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerViewHomeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.Fragment_Main_Home_RecyclerView);

        runAnimation(recyclerView, 1);
        prepareMovieData();

        return view;
    }

    private void prepareMovieData() {

        Model_Post_Home model_post_home = new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "Khoob", "52");
        model_post_homes.add(model_post_home);
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));
        model_post_homes.add(new Model_Post_Home(R.drawable.ghoozhism, "Ghoozh", "12:14", "10", "52"));

    }

    private void runAnimation(RecyclerView recyclerView, int type) {
        Context context = recyclerView.getContext();
        LayoutAnimationController controller = null;

        if (type == 0) {
            controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_fall_down);
        } else if (type == 1) {
            controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_slide_from_button);
        } else if (type == 2) {
            controller = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_slide_from_right);
        }
        RecyclerViewHomeAdapter adapter = new RecyclerViewHomeAdapter(model_post_homes);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}


