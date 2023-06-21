package commands;

import consoles.Console;

public abstract class Command {
    protected Console console;
    private String name, description;

    protected Command(String name, String description, Console console) {
        this.name = name;
        this.description = description;
        this.console = console;
    }

    public String getName() {
        return name;
    }

    /**
     * Выполняет команду
     */
    public abstract void execute(String[] args);

    @Override
    public String toString() {
        return name + ": " + description;
    }
}