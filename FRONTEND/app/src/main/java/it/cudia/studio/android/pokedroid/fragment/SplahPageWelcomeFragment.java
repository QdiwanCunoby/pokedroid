package it.cudia.studio.android.pokedroid.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.activity.AccessActivity;
import it.cudia.studio.android.pokedroid.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SplahPageWelcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SplahPageWelcomeFragment extends Fragment {

    private static final String TAG = "SplahPageWelcomeFragmen";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SplahPageWelcomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SplahPageWelcomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SplahPageWelcomeFragment newInstance(String param1, String param2) {
        SplahPageWelcomeFragment fragment = new SplahPageWelcomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        View v = inflater.inflate(R.layout.fragment_splah_page_welcome, container, false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated() called with: view = [" + view + "], savedInstanceState = [" + savedInstanceState + "]");
        super.onViewCreated(view, savedInstanceState);
        final Handler handler = new Handler(); // instatiate Handler. A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue. Each Handler instance is associated with a single thread and that thread's message queue.
        /*Delay 5s switch to UI main Thread the rendering and start of AccessActivity */
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent  =  new Intent(getActivity(), AccessActivity.class);
                startActivity(intent);
            }
        }, 5000);
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView() called");
        super.onDestroyView();
    }
}