package it.cudia.studio.android.pokedroid.fragment.dialog;

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

import it.cudia.studio.android.pokedroid.R;

public class CustomDialog extends DialogFragment {
    private static final String TAG = "CustomDialog";
    Button okButton;
    type_dialog typeDialog = type_dialog.RIGHT ;
    ImageView labelIcon;
    TextView label;
    TextView content;
    String contenutoDialog = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedIstance){
        View view = inflater.inflate(R.layout.custom_dialog,container,false);
        okButton= view.findViewById(R.id.btOkDialogRegistration);
        labelIcon = view.findViewById(R.id.ivIconDialog);
        content = view.findViewById(R.id.tvContentDiaolog);
        label = view.findViewById(R.id.tvTitleDialog);

        if(typeDialog == type_dialog.WRONG){
            labelIcon.setImageResource(R.drawable.zubat_icon);
            label.setText("WRONG");
            content.setText(contenutoDialog);
        }else if(typeDialog == type_dialog.RIGHT){
            labelIcon.setImageResource(R.drawable.pika_icon);
            label.setText("Succes");
            content.setText(contenutoDialog);
        } else if (typeDialog == type_dialog.WARNING) {
            labelIcon.setImageResource(R.drawable.meowth_icon);
            label.setText("Warning");
            content.setText(contenutoDialog);
        }

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick! ok close dialog");
                getDialog().dismiss();
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

    public void setDialogWarning(String contenutoDialog){
        typeDialog = type_dialog.WARNING;
        this.contenutoDialog = contenutoDialog;
    }
}

enum type_dialog{
    WRONG,
    RIGHT,
    WARNING
}