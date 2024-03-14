package ru.vandercat.goldenoakinject.client;

import net.fabricmc.api.ClientModInitializer;
import ru.vandercat.goldenoakinject.GoldenOakInjection;

public class GoldenOakInjectionClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        GoldenOakInjection.LOGGER.info("Starlight Glimmer is the best pony.");
    }
}
