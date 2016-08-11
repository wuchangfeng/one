package com.wu.allen.myone.view;

import com.wu.allen.myone.model.Book;
import java.util.List;

/**
 * Created by allen on 2016/8/10.
 */

public interface IBookView extends IBaseView{

    void fillData(List<Book> list);
}
