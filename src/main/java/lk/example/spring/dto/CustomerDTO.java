package lk.example.spring.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data //-----> @Getter @Setter
@ToString
public class CustomerDTO {
    private String id;
    private String name;
    private String address;
    private double salary;
}
