package com.r.lat3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class DailyFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_recycle, container, false);

        id.clear();
        title.clear();
        description.clear();

        id.add("1");
        title.add("Sholat 5 Waktu");
        description.add("Karna sholat wajib hukumnya bagi umat Islam");

        id.add("2");
        title.add("Bermain Dota 2");
        description.add("Untuk refreshing ku kalau sudah Jangar");

        id.add("3");
        title.add("Beberes Rumah");
        description.add("Itung- itung bari olahraga jadi sekalian");

        id.add("4");
        title.add("Tidur");
        description.add("Kalo ngga tidur lama kelamaaan sakit liver");

        id.add("5");
        title.add("Olah raga");
        description.add("Agar badan selalu bugar diselingi dengan olahraga besar");

        id.add("6");
        title.add("Belajar");
        description.add("Biar otak ngga hese buat mikir");

        id.add("7");
        title.add("Ngulik");
        description.add("Ngotak - Ngatik sesuatu dan uang jelas membuat saya penasaran");

        id.add("8");
        title.add("Mandi");
        description.add("Harus mandi dan juga jaga kebersihan");

        id.add("9");
        title.add("Makan");
        description.add("Yang jelas makannya yang ic_4 Sehat ic_5 Sempurna");

        id.add("10");
        title.add("Liburan");
        description.add("Selain main game saya juga senang Travelling");

        recyclerView = view.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapter(getActivity().getApplicationContext(), id, title, description);
        recyclerView.setAdapter(mAdapter);

        return view;
    }
}
