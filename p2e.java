///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS info.picocli:picocli:4.6.3
//DEPS info.picocli:picocli-codegen:4.6.3
//JAVA 17

import java.util.Locale;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "p2e", mixinStandardHelpOptions = true, version = "0.1.0",
        description = "Convert Spring configuration property names to environment variable names.")
class p2e implements Runnable {
    @Parameters(index = "0", description = "The property name")
    private String property;

    public static void main(String... args) {
        System.exit(new CommandLine(new p2e()).execute(args));
    }

    @Override
    public void run() {
        // see https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config.typesafe-configuration-properties.relaxed-binding.environment-variables
        var environmentVariableName =
            property
                .replace(".", "_")
                .replace("-", "")
                .replaceAll("\\[(?<index>[0-9]+)\\]", "_${index}")
                .toUpperCase(Locale.ENGLISH);

        System.out.println(environmentVariableName);
    }
}
