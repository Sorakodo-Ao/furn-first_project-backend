package com.caiwei.spring.Entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("furn")
public class Furn {
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;

//    @TableField(value = "name")
    private String name;

    private String maker;
    private Double price;
    private Integer sales;
    private Integer stock;
}
