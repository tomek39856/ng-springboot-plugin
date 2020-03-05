package com.github.tomek39856.gradle.plugin.npm2springboot.task;

import org.gradle.api.tasks.Exec;
import org.gradle.internal.os.OperatingSystem;

import java.io.File;
import java.util.List;

public abstract class AbstractNpmTask extends Exec implements ProjectDirectoryConfigurableWebappBuildTask {
  AbstractNpmTask(List<String> arguments) {
    configureNpmExecutionMethod();
    setArgs(arguments);
    configureWebappBuild();
  }

  private void configureWebappBuild() {
    setWorkingDir(new File(
        getProjectDirectory(getProject())
    ));
  }

  private void configureNpmExecutionMethod() {
    if (OperatingSystem.current().isWindows()) {
      setExecutable("npm.cmd");
    } else {
      setExecutable("npm");
    }
  }
}
