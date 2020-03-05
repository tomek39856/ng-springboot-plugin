package com.github.tomek39856.gradle.plugin.npm2springboot

import com.github.tomek39856.gradle.plugin.npm2springboot.extension.WebappBuildConfig
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

class NgSpringBootPluginTest extends Specification {
    def "should register all plugins when project provided"() {
        given:
        def project = ProjectBuilder
                .builder()
                .build()

        when:
        new NgSpringBootPlugin().apply(project)
        def tasks = project.getTasks()

        then:
        tasks.size() == 3
    }

    def "should register extension with default values when project provided"() {
        given:
        def project = ProjectBuilder
                .builder()
                .build()

        when:
        new NgSpringBootPlugin().apply(project)

        then:
        project.extensions.ngspringbootplugin instanceof WebappBuildConfig
        project.extensions.ngspringbootplugin.projectDirectory == "web"
    }
}
