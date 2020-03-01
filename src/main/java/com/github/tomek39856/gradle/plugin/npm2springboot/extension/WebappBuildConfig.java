package com.github.tomek39856.gradle.plugin.npm2springboot.extension;

public class WebappBuildConfig {
  public static final String NAME = "ngspringbootplugin";

  private String projectDirectory;

  public String getProjectDirectory() {
    return projectDirectory;
  }

  public void setProjectDirectory(String projectDirectory) {
    this.projectDirectory = projectDirectory;
  }
}
