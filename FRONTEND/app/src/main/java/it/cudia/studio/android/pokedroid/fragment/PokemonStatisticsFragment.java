package it.cudia.studio.android.pokedroid.fragment;

import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.loader.content.Loader;

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

        factors.append(1, R.string.stat_forza);
        factors.append(2, R.string.stat_velocita);
        factors.append(3, R.string.stat_grinta);
        factors.append(4, R.string.stat_fortuna);
        factors.append(5, R.string.stat_difesa);
        factors.append(6, R.string.stat_astuzia);
        factors.append(7, R.string.stat_resistenza);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_pokemon_statistics, container, false);;
        mChart = (RadarChart) v.findViewById(R.id.radarChart);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setXOffset(0f);
        xAxis.setYOffset(0f);
        xAxis.setTypeface(mTfLight);
        xAxis.setTextSize(8f);

        xAxis.setValueFormatter(new ValueFormatter() {

            private String[] mFactors = new String[]{getString(factors.get(1)), getString(factors.get(2)),
                    getString(factors.get(3)), getString(factors.get(4)), getString(factors.get(5))};

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mFactors[(int) value % mFactors.length];
            }
        });

        YAxis yAxis = mChart.getYAxis();
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(50f);
        yAxis.setTypeface(mTfLight);
        yAxis.setTextSize(9f);
        yAxis.setLabelCount(5, false);
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
        scores.append(1, 18);
        scores.append(2, 26);
        scores.append(3, 35);
        scores.append(4, 40);
        scores.append(5, 48);
        scores.append(6, 48);
        scores.append(7, 48);

        drawChart();
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
        data.setValueTextSize(8f);

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