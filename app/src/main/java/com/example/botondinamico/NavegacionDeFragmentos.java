package com.example.botondinamico;

import androidx.databinding.ViewDataBinding;

public abstract class NavegacionDeFragmentos <VDB extends ViewDataBinding> {

    protected void enableNextView(NavegacionDeFragmentos nextFragment, boolean navigateAfterLoading) {
        NavegacionDeFragmentos adapter;
      /*  if ((adapter = getAdapter()) == null || nextFragment == null) {
            View v;
            if ((v = getView()) != null) {
                SnackBar.show(v, "Algo salió mal al generar la vista.");
            }
            Log.e("enableNextView: ", "adapter or next fragment is null");
            return;
        }
        disableNextViews();
        adapter.setNextFragment(
                nextFragment
        );
        if (navigateAfterLoading) {
            getViewPager().setCurrentItem(adapter.getCount() - 1, false);
        } else {
        }*/
    }

  /*  public void setNextFragment(NavegacionDeFragmentos nf) {
        mNavigationStack.add(nf);
        notifyDataSetChanged();
    }
*/

}
