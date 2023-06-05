package cart.dto;

import cart.domain.Product;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(implementation = ProductDto.class)
public class ProductDto {
    private Long id;
    private String name;
    private int price;
    private String imageUrl;

    private ProductDto(Long id, String name, int price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public static ProductDto of(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getImageUrl());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}