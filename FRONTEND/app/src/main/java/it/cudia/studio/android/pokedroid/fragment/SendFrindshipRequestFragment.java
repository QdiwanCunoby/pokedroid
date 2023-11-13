package it.cudia.studio.android.pokedroid.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.integration.android.IntentIntegrator;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.activity.CaptureActivityPortrait;
import it.cudia.studio.android.pokedroid.fragment.dialog.CustomDialog;
import it.cudia.studio.android.pokedroid.singleton.PokedroidToolbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SendFrindshipRequestFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SendFrindshipRequestFragment extends Fragment {

    private static final String TAG = "SendFrindshipRequestFra";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText etCodiceAmico;
    EditText etEmailAmico;
    Button btSendFrinedshipRequest;

    public SendFrindshipRequestFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SendFrindshipRequestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SendFrindshipRequestFragment newInstance(String param1, String param2) {
        SendFrindshipRequestFragment fragment = new SendFrindshipRequestFragment();
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

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_send_frindship_request, container, false);

        etCodiceAmico = view.findViewById(R.id.etCurrentPassword);
        etEmailAmico = view.findViewById(R.id.etNewPassword);
        btSendFrinedshipRequest = view.findViewById(R.id.btSendChangePasswordRequest);

        btSendFrinedshipRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog dialog = new CustomDialog();
                if(etCodiceAmico.getText().toString().equals("") && etEmailAmico.getText().toString().equals("")){
                    dialog.setDialogWrong("riempire i campi di testo!");
                    dialog.show(getFragmentManager(),"CustomDialog");
                }else if(etCodiceAmico.getText().toString().equals("")){
                    Log.d(TAG, "onClick() called inner if with :"+ etCodiceAmico.getText().toString());
                    dialog.setDialogWrong("il campo codice amico e' vuoto!");
                    dialog.show(getFragmentManager(),"CustomDialog");
                }else if(etEmailAmico.getText().toString().equals("")){
                    Log.d(TAG, "onClick() called inner if with :"+ etCodiceAmico.getText().toString());
                    dialog.setDialogWrong("il campo per email amico e' vuoto!");
                    dialog.show(getFragmentManager(),"CustomDialog");
                }else{
                    //Thread t = new Thread( new SendFrindshipRequestFragment().RetrivePokedexIdLocalDBRunnable());
                    //t.start();
                }
            }
        });

        Button btQrRiscattaPokemon = view.findViewById(R.id.btQrScannerFriendship);
        btQrRiscattaPokemon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // we need to create the object
                // of IntentIntegrator class
                // which is the class of QR library
                IntentIntegrator intentIntegrator = new IntentIntegrator(getActivity());
                intentIntegrator.setPrompt("Scan a barcode or QR Code");
                intentIntegrator.setOrientationLocked(true);
                intentIntegrator.setBeepEnabled(true);
                intentIntegrator.setCaptureActivity(CaptureActivityPortrait.class);
                intentIntegrator.initiateScan();
            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu,menuInflater);

        PokedroidToolbar.enableBackNavigation();
        menu.findItem(R.id.menu_profile).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem item) {
                NavHostFragment.findNavController(SendFrindshipRequestFragment.this).navigate(R.id.action_sendFrindshipRequestFragment_to_profileFragment);
                return true;
            }
        });

    }


}