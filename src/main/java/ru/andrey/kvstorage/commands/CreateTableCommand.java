package ru.andrey.kvstorage.commands;

import ru.andrey.kvstorage.commandresults.DatabaseCreateTableResult;
import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;
import ru.andrey.kvstorage.console.ExecutionEnvironment;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CreateTableCommand implements DatabaseCommand {

    private final String databaseName;

    private final String tableName;

    private final ExecutionEnvironment context;

    public CreateTableCommand(ExecutionEnvironment context, String databaseName, String tableName) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.context = context;
    }

    public DatabaseCommandResult execute() {
        Optional<Database> odb = context.getDatabase(databaseName);
        if (odb.isEmpty()) {
            return DatabaseCreateTableResult.CreateFailedResult(DatabaseCreateTableResult.ERROR_NOT_SUCH_DATABASE);
        }
        try {
            odb.get().createTableIfNotExists(tableName);
            return DatabaseCreateTableResult.CreateSuccessResult();
        }
        catch (DatabaseException e) {
            return DatabaseCreateTableResult.CreateFailedResult(e.getMessage());
        }
    }

}
