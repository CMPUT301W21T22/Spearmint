package com.example.spearmint;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExperimentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExperimentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExperimentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExperimentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExperimentFragment newInstance(String param1, String param2) {
        ExperimentFragment fragment = new ExperimentFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*
        Samantha Squires. (2016, March 1). 1.5: Display a ListView in a Fragment [Video]. YouTube. https://www.youtube.com/watch?v=edZwD54xfbk
        Abram Hindle, "Lab 3 instructions - CustomList", Public Domain, 2021-02-12, https://eclass.srv.ualberta.ca/pluginfile.php/6713985/mod_resource/content/1/Lab%203%20instructions%20-%20CustomList.pdf
        https://stackoverflow.com/users/788677/rakhita. (2011, Nov 17). Custom Adapter for List View. https://stackoverflow.com/. https://stackoverflow.com/questions/8166497/custom-adapter-for-list-view/8166802#8166802
         */

        View view = inflater.inflate(R.layout.fragment_experiment, container, false);
        ArrayList<Experiment> experimentList = new ArrayList<>();

        experimentList.add(new Experiment("Coin Flip", "Calgary", "9"));
        experimentList.add(new Experiment("Count number", "Edmonton", "7"));
        experimentList.add(new Experiment("Number of Trials", "Vancouver", "11"));

        ListView listView = (ListView) view.findViewById(R.id.experiment_list);

        ExperimentAdapter customAdapter = new ExperimentAdapter(getActivity(), R.layout.content, experimentList);

        listView.setAdapter(customAdapter);

        return view;
    }
}