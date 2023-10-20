package demo.project.pd.workshop.demostatement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfficeCab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private String pickupAddress;

    private String dropAddress;
    private  String name;

    private  long contactNumber;

    private String cabNumber;

    private String time;

    private String emailId;



}
