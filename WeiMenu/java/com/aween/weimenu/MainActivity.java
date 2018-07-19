package com.aween.weimenu;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

/**
 * 实现仿微信菜单
 *
 * @param      null
 * @return
 * @date       2018/7/19 16:36
 */
public class MainActivity extends AppCompatActivity {
    PopupWindow popupWindow = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMenu(View view){
        //根据自定义的菜单布局文件
        View popupWindow_view = getLayoutInflater().inflate(R.layout.menu, null, false);
        //创建PopupWindow实例，设置菜单宽度和高度为包裹其自身内容
        popupWindow = new PopupWindow(popupWindow_view, ActionBar.LayoutParams.WRAP_CONTENT,
                ActionBar.LayoutParams.WRAP_CONTENT, true);
        //设置菜单显示在按钮的下面
        popupWindow.showAsDropDown(findViewById(R.id.btn_menu),0,0);
        //单击其他地方消失
        popupWindow_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                //如果菜单存在并且为显示状态，就关闭菜单并初始化菜单
                if (popupWindow != null && popupWindow.isShowing()){
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                return false;
            }
        });
    }

}
