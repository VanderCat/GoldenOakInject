package ru.vandercat.goldenoakinject;

import com.mojang.authlib.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Properties;

public class GoldenOakInjection implements PreLaunchEntrypoint {
    /**
     * Runs the mod initializer.
     */
    public static Environment NewAuth;
    public static Properties properties = new Properties();
    public static final Logger LOGGER = LogManager.getLogger();

    public static void loadDefaultProp() {
        properties.setProperty("auth", "https://goldenoak.vanderc.at");
        properties.setProperty("account", "https://goldenoak.vanderc.at");
        properties.setProperty("session", "https://goldenoak.vanderc.at");
        properties.setProperty("services", "https://goldenoak.vanderc.at");
        properties.setProperty("name", "GoldenOak");
    }
    @Override
    public void onPreLaunch() {
        var cfgFile = FabricLoader.getInstance().getConfigDir().resolve("customauth.properties").toFile();
        loadDefaultProp();
        if (!cfgFile.isFile()) {
            try {
                var stream = new FileOutputStream(cfgFile);
                properties.store(stream, "GoldenOak Injector");
            } catch (IOException e) {
                LOGGER.error("Failed to save default config");
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                var stream = new FileInputStream(cfgFile);
                properties.load(stream);
            } catch (IOException e) {
                LOGGER.error("Failed to save load config");
                throw new RuntimeException(e);
            }
        }
        NewAuth = Environment.create(
                properties.getProperty("auth"),
                properties.getProperty("account"),
                properties.getProperty("session"),
                properties.getProperty("services"),
                properties.getProperty("name")
        );
    }
}
