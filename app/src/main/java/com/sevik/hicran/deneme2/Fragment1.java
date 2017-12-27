package com.sevik.hicran.deneme2;


import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Fragment1 extends Fragment {

static ListView besinListView;
    static BesinAdapter adapter;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_fragment1, container, false);
        BesinAsync veriCek=new BesinAsync(view.getContext());
        veriCek.execute();
        besinListView = (ListView) view.findViewById(R.id.besinListView);
       adapter=new BesinAdapter((Activity) view.getContext(),BesinAsync.besinArraylist);
       besinListView.setAdapter(adapter);
        besinListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String besinAdi= BesinAsync.besinArraylist.get(position).getBesinAdi();
                String besinMiktar=BesinAsync.besinArraylist.get(position).getMiktar();
                int kalori =BesinAsync.besinArraylist.get(position).getKalori();
                View popupView = inflater.inflate(R.layout.activity_popup,null);
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setView(popupView);
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
        return view;
    }

}
