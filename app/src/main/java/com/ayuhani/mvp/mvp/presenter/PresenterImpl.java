package com.ayuhani.mvp.mvp.presenter;

import com.ayuhani.mvp.mvp.model.User;
import com.ayuhani.mvp.mvp.view.IView;

/**
 * Created by wang on 2018/3/5.
 */

public class PresenterImpl implements IPresenter {

    private IView mView;

    public PresenterImpl(IView mView) {
        this.mView = mView;
    }

    @Override
    public void start() {
        String text = User.instance().getBtnText();
        mView.updateBtnText(text);
    }

    @Override
    public void onBtnClick(int height, float weight) {
        User.instance().setHeight(height);
        User.instance().setWeight(weight);
        float bmi = User.instance().getBMI();
        mView.showToast(bmi);
    }

    @Override
    public void destroy() {
        mView = null;
    }

}
