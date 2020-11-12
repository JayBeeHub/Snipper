package com.example.domain.repositories;

import com.example.domain.model.UserModel;

import io.reactivex.Completable;

public interface UserRepository {
    Completable deleteProfilePicture(UserModel model);

    Completable saveFullNameAndEmail(UserModel model);

    Completable saveProfilePicture(UserModel model);

    Completable updateProfilePicture(UserModel model);

}
