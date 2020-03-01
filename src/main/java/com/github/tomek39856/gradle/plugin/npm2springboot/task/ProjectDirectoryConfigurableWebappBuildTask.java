package com.github.tomek39856.gradle.plugin.npm2springboot.task;

import com.github.tomek39856.gradle.plugin.npm2springboot.extension.WebappBuildConfig;
import org.gradle.api.Project;

import java.util.Optional;

public interface ProjectDirectoryConfigurableWebappBuildTask {
  default String getProjectDirectory(Project project) {
    return Optional.ofNullable(project.getExtensions().getByType(WebappBuildConfig.class).getProjectDirectory())
        .orElseThrow(() -> new IllegalArgumentException("provide ngspringboot.projectDirectory in build.gradle file"));
  }
}
