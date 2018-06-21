## Release Instructions

1. Make sure, that all tests are successful:
```bash
./gradlew test
```

2. Run gradle release:
```bash
./gradlew release
```

3. Close and release artifact in staging [OSS nexus repository](https://oss.sonatype.org/#stagingRepositories).