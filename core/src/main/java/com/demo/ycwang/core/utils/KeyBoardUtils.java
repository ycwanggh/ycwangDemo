package com.demo.ycwang.core.utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/12 11:37
 */
public class KeyBoardUtils {

    /**
     * Show the soft input.
     *
     * @param view The view.
     */
    public static void showSoftInput(Context context, final View view) {
        InputMethodManager imm =
                (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        //noinspection ConstantConditions
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }


    /**
     * Hide the soft input.
     *
     * @param view The view.
     */
    public static void hideSoftInput(Context context, final View view) {
        InputMethodManager imm =
                (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        //noinspection ConstantConditions
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    /**
     * Click blankj area to hide soft input.
     * <p>Copy the following code in ur activity.</p>
     */
    public static void clickBlankArea2HideSoftInput() {
        Log.i("KeyboardUtilsCp", "Please refer to the following code.");
        /*
        @Override
        public boolean dispatchTouchEvent(MotionEvent ev) {
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                View v = getCurrentFocus();
                if (isShouldHideKeyboard(v, ev)) {
                    InputMethodManager imm =
                            (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS
                    );
                }
            }
            return super.dispatchTouchEvent(ev);
        }

        // Return whether touch the view.
        private boolean isShouldHideKeyboard(View v, MotionEvent event) {
            if (v != null && (v instanceof EditText)) {
                int[] l = {0, 0};
                v.getLocationInWindow(l);
                int left = l[0],
                        top = l[1],
                        bottom = top + v.getHeight(),
                        right = left + v.getWidth();
                return !(event.getX() > left && event.getX() < right
                        && event.getY() > top && event.getY() < bottom);
            }
            return false;
        }
        */
    }

}
