package com.demo.ycwang.aidlt;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

import com.demo.ycwang.ycwangdemo.R;

import java.util.List;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/3/26 11:13
 */
public class BookManagerActivity extends Activity {

    private IBookManager mRemoteBookManager;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 3:
                    Log.e("ycwang", "receive book :==" + msg.obj);
                    break;
                default:
                    super.handleMessage(msg);
                    break;
            }
        }
    };


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManager bookManager = IBookManager.Stub.asInterface(service);
            try {
                mRemoteBookManager = bookManager;
                List<Book> mList = bookManager.getBookList();
                Log.e("ycwang1", "Client:======TYPE:" + mList.getClass().getCanonicalName());
                Log.e("ycwang1", "Client:======STRING:" + mList.toString());
                Book book = new Book(3, "Android 开发艺术探索");
                bookManager.addBook(book);
                Log.e("ycwang1", "add Book:" + book);
                List<Book> newList = bookManager.getBookList();
                Log.e("ycwang1", "Client:======STRING:" + newList.toString());
                bookManager.registerIOnNewBookArrivedListener(iOnNewBookArrivedListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    IOnNewBookArrivedListener iOnNewBookArrivedListener = new IOnNewBookArrivedListener.Stub() {
        @Override
        public void onNewBookArrived(Book newBook) throws RemoteException {
            handler.obtainMessage(3, newBook).sendToTarget();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, BookManagerService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        if (mRemoteBookManager != null && mRemoteBookManager.asBinder().isBinderAlive()) {
            try {
                mRemoteBookManager.unRegistenerIOnNewBookArrivedListener(iOnNewBookArrivedListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        unbindService(serviceConnection);
        super.onDestroy();
    }
}
