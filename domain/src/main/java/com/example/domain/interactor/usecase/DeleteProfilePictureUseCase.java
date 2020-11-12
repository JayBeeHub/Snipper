package com.example.domain.interactor.usecase;

import com.example.domain.interactor.type.CompletableUseCase;
import com.example.domain.interactor.type.CompletableUseCaseWithParameter;
import com.example.domain.model.UserModel;
import com.example.domain.repositories.UserRepository;

import io.reactivex.Completable;

public class DeleteProfilePictureUseCase implements CompletableUseCaseWithParameter<UserModel> {

    private UserRepository repository;

    public DeleteProfilePictureUseCase(UserRepository repository) {
        this.repository = repository;
    }


    @Override
    public Completable execute(UserModel model) {
        return repository.deleteProfilePicture(model);
    }
}
