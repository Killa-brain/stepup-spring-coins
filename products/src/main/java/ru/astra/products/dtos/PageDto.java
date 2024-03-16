package ru.astra.products.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PageDto<T> {
    private List<T> content;

    public PageDto(List<T> content) {
        this.content = content;
    }
}
