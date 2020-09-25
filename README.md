# cassandra-java-driver-collection-append
Example of how to append to a collection using Java Driver's annotation-driven Mappers


## Building

```
./gradlew build
```

## Running

1. Create table, insert some values followed by `nodetool flush`

```
CREATE TABLE keyspace1.contact (
    name text PRIMARY KEY,
    phone_numbers set<text>
)
```

2. Modify C* hostname  `src/main/java/driver/append/example/App`

3. Run app: `./gradlew run`

