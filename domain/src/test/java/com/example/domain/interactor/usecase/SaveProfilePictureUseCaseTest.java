package com.example.domain.interactor.usecase;

import com.example.domain.model.UserModel;
import com.example.domain.repositories.UserRepository;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


import io.reactivex.Completable;
import io.reactivex.observers.TestObserver;

public class SaveProfilePictureUseCaseTest {

    private SaveProfilePictureUseCase saveProfilePictureUseCase;
    private UserRepository userRepository;
    private TestObserver<Object> testObserver;

    @Before
    public void setUp() throws  Exception {
        userRepository = Mockito.mock(UserRepository.class);
        saveProfilePictureUseCase = new SaveProfilePictureUseCase(userRepository);
        testObserver = new TestObserver<>();
    }

    @Test
    public void shouldSaveProfilePicture(){
        UserModel userModelTest = DomainTestData.USER_MODEL;

        Mockito.when(userRepository.saveProfilePicture(userModelTest)).thenReturn(Completable.complete());

        saveProfilePictureUseCase.execute(userModelTest).subscribe(testObserver);

        Mockito.verify(userRepository, Mockito.times(1)).saveProfilePicture(DomainTestData.USER_MODEL);
        Mockito.verifyNoMoreInteractions(userRepository);

        testObserver.assertComplete();


    }



}