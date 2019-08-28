package Controller;

import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


import javafx.fxml.Initializable;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Database.DBHandler; // importing DBHandler class
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class AddStudent implements Initializable {

    @FXML
    private BorderPane upperBoredePane;

    @FXML
    private Pane stdRegCompletePane;

    @FXML
    private TextField stdfn;

    @FXML
    private TextField stdln;

    @FXML
    private Text stdRegTopicText;

    @FXML
    private ImageView studentRegistrationImg;

    @FXML
    private DatePicker stddob;

    @FXML
    private TextField stdEmail;

    @FXML
    private TextField stdNIC;

    @FXML
    private TextField stdSchool;

    @FXML
    private JFXRadioButton stdMale;

    @FXML
    private ToggleGroup StudentGender;

    @FXML
    private JFXRadioButton stdFemale;

    @FXML
    private Button stdRegButton;

    @FXML
    private Text stdRegstdDetailsText;

    @FXML
    private Text stdRegParDetText;

    @FXML
    private TextField stdTel;

    @FXML
    private TextField stdID;

    @FXML
    private Pane parDetPane;

    @FXML
    private TextField parfn;

    @FXML
    private TextField parln;


    @FXML
    private TextField parHomeNo;

    @FXML
    private TextField parStAdd;

    @FXML
    private TextField parCity;

    @FXML
    private TextField parProv;

    @FXML
    private TextField parID;

    @FXML
    private VBox leftVbox;

    @FXML
    private Button VBOXHomeButton;

    @FXML
    private Button VBOXStudentButton;

    @FXML
    private Button VBOXStaffButton;

    @FXML
    private Button VBOXCourseButton;

    @FXML
    private Button VoxFinanceButton;

        private Connection connection;
        private DBHandler handler;
        private PreparedStatement pst;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

            handler = new DBHandler();

    }

    @FXML

    public void registerStudentAction(){

                // saving data
                String insert = "INSERT INTO Student(idStudent,FN,LN,email,NIC,dob,school,gender)" + "Values(?,?,?,?,?,?,?,?)";

                connection = handler.getConnection();
            try {
                    pst = connection.prepareStatement(insert);
            } catch (SQLException e1) {
                    e1.printStackTrace();
            }

            try {       // assigning values for each prepared statements
                    pst.setString(1,stdID.getText());
                    pst.setString(2,stdfn.getText());
                    pst.setString(3,stdln.getText());
                    pst.setString(4,stdEmail.getText());
                    pst.setString(5,stdNIC.getText());
                    pst.setDate(6, java.sql.Date.valueOf(stddob.getValue()));
                    pst.setString(7,stdSchool.getText());
                    pst.setString(8,getGender());


                    pst.executeUpdate();


            } catch (SQLException e1) {
                    e1.printStackTrace();
            }
    }

    public String getGender(){

            String gen = "";

            if(stdMale.isSelected()){

                    gen = "M";
            }
            else if(stdFemale.isSelected()){
                    gen = "F";
            }
            return gen;
    }


}

