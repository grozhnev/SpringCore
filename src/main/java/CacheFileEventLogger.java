<<<<<<< Updated upstream
package PACKAGE_NAME;

public class CacheFileEventLogger {
=======
import javax.annotation.PreDestroy;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    String cacheSize;
    List<Event> cache;

    public void setCacheSize(String cacheSize) {
        this.cacheSize = cacheSize;
    }

    public CacheFileEventLogger(String fileName) {
        super(fileName);
    }

    public void logEvent(Event event) {
         cache.add(event);

         if (cache.size() == Integer.valueOf(cacheSize)){
             writeEventsFromCache();
             cache.clear();
         }
    }

    private void writeEventsFromCache() {
        for (Event event : cache) {
            super.logEvent(event);
        }
    }

    @PreDestroy
    void destroy(){
        //.. kill'em all
    }
>>>>>>> Stashed changes
}
