package com.ayuhani.mvp.mvp.presenter;

/**
 * Created by wang on 2018/3/5.
 */

public interface IPresenter {

    /**
     * 调用该方法表示 Presenter 被激活了
     */
    void start();

    void onBtnClick(int height, float weight);

    /**
     * 调用该方法表示 Presenter 要结束了
     * 为了避免相互持有引用而导致的内存泄露
     */
    void destroy();

}
