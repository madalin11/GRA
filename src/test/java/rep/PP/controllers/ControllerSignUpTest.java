package rep.PP.controllers;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import rep.PP.services.FileSystemService;
import rep.PP.services.UserService;

import static org.junit.Assert.*;

public class ControllerSignUpTest extends ApplicationTest {

    @Test
    public void initialize() {
    }

    @Test
    public void home() {
    }

    @Test
    public void handleRegisterAction() {

    }
    public static final String TEST_USER = "testUser";
    public static final String TEST_PASSWORD = "testPassword";
    private ControllerSignUp controller;

    @BeforeClass
    public static void setupClass() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".test-registration-example";
        FileSystemService.initApplicationHomeDirIfNeeded();
        UserService.loadUsersFromFile();
    }

    @Before
    public void setUp() throws Exception {
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomePath().toFile());
        UserService.loadUsersFromFile();

        controller = new ControllerSignUp();
        controller.usernameField = new TextField();
        controller.passwordField = new PasswordField();
        controller.registrationMessage = new Text();
        controller.mail=new TextField();
        controller.passwordField.setText(TEST_PASSWORD);
        controller.usernameField.setText(TEST_USER);
    }

    @Test
    public void testHandleAddUserActionCode() {
        controller.handleRegisterAction();

        assertEquals("Username used !", controller.registrationMessage.getText());
    }

    @Test
    public void testAddSameUserTwice() {
        controller.handleRegisterAction();
        controller.handleRegisterAction();
        assertEquals("Username used !" , controller.registrationMessage.getText());
    }
}