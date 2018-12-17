package hackthon.git.com.hacking;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import ru.noties.markwon.view.MarkwonView;

public class Home extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private Toolbar mToolbar;
    private List<PageView> pageList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initData();
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getSupportActionBar().setTitle("Re-Entry");


    }

    public void showLimit(){
        AlertDialog alertDialog;

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
// ...Irrelevant code for customizing the buttons and title
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.alert_markdown, null);
        dialogBuilder.setView(dialogView);

        MarkwonView markwonView = (MarkwonView) dialogView.findViewById(R.id.alertJob);
        markwonView.setMarkdown(new TextProvider().jobLimit());

        dialogBuilder.setPositiveButton("Okey", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog = dialogBuilder.create();
        alertDialog.show();
    }


    private void initData() {
        pageList = new ArrayList<>();
        pageList.add(new PageJob(Home.this));
        pageList.add(new PageSkill(Home.this));
        pageList.add(new PageBlog(Home.this));
        pageList.add(new PageSaved(Home.this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chat, menu);

        MenuItem menuChat = menu.findItem(R.id.chat_menu);

        menuChat.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                Intent intent = new Intent();
                intent.setClass(Home.this,ChatList.class);
                startActivity(intent);

                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);

    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        mToolbar.setTitle("更生");

//        getActionBar().setTitle("更生");
//        setSupportActionBar(mToolbar);


        mTabLayout.addTab(mTabLayout.newTab().setText("JOB"));
        mTabLayout.addTab(mTabLayout.newTab().setText("SKILL"));
        mTabLayout.addTab(mTabLayout.newTab().setText("BLOG"));
        mTabLayout.addTab(mTabLayout.newTab().setText("SAVED"));

        mViewPager.setAdapter(new SamplePagerAdapter());
        initListener();

    }

    private void initListener() {
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    private class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return pageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(pageList.get(position));
            return pageList.get(position);
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }
}
