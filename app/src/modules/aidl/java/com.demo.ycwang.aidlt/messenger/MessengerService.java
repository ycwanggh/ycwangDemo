package com.demo.ycwang.aidlt.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/**
 * @Description: 服务端代码
 * @Author: ycwang
 * @Date: 2019/3/26 9:45
 */
public class MessengerService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    private static class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    // 接客户端的消息
                    Log.e("ycwang", msg.getData().getString("msg"));

                    // 回复客户端的消息
                    Messenger messengerReply = msg.replyTo;
                    Message messageReply = Message.obtain(null, 2);
                    Bundle bundle = new Bundle();
                    bundle.putString("reply", "I am receive your message, hold on please!");
                    messageReply.setData(bundle);
                    try {
                        messengerReply.send(messageReply);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    private Messenger messenger = new Messenger(new MessengerHandler());

}
