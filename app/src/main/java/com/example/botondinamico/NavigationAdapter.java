package com.example.botondinamico;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.Stack;
public class NavigationAdapter extends FragmentPagerAdapter {

    public static abstract class Fragment extends FragmentBase {
        protected NavigationDelegate<Bundle> navigationDelegate;
        private boolean backEnabled = true;
        private boolean fragmentResumed;
        private boolean resettable;
        public void setNavigationDelegate(NavigationDelegate<Bundle> navigationDelegate) {
            this.navigationDelegate = navigationDelegate;
        }

        public boolean isFragmentResumed() {
            return fragmentResumed;
        }

        public void setFragmentResumed(boolean fragmentResumed) {
            this.fragmentResumed = fragmentResumed;
        }

        public boolean isBackEnabled() {
            return backEnabled;
        }

        public void setBackEnabled(boolean backEnabled) {
            this.backEnabled = backEnabled;
        }

        public boolean isResettable() {
            return resettable;
        }

        public void setResettable(boolean resettable) {
            this.resettable = resettable;
        }

        public void reset() {

        }

        public void resumeFragment() {

        }
    }

    private Stack<Fragment> fragments = new Stack<>();
    public int pushFragment(Fragment fragment){
        fragments.push(fragment);
        notifyDataSetChanged();
        return fragments.indexOf(fragment);
    }

    public void popUpTo(int position) {
        for (int index = fragments.size() - 1; index >= 0; index--) {
            if (index > position) {
                fragments.pop();
            }
        }

        notifyDataSetChanged();
    }

    public NavigationAdapter (FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public long getItemId(int position) {
        return fragments.get(position).hashCode();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        for (int position = 0; position < fragments.size(); position++) {
            Fragment fragment;
            fragment = fragments.get(position);
            if (fragment.equals(object)) {
                return position;
            }
        }
        return POSITION_NONE;
    }
}

