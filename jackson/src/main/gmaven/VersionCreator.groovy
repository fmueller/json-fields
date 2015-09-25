/**
 * This creates a Jackson Version class using the Maven Project Coordinates.
 */
class VersionCreator{
    
    void create(project, packageName, className){
        def file = new File(project.build.directory,
                'generated-sources/groovy/' + (packageName.replace('.', '/') + '/' + className + '.java'))
        file.parentFile.mkdirs()
        file.text = """
package $packageName;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.util.VersionUtil;

public final class $className implements Versioned {
    public static final Version VERSION = VersionUtil.parseVersion(
        "${project.version}",
        "${project.groupId}",
        "${project.artifactId}");

    @Override
    public Version version() {
        return VERSION;
    }
    
    private $className(){}

    private static final $className INSTANCE = new $className();
    public static $className get(){
        return INSTANCE;
    }
}
"""
        project.compileSourceRoots.add(project.build.directory+'/generated-sources/groovy/')
    }
    
}