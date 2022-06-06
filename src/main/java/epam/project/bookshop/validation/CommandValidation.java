package epam.project.bookshop.validation;

import epam.project.bookshop.command.CommandType;

public class CommandValidation {

    public boolean checkCommandToValidation(String command) {
        if (command == null || command.isEmpty()) {
            return false;
        }

        boolean isCommand = false;

        for (int i = 0; i < CommandType.values().length; i++) {
            if (command.equalsIgnoreCase(CommandType.values()[i].name())) {
                isCommand = true;
                break;
            }
        }
        return isCommand;
    }

}
