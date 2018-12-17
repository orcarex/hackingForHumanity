package hackthon.git.com.hacking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import ru.noties.markwon.view.MarkwonView;

/**
 * Created by rick on 2016/7/9.
 */

public class PageSkill extends PageView {
    public PageSkill(final Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.skill_content, null);

        MarkwonView doer = view.findViewById(R.id.doer_simple);
        doer.setMarkdown(new TextProvider().memtorSimpleDoe());

        doer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context,MentorFile.class);
                context.startActivity(intent);
            }
        });

        MarkwonView back = view.findViewById(R.id.hansuk_simple);
        back.setMarkdown(new TextProvider().memtorSimpleHan());

        addView(view);

    }

    @Override
    public void refresh() {

    }
}
