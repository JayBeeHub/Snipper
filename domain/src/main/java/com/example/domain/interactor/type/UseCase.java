package com.example.domain.interactor.type;


import io.reactivex.Observable;

public interface UseCase<R> {

    Observable<R> execute();

}
