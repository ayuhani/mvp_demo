package com.ayuhani.mvp.mvp.view;

/**
 * Created by wang on 2018/3/5.
 */

public interface IView {

    /**
     * 用来更改按钮的文本
     *
     * @param text
     */
    void updateBtnText(String text);

    /**
     * 用来弹出吐司显示 BMI
     *
     * @param bmi
     */
    void showToast(float bmi);

}
