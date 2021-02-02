keytool -genkeypair -alias admission -keyalg RSA -keypass admission-api -keystore admission-keystore.jks -storepass admission-api

keytool -list -rfc --keystore admission-keystore.jks | openssl x509 -inform pem -pubkey


## Docker build

```
docker build --rm -t adm-api .
```