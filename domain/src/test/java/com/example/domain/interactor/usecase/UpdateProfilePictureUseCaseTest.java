package com.example.domain.interactor.usecase;

import com.example.domain.model.UserModel;
import com.example.domain.repositories.UserRepository;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import io.reactivex.Completable;
import io.reactivex.observers.TestObserver;

public class UpdateProfilePictureUseCaseTest{

    private UpdateProfilePictureUseCase updateProfilePictureUseCase;
    private UserRepository userRepository;
    private TestObserver<Object> testObserver;

    @Before
    public void setUp() throws Exception {
        userRepository = Mockito.mock(UserRepository.class);
        updateProfilePictureUseCase = new UpdateProfilePictureUseCase(userRepository);
        testObserver = new TestObserver<>();
    }

    @Test
    public void shouldUpdateProfilePicture() {

        UserModel userModelTest = DomainTestData.USER_MODEL;

        Mockito.when(userRepository.updateProfilePicture(userModelTest)).thenReturn(Completable.complete());

        updateProfilePictureUseCase.execute(userModelTest).subscribe(testObserver);

        Mockito.verify(userRepository, Mockito.times(1)).updateProfilePicture(DomainTestData.USER_MODEL);
        Mockito.verifyNoMoreInteractions(userRepository);
        testObserver.assertComplete();
    }


}