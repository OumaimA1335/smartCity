package com.smartCity.finesService.entities;




import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {
   @Id 
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   private String nationalIdNumber;
   private String FullName;
   private String gender;
   private String nationnality;
   private String phoneNumber;
   private String address;
   private String profession;
   @OneToMany(mappedBy="citizen")
   private List<Fine> listFines;
}
