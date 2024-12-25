## Secure Server and Client Setup

### SecureServer

The `SecureServer` class sets up a secure server using SSL. It loads the keystore, initializes the `KeyManagerFactory`, and creates an `SSLServerSocket` to communicate with clients.

### SecureClient

The `SecureClient` class sets up a secure client using SSL. It loads the truststore, initializes the `TrustManagerFactory`, and creates an `SSLSocket` to communicate with the server.

### Keystore and Truststore

To list the entries in the keystore, use the following command:

```sh
keytool -list -v -keystore keystore.jks -storepass changeit
```
### Create a Keystore
```sh
keytool -genkeypair -alias mykey -keyalg RSA -keysize 2048 -dname "CN=localhost, OU=Unknown, O=Unknown, L=Unknown, ST=Unknown, C=Unknown" -validity 365 -storetype JKS -keystore keystore.jks -storepass changeit
