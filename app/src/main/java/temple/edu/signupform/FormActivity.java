package temple.edu.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
   //
    EditText userName;
    EditText userEmail;
    EditText userPassword;
    EditText ConfirmPassword;
    //
    TextView wrong_Name;
    TextView wrong_Email;
    TextView wrong_Password;
    TextView wrong_ConfirmPassword;
    String name, email, password, confirmPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
    }

    private void start() {
        userName = findViewById(R.id.editName);
        userEmail = findViewById(R.id.editEmail);
        ConfirmPassword = findViewById(R.id.editConfirmPassword);
        userPassword = findViewById(R.id.editPassword);
        wrong_Name = findViewById(R.id.wrong_Name);
        wrong_Email = findViewById(R.id.wrong_Email);
        wrong_Password = findViewById(R.id.wrong_Password);
        wrong_ConfirmPassword = findViewById(R.id.wrong_ConfirmPassword);
    }

    public void saveClick(View view) {
        name = userName.getText().toString();
        email = userEmail.getText().toString();
        password = userPassword.getText().toString();
        confirmPassword = ConfirmPassword.getText().toString();

        if (name.equals(""))
            wrong_Name.setVisibility(View.VISIBLE);
        else
            wrong_Name.setVisibility(View.GONE);
        if (email.equals(""))
            wrong_Email.setVisibility(View.VISIBLE);
        else
            wrong_Email.setVisibility(View.GONE);
        if (password.equals(""))
            wrong_Password.setVisibility(View.VISIBLE);
        else
            wrong_Password.setVisibility(View.GONE);
        if (confirmPassword.equals("")) {
            wrong_ConfirmPassword.setText(R.string.cnf_pass);
            wrong_ConfirmPassword.setVisibility(View.VISIBLE);
        } else {
            wrong_ConfirmPassword.setText(R.string.password_does_not_match);
            wrong_ConfirmPassword.setVisibility(View.GONE);
        }
        if (!confirmPassword.equals(password))
            wrong_ConfirmPassword.setVisibility(View.VISIBLE);
        else
            wrong_ConfirmPassword.setVisibility(View.GONE);
        if (!name.equals("") && !email.equals("") && !password.equals("") && confirmPassword.equals(password)) {
            Toast.makeText(this, "Welcome, " + name + ", to the SignUpForm App", Toast.LENGTH_LONG).show();
        }
    }
}