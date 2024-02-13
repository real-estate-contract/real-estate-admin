package hello.realestateadmin.domain.entity;

import com.sun.istack.NotNull;
import hello.realestateadmin.domain.constant.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="manager")
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class) // 추가
public class Manager {
    @Id
    @Column(name = "manager_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "role")
    @NotNull
    private String role;

    @Column(name = "department")
    @NotNull
    private String department;

    @Column(name = "is_approved", columnDefinition = "TINYINT(1)")
    @ColumnDefault("0")
    private Boolean isApproved;

    @Column(name = "created_at")
    @NotNull
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @NotNull
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Builder
    public Manager(String name, String password, Role role, String department, Boolean isApproved){
        this.name = name;
        this.password = password;
        this.role = role.getValue();
        this.department = department;
        this.isApproved = isApproved;
    }

    public void updateRole(Role role, boolean isApproved) {
        this.role = role.getValue();
        this.isApproved = isApproved;
    }
}
