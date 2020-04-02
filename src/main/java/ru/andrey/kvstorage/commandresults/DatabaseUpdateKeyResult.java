package ru.andrey.kvstorage.commandresults;

import ru.andrey.kvstorage.console.DatabaseCommandResult;

import java.util.Objects;
import java.util.Optional;

public class DatabaseUpdateKeyResult implements DatabaseCommandResult {

    public static DatabaseUpdateKeyResult CreateSuccessResult() {
        return new DatabaseUpdateKeyResult(null);
    }

    public static DatabaseUpdateKeyResult CreateFailedResult(String errorMessage) {
        return new DatabaseUpdateKeyResult(errorMessage);
    }

    public static final String ERROR_NOT_SUCH_DATABASE = "Not such database";

    private final String errorMessage;

    private DatabaseUpdateKeyResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Optional<String> getResult() {
        return null;
    }

    public DatabaseCommandStatus getStatus() {
        return Objects.isNull(errorMessage) ? DatabaseCommandStatus.SUCCESS : DatabaseCommandStatus.FAILED;
    }

    public boolean isSuccess() {
        return Objects.isNull(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
