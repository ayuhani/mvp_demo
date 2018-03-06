package com.ayuhani.mvp.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ayuhani.mvp.R;
import com.ayuhani.mvp.mvp.presenter.IPresenter;
import com.ayuhani.mvp.mvp.presenter.PresenterImpl;

public class MVPActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private EditText mEtHeight;
    private EditText mEtWeight;
    private Button mBtnCal;

    private IPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 实例化 PresenterImpl
        mPresenter = new PresenterImpl(this);
        // View 的相关初始化
        mEtHeight = findViewById(R.id.et_height);
        mEtWeight = findViewById(R.id.et_weight);
        mBtnCal = findViewById(R.id.btn_cal);
        mBtnCal.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.start();
    }


    @Override
    public void onClick(View v) {
        int height = Integer.parseInt(mEtHeight.getText().toString());
        float weight = Float.parseFloat(mEtWeight.getText().toString());
        mPresenter.onBtnClick(height, weight);
    }

    @Override
    public void updateBtnText(String text) {
        mBtnCal.setText(text);
    }

    @Override
    public void showToast(float bmi) {
        Toast.makeText(this, "BMI: " + bmi, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.destroy();
            mPresenter = null;
        }
        super.onDestroy();
    }
}
