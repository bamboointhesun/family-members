package vip.leemy.sunny.familymembers.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author: Leemy
 * @date: 2022/1/12-19:28
 * @description: 家庭成员
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "family_members",
uniqueConstraints = {
        @UniqueConstraint(name = "members_phone_unique",columnNames = "phone"),
        @UniqueConstraint(name = "members_email_unique",columnNames = "email"),
})
public class FamilyMembers {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(updatable = false)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int age;
    @Column(columnDefinition = "varchar(255) COMMENT '生日' ")
    private String birthday;
    @Column(nullable = false,columnDefinition = "integer COMMENT '生日月份' ")
    private int birthYear;
    @Column(nullable = false,columnDefinition = "varchar(255) COMMENT '星座' ")
    private String constellation;
    @Column(nullable = false,columnDefinition = "varchar(255) COMMENT '生肖' ")
    private String animalSigns;
    @Column(nullable = false)
    private String sex;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String job;
}
