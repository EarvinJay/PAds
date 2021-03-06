package com.pads.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.pads.Adapters.AdvertisementsAdapter;
import com.pads.R;
import com.pads.entities.Advertisements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srthg on 3/12/2016.
 */
public class ListViewFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private TextView mTvEmpty;
    private List<Advertisements> mAds= new ArrayList<>();


    public static ListViewFragment newInstance() {
        return new ListViewFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listview, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // find all the views
        mListView = (ListView) view.findViewById(R.id.listView);
        mTvEmpty = (TextView) view.findViewById(android.R.id.empty);

        // create a new instance of adapter
        AdvertisementsAdapter adapter = new AdvertisementsAdapter(getActivity(),R.layout.data_listview,mAds);

        // set the adapter
        mListView.setAdapter(adapter);

        if (adapter.isEmpty()) {
            mTvEmpty.setVisibility(View.VISIBLE);
        } else {
            mTvEmpty.setVisibility(View.GONE);
        }

        // set item click listener
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Intent intent = new Intent(getActivity(), MovieDetailsActivity.class);
//        intent.putExtra("key_position", position);
//        startActivity(intent);
//    }
}

