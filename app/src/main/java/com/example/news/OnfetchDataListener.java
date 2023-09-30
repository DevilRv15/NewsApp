package com.example.news;

import com.Models.NewsHeadlines;

import java.util.List;

public interface OnfetchDataListener<NewsApiResponse> {
    void onFetchData(List<NewsHeadlines> list, String message);
    void onError(String message) ;
}
