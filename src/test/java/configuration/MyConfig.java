package configuration;
import org.aeonbits.owner.Config;

@Config.Sources("file:src/test/resources/petstore.properties")
public interface MyConfig extends Config {
    String url();
}
