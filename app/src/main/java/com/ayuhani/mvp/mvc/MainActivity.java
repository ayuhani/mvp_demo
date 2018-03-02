package com.ayuhani.mvp.mvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayuhani.mvp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtHeight;
    private EditText mEtWeight;
    private Button mBtnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Controller 访问了 View 的组件
        mEtHeight = findViewById(R.id.et_height);
        mEtWeight = findViewById(R.id.et_weight);
        mBtnCal = findViewById(R.id.btn_cal);
        // 这个点击事件属于 View，它是 View 的监听器
        mBtnCal.setOnClickListener(this);

        // Controller 调用了 Model
        String btnText = User.instance().getBtnText();
        // 然后 Controller 更新了 View 的属性
        mBtnCal.setText(btnText);
    }

    @Override
    public void onClick(View v) {
        int height = Integer.parseInt(mEtHeight.getText().toString());
        float weight = Float.parseFloat(mEtWeight.getText().toString());
        // Controller 更新了 Modal 中的数据
        User.instance().setHeight(height);
        User.instance().setWeight(weight);
        // 这里 View 又访问了 Model 的数据，并呈现在 UI 上
        String valueBMI = String.valueOf(User.instance().getBMI());
        Toast.makeText(this, "BMI: " + valueBMI, Toast.LENGTH_LONG).show();
    }
}
