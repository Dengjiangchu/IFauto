package common;

import center.PropertiesReader;
import lombok.extern.log4j.Log4j2;

import java.util.Properties;

/**
 *  测试基类，初始化时获取环境变量
 */
@Log4j2
public class BaseTest {
    private String host;

    private String env;

    private Properties properties;

    public BaseTest() {
        properties = PropertiesReader.getProperties();
        String env = this.properties.getProperty("environment");
        String host = this.properties.getProperty("api.host");
        this.host = host;
        this.env = env;
    }

    public String getHost() {
        return host;
    }

    public String getEnv() {
        return env;
    }
}
