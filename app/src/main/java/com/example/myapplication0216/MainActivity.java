package com.example.myapplication0216;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final Fragment fragment_message=new Fragment_message();
    private final Fragment fragment_friend=new Fragment_friend();
    private final Fragment fragment_connect=new Fragment_connect();
    private final Fragment fragment_setting=new Fragment_setting();
    private FragmentManager fm;
    private FragmentTransaction transaction;
    private LinearLayout tabChat;
    private LinearLayout tabFriend;
    private LinearLayout tabContect;
    private LinearLayout tabSetting;
    private ImageButton imgChat;
    private ImageButton imgFriend;
    private ImageButton imgContact;
    private ImageButton imgSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_main);
        //去掉它自带的标题框
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }

        initView();//关联对象
        initFragment();//添加界面
        transaction=fm.beginTransaction();
        hidefragment(transaction);
        //局部监听
        tabChat.setOnClickListener(this);
        tabFriend.setOnClickListener(this);
        tabContect.setOnClickListener(this);
        tabSetting.setOnClickListener(this);
    }

    //Fragment初始化函数
    private void initFragment(){
        fm=getSupportFragmentManager();
        transaction=fm.beginTransaction()
                .add(R.id.content,fragment_message)
                .add(R.id.content,fragment_friend)
                .add(R.id.content,fragment_connect)
                .add(R.id.content,fragment_setting);
        transaction.commit();
    }
    // 找到所有的控件
    private void initView() {
        tabChat = findViewById(R.id.linear_char);
        tabFriend = findViewById(R.id.linear_friend);
        tabContect = findViewById(R.id.linear_contact);
        tabSetting = findViewById(R.id.linear_setting);

        imgChat = findViewById(R.id.聊天);
        imgFriend = findViewById(R.id.朋友);
        imgContact = findViewById(R.id.通讯录);
        imgSetting = findViewById(R.id.设置);
    }

    //控制图片变换
    private void setSelect(int i){
        FragmentTransaction transaction=fm.beginTransaction();
        hidefragment(transaction);
        switch (i){
            case  1:
                transaction.show(fragment_message);
                imgChat.setImageResource(R.drawable.chat);
                break;
            case  2:
                transaction.show(fragment_friend);
                imgFriend.setImageResource(R.drawable.friend);
                break;
            case  3:
                transaction.show(fragment_connect);
                imgContact.setImageResource(R.drawable.txl);
                break;
            case  4:
                transaction.show(fragment_setting);
                imgSetting.setImageResource(R.drawable.setting);
                break;
            default:
                break;
        }
        // transaction.commit();
    }
    //隐藏所有tab
    private void hidefragment(@NonNull FragmentTransaction transaction){

        transaction.hide(fragment_message);
        transaction.hide(fragment_friend);
        transaction.hide(fragment_connect);
        transaction.hide(fragment_setting);
        transaction.commit();
    }
    //重写onClick方法
    //用户点击哪个tab，就设置i值
    public void onClick(@NonNull View v) {
        resetimg();
        switch (v.getId()){
            case R.id.linear_char:
                setSelect(1);
                break;
            case R.id.linear_friend:
                setSelect(2);
                break;
            case R.id.linear_contact:
                setSelect(3);
                break;
            case R.id.linear_setting:
                setSelect(4);
                break;
            default:
                break;
        }
    }
    //将未点击的图片按钮还原成原来的颜色
    private void resetimg(){
        imgChat.setImageResource(R.drawable.chat);
        imgFriend.setImageResource(R.drawable.friend);
        imgContact.setImageResource(R.drawable.txl);
        imgSetting.setImageResource(R.drawable.setting);
    }
    //最后调用函数

}