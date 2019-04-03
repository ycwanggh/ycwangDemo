package com.demo.ycwang.aidlt;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/3/26 11:02
 */
public class BookManagerService extends Service {


    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    private CopyOnWriteArrayList<Book> mBookList = new CopyOnWriteArrayList<>();
    private RemoteCallbackList<IOnNewBookArrivedListener> mListenerList = new RemoteCallbackList<>();

    private Binder binder = new IBookManager.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            mBookList.add(book);
        }

        @Override
        public void registerIOnNewBookArrivedListener(IOnNewBookArrivedListener listener) throws RemoteException {
            mListenerList.register(listener);
        }

        @Override
        public void unRegistenerIOnNewBookArrivedListener(IOnNewBookArrivedListener listener) throws RemoteException {
            mListenerList.unregister(listener);
        }
    };


    @Override
    public void onCreate() {
        super.onCreate();
        mBookList.add(new Book(1, "Android"));
        mBookList.add(new Book(2, "IOS"));

        new Thread(new ServiceWorke()).start();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        atomicBoolean.set(true);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


    public class ServiceWorke implements Runnable {

        @Override
        public void run() {
            while (!atomicBoolean.get()) {
                try {
                    Thread.sleep(5000);
                    int bookID = mBookList.size() + 1;
                    Book newBook = new Book(bookID, "#newBook" + bookID);
                    onNewBookArrived(newBook);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void onNewBookArrived(Book newBook) {
        mBookList.add(newBook);
        final int N = mListenerList.beginBroadcast();

        for (int i = 0; i < N; i++) {
            IOnNewBookArrivedListener iOnNewBookArrivedListener = mListenerList.getBroadcastItem(i);
            if (iOnNewBookArrivedListener != null) {
                try {
                    iOnNewBookArrivedListener.onNewBookArrived(newBook);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        mListenerList.finishBroadcast();
    }
}
