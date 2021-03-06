package com.soft11851.springboot.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/**
 * @author ke
 * @ClassName Message
 * @Description TOOD
 * @Date 2020/5/12
 * @Version 1.0
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer msgId;
    @Column(nullable = false)
    private String msgText;
    @Column(nullable = true, length = 32)
    private String msgSummary;
}
