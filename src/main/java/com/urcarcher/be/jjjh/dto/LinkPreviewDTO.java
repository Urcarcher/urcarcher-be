package com.urcarcher.be.jjjh.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkPreviewDTO {

	private String title;
    private String description;
    private String imageUrl;
    private String pageUrl;
}