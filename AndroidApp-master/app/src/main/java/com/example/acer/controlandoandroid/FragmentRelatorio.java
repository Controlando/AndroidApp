package com.example.acer.controlandoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class FragmentRelatorio extends Fragment {
    private TabLayout tablayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    View view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.relatorio_fragment, null);

        tablayout = (TabLayout) view.findViewById(R.id.tabLayout_id);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());

        adapter.AddFragment(new FragmentVerDespesa(),"Despesas");
        adapter.AddFragment(new FragmentVerMeta(),"Metas");
        adapter.AddFragment(new FragmentVerReceita(),"Receitas");

        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);

        return view;
    }


}
