package com.mermer.ch6;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

	private long id;
	private LocalDateTime createdAt;
	private long createdByUserId;
	private OrderStatus status;
	private int quantity;
	private BigDecimal amount;
	
	public enum OrderStatus{
		CREATED,
		IN_PROGRESS,
		ERROR,
		PROCESSED
	}

	public long getId() {
		return id;
	}

	public Order setId(long id) {
		this.id = id;
		return this;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public Order setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
		return this;
	}

	public long getCreatedByUserId() {
		return createdByUserId;
	}

	public Order setCreatedByUserId(long createdByUserId) {
		this.createdByUserId = createdByUserId;
		return this;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public Order setStatus(OrderStatus status) {
		this.status = status;
		return this;
	}

	public int getQuantity() {
		return quantity;
	}

	public Order setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Order setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", createdAt=" + createdAt + ", createdByUserId=" + createdByUserId + ", status="
				+ status + ", quantity=" + quantity + ", amount=" + amount + "]";
	}
	
	
	
}
