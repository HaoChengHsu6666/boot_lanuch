package com.chris.bootlaunch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
//調整Json鍵值輸出順序
@JsonPropertyOrder(value = {"content","title"})

@AllArgsConstructor
@NoArgsConstructor
public class ArticleVO {

    //此屬性在Json輸出時會隱藏起來
    //@JsonIgnore
    private long id;
    private String author;

    //調整Json名稱輸出格式
//    @JsonPropertyOrder("titletle")
    private String title;
    private String content;

    //調整Json時間輸出格式
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    //此屬性值為空的話，Json輸出時不返回(不顯示)此鍵值
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Reader> reader;
}
