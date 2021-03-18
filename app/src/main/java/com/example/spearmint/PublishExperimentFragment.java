package com.example.spearmint;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PublishExperimentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PublishExperimentFragment extends DialogFragment {

    Button publishExperiment;
    private EditText experimentDescription;
    private EditText experimentRegion;
    private EditText experimentCount;
    private OnFragmentInteractionListener listener;

    public interface OnFragmentInteractionListener {
        void onOkPressed(Experiment newExperiment);
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PublishExperimentFragment() {
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
    public static PublishExperimentFragment newInstance(String param1, String param2) {
        PublishExperimentFragment fragment = new PublishExperimentFragment();
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

        View view = inflater.inflate(R.layout.fragment_publish, container, false);
        experimentDescription = view.findViewById(R.id.description);
        experimentRegion = view.findViewById(R.id.region);
        experimentCount = view.findViewById(R.id.count);

        publishExperiment = view.findViewById(R.id.publishButton);
        publishExperiment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String exDescription = experimentDescription.getText().toString();
                String exRegion = experimentRegion.getText().toString();
                String exCount = experimentCount.getText().toString();
                new Experiment(exDescription, exRegion, exCount);

                ExperimentFragment experimentFragment = new ExperimentFragment();
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.navHostfragment, experimentFragment);
                transaction.commit();

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    /*
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_publish, null);
        experimentDescription = view.findViewById(R.id.description);
        experimentRegion = view.findViewById(R.id.region);
        experimentCount = view.findViewById(R.id.count);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        return builder
                .setView(view)
                .setTitle("Publish Experiment")
                .setNegativeButton("Cancel", null)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String exDescription = experimentDescription.getText().toString();
                        String exRegion = experimentRegion.getText().toString();
                        String exCount = experimentCount.getText().toString();
                        listener.onOkPressed(new Experiment(exDescription, exRegion, exCount));
                    }}).create();
    }

     */


}