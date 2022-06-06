package epam.project.bookshop.entity.type;

import epam.project.bookshop.command.CommandType;

import java.util.Arrays;
import java.util.OptionalLong;
import java.util.Set;

import static epam.project.bookshop.command.CommandType.*;

public enum Role {
    ADMIN(Set.of(ADD_BOOK, ADD_USER, ADD_GENRE, ADD_AUTHOR,
            DELETE_GENRE, DELETE_AUTHOR, DELETE_USER, DELETE_BOOK,
            UPDATE_GENRE, UPDATE_BOOK, UPDATE_AUTHOR,
            LOGOUT, LOGIN, DEFAULT)),
    MODERATOR(Set.of(ADD_BOOK, ADD_USER, ADD_GENRE, ADD_AUTHOR,
            UPDATE_GENRE, UPDATE_BOOK, UPDATE_AUTHOR,
            LOGOUT, LOGIN, DEFAULT)),
    USER(Set.of(ADD_USER, DELETE_USER,
            LOGOUT, LOGIN, DEFAULT));

    private final Set<CommandType> permission;

    Role(Set<CommandType> permission) {
        this.permission = permission;
    }

    public static boolean findPermission(Long roleId, String permission){

        boolean isPrediction = false;
        for (int i = 0; i <Role.values().length; i++) {
            if (i==roleId){
                isPrediction = Role.values()[i].permission.stream()
                        .anyMatch(commandType -> commandType.toString().toLowerCase().equals(permission));
            }
        }

        return isPrediction;
    }
}