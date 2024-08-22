package com.hqyj.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author rock
 * @since 2024-08-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 订单编号
     */
    @TableId(value = "order_id",type = IdType.ASSIGN_UUID)
    private String orderId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 订单的状态，0::待支付、1:已支付、2:已取消等。
     */
    private Integer orderStatus;

    /**
     * 订单金额
     */
    private BigDecimal orderMoney;

    /**
     * 付款时间
     */
    private Date payTime;

    /**
     * 支付方式 0 支付宝 1 微信支付 2 线下支付
     */
    private Integer payType;

    /**
     * 订单收货人的姓名。
     */
    private String name;

    /**
     * 订单收货的详细地址
     */
    private String address;

    /**
     * 收货人电话
     */
    private String phone;

    /**
     * 收货人邮政编码
     */
    private String postCode;

    /**
     * 收货人电子邮件
     */
    private String email;

    /**
     * 订单备注:用户填写
     */
    private String orderRemark;

    /**
     * 逻辑删除  0 未删除  1删除
     */
    @TableLogic
    private Integer deleteTag;

    /**
     * 配送类型 0 申通快递 1 顺丰快递 2 邮局平邮
     */
    private Integer deliveryType;

    //购物车id集合
    @TableField(exist = false)
    private List<Integer> list;

}
