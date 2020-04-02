package ru.andrey.kvstorage.commandresults;

import com.sun.net.httpserver.Authenticator;
import ru.andrey.kvstorage.commands.DatabaseReadKeyCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;

import java.util.Objects;
import java.util.Optional;

public class DatabaseReadKeyResult implements DatabaseCommandResult {

    public static final String ERROR_NOT_SUCH_DATABASE = "Not such table";

    private final String errorMessage;

    private String keyValue;

    private DatabaseReadKeyResult() {
        this.errorMessage = null;
    }

    private DatabaseReadKeyResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static DatabaseReadKeyResult CreateSuccessResult(String keyValue) {
        DatabaseReadKeyResult result = new DatabaseReadKeyResult();
        result.keyValue = keyValue;
        return new DatabaseReadKeyResult();
    }

    public static DatabaseReadKeyResult CreateFailedResult(String errorMessage) {
        return new DatabaseReadKeyResult(errorMessage);
    }

    public Optional<String> getResult() {
        return Optional.of(keyValue);
    }


    public DatabaseCommandResult.DatabaseCommandStatus getStatus() {
        return isSuccess() ? DatabaseCommandResult.DatabaseCommandStatus.SUCCESS : DatabaseCommandResult.DatabaseCommandStatus.FAILED;
    }

    public boolean isSuccess() {
        return Objects.isNull(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
