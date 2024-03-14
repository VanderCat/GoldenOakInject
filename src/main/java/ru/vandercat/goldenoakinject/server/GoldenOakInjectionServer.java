package ru.vandercat.goldenoakinject.server;

import net.fabricmc.api.DedicatedServerModInitializer;
import ru.vandercat.goldenoakinject.GoldenOakInjection;

public class GoldenOakInjectionServer implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        GoldenOakInjection.LOGGER.info("omg hi!!!! im working uwu");
    }
}
