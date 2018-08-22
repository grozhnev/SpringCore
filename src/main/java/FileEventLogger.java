<<<<<<< Updated upstream
package PACKAGE_NAME;

public class FileEventLogger {
=======
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Service("fileLogger")
@Scope("prototype")
public class FileEventLogger implements EventLogger {
    @Value("newFile.txt")
    String fileName;
    File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    @PostConstruct
    public void init() throws IOException {
        this.file = new File(fileName);
    }

    @Override
    public void logEvent(Event event) {
        try {
            if(file.canWrite()){
                FileUtils.writeStringToFile(file, event.toString(), true);
            } else {
                throw new IOException("We can't write to" + file.toString());
            }
        } catch (IOException | NullPointerException e) {
            System.err.println("EXCEPTION IN FILEEVENTLOGGER:");
            e.printStackTrace();
        }
    }
>>>>>>> Stashed changes
}
