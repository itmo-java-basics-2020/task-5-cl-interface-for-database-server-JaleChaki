package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.commandresults.DatabaseUnsupportedCommandResult;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;

public class DatabaseUnsupportedCommand implements DatabaseCommand {

    public static final DatabaseUnsupportedCommand INSTANCE = new DatabaseUnsupportedCommand();

    private DatabaseUnsupportedCommand() {

    }

    public DatabaseCommandResult execute() {
        return DatabaseUnsupportedCommandResult.INSTANCE;
    }
}
