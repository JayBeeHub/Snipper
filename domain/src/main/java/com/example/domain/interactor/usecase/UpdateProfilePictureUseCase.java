package com.example.domain.interactor.usecase;

import com.example.domain.interactor.type.CompletableUseCaseWithParameter;
import com.example.domain.model.UserModel;
import com.example.domain.repositories.UserRepository;

import io.reactivex.Completable;

public class UpdateProfilePictureUseCase implements CompletableUseCaseWithParameter<UserModel> {
    private UserRepository repository;

    public UpdateProfilePictureUseCase(UserRepository repository){
        this.repository = repository;
    }


    @Override
    public Completable execute(UserModel model) {
        return repository.updateProfilePicture(model);
    }
}
