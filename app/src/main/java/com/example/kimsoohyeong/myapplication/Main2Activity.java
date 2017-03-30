package com.example.kimsoohyeong.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        final String data[] = {"치킨", "피자"};
        final String data2[] = {"치킨", "피자", "짜장", "탕슉"};
        final boolean checked[] = {true, false, true, false};
        switch (v.getId()) {
            case R.id.b1:
                dlg.setTitle("제목")
                        .setMessage("내용")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),
                                        "확인을 눌렀습니다.", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .show();
                break;
            case R.id.b2:
                dlg.setTitle("먹고싶은 메뉴는?")
                        .setSingleChoiceItems(data, 0, null)
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),
                                        "확인을 눌렀습니다.", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .show();
                break;
            case R.id.b3:
                dlg.setTitle("먹고싶은 메뉴는?")
                        .setMultiChoiceItems(data2, checked, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checked[which] = isChecked;
                            }
                        })
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String str = "";
                                for (int i = 0; i < 4; i++) {
                                    if (checked[i]) {
                                        str += data2[i];
                                        if (i < 3) str += ", ";
                                    }
                                }
                                Toast.makeText(getApplicationContext(),
                                        str + "이 선택되었습니다.", Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .show();
                break;
            case R.id.b4:
                View view = View.inflate(this, R.layout.mytoast, null);
                final EditText e1 = (EditText)view.findViewById(R.id.e1);

                dlg.setTitle("먹고싶은 메뉴는?")
                        .setView(view)
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("닫기", null)
                        .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(),
                                         e1.getText().toString(), Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })
                        .show();
                break;
        }
    }
}
