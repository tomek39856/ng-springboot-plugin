package com.github.tomek39856.gradle.plugin.npm2springboot.task;

import org.gradle.api.tasks.Copy;

public class CopyFrontendResourcesTask extends Copy implements ProjectDirectoryConfigurableWebappBuildTask {
  public static final String TASK_NAME = "copyFrontendToResources";

  public CopyFrontendResourcesTask() {
    String projectDirectory = getProjectDirectory(getProject());
    this.from(projectDirectory + "/dist/" + projectDirectory);
    this.into("build/resources/main/static");
    this.dependsOn(NpmBuildTask.TASK_NAME);
  }
}
