package nio.ok;

import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;

/**
 * ${end}
 *
 * @author Isen
 * @date 2018/8/9 16:37
 */
public class PathDemo {
    @Test
    public void testPath(){
        Path path = Paths.get("c:\\data\\myfile.txt");

        Path projects = Paths.get("d:\\data", "projects");

        Path file = Paths.get("d:\\data", "projects\\a-project\\myfile.txt");

        Path currentDir = Paths.get(".");
        System.out.println(currentDir.toAbsolutePath());

        String originalPath =
                "d:\\data\\projects\\a-project\\..\\another-project";

        Path path1 = Paths.get(originalPath);
        System.out.println("path1 = " + path1);

        Path path2 = path1.normalize();
        System.out.println("path2 = " + path2);
    }
}
