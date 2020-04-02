package ru.andrey.kvstorage.commandresults;

import com.sun.net.httpserver.Authenticator;
import ru.andrey.kvstorage.console.DatabaseCommandResult;

import java.util.Objects;
import java.util.Optional;

public class DatabaseCreateTableResult implements DatabaseCommandResult {

    public static final String ERROR_TABLE_ALREADY_EXISTS = "Table already exists";

    public static final String ERROR_NOT_SUCH_DATABASE = "Not such table";


    private final String errorMessage;

    private DatabaseCreateTableResult() {
        this.errorMessage = null;
    }

    private DatabaseCreateTableResult(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static DatabaseCreateTableResult CreateSuccessResult() {
        return new DatabaseCreateTableResult();
    }

    public static DatabaseCreateTableResult CreateFailedResult(String errorMessage) {
        return new DatabaseCreateTableResult(errorMessage);
    }

    public Optional<String> getResult() {
        return null;
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
