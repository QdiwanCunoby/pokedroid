package it.cudia.studio.android.pokedroid.fragment;

import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.loader.content.Loader;

import android.util.Log;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

import it.cudia.studio.android.pokedroid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PokemonStatisticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PokemonStatisticsFragment extends Fragment {

    private static final String TAG = "PokemonStatisticsFragme";
    private RadarChart mChart;
    private Typeface mTfLight;
    private SparseIntArray factors = new SparseIntArray(7);
    private SparseIntArray scores = new SparseIntArray(7);
    private ArrayList<RadarEntry> entries = new ArrayList<>();
    private ArrayList<IRadarDataSet> dataSets = new ArrayList<>();


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int forza, velocita, grinta, difesa, fortuna, astuzia, resistenza;

    public PokemonStatisticsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PokemonStatisticsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PokemonStatisticsFragment newInstance(String param1, String param2) {
        PokemonStatisticsFragment fragment = new PokemonStatisticsFragment();
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


    private String[] getXAxisValues()
    {
        String[] mFactors = new String[]{getString(factors.get(1)), getString(factors.get(2)),
                getString(factors.get(3)), getString(factors.get(4)), getString(factors.get(5))
                , getString(factors.get(6)), getString(factors.get(7))};


        return mFactors;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_pokemon_statistics, container, false);;
        factors.append(1, R.string.stat_forza);
        factors.append(2, R.string.stat_velocita);
        factors.append(3, R.string.stat_grinta);
        factors.append(4, R.string.stat_fortuna);
        factors.append(5, R.string.stat_difesa);
        factors.append(6, R.string.stat_astuzia);
        factors.append(7, R.string.stat_resistenza);
        getActivity().getSupportFragmentManager().setFragmentResultListener("requestKey", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                Log.d(TAG, "onFragmentResult() called with: requestKey = [" + requestKey + "], bundle = [" + bundle + "]");
                // We use a String here, but any type that can be put in a Bundle is supported.
                forza = bundle.getInt("forza");
                velocita = bundle.getInt("velocita");
                grinta = bundle.getInt("grinta");
                difesa = bundle.getInt("difesa");
                fortuna = bundle.getInt("fortuna");
                astuzia = bundle.getInt("astuzia");
                resistenza = bundle.getInt("resistenza");
                // Do something with the result.
                scores.append(1, forza);
                scores.append(2, velocita);
                scores.append(3, grinta);
                scores.append(4, fortuna);
                scores.append(5, difesa);
                scores.append(6, astuzia);
                scores.append(7, resistenza);
                drawChart();
            }
        });

        mChart = (RadarChart) v.findViewById(R.id.radarChart);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setXOffset(0f);
        xAxis.setYOffset(0f);
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum(70f);
        xAxis.setTypeface(mTfLight);
        xAxis.setGranularity(10f); // interval 10
        xAxis.setTextSize(18f);
        xAxis.setTextColor(getResources().getColor(R.color.white));
        xAxis.setValueFormatter(new IndexAxisValueFormatter(getXAxisValues()));


        YAxis yAxis = mChart.getYAxis();
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(70f);
        yAxis.setTypeface(mTfLight);
        yAxis.setTextSize(20f);
        yAxis.setGranularity(10f); // interval 10
        yAxis.setLabelCount(5, false);
        yAxis.setTextColor(getResources().getColor(R.color.white));
        yAxis.setDrawLabels(false);


        mChart.getLegend().setEnabled(false);
        mChart.getDescription().setEnabled(false);
        mChart.animateXY(
                1400, 1400,
                Easing.EaseInOutQuad,
                Easing.EaseInOutQuad);

        scores.clear();
        // while (cursor.moveToNext()) {
        //     ...
        //     scores.put(..., ...);
        // }

        // Or hardcode some test data:



        return v;
    }


    private void drawChart() {

        entries.clear();

        for (int i = 1; i <= 7; i++) {
            entries.add(new RadarEntry(scores.get(i)));
        }

        RadarDataSet dataSet = new RadarDataSet(entries, "");
        dataSet.setColor(R.color.white);
        dataSet.setDrawFilled(true);

        dataSets.add(dataSet);

        RadarData data = new RadarData(dataSets);
        data.setValueTypeface(mTfLight);
        data.setValueTextSize(15f);
        data.setValueTextColor(getResources().getColor(R.color.white));

        data.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                return String.valueOf((int) value);
            }

        });

        mChart.setData(data);
        mChart.invalidate();
    }
}