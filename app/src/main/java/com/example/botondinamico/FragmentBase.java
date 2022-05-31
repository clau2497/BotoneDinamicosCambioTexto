package com.example.botondinamico;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public abstract class FragmentBase extends Fragment {
    public interface OnVisibilityChangeListener {
        void dismissLoading();

        void showLoading();
    }

    private OnVisibilityChangeListener onVisibilityChangeListener;
    protected boolean isNetworkAvailable;
    private ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
        @Override
        public void onAvailable(Network network) {
            onNetworkAvailable();
        }

        @Override
        public void onLosing(Network network, int maxMsToLive) {
            onNetworkUnavailable();
        }

        @Override
        public void onLost(Network network) {
            onNetworkUnavailable();
        }

        @Override
        public void onUnavailable() {
            onNetworkUnavailable();
        }
    };

    private void onNetworkAvailable() {
        isNetworkAvailable = true;
    }

    private void onNetworkUnavailable() {
        isNetworkAvailable = false;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onVisibilityChangeListener = (OnVisibilityChangeListener) getActivity();
        NetworkRequest.Builder networkRequestBuilder;
        networkRequestBuilder = new NetworkRequest.Builder();
        networkRequestBuilder.addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
        ConnectivityManager connectivityManager;
        connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        connectivityManager.requestNetwork(networkRequestBuilder.build(), networkCallback);
    }

    /*@Override
    public void dismissLoading() {
        onVisibilityChangeListener.dismissLoading();
    }

    @Override
    public void showLoading() {
        onVisibilityChangeListener.showLoading();
    }

    @Override
    public void showNetworkUnavailable() {

    }*/
}
