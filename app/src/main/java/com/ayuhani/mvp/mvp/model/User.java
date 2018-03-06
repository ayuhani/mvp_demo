package com.ayuhani.mvp.mvp.model;

/**
 * Created by wang on 2018/3/2.
 */

public class User {

    private int height;
    private float weight;

    private static User mUser;

    public static User instance(){
        if (mUser == null) {
            synchronized (User.class) {
                if (mUser == null) {
                    mUser = new User();
                }
            }
        }
        return mUser;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getBtnText() {
        // 在这里，我们可以从数据库中查询数据
        // 或者访问网络获取数据
        return "计算BMI";
    }

    public float getBMI() {
        // 通过已有的属性计算出新的属性，也属于业务逻辑的操作
        return weight / (height * height) * 10000;
    }
}
