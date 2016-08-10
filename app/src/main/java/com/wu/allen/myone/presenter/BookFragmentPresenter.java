package com.wu.allen.myone.presenter;

import android.content.Context;
import android.util.Log;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.wu.allen.myone.model.Book;
import com.wu.allen.myone.view.IBookView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by allen on 2016/8/10.
 */
public class BookFragmentPresenter extends BaseFragmentPresenter {

    private static final String TAG = "BookFragmentPresenter";
    private IBookView mBookView;
    private List<Book> books = new ArrayList<>();

    @Override
    public void onCreate(int page) {
        getBook(page);
    }

    public void onAttachView(IBookView iBookView) {
        mBookView = iBookView;
    }

    public void getIntentArticle(Context context,int position){
        //Intent intent = new Intent(context, ArtDetailActivity.class);
        //intent.putExtra("article", articles.get(position));
        //context.startActivity(intent);
    }

    private void getBook(int page) {
        //mSuJinView.showLoading();
        AVQuery<AVObject> query = AVQuery.getQuery("BookSave");
        query.orderByDescending("createdAt");
        query.setLimit(10);
        query.setSkip(page * 10);
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if (e == null) {
                    Book book;
                    for (AVObject avObject : list) {
                        String bookAuth = avObject.getString("bookAuth");
                        String bookTitle = avObject.getString("bookTitle");
                        String bookIntr = avObject.getString("bookIntr");
                        String rateNum = avObject.getString("rateNum");
                        String bookRate = avObject.getString("bookRate");
                        String imgUrl = avObject.getString("imgUrl");
                        book = new Book(bookAuth,bookTitle,bookIntr,rateNum,bookRate,imgUrl);
                        books.add(book);
                    }
                    mBookView.fillData(books);
                } else {
                    //mSuJinView.errorLayoutShow();
                    Log.d(TAG,e.getMessage());
                }
            }
        });
    }

}
