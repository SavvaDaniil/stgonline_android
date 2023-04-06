package com.example.stgonline.Controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.stgonline.Adapter.LessonPreviewListViewAdapter;
import com.example.stgonline.Facade.LessonFacade;
import com.example.stgonline.Model.JsonAnswerStatusModel;
import com.example.stgonline.Model.Lesson.LessonPreviewModel;
import com.example.stgonline.R;
import com.example.stgonline.Service.LessonService;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;


public class LessonsFragment extends Fragment {

    private ListView _lessonPreviewsListView;
    private View _footerLoadingView;
    private View _footerErrorView;
    private LessonPreviewListViewAdapter _lessonPreviewListViewAdapter;
    private boolean _isLoading = false;
    private boolean _isLessonSearchMaxResult = false;

    private ArrayList<LessonPreviewModel> _lessonPreviewModels = new ArrayList<LessonPreviewModel>();
    //private LessonService _lessonService = new LessonService();
    private LessonFacade _lessonFacade;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lessons, container, false);
        _lessonFacade = new LessonFacade(getContext());
        _lessonPreviewsListView = (ListView) view.findViewById(R.id.lessonPreviewsListView);
        _footerLoadingView = ((LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_view_loading_footer, null, false);
        _footerErrorView = ((LayoutInflater) getActivity().getSystemService(getActivity().LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_view_error_footer, null, false);

        _lessonPreviewListViewAdapter = new LessonPreviewListViewAdapter(getActivity(), _lessonPreviewModels);
        _lessonPreviewsListView.setAdapter(_lessonPreviewListViewAdapter);
        _lessonPreviewsListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE
                        && (_lessonPreviewsListView.getLastVisiblePosition() - _lessonPreviewsListView.getHeaderViewsCount() -
                        _lessonPreviewsListView.getFooterViewsCount()) >= (_lessonPreviewListViewAdapter.getCount() - 1)) {
                    //System.out.println("Достигнут конец списка");
                    if(_isLessonSearchMaxResult)return;
                    searchInit();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {}
        });

        _lessonPreviewsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //System.out.println("lesson id: " + _lessonPreviewModels.get(position).getId());
                Intent lessonAboutIntent = new Intent(getActivity(), LessonAboutActivity.class);
                
                ...

                startActivity(lessonAboutIntent);
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        searchInit();
    }

    public void searchInitFromStart(){
        System.out.println("LessonsFragment searchInitFromStart");
        _lessonPreviewModels.clear();
        _isLessonSearchMaxResult = false;
        _isLoading = false;
        this.searchInit();
    }

    private void searchInit(){
        if(_isLoading)return;
        LessonSearchTask lessonSearchTask = new LessonSearchTask();
        lessonSearchTask.execute();
    }

    private void changeState(LessonPreviewsState lessonPreviewsState){
        switch(lessonPreviewsState){
            case ERROR:
                _lessonPreviewsListView.addFooterView(_footerErrorView);
                _lessonPreviewsListView.removeFooterView(_footerLoadingView);
                break;
            case LOADING:
                
                ...

                break;
            case FINISHED:
            
                ...

                break;
            default:
                break;
        }
    }


    private class LessonSearchTask extends AsyncTask<String, String, JsonAnswerStatusModel>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            _isLoading = true;
            changeState(LessonPreviewsState.LOADING);
        }

        @Override
        protected JsonAnswerStatusModel doInBackground(String... strings) {
            return _lessonFacade.search(_lessonPreviewModels.size());
        }

        @Override
        protected void onPostExecute(JsonAnswerStatusModel jsonAnswerStatusModel) {
            super.onPostExecute(jsonAnswerStatusModel);

            _isLoading = false;
            if(jsonAnswerStatusModel == null) {
                changeState(LessonPreviewsState.ERROR);
            } else if(jsonAnswerStatusModel.getStatus().equals("success") && (jsonAnswerStatusModel.getLessonPreviewViewModels() == null
                    || jsonAnswerStatusModel.getLessonPreviewViewModels().size() == 0)){
                _isLessonSearchMaxResult = true;
                changeState(LessonPreviewsState.FINISHED);
            } else if(jsonAnswerStatusModel.getStatus().equals("success") && jsonAnswerStatusModel.getLessonPreviewViewModels() != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    jsonAnswerStatusModel.getLessonPreviewViewModels().stream().forEach(lessonPreviewModel -> {
                        ...
                    });
                } else {
                    for (LessonPreviewModel lessonPreviewModel : jsonAnswerStatusModel.getLessonPreviewViewModels()) {
                       ...
                    }
                }
                changeState(LessonPreviewsState.FINISHED);
            } else {
                changeState(LessonPreviewsState.ERROR);
            }
        }
    }


    private enum LessonPreviewsState {
        ERROR,
        LOADING,
        FINISHED
    }
}