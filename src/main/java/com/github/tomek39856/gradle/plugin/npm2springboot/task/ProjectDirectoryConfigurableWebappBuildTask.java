package com.github.tomek39856.gradle.plugin.npm2springboot.task;

import com.github.tomek39856.gradle.plugin.npm2springboot.extension.WebappBuildConfig;
import org.gradle.api.Project;

public interface ProjectDirectoryConfigurableWebappBuildTask {
  default String getProjectDirectory(Project project) {
    return project.getExtensions().getByType(WebappBuildConfig.class).getProjectDirectory();
  }
}
