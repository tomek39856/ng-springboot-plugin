package com.github.tomek39856.gradle.plugin.npm2springboot.task;

import java.io.File;
import java.util.Arrays;

public class NpmBuildTask extends AbstractNpmTask {
  public static final String TASK_NAME ="npmBuildFrontend";

  public NpmBuildTask() {
    super(Arrays.asList("run", "build"));
    configureInputsAndOutputsForIncrementalBuild();
    this.dependsOn(NpmInstallTask.TASK_NAME);
  }

  private void configureInputsAndOutputsForIncrementalBuild() {
    String projectDirectory = getProjectDirectory(getProject());
    this.getInputs().file(new File(projectDirectory + "/package.json"));
    this.getInputs().dir(projectDirectory + "/src");
    this.getOutputs().dir(projectDirectory + "/dist");
  }
}
