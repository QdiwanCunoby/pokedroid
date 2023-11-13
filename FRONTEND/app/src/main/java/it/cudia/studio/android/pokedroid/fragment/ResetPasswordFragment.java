package it.cudia.studio.android.pokedroid.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.fragment.dialog.CustomDialog;
import it.cudia.studio.android.pokedroid.model.AppDatabase;
import it.cudia.studio.android.pokedroid.singleton.PokedroidToolbar;
import it.cudia.studio.android.pokedroid.singleton.SingletonVolley;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResetPasswordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResetPasswordFragment extends Fragment {

    private static final String TAG = "ResetPasswordFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText currentPassword;
    private EditText newPassword;
    private EditText newPasswordCheck;
    private Button changePassword;
    public ResetPasswordFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResetPasswordFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResetPasswordFragment newInstance(String param1, String param2) {
        ResetPasswordFragment fragment = new ResetPasswordFragment();
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
        View v =inflater.inflate(R.layout.fragment_reset_password, container, false);

        currentPassword = v.findViewById(R.id.etCurrentPassword);
        newPassword = v.findViewById(R.id.etNewPassword);
        newPasswordCheck = v.findViewById(R.id.etNewPasswordConferma);
        changePassword = v.findViewById(R.id.btSendChangePasswordRequest);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new sendChangePasswordRequest()).start();
            }
        });

        return v;
    }

    public class sendChangePasswordRequest implements Runnable {

        @Override
        public void run() {
            LooperThread looperThread = new LooperThread();
            looperThread.start();
            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());
            String json_string = null;
            if (db.userDao().loadUserUsername(1) != null) {
                json_string = "{\n" +
                        "    email: '" + db.userDao().loadUserEmail(1) + "',\n" +
                        "    currentPassword: '" + currentPassword.getText().toString() + "',\n" +
                        "    newPassword: '" + newPassword.getText().toString() + "'\n" +
                        "}";
            }

            JSONObject jsonObject;
            try {
                jsonObject = new JSONObject(json_string); // make a json string in a json object
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            String url = getResources().getString(R.string.base_url) + "UtenteServlet";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.PUT, url, jsonObject, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            CustomDialog dialog = new CustomDialog();
                            dialog.setDialogSuccesUpdatePassword("password cambiata!");
                            dialog.show(getFragmentManager(),"CustomDialog");
                            looperThread.handler.post(new UpdateUserPasswordDBlocal());

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            CustomDialog dialog = new CustomDialog();
                            dialog.setDialogWrong("Qualcosa e' andato storto!");
                            dialog.show(getFragmentManager(),"CustomDialog");
                            Log.d(TAG, "onErrorResponse() called with: error = [" + error + "]");
                        }
                    });
            if(newPassword.getText().toString().equals(newPasswordCheck.getText().toString())){
                // send request with a instance of singleton VOLLEY network android tool
                SingletonVolley.getInstance(getActivity().getApplicationContext()).addToRequestQueue(jsonObjectRequest);
            }else {
                CustomDialog dialog = new CustomDialog();
                dialog.setDialogWarning("password e conferma password non combaciano!");
                dialog.show(getFragmentManager(),"CustomDialog");
            }

        }
    }

    public class LooperThread extends Thread{
        public Handler handler;

        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler();
            Looper.loop();
        }
    }
    public class UpdateUserPasswordDBlocal implements Runnable {
        AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());
        @Override
        public void run() {
            db.userDao().updatePassword(newPassword.getText().toString());
        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        super.onCreateOptionsMenu(menu,menuInflater);

        PokedroidToolbar.disableProfileIcon();
        PokedroidToolbar.enableBackNavigation();
    }
}