package com.example.domain.interactor.usecase;

import com.example.domain.interactor.type.CompletableUseCaseWithParameter;
import com.example.domain.model.UserModel;
import com.example.domain.repositories.UserRepository;

import io.reactivex.Completable;

public class SaveProfilePictureUseCase implements CompletableUseCaseWithParameter<UserModel> {


    private UserRepository repository;
    public SaveProfilePictureUseCase(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public Completable execute(UserModel model) {return repository.saveProfilePicture(model);}
}
