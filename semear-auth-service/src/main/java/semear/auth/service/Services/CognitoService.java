package semear.auth.service.Services;

import io.micronaut.context.annotation.Value;
import jakarta.inject.Singleton;
import semear.auth.service.Models.LoginRequestDTO;
import semear.auth.service.Models.LoginResponseDTO;
import semear.auth.service.Services.Interfaces.ICognitoService;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminInitiateAuthRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminInitiateAuthResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AuthFlowType;

import java.util.Map;

@Singleton
public class CognitoService implements ICognitoService {
    @Value("${AWS.cognito.user-pool-id}")
    private String userPoolId;
    @Value("${AWS.cognito.client-id}")
    private String clientId;
    @Value("${AWS.region}")
    private String region;

    private CognitoIdentityProviderClient client(){
        return CognitoIdentityProviderClient.builder()
                .region(Region.of(region))
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }

    public LoginResponseDTO Login(String username, String password){
        var authRequest = AdminInitiateAuthRequest.builder()
                .authFlow(AuthFlowType.ADMIN_NO_SRP_AUTH)
                .userPoolId(userPoolId)
                .clientId(clientId)
                .authParameters(Map.of("USERNAME", username, "PASSWORD", password))
                .build();

        AdminInitiateAuthResponse response = client().adminInitiateAuth(authRequest);
        return new LoginResponseDTO(
                response.authenticationResult().idToken(),
                response.authenticationResult().accessToken(),
                response.authenticationResult().refreshToken()
        );
    }

}
