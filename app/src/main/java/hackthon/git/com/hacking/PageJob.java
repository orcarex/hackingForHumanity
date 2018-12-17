package hackthon.git.com.hacking;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.noties.markwon.view.MarkwonView;

/**
 * Created by rick on 2016/7/9.
 */

public class PageJob extends PageView {

    TextView apple,guard;

    MarkwonView doer,back;

    LinearLayout job_step_2;

    public PageJob(final Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.job_content, null);

        job_step_2 = view.findViewById(R.id.job_step_2);

        doer = view.findViewById(R.id.doer_simple);


        doer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context,MentorFile.class);
                context.startActivity(intent);
            }
        });


        back = view.findViewById(R.id.hansuk_simple);


        apple = view.findViewById(R.id.apple);
        guard = view.findViewById(R.id.gaurd);

        apple.setOnClickListener(new ClickLsr());
        guard.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackground(getResources().getDrawable(R.drawable.card_focused_background,null));
                ( (Home)context ).showLimit();
                doer.setMarkdown(new TextProvider().memtorSimpleDoe());
                back.setMarkdown(new TextProvider().memtorSimpleBack());
                job_step_2.setVisibility(VISIBLE);

            }
        });


        addView(view);

    }

    @Override
    public void refresh() {

    }

    public class ClickLsr implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            v.setBackground(getResources().getDrawable(R.drawable.card_focused_background,null));
        }
    }

}
