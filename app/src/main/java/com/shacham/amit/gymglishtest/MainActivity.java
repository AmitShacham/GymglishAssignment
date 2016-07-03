package com.shacham.amit.gymglishtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements
        AdapterView.OnItemClickListener {

    public static final String URL_TO_LOAD = "web_view_url";

    private ArrayList<Website> mWebsiteList = new ArrayList<>();
    private ListView mWebsiteListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
        initListAdapter();
    }

    private void initViews() {
        mWebsiteListView = (ListView) findViewById(R.id.website_list);
    }

    private void initListeners() {
        mWebsiteListView.setOnItemClickListener(this);
    }

    private void initListAdapter() {
        mWebsiteList.add(new Website("Gymglish", "http://www.gymglish.com"));
        mWebsiteList.add(new Website("Frantastique", "http://www.frantastique.com"));
        mWebsiteList.add(new Website("vate faire conjuguer", "http://www.vatefaireconjuguer.com"));
        mWebsiteList.add(new Website("The Delavigne Corporation Blog", "http://blog.delavignecorp.com"));
        mWebsiteList.add(new Website("The Word of the Month", "http://www.thewordofthemonth.com/"));
        mWebsiteList.add(new Website("Richmorning", "https://www.richmorning.com/"));

        WebsiteListAdapter listAdapter = new WebsiteListAdapter(this, R.layout.list_item, mWebsiteList);
        mWebsiteListView.setAdapter(listAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Website website = (Website) parent.getItemAtPosition(position);
        startWebViewActivity(website.getUrl());
    }

    private void startWebViewActivity(String url) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra(URL_TO_LOAD, url);
        startActivity(intent);
    }
}
