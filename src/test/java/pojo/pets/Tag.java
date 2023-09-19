package pojo.pets;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {
    private Long id;
    private String name;
}
