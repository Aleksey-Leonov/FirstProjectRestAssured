package pojo.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusStore {
    @JsonProperty("Widowed, Remarried")
    public Integer widowed, Remarried;
    public Integer sold;
    public Integer placed;
    public Integer string;
    public Integer unavailable;
    public Integer pending;
    public Integer available;
    public Integer pend;
}
