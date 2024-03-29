# :arrows_counterclockwise: p2e

Convert Spring configuration property names to environment variable names.

# Usage

The easiest way to use `p2e` is via [JBang](https://jbang.dev/).

```sh
$ jbang p2e@helpermethod spring.application.name
# outputs SPRING_APPLICATION_NAME
```

Alternatively, you can install `p2e` as a native image with [Homebrew](https://brew.sh/).

```sh
$ brew tap helpermethod/tap
$ brew install p2e

$ p2e spring.application.name
# outputs SPRING_APPLICATION_NAME
```
