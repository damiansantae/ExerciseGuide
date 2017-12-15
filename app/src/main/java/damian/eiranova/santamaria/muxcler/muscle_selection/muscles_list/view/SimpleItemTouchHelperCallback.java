package damian.eiranova.santamaria.muxcler.muscle_selection.muscles_list.view;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private final IItemTouchHelperAdapter mAdapter;

    public SimpleItemTouchHelperCallback(IItemTouchHelperAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
       int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
       int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
       return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return  false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        //TODO presentar alerta de la vista principal
       mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
        //AppMediador.getInstance().getVistaPrincipal().presentarAlerta(viewHolder.getAdapterPosition());

    }
}
