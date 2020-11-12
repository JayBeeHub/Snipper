package com.example.domain.interactor.type;

import io.reactivex.Single;

public interface SingleUseCase<R> {

    Single<R> execute();

}
