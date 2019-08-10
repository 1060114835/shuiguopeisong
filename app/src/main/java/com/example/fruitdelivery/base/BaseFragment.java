package com.example.fruitdelivery.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * V 层
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IView {

    protected View mView;

    protected LayoutInflater mInflater;

    protected P mPresenter;

    protected boolean mIsCreated = false;

    //可见一次 在某些情况下onResume会触发，但是onVisible不会触发
    protected boolean mVisibleOnce = false;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mInflater = LayoutInflater.from(getContext());
        mView = mInflater.inflate(getContentLayoutId(), container, false);
        mPresenter = createPresenter();
        if (mPresenter != null) mPresenter.attach(this);
        initView();
        mIsCreated = true;
        //可见则再次调用
        if (getUserVisibleHint()) onVisibleToUser();
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        //可见 但是未触发setUserVisibleHint()方法时
        if (getUserVisibleHint() && !mVisibleOnce) {
            onVisibleToUser();
            onVisibleToUserWithOutOnCreate();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mVisibleOnce) {
            mVisibleOnce = false;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) mPresenter.detach();
    }

    /**
     * 该方法会在onCreateView之前调用
     * 该方法在ViewPager+Fragment组合时可用，在FragmentTabHost+Fragment时不可用
     * @param isVisibleToUser 对用户是否可见
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (mIsCreated) {
            if (getUserVisibleHint()) {
                mVisibleOnce = true;
                onVisibleToUser();
                onVisibleToUserWithOutOnCreate();
            } else {
                mVisibleOnce = false;
                onUnVisibleToUser();
            }
        }
    }

    @Override
    public BaseActivity getBActivity() {
        return (BaseActivity) getActivity();
    }

    @Override
    public void toast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void setTitle(String title) {
        getBActivity().setTitle(title);
    }

    /**
     * 对用户可见时调用，在可见&第一次创建的时候也会调用
     */
    protected void onVisibleToUser() { }

    /**
     * 对用户不可见时调用
     */
    protected void onUnVisibleToUser() { }

    /**
     * 可见时调用，但不是创建时
     * 相当于onResume
     */
    protected void onVisibleToUserWithOutOnCreate() { }

    protected abstract int getContentLayoutId();

    protected abstract P createPresenter();

    protected abstract void initView();
}
