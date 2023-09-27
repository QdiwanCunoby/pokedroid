package it.cudia.studio.android.pokedroid.fragment.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import it.cudia.studio.android.pokedroid.R;
import it.cudia.studio.android.pokedroid.activity.AccessActivity;
import it.cudia.studio.android.pokedroid.activity.MainActivity;
import it.cudia.studio.android.pokedroid.fragment.ListaPokemonFragment;
import it.cudia.studio.android.pokedroid.fragment.RiscattaPokemonFragment;
import it.cudia.studio.android.pokedroid.model.AppDatabase;

public class CustomDialog extends DialogFragment {
    private static final String TAG = "CustomDialog";
    Button okButton;
    type_dialog typeDialog = type_dialog.RIGHT ;
    ImageView labelIcon;
    TextView label;
    TextView content;
    String contenutoDialog = "";

    FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedIstance){
        View view = inflater.inflate(R.layout.custom_dialog,container,false);
        okButton= view.findViewById(R.id.btOkDialogRegistration);
        labelIcon = view.findViewById(R.id.ivIconDialog);
        content = view.findViewById(R.id.tvContentDiaolog);
        label = view.findViewById(R.id.tvTitleDialog);
        Dialog d = getDialog();
        d.setCanceledOnTouchOutside(false);

        if(typeDialog == type_dialog.WRONG){
            labelIcon.setImageResource(R.drawable.zubat_icon);
            label.setText("WRONG");
            content.setText(contenutoDialog);
        }else if(typeDialog == type_dialog.RIGHT || typeDialog == type_dialog.SUCCES_RISCATTA_POKEMON){
            labelIcon.setImageResource(R.drawable.pika_icon);
            label.setText("Succes");
            content.setText(contenutoDialog);
        } else if (typeDialog == type_dialog.WARNING) {
            labelIcon.setImageResource(R.drawable.meowth_icon);
            label.setText("Warning");
            content.setText(contenutoDialog);
        } else if(typeDialog == type_dialog.LOGOUT){
            labelIcon.setImageResource(R.drawable.meowth_icon);
            label.setText("Warning");
            content.setText(contenutoDialog);
        }

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(typeDialog == type_dialog.RIGHT){
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                }else if(typeDialog == type_dialog.LOGOUT){
                    Thread t = new Thread(new DeleteUserSqlLiteRunnable());
                    t.start();

                } else if (typeDialog == type_dialog.SUCCES_RISCATTA_POKEMON) {
                    /*TODO*/
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            RiscattaPokemonFragment riscattaPokemon = new RiscattaPokemonFragment();
                            fragmentManager.beginTransaction()
                                    .replace(R.id.riscattaPokemonFragment, riscattaPokemon)
                                    .commit();
                        }
                    });
                    t.start();
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                } else{
                    Log.d(TAG, "onClick! ok close dialog");
                    getDialog().dismiss();
                }
            }
        });

        return view;
    }

    public void setDialogWrong(String contenutoDialog){
        typeDialog = type_dialog.WRONG;
        this.contenutoDialog = contenutoDialog;

    }

    public void setDialogRight(String contenutoDialog){
        typeDialog = type_dialog.RIGHT;
        this.contenutoDialog = contenutoDialog;
    }

    public void setDialogSuccessRiscattaPokemon(String contenutoDialog,FragmentManager fragmentManager){
        typeDialog = type_dialog.SUCCES_RISCATTA_POKEMON;
        this.fragmentManager = fragmentManager;
        this.contenutoDialog = contenutoDialog;
    }

    public void setDialogWarning(String contenutoDialog){
        typeDialog = type_dialog.WARNING;
        this.contenutoDialog = contenutoDialog;
    }

    public void setDialogLogout(String contenutoDialog){
        typeDialog = type_dialog.LOGOUT;
        this.contenutoDialog = contenutoDialog;

    }

    public class DeleteUserSqlLiteRunnable implements Runnable{
        public DeleteUserSqlLiteRunnable() {

        }

        public void run() {
            AppDatabase db = AppDatabase.getInstance(getActivity().getApplicationContext());

            db.userDao().deleteById(1);
            Intent intent  =  new Intent(getActivity(), AccessActivity.class);
            startActivity(intent);
        }
    }
}

enum type_dialog{
    WRONG,
    RIGHT,
    WARNING,
    LOGOUT,
    SUCCES_RISCATTA_POKEMON
}