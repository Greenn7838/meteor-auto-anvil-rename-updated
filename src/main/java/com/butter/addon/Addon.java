package com.butter.addon;

import com.butter.addon.modules.AnvilDupe;
import com.mojang.logging.LogUtils;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.systems.modules.Modules;

import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;

public class Addon extends MeteorAddon {
    public static final Logger LOG = LogUtils.getLogger();


    @Override
    public void onInitialize() {
        LOG.info("Initializing Meteor Dupe addon");

        // register @EventHandler
        MeteorClient.EVENT_BUS.registerLambdaFactory("com.butter.addon", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));

        // Modules
        Modules.get().add(new AnvilDupe());
    }
    

    @Override
    public String getPackage() {
        return "com.butter.addon";
    }
}
