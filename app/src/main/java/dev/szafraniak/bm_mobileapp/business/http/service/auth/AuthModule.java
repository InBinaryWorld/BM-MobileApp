package dev.szafraniak.bm_mobileapp.business.http.service.auth;

import android.app.Application;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.szafraniak.bm_mobileapp.BuildConfig;

@Module
public class AuthModule {

    @Provides
    @Singleton
    public AuthorizationService provideAuthorizationService(Application app) {
        return new AuthorizationService(app);
    }

    @Provides
    @Singleton
    public GoogleSignInClient provideGoogleSignInClient(Application app) {
        GoogleSignInOptions gso = new GoogleSignInOptions
                .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(BuildConfig.GOOGLE_CLIENT_ID)
                .build();
        return GoogleSignIn.getClient(app, gso);
    }
}
