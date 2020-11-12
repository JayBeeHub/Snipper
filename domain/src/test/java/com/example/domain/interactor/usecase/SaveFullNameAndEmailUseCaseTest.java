package com.example.domain.interactor.usecase;

import com.example.domain.model.UserModel;
import com.example.domain.repositories.UserRepository;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import io.reactivex.Completable;
import io.reactivex.observers.TestObserver;

public class SaveFullNameAndEmailUseCaseTest  {

    private SaveFullNameAndEmailUseCase saveFullNameAndEmailUseCase;
    private UserRepository userRepository;
    private TestObserver<Object> testObserver;

    @Before
    public void setUp() throws Exception {
        userRepository = Mockito.mock(UserRepository.class);
        saveFullNameAndEmailUseCase = new SaveFullNameAndEmailUseCase(userRepository);
        testObserver = new TestObserver<>();
    }

    @Test
    public void shouldSaveFullNameAndEmail(){

        UserModel userModelTest = DomainTestData.USER_MODEL;
        Mockito.when(userRepository.saveFullNameAndEmail(userModelTest)).thenReturn(Completable.complete());

        saveFullNameAndEmailUseCase.execute(userModelTest).subscribe(testObserver);

        Mockito.verify(userRepository,Mockito.times(1)).saveFullNameAndEmail(DomainTestData.USER_MODEL);
        Mockito.verifyNoMoreInteractions(userRepository);

        testObserver.assertComplete();
    }

}