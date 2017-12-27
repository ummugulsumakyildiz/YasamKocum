package com.sevik.hicran.deneme2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Fragment1 extends Fragment {

static ListView besinListView;
    static  ArrayAdapter<String>adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_fragment1, container, false);
        BesinAsync veriCek=new BesinAsync(view.getContext());
        veriCek.execute();
        besinListView = (ListView) view.findViewById(R.id.besinListView);
       adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_list_item_1,BesinAsync.besinArraylist);
       besinListView.setAdapter(adapter);
        return view;
    }

}
