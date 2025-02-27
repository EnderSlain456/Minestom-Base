package net.enderslain.properties;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Map;

public class PropertiesManager {

    private final String resourcePath = "properties.yml";  // Path to the YAML file in resources
    private Properties properties;

    public PropertiesManager() {
        this.properties = new Properties();
    }

    // Load properties from YAML file in the resources folder
    public boolean loadProperties() {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream != null) {
                Map<String, Object> data = yaml.load(inputStream);
                if (data != null) {
                    properties.setIP((String) data.get("server.ip"));
                    properties.setPort((Integer) data.get("server.port"));
                    properties.setMotd((String) data.get("server.motd"));
                    return true;
                }
            } else {
                System.out.println("YAML file not found in resources.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Save properties to the YAML file in the resources folder
    public boolean saveProperties() {
        Yaml yaml = new Yaml();
        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        yaml = new Yaml(options);

        try (OutputStream outputStream = new FileOutputStream(new File(getClass().getClassLoader().getResource(resourcePath).toURI()))) {
            Map<String, Object> data = Map.of(
                    "server", Map.of(
                            "ip", properties.getIP(),
                            "port", properties.getPort(),
                            "motd", properties.getMotd()
                    )
            );
            yaml.dump(data);
            return true;
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
