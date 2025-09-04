package kg.gov.mtsdr.ubk.integration.tunduk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

@Configuration
public class SecurityCredentialsConfig {

    @Value("${tunduk.security.keystore.path}")
    private Resource keyStore;

    @Value("${tunduk.security.keystore.password}")
    private String keyStorePassword;

    @Value("${tunduk.security.keystore.alias}")
    private String keyAlias;

    @Value("${tunduk.security.truststore.path}")
    private Resource trustStore;

    @Value("${tunduk.security.truststore.password}")
    private String trustStorePassword;

    @Bean
    public KeyStore keyStore() throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        ks.load(keyStore.getInputStream(), keyStorePassword.toCharArray());
        return ks;
    }

    @Bean
    public KeyPair keyPair(KeyStore keyStore) throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException {
        Key key = keyStore.getKey(keyAlias, keyStorePassword.toCharArray());
        if (key instanceof PrivateKey) {
            X509Certificate cert = (X509Certificate) keyStore.getCertificate(keyAlias);
            PublicKey publicKey = cert.getPublicKey();
            return new KeyPair(publicKey, (PrivateKey) key);
        }
        return null;
    }

    @Bean
    public KeyStore trustStore() throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        KeyStore ts = KeyStore.getInstance(KeyStore.getDefaultType());
        ts.load(trustStore.getInputStream(), trustStorePassword.toCharArray());
        return ts;
    }
}
