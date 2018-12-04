package com.yitianli.myapplication.poem_mvp;

import com.yitianli.myapplication.Poem;
import com.yitianli.myapplication.base.BaseCallback;
import com.yitianli.myapplication.base.BaseView;

public interface PoemContract {

    interface View extends BaseView {

        void showData(PoemBean2 poem);
    }

}
