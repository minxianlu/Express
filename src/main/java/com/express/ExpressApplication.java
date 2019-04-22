package com.express;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author chenyb
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan({"com.express.project.*.*.mapper"})
public class ExpressApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(ExpressApplication.class, args);
        System.out.println(
                        "                        .::::.\n" +
                        "                     .::::::::.\n" +
                        "                    :::::::::::\n" +
                        "                 ..:::::::::::'\n" +
                        "              '::::::::::::'\n" +
                        "                .::::::::::\n" +
                        "           '::::::::::::::..\n" +
                        "                ..::::::::::::.\n" +
                        "              ``::::::::::::::::\n" +
                        "               ::::``:::::::::'        .:::.\n" +
                        "              ::::'  '::::::'       .::::::::.\n" +
                        "            .::::'     :::::     .:::::::'::::.\n" +
                        "           .:::'       :::::  .:::::::::' ':::::.\n" +
                        "          .::'        :::::.:::::::::'      ':::::.\n" +
                        "         .::'         ::::::::::::::'         ``::::.\n" +
                        "     ...:::           ::::::::::::'              ``::.\n" +
                        "    ```` ':.          ':::::::::'                  ::::..\n" +
                        "                       '.:::::'                    ':'````..\n");
        System.out.println("(♥◠‿◠)ﾉﾞ  项目启动成功   ლ(´ڡ`ლ)ﾞ  \\n");
    }
}