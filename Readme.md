# Connector

This repository contains a dataspace connector built via the [EDC](https://eclipse-edc.github.io/) open source framework by the Eclipse Foundation.

The used configuration is based on [MinimumViableDataspace](https://github.com/eclipse-edc/MinimumViableDataspace)

# License

Apache 2.0

# How to run

to run on your local machine run:
```
docker build -t connector:v0 .
```

Then use same image in connector example for [provider](https://github.com/wetransform/connector-example/blob/19e2960b1c53f74ca171da7c4a4c66aee7d08813/docker-compose.yaml#L4) and [consumer](https://github.com/wetransform/connector-example/blob/19e2960b1c53f74ca171da7c4a4c66aee7d08813/docker-compose.yaml#L60).