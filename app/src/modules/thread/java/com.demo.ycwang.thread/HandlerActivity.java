package com.demo.ycwang.thread;

import android.app.Activity;
import android.os.Bundle;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/3/19 17:12
 *
 *
 * Handler 引起的内存泄露原因以及最佳解决方案
 * 将 Handler 定义成静态的内部类，在内部持有 Activity 的弱引用，并及时移除所有消息。
 * private static class SafeHandler extends Handler {
 *
 *     private WeakReference<HandlerActivity> ref;
 *
 *     public SafeHandler(HandlerActivity activity) {
 *         this.ref = new WeakReference(activity);
 *     }
 *
 *     @Override
 *     public void handleMessage(final Message msg) {
 *         HandlerActivity activity = ref.get();
 *         if (activity != null) {
 *             activity.handleMessage(msg);
 *         }
 *     }
 * 并且再在 Activity.onDestroy() 前移除消息，加一层保障：
 *     @Override
 *     protected void onDestroy() {
 *         safeHandler.removeCallbacksAndMessages(null);
 *         super.onDestroy();
 *     }
 * }
 *
 *
 *
 *
 * 子线程里弹 Toast 会崩溃，本质上是因为 Toast 的实现依赖于 Handler，按子线程使用 Handler 的要求修改即可
 *
 * new Thread(new Runnable() {
 *   @Override
 *   public void run() {
 *     Looper.prepare();
 *     Toast.makeText(HandlerActivity.this, "不会崩溃啦！", Toast.LENGTH_SHORT).show();
 *     Looper.loop();
 *   }
 * }).start();
 *
 *

 */
public class HandlerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
