package eu.kanade.mangafeed.ui.library.category;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import eu.kanade.mangafeed.R;
import eu.kanade.mangafeed.data.database.models.Category;
import eu.kanade.mangafeed.ui.base.adapter.FlexibleViewHolder;

public class CategoryHolder extends FlexibleViewHolder {

    private View view;

    @Bind(R.id.image) ImageView image;
    @Bind(R.id.title) TextView title;

    public CategoryHolder(View view, CategoryAdapter adapter, OnListItemClickListener listener) {
        super(view, adapter, listener);
        ButterKnife.bind(this, view);
        this.view = view;
    }

    public void onSetValues(Category category, ColorGenerator generator) {
        title.setText(category.name);
        image.setImageDrawable(getRound(category.name.substring(0, 1), generator));
    }

    private TextDrawable getRound(String text, ColorGenerator generator) {
        return TextDrawable.builder().buildRound(text, generator.getColor(text));
    }

    @OnClick(R.id.image)
    void onImageClick() {
        // Simulate long click on this view to enter selection mode
        onLongClick(view);
    }

}