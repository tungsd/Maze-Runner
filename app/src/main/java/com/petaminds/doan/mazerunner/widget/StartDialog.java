package com.petaminds.doan.mazerunner.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.petaminds.doan.mazerunner.MainActivity;
import com.petaminds.doan.mazerunner.R;

public class StartDialog extends Dialog {

    private Activity activity;

    public StartDialog(Activity a) {
        super(a);
        this.activity = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_start);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        setCancelable(false);
        Typeface custom_font = Typeface.createFromAsset(getContext().getAssets(), "fonts/maze.ttf");
        TextView textView = findViewById(R.id.title);
        textView.setTypeface(custom_font);

        Button startBtn = findViewById(R.id.start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                ((MainActivity) activity).start();
            }
        });

        Button exitBtn = findViewById(R.id.exit);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                activity.finish();
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(!hasFocus){
            dismiss();
        }
    }
}
