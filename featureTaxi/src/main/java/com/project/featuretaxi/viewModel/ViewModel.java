package com.project.featuretaxi.viewModel;

import android.util.Log;

import androidx.databinding.BaseObservable;

import com.project.featuretaxi.model.Database;


//class LocalDBRepository {
//    private final Database database; // Local DB
//}
//
//class ProductRepository {
//    private final Database database; // Local DB
//    private final NetworkPresenter presenter; // API
//}
//
//class UseCase {
//    ProductRepository productRepository;
//}

public class ViewModel extends BaseObservable {
    private final Database database; // Local DB
//    private final NetworkPresenter presenter; // API
    private String winner;
    public Observable<String> winnerObservable = new Observable<>("");

    private ViewModelBindingListener listener;

    public ViewModel(Database database){
        this.database = database;

        this.database.setOnDatabaseListener(new Database.DatabaseListener() {
            @Override
            public void onChanged() {
                try {
                    winner = null;
                    winner = database.getWinner();
//                    listener.onChange(winner);

                    winnerObservable.onNext(winner);
                    notifyChange();

                } catch ( Exception e){
                    Log.d("뭐지", e.toString());
                }
            }
        });
    }

    public void getUser() {
        database.getUser();
    }

    public String getWinner(){
        return winner;
    }

    public void setListener(ViewModelBindingListener listener) {
        this.listener = listener;
    }

    public interface ViewModelBindingListener {
        void onChange(String text);
    }
}