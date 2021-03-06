package com.azuriom.azlink.common;

import com.azuriom.azlink.common.command.CommandSender;
import com.azuriom.azlink.common.data.PlatformData;
import com.azuriom.azlink.common.data.WorldData;
import com.azuriom.azlink.common.logger.LoggerAdapter;

import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

public interface AzLinkPlatform {

    AzLinkPlugin getPlugin();

    LoggerAdapter getLoggerAdapter();

    PlatformType getPlatformType();

    String getPlatformName();

    String getPlatformVersion();

    String getPluginVersion();

    Path getDataDirectory();

    Stream<CommandSender> getOnlinePlayers();

    int getMaxPlayers();

    default Optional<WorldData> getWorldData() {
        return Optional.empty();
    }

    void dispatchConsoleCommand(String command);

    default void executeSync(Runnable runnable) {
        executeAsync(runnable);
    }

    void executeAsync(Runnable runnable);

    default PlatformData getPlatformData() {
        return new PlatformData(getPlatformType(), getPlatformName(), getPlatformVersion());
    }
}
