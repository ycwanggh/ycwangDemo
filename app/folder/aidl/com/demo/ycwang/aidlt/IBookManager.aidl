package com.demo.ycwang.aidlt;
import com.demo.ycwang.aidlt.Book;
import com.demo.ycwang.aidlt.IOnNewBookArrivedListener;

interface IBookManager{

List<Book> getBookList();
void addBook(in Book book);

void registerIOnNewBookArrivedListener(IOnNewBookArrivedListener listener);
void unRegistenerIOnNewBookArrivedListener(IOnNewBookArrivedListener listener);
}