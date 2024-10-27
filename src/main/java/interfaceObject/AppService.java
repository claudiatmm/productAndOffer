package interfaceObject;

import exception.ValidationFailedException;

import java.util.List;

public interface AppService<T> {

    void create(T create) throws ValidationFailedException;
    List<T> search(String searchedTerm);
    boolean delete(T element) throws ValidationFailedException;

}
