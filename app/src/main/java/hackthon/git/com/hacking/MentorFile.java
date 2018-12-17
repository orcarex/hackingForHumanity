package hackthon.git.com.hacking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.noties.markwon.view.MarkwonView;

public class MentorFile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor_file);


        MarkwonView markwonView = findViewById(R.id.mentor_title);
        markwonView.setMarkdown(new TextProvider().mentorTitle());

        MarkwonView markwonView2 = findViewById(R.id.mentor_content);
        markwonView2.setMarkdown(new TextProvider().memtorContent());

    }
}
