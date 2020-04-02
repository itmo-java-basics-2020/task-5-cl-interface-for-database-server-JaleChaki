package ru.andrey.kvstorage.commandresults;

import ru.andrey.kvstorage.commands.DatabaseUnsupportedCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;

import javax.xml.crypto.Data;
import java.util.Optional;

public class DatabaseUnsupportedCommandResult implements DatabaseCommandResult {

    public static final DatabaseCommandResult INSTANCE = new DatabaseUnsupportedCommandResult();

    private static final String ERROR_UNSUPPORTED_COMMAND = "Unsupported command";

    private DatabaseUnsupportedCommandResult() {

    }

    public Optional<String> getResult() {
        return null;
    }

    public DatabaseCommandStatus getStatus() {
        return DatabaseCommandStatus.FAILED;
    }

    public boolean isSuccess() {
        return false;
    }

    public String getErrorMessage() {
        return ERROR_UNSUPPORTED_COMMAND;
    }

}
