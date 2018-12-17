package hackthon.git.com.hacking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ru.noties.markwon.view.MarkwonView;

public class ChatList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        MarkwonView chat1 = findViewById(R.id.chats_1);
        MarkwonView chat2 = findViewById(R.id.chats_2);

        chat1.setMarkdown(new TextProvider().chat1());

        chat2.setMarkdown(new TextProvider().chat2());

    }
}
