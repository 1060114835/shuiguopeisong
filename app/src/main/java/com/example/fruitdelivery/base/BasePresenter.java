package com.example.fruitdelivery.base;

/**
 * P 层
 */
public abstract class BasePresenter<V extends IView, M extends  BaseModel> {

    protected V mView;

    protected M mModel;

    protected void attach(V view) {
        this.mView = view;
        this.mModel = createModel();
    }

    public void detach() {
        if (mView != null) mView = null;
        if (mModel != null) mModel.detachView();
    }

    protected abstract M createModel();
}
