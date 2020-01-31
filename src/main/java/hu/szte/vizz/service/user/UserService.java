package hu.szte.vizz.service.user;

import hu.szte.vizz.exception.TokenNotFoundException;
import hu.szte.vizz.exception.UserActivatedException;
import hu.szte.vizz.exception.UserExistsException;
import hu.szte.vizz.exception.UserNotFoundException;
import hu.szte.vizz.model.user.RegisterDTO;
import hu.szte.vizz.model.user.TokenDTO;
import hu.szte.vizz.model.user.UserDTO;

import java.util.UUID;

/**
 * Service for the user management
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public interface UserService {
    /**
     * Returns the user by the specified ID
     *
     * @param id ID of the user
     * @return Properties of the user
     * @throws UserNotFoundException if the user is not found
     */
    UserDTO getUserById(UUID id) throws UserNotFoundException;

    /**
     * Registers a user with the specified paramterer
     *
     * @param user Parameters of the user who wants to register
     * @return Paramteres of the registered user
     * @throws UserExistsException if the user is already registered (username or email exists)
     */
    UserDTO registerUser(RegisterDTO user) throws UserExistsException;

    /**
     * Deletes the user
     *
     * @param user Parameters of the user who wants to be deleted
     * @throws UserNotFoundException if the user is not found
     */
    void deleteUser(UserDTO user) throws UserNotFoundException;


    /**
     * Returns the existence of a user by a specified username.
     *
     * @param username The username which is checked
     * @return Returns true if the user exists.
     */
    boolean usernameExists(String username);

    /**
     * Returns the existence of a user by a specified email address.
     *
     * @param email The email address which is checked
     * @return Returns true if the user exists.
     */
    boolean emailExists(String email);

    /**
     * Sends an activation mail to the specified user.
     *
     * @param user Recipient of the mail
     * @throws UserNotFoundException if the user is not found
     * @throws UserActivatedException if the user is already activated
     */
    void sendActivationMail(UserDTO user) throws UserActivatedException, UserNotFoundException;

    /**
     * Handles the email confirmation of the specified user
     *
     * @param token Email confirmation token and its user
     * @throws UserNotFoundException if the user is not found
     * @throws TokenNotFoundException if the token is not found (maybe expired)
     * @throws UserActivatedException if the user is already activated
     */
    void confirmEmailActivation(TokenDTO token) throws UserActivatedException, UserNotFoundException, TokenNotFoundException;
}
