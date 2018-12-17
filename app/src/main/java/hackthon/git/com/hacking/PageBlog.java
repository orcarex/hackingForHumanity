package hackthon.git.com.hacking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import ru.noties.markwon.view.MarkwonView;

/**
 * Created by rick on 2016/7/9.
 */

public class PageBlog extends PageView {
    public PageBlog(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.blog_content, null);

        MarkwonView markwonView = view.findViewById(R.id.blog_markdown);
        markwonView.setMarkdown(new TextProvider().blogContent());

        MarkwonView markwonView2 = view.findViewById(R.id.blog_markdown2);
        markwonView2.setMarkdown(new TextProvider().CCER());

        addView(view);

    }

    @Override
    public void refresh() {

    }
}
