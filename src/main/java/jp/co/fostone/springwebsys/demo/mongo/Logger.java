package jp.co.fostone.springwebsys.demo.mongo;

import java.util.Date;

import org.joda.money.Money;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Logger {
    @Id
    private String id;
    private String type;
    private String code;
    private String name;
    private Money price;  //For Test
    private Date createTime;
    private Date updateTime;
}
