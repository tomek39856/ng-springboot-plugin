package com.github.tomek39856.gradle.plugin.npm2springboot.task;

import org.gradle.api.tasks.Copy;

import static java.io.File.separator;

public class CopyFrontendResourcesTask extends Copy implements ProjectDirectoryConfigurableWebappBuildTask {
  public static final String TASK_NAME = "copyFrontendToResources";

  public CopyFrontendResourcesTask() {
    String projectDirectory = getProjectDirectory(getProject());
    this.from(projectDirectory + separator + "dist" + separator + projectDirectory);
    this.into("build" + separator + "resources" + separator + "main" + separator + "static");
    this.dependsOn(NpmBuildTask.TASK_NAME);
  }
}
