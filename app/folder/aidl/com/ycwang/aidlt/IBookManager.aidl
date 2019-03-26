package com.ycwang.aidlt;
import com.ycwang.aidlt.Book;
import com.ycwang.aidlt.IOnNewBookArrivedListener;

interface IBookManager{

List<Book> getBookList();
void addBook(in Book book);

void registerIOnNewBookArrivedListener(IOnNewBookArrivedListener listener);
void unRegistenerIOnNewBookArrivedListener(IOnNewBookArrivedListener listener);
}