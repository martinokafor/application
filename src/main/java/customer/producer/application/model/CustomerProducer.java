package customer.producer.application.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "customer_producer")
public class CustomerProducer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer customerId;
    private String customerName;
    private String city;
    @Nullable
    private Integer noOfVehicle;
    @Column(name = "created_on", updatable = false)
    public Instant createdOn = Instant.now();
    @Column(name = "updated_on")
    public Instant updatedOn = Instant.now();

}
