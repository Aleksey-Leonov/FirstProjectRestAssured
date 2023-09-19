package pojo.pets;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    private Long id;
    private String name;
}