package com.github.tomek39856.gradle.plugin.npm2springboot;

import com.github.tomek39856.gradle.plugin.npm2springboot.extension.WebappBuildConfig;
import com.github.tomek39856.gradle.plugin.npm2springboot.task.CopyFrontendResourcesTask;
import com.github.tomek39856.gradle.plugin.npm2springboot.task.NpmBuildTask;
import com.github.tomek39856.gradle.plugin.npm2springboot.task.NpmInstallTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class NgSpringBootPlugin implements Plugin<Project> {
  @Override
  public void apply(Project project) {
    project.getExtensions().create(WebappBuildConfig.NAME, WebappBuildConfig.class);
    project.getTasks().register(NpmInstallTask.TASK_NAME, NpmInstallTask.class);
    project.getTasks().register(NpmBuildTask.TASK_NAME, NpmBuildTask.class);
    project.getTasks().register(CopyFrontendResourcesTask.TASK_NAME, CopyFrontendResourcesTask.class);
  }
}
