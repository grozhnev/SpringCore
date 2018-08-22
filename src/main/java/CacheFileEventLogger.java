import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PreDestroy;
import java.util.List;


public class CacheFileEventLogger extends FileEventLogger {
    @Value("10")
    String cacheSize;
    List<Event> cache;

//    public CacheFileEventLogger(String fileName) {
//        super(fileName);
//    }

    public CacheFileEventLogger(
            @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
            String fileName) {
        super(fileName);
    }

    public CacheFileEventLogger(String fileName, List<Event> cache) {
        super(fileName);
        this.cache = cache;
    }

//    public CacheFileEventLogger(String s, String s2) {
//        super(s);

//    }

    public void setCacheSize(String cacheSize) {
        this.cacheSize = cacheSize;
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
}
