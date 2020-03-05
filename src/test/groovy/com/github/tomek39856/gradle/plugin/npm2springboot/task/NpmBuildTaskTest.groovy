package com.github.tomek39856.gradle.plugin.npm2springboot.task

import com.github.tomek39856.gradle.plugin.npm2springboot.NgSpringBootPlugin
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

class NpmBuildTaskTest extends Specification {
    public static final String PROJECT_DIRECTORY = "projectDir"

    def "should configure build directory and executable command"() {
        given:
        def project = ProjectBuilder
                .builder()
                .withProjectDir(new File(PROJECT_DIRECTORY))
                .build()

        when:
        new NgSpringBootPlugin().apply(project)
        def npmInstallTask = project.getTasksByName(NpmBuildTask.TASK_NAME, true)[0]

        then:
        npmInstallTask.properties.executable == 'npm' || 'npm.cmd'
        npmInstallTask.properties.args[0] == 'run'
        npmInstallTask.properties.args[1] == 'build'
        npmInstallTask.properties.workingDir.toString().contains('web')
    }

    def "should configure dependency on npmInstall task"() {
        given:
        def project = ProjectBuilder
                .builder()
                .withName("testProject")
                .withProjectDir(new File(PROJECT_DIRECTORY))
                .build()

        when:
        new NgSpringBootPlugin().apply(project)
        def copyFrontendResourcesTask = project.getTasksByName(NpmBuildTask.TASK_NAME, true)[0]


        then:
        copyFrontendResourcesTask.dependsOn.contains(NpmInstallTask.TASK_NAME)
    }
}
