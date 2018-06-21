## Release Instructions

1. Make sure, that all tests are successful:
```bash
./gradlew test
```

2. Run the gradle publish plugin:
```bash
./gradlew publish
```

3. Close and release artifact in staging [OSS nexus repository](https://oss.sonatype.org/#stagingRepositories).

4. Run the gradle release plugin:
```bash
./gradlew release
```
