package org.example.ex4_5_ss10_ioc.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageMeta {
    private long totalElements;
    private int page;
    private int pageSize;
    private int totalPages;
}
