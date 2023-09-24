package it.cudia.studio.android.pokedroid.fragment;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.fragment.dialog.CustomDialog;
import it.cudia.studio.android.pokedroid.model.AppDatabase;
import it.cudia.studio.android.pokedroid.services.MyFirebaseInstanceIDService;
import it.cudia.studio.android.pokedroid.singleton.PokedroidToolbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    private static final String TAG = "ProfileFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView logout;
    CustomDialog dialog;
    ImageView imgQRcodeFrindship;
    ImageView imgProfile;
    FloatingActionButton floatingActionButtonProfileImage;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        imgProfile = view.findViewById(R.id.imgProfile);
        floatingActionButtonProfileImage = view.findViewById(R.id.floatingActionButtonProgileImage);
        Thread t = new Thread(new RetriveImgProfileLocalDBRunnable());
        t.start();

        floatingActionButtonProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(getActivity())
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });

        Button changePassword = view.findViewById(R.id.btCambioPassword);

        logout = view.findViewById(R.id.tvLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog = new CustomDialog();
                dialog.setDialogLogout("Sei sicuro di voler uscire dal tuo profilo?");
                dialog.show(getFragmentManager(),"CustomDialog");

            }
        });

        changePassword.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ProfileFragment.this).navigate(R.id.action_profileFragment_to_resetPasswordFragment);

            }
        });

        Button friendList = view.findViewById(R.id.btSendFrinedshipRequest);

        friendList.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ProfileFragment.this).navigate(R.id.action_profileFragment_to_friendsListFragment);

            }
        });

        imgQRcodeFrindship = view.findViewById(R.id.imgQRcodeFrindship);

        try {
            imgQRcodeFrindship.setImageBitmap(encodeAsBitmap(MyFirebaseInstanceIDService.getToken(getContext())));
        } catch (WriterException e) {
            throw new RuntimeException(e);
        }


        Thread t_setUserData = new Thread(new ProfileFragment.RetriveDataUserLocalDBRunnable(view.findViewById(R.id.tvUsername),
                view.findViewById(R.id.tvEmail),
                view.findViewById(R.id.tvPercentualeAvanzamentoProfilo)));
        t_setUserData.start();

        return view;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("message", "This is my message to be reloaded");
        super.onSaveInstanceState(outState);
        Thread t = new Thread(new RetriveImgProfileLocalDBRunnable());
        t.start();
    }

    Bitmap encodeAsBitmap(String str) throws WriterException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(str, BarcodeFormat.QR_CODE, 400, 400);

        int w = bitMatrix.getWidth();
        int h = bitMatrix.getHeight();
        int[] pixels = new int[w * h];
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                pixels[y * w + x] = bitMatrix.get(x, y) ? Color.BLACK : Color.argb(95,197,3,3);
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, w, 0, 0, w, h);
        return bitmap;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        PokedroidToolbar.enableBackNavigation();
        PokedroidToolbar.disableProfileIcon();
    }

    public class RetriveImgProfileLocalDBRunnable implements Runnable {

        @Override
        public void run() {
            retriveProgileImage();
        }

        void retriveProgileImage(){
            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());
            if(db.userDao().loadUserProfileImage(1) != null){
                imgProfile.setImageURI(Uri.parse(db.userDao().loadUserProfileImage(1)));
            }
        }
    }
    public class RetriveDataUserLocalDBRunnable implements Runnable {

        TextView username;
        TextView email;
        TextView avanzamentoPokedex;

        RetriveDataUserLocalDBRunnable(TextView username, TextView email , TextView avanzamentoPokedex) {
            this.username = username;
            this.email = email;
            this.avanzamentoPokedex = avanzamentoPokedex;
        }
        public void run() {
            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());

            if(db.userDao().loadUserUsername(1)!=null){
                this.username.setText(db.userDao().loadUserUsername(1));
            }

            if(db.userDao().loadAvanzamentoPokedex(1)!=null){
                this.avanzamentoPokedex.setText(db.userDao().loadAvanzamentoPokedex(1).intValue() + "%");
            }

            if(db.userDao().loadUserEmail(1)!=null){
                this.email.setText(db.userDao().loadUserEmail(1));
            }

        }
    }

}