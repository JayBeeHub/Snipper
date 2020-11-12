package com.example.domain.interactor.usecase;

import com.example.domain.model.UserModel;
import com.example.domain.repositories.UserRepository;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import io.reactivex.Completable;
import io.reactivex.observers.TestObserver;

public class DeleteProfilePictureUseCaseTest {
    private DeleteProfilePictureUseCase deleteProfilePictureUseCase;
    private UserRepository userRepository;
    private TestObserver<Object> testObserver;

    @Before
    public void setUp() throws Exception {
        userRepository = Mockito.mock(UserRepository.class);
        deleteProfilePictureUseCase = new DeleteProfilePictureUseCase(userRepository);
        testObserver = new TestObserver<>();
    }


    @Test
    public void shouldDeleteProfilePicture() {

        UserModel userModelTest = DomainTestData.USER_MODEL;

        Mockito.when(userRepository.deleteProfilePicture(userModelTest)).thenReturn(Completable.complete());

        deleteProfilePictureUseCase.execute(userModelTest).subscribe(testObserver);

        Mockito.verify(userRepository, Mockito.times(1)).deleteProfilePicture(DomainTestData.USER_MODEL);
        Mockito.verifyNoMoreInteractions(userRepository);
        testObserver.assertComplete();
    }

}
