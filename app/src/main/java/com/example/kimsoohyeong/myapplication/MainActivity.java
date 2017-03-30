package com.example.kimsoohyeong.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    void init() {
        e1 = (EditText)findViewById(R.id.e1);
        e2 = (EditText)findViewById(R.id.e2);
    }

    @Override
    public void onClick(View v) {
        Toast toastView;
        switch (v.getId()) {
            case R.id.b1:
                Toast.makeText(this, "일반 메세지 창입니다.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.b2:
                String sx = e1.getText().toString();
                String sy = e2.getText().toString();
                int x = sx.equals("") ? 0 : Integer.parseInt(sx);
                int y = sy.equals("") ? 0 : Integer.parseInt(sy);
                toastView = Toast.makeText(this, "위치 지정 메세지 창입니다", Toast.LENGTH_SHORT);
                toastView.setGravity(Gravity.LEFT | Gravity.TOP, x, y);
                toastView.show();
                break;
            case R.id.b3:
                View view = View.inflate(this, R.layout.mytoast, null);
                
//                TextView t1 = (TextView)view.findViewById(R.id.t1);
//                t1.setText("레이아웃으로 만든 토스트 창입니다");

                toastView = new Toast(this);
                toastView.setDuration(Toast.LENGTH_SHORT);
                toastView.setGravity(Gravity.CENTER, 0, 100);
                toastView.setView(view);
                toastView.show();
                break;
            case R.id.b4:
                Snackbar.make(v, "SnackBar로 보여주는 메세지에요", Snackbar.LENGTH_SHORT)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //
                            }
                        }).show();
                break;
        }
    }
}
