package center;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  配置读取器，配置启动测试读取一次
 */
@Log4j2
public class PropertiesReader {
    private static Properties properties;

    public static Properties getProperties(){
        if (properties==null){
            log.info("读取配置文件：{}","env.properties");
            InputStream stream = PropertiesReader.class.getClassLoader().getResourceAsStream("env.properties");
            properties = new Properties();
            try {
                properties.load(stream);
                log.info("读取到配置文件内容：{}",properties.toString());
            } catch (IOException e) {
                log.error("配置文件读取失败");
                e.printStackTrace();
            }
        }
        return properties;
    }
}
