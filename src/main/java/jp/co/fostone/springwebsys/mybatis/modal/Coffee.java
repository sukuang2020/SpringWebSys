package jp.co.fostone.springwebsys.mybatis.modal;

import java.io.Serializable;
import java.util.Date;
import org.joda.money.Money;

public class Coffee implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_coffee.id
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_coffee.name
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_coffee.price
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    private Money price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_coffee.create_time
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_coffee.update_time
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_coffee
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_coffee.id
     *
     * @return the value of t_coffee.id
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_coffee
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public Coffee withId(Long id) {
        this.setId(id);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_coffee.id
     *
     * @param id the value for t_coffee.id
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_coffee.name
     *
     * @return the value of t_coffee.name
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_coffee
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public Coffee withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_coffee.name
     *
     * @param name the value for t_coffee.name
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_coffee.price
     *
     * @return the value of t_coffee.price
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public Money getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_coffee
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public Coffee withPrice(Money price) {
        this.setPrice(price);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_coffee.price
     *
     * @param price the value for t_coffee.price
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public void setPrice(Money price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_coffee.create_time
     *
     * @return the value of t_coffee.create_time
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_coffee
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public Coffee withCreateTime(Date createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_coffee.create_time
     *
     * @param createTime the value for t_coffee.create_time
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_coffee.update_time
     *
     * @return the value of t_coffee.update_time
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_coffee
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public Coffee withUpdateTime(Date updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_coffee.update_time
     *
     * @param updateTime the value for t_coffee.update_time
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_coffee
     *
     * @mbg.generated Mon Jun 29 15:18:52 JST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}