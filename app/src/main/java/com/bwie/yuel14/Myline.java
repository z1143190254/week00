package com.bwie.yuel14;
/*
 *@auther:周鑫光
 *@Date: 2019/11/26
 *@Time:15:40
 *@Description:${DESCRIPTION}
 * */

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Myline extends LinearLayout implements View.OnClickListener {
    public Context context;
    private EditText editText;
    private Button button;
    private String name;

    public Myline(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.myline, this);
        inisView();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Myline);
        String string = typedArray.getString(R.styleable.Myline_My_Text);
        editText.setHint(string);
        typedArray.recycle();

    }

    public String setText() {
        return editText.getHint().toString().trim();
    }

    private void inisView() {
        editText = findViewById(R.id.edit);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                name = editText.getText().toString().trim();
                if (name.isEmpty()) {
                    Toast.makeText(context, "不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    setName.onSetnamea(name);
                }
        }
    }

    public interface SetName {
        void onSetnamea(String name);
    }

    public SetName setName;

    public void onSetname(SetName setName) {
        this.setName = setName;
    }
}
