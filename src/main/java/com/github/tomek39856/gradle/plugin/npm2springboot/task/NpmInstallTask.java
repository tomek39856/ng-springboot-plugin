package com.github.tomek39856.gradle.plugin.npm2springboot.task;

import java.util.Arrays;

public class NpmInstallTask extends AbstractNpmTask {
  public static final String TASK_NAME = "npmInstall";

  public NpmInstallTask() {
    super(Arrays.asList("install"));
  }
}
