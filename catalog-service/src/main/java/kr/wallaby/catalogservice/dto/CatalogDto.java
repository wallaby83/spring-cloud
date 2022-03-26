package kr.wallaby.catalogservice.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class CatalogDto implements Serializable {
    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private String orderId;
    private String userId;
}
